# # # [11] 사례 연구 소스 

# 1. koweps_hpc10_2015_beta5.sav로드하여 변수명 변경

# 1.1 패키지 설치 및 로드
install.packages("foreign")
library(foreign) # SPSS파일 불러오기
library(dplyr)   # 전처리
library(doBy)    # 전처리
library(ggplot2) # 시각화
library(readxl)  # 엑셀파일 
rm(list=ls(all.names = TRUE))

# 1.2 데이터 불러오기 
getwd()

raw_welfare <- read.spss(file = 'inData/koweps/Koweps_hpc10_2015_beta1.sav',
                         # reencode = 'utf-8',
                         to.data.frame = T) # 기본적으로 list형태로 받아옴
View(raw_welfare)
welfare <- raw_welfare

# 1.3 데이터 검토
dim(welfare)
head(welfare)
tail(welfare)
View(welfare)
str(welfare)
summary(welfare)

# 1.4 필요한 필드만 추출 후, 변수명 수정 
welfare <- rename(welfare,  
                  gender = h10_g3,         # 성별
                  birth = h10_g4,          # 생년
                  marriage = h10_g10,      # 혼인상태
                  religion = h10_g11,      # 종교
                  income = p1002_8aq1,     # 월급
                  code_job = h10_eco9,     # 직업코드
                  code_region = h10_reg7)  # 지역코드 

welfare <- welfare %>% 
  select(gender, birth, marriage, religion,
         income, code_job, code_region)  

head(welfare)
View(welfare)
dim(welfare)
table(is.na(welfare))
colSums(is.na(welfare))
colSums(!is.na(welfare))

####################################

# 2. 성별에 따른 월급 차이가 있는가? 

# 2.1 이상치 처리 
table(welfare$gender, useNA = "ifany") # 이상치 없음 

# 2.2 결측치 확인 
table(is.na(welfare$gender))

# 2.3 gender값의 1을 male로, 2는 female로 변경하고, factor로 형변환 
str(welfare$gender)
summary(welfare$gender)

welfare$gender <- ifelse(welfare$gender == 1, 'male', 'female')

welfare$gender <- as.factor(welfare$gender)

str(welfare$gender)
table(welfare$gender)

  # cf. factor의 순서를 바꾸려면 이렇게
welfare$gender <- factor(welfare$gender, levels = c('male', 'female'))

# 2.4 성별 비율을 도표와 그래프로 시각화 
welfare %>% # 도표
  group_by(gender) %>% 
  summarise(ratio = n() / nrow(welfare) * 100) # 성별 비율

welfare %>%  # 시각화(막대그래프)
  group_by(gender) %>% 
  summarise(ratio = n() / nrow(welfare) * 100) %>% 
  ggplot(aes(x = gender, y= ratio)) +
  geom_col(aes(fill = gender)) +
  labs(title = "성별 비율") + 
  scale_x_discrete(limits = c('male', 'female')) + # x축 순서 바뀜
  #scale_fill_discrete(limits=c('female','male'), labels=c("f", "m")) + # 범례의 텍스트 순서도 바뀜
  theme(legend.position = "none",
        legend.background = element_rect(fill = 'lightgray'),
        legend.title = element_text(face = 3, color = 'red')) # face: italic


gender.ratio <- welfare %>% # 성비 도표 변수(gender.ratio)에 넣기
  group_by(gender) %>% 
  summarise(ratio = n() / nrow(welfare) * 100)
gender.ratio

pie(gender.ratio$ratio, # 성비 시각화(파이 차트)
    labels = paste(gender.ratio$gender,
                   round(gender.ratio$ratio, 1), '%'),
    clockwise = T)

ggplot(gender.ratio, aes(x = '', y = ratio, fill = gender)) + 
  geom_bar(stat = 'identity') +
  coord_polar("y") # 원형으로 

# 2.5 급여 시각화 
summary(welfare$income)
table(welfare$income)

qplot(welfare$income) # 히스토그램
qplot(welfare$income, xlim = c(0, 1000))

ggplot(data = welfare, aes(income)) +
  geom_histogram() + # 연속형 자료 income을 계급별로 나누어 도수분포표로
  coord_cartesian(xlim = c(0, 1000))

# 2.6 이상치를 결측치로 
boxplot(welfare$income) # 이상치 확인 
bp <- boxplot(welfare$income)$stat
bp

table(welfare$income <= bp[1], useNA = "ifany") # 하위 이상치를 벗어난 값들
table(welfare$income > bp[5], exclude = NULL) # 상위 이상치를 벗어난 값
  # => 상위 이상치를 벗어난 값이 5%이상이라서 하위 이상치 값만 결측치 처리한다.

welfare$income <- ifelse(welfare$income <= bp[1], NA, welfare$income)

table(welfare$income == bp[1], useNA = "ifany") # 처리 여부 확인 
table(is.na(welfare$income))
summary(welfare$income)

# 2.7 성별에 따른 월급 차이 도표로 분석하기 
tapply(welfare$income, welfare$gender, FUN = mean, na.rm = T)
tapply(welfare$income, welfare$gender, FUN = sd, na.rm = T)

by(welfare$income, welfare$gender, mean, na.rm = T)
by(welfare$income, welfare$gender, sd, na.rm = T)

summaryBy(income ~ gender, data = welfare, FUN = c(mean, sd), na.rm = T)

aggregate(welfare$income, by=list(welfare$gender), mean, na.rm = T)
aggregate(welfare$income, by=list(welfare$gender), sd, na.rm = T)

temp <- welfare[, c('income', 'gender')]
temp <- na.omit(temp)
summary(temp)
summaryBy(income ~ gender, temp, FUN = c(mean, sd))

welfare %>% 
  filter(!is.na(income) & !is.na(gender)) %>% 
  group_by(gender) %>% 
  summarise(mean = mean(income),
            sd = sd(income))

# 2.7 성별에 따른 월급 차이 여부 그래프로 분석하기 
welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(gender) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income)) %>% 
  ggplot(aes(x = gender, y = income.mean)) +
  geom_bar(stat = 'identity') +
  labs(title = "성비에 따른 평균 수입")

ggplot(data = welfare, aes(x = gender, y = income)) +
  geom_point(position = "jitter", col = "skyblue", alpha = 0.1) +
  geom_violin() +
  geom_boxplot(aes(col = gender), fill = 'lightyellow',
               notch = T, width = 0.7) +
  geom_rug(col = "dimgray") +
  labs(title = "하위 이상치 처리 후 성별에 따른 수입 분석") +
  coord_cartesian(ylim = c(0, 1000))

# 2.8 성비에 따른 월급 차이 통계 분석 
temp <- welfare %>% filter(!is.na(income))
View(temp)

var.test(income ~ gender, data = temp) # 등분산성 테스트
t.test(income ~ gender, data = temp, var.equal = F) # t.test

  # => # p-value가 0.05미만으로 성별에 따른 월급차이가 없다는 가설을 기각한다

######################################

# 3. 나이와 월급의 관계 (월급이 가장 많은 나이)
names(welfare)
class(welfare$birth)

# 3.1 이상치, 결측치 확인 
(b <- boxplot(welfare$birth)$stat)
table(welfare$birth < b[1] | welfare$birth > b[5]) # 이상치 없음 

summary(welfare$birth) # 결측치 확인 
table(!is.na(welfare$birth)) 

# 3.2 나이 변수 추가 (2015년 기준)
dim(welfare)

welfare$age <- 2015 - welfare$birth + 1

View(welfare)
head(welfare)
summary(welfare$age)

qplot(welfare$age) # 나이 분포 그래프로 확인

ggplot(data = welfare, aes(age)) +
  geom_histogram()

ggplot(data = welfare, aes(age)) +
  geom_bar() # 가능한 방법이지만, geom_bar()는 주로 범주형 자료에서 사용한다.

boxplot(welfare$age)$stat
ggplot(welfare, aes(y = age)) +
  geom_boxplot() +
  theme(axis.text.x = element_blank()) + # x축 눈금 없애기
  coord_cartesian(xlim = NULL)

# 3.3 나이와 나이별 평균에 따른 월급의 변화 시각화 
age_income <- welfare %>% 
  filter(!is.na(welfare$income)) %>% 
  group_by(age) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income))
age_income # 나이별 월급의 평균과 표준편차 

ggplot(age_income, aes(x = age, y = income.mean)) +
  geom_col()
  
ggplot(age_income, aes(x = age, y = income.mean)) +
  geom_bar(stat = 'identity') +
  geom_line()

# 3.4 통계 분석 
result <- aov(income ~ age, data = welfare)
summary(result)  
  
fit <- lm(income ~ age, data = welfare)
anova(fit)
  # => F-value값에 따라 나이에 따른 월급의 차이는 유의미한 것으로 본다
  
# 3.5 월급을 가장 많이 받는 나이대는? 
ggplot(age_income, aes(x = age, y = income.mean)) +
  geom_line() + 
  coord_cartesian(xlim = c(30, 60))

orderBy(~-income.mean, data = age_income)[1:5, ]

age_income[order(age_income$income.mean, decreasing = T), ]

age_income %>% 
  arrange(-income.mean) %>% 
  head(5)

  # => 월급을 가장많이 받는 나이: 53세 

##############################

# 4. 연령대에 따른 월급 차이 - 가장 월급이 많은 연령대는? 

# 4.1 파생변수 agegrade 추가 
#     (young 30세 이하 / 31~60 middle / 61세 이상 - old)
welfare <- welfare %>% 
  mutate(agegrade = ifelse(age <= 30, "young", 
                           ifelse(age <= 60, "middle", "old")))
str(welfare$agegrade)

# welfare$agegrade를 factor형 변수로 하면 아래의 방법으로~
# welfare$agegrade <- factor(welfare$agegrade,  
#                            levels = c('young','middle','old'))

# 4.2 도표와 그래프로 시각화 
table(welfare$agegrade, useNA = "ifany")

qplot(welfare$agegrade)
ggplot(data = welfare, aes(agegrade)) +
  geom_bar(aes(fill = agegrade)) +
  #xlim(c('young','middle','old')) + # 아래와 같음 
  scale_x_discrete(limits = c('young', 'middle', 'old')) +
  theme(legend.position = "none")

# 4.3 연령대별 월급의 상자 도표 
boxplot(income ~ agegrade, 
        data = welfare,
        col = c('red', 'green', 'blue'))

ggplot(welfare, aes(x = agegrade, y = income, fill = agegrade)) +
  geom_boxplot(notch = T) +
  scale_fill_manual(values = topo.colors(3)) +
  coord_cartesian(ylim = c(0, 700))

# 4.4 연령대에 따른 월급차이 도표, 그래프
agegrade_income <- welfare %>%  # 도표
  group_by(agegrade) %>% 
  summarise(income.mean = mean(income, na.rm = T),
            income.sd = sd(income, na.rm = T))
agegrade_income

summaryBy(income ~ agegradem, welfare, FUN = c(mean, sd), na.rm = T)

ggplot(agegrade_income, aes(x = agegrade, y = income.mean)) + # 그래프 
  geom_col(aes(fill = agegrade)) +
  scale_x_discrete(limits = c('young', 'middle', 'old')) +
  theme(legend.position = "none")

ggplot(welfare, aes(x = agegrade, y = income)) +
  geom_point(position = 'jitter', col = 'orange', alpha = 0.2) +
  geom_boxplot(aes(fill = agegrade), notch = T) +
  scale_x_discrete(limits = c('young', 'middle', 'old')) +
  scale_fill_discrete(limits = c('young', 'middle', 'old')) +
  geom_rug(col = 'dimgray') +
  coord_cartesian(ylim = c(0, 4000))

# 4.5 통계 분석 
temp <- welfare %>% filter(!is.na(income))
result <- aov(income ~ agegrade, data = temp)
summary(result)

############################

# 5. 성별에 따른 월급차이는 연령대 별로 다를까? 

# 5.1 결측치 확인
table(is.na(welfare$gender))
table(is.na(welfare$agegrade))
table(is.na(welfare$income))

# 5.2 연령대별, 성별 월급의 평균과 표준편차, 빈도 출력 
gender_agegrade_income <- welfare %>% 
  filter(!is.na(income)) %>% 
  group_by(agegrade, gender) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income),
            n = n())
gender_agegrade_income

# 5.3 시각화 
ggplot(gender_agegrade_income, 
       aes(x = agegrade, y = income.mean, fill = gender)) +
  geom_bar(stat = 'identity', position = 'dodge')

ggplot(gender_agegrade_income, 
       aes(x = agegrade, y = income.mean, fill = gender)) +
  geom_col(position = "dodge") +
  scale_x_discrete(limits = c('young', 'middle', 'old'))

ggplot(gender_agegrade_income, 
       aes(x = agegrade, y = income.mean)) +
  geom_col(aes(fill = gender), position = 'dodge') +
  facet_wrap(~agegrade) +
  theme(legend.position = "none")

# cf) 연령대별 남녀 비교
# 1) young 
young <- ggplot(subset(welfare, agegrade == 'young'),
                aes(x = gender, y = income)) +
  geom_point(position = "jitter", col = 'brown', alpha = 0.3) +
  geom_violin() +
  geom_boxplot(aes(fill = gender), notch = T, width = 0.6) +
  theme(legend.position = "none")
young

# 2) middle
middle <- ggplot(subset(welfare, agegrade == 'middle'),
              aes(x = gender, y = income)) +
  geom_point(position = "jitter", col = 'brown', alpha = 0.3) +
  geom_violin() +
  geom_boxplot(aes(fill = gender), notch = T, width = 0.6) + 
  theme(legend.position = "none")

# 3) old
old <- ggplot(subset(welfare, agegrade == 'old'),
              aes(x = gender, y = income)) +
  geom_point(position = "jitter", col = 'brown', alpha = 0.3) +
  geom_violin() +
  geom_boxplot(aes(fill = gender), notch = T, width = 0.6) + 
  theme(legend.position = "none")

library(gridExtra)
grid.arrange(young, middle, old, ncol=3)

#############################

# 6.나이에 따른 성별 월급차이 분석 

# 6.1 나이와 성별로 그룹화하여 월급 평균, 표준편차, 중앙값, 최소값, 빈도 출력 
gender_age_income <- welfare %>% 
  filter(!is.na(welfare$income)) %>% 
  group_by(age, gender) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income),
            income.median = median(income),
            income.min = min(income),
            income.max = max(income),
            n = n())
gender_age_income

# 6.2 나이에 따른 월급 평균 추이 
png(filename = 'outData/11_result.png', 
    width = 800, height = 600)

ggplot(gender_age_income, 
       aes(x = age, y = income.mean, col = gender)) +
  geom_line()

dev.off()

###########################

# 7. 직업별 월급 차이 
table(welfare$code)

# 7.1 직업별 월급 평균, 표준편차, 빈도를 평균 월급 순으로 정렬
job_list <- read_excel('inData/koweps/Koweps_Codebook.xlsx',
                       col_names = T, sheet = 2)
View(job_list)
head(job_list)
head(welfare)

welfare <- left_join(welfare, job_list, id='code_job')
View(welfare)

job_income <- welfare %>%  
  filter(!is.na(job) & !is.na(income)) %>% 
  group_by(job) %>% 
  summarise(income.mean = mean(income),
            income.sd = sd(income),
            n = n()) %>% 
  arrange(desc(income.mean))

View(job_income)
nrow(job_income)

# 7.2 상위 소득 10개 직업군 출력 
top10 <- head(job_income, 10)
top10[, 'job']

ggplot(data = top10, 
       aes(x = income.mean, y = reorder(job, income.mean))) +
  geom_col() +
  labs(title = '상위 소득 10개 직업군',
       x = '직업', y = '평균소득') +
  scale_y_discrete(limits = c('금속 재료 공학 기술자 및 시험원',
                              '의료진료 전문가',
                              '의회의원 고위공무원 및 공공단체임원',
                              '보험 및 금융 관리자',
                              '제관원 및 판금원',
                              '행정 및 경영지원 관리자',
                              '문화 예술 디자인 및 영상 관련 관리자',
                              '연구 교육 및 법률 관련 관리자',
                              '건설 전기 및 생산 관련 관리자',
                              '석유 및 화학물 가공장치 조작원'),
                   labels = c('금속재료공학', '의료진료', '고위공무원',
                              '보험', '제관원', '행정경영', '문화예술',
                              '연구교육', '건설생산', '석유화학'))


# 7.3 하위 소득 10개 직업 
bottom10 <- welfare %>% 
  filter(!is.na(income) & !is.na(job)) %>% 
  group_by(job) %>% 
  summarise(mean.income = mean(income)) %>% 
  arrange(mean.income) %>% 
  head(10)
bottom10

ggplot(bottom10, 
       aes(x = mean.income, y = reorder(job, -mean.income))) +
  geom_col(aes(fill = job)) + 
  labs(title = "하위 소득 10 직업군", 
       x = '직업군', y = '평균 소득') +
  theme(legend.position = 'none')

########################################

# 8. 성별 직업 빈도: 성별로 어떤 직업이 많을까? 

# 8.1 여성 최빈 직업 top10 
female_top10 <- welfare %>% 
  filter(!is.na(job) & gender=='female') %>% 
  group_by(job) %>% 
  summarise(cnt = n()) %>% 
  arrange(desc(cnt)) %>% 
  head(10)
female_top10

ggplot(data = female_top10, 
       aes(y = reorder(job, cnt), x = cnt)) +
  geom_col()

# 8.2 남성 최빈 직업 top10 
male_top10 <- welfare %>% 
  filter(!is.na(job) & gender=='male') %>% 
  group_by(job) %>% 
  summarise(cnt = n()) %>% 
  arrange(desc(cnt)) %>% 
  head(10)
male_top10

ggplot(data = male_top10, 
       aes(y = reorder(job, cnt), x = cnt)) +
  geom_col()

########################

# 9. 종교 유무에 따른 이혼율

# 9.1 이상치 및 결측치 확인 
table(welfare$religion, exclude = NULL)
table(!is.na(welfare$religion))

# 9.2 1은 종교-유, 2는 종교-무로 데이터 변경
welfare$religion <- ifelse(welfare$religion==1, '종교-유', '종교-무')

# 9.3 빈도 시각화 
table(welfare$religion)

ggplot(welfare, aes(x = religion, fill = religion)) +
  geom_bar(width = 0.7) +
  theme(legend.position = "none")

# 9.4 파생변수 marriage_group추가 
welfare <- welfare %>% 
  mutate(marriage_group = ifelse(marriage==1, '기혼',
                                 ifelse(marriage==3, '이혼', NA)))
head(welfare)

table(welfare$marriage, useNA = 'ifany')
table(welfare$marriage_group, useNA = 'ifany')

# 9.5 종교 유무에 따른 이혼률 분석 
temp <- welfare %>% 
  filter(!is.na(marriage_group) & !is.na(religion))
View(temp)

table(temp$religion, temp$marriage_group) # 도표 

religion_marriage <- welfare %>% 
  filter(!is.na(marriage_group)) %>% 
  group_by(religion, marriage_group) %>% 
  summarise(n = n()) %>% 
  mutate(tot_group = sum(n)) %>% 
  mutate(pct = round(n / tot_group * 100, 1))

religion_marriage

# 9.6 시각화 
ggplot(religion_marriage, 
       aes(x = religion, y = n, fill = marriage_group)) +
  geom_col(position = "dodge")

# 기혼 상태
welfare %>% 
  filter(marriage_group == '기혼') %>% 
  group_by(religion) %>% 
  summarise(tot = n()) %>% 
  mutate(pct = tot/sum(tot)*100) %>% 
  ggplot(aes(x = religion, y = pct)) +
  geom_col()

# 이혼 상태 
welfare %>% 
  filter(marriage_group == '이혼') %>% 
  group_by(religion) %>% 
  summarise(tot = n()) %>% 
  mutate(pct = tot/sum(tot)*100) %>% 
  ggplot(aes(x = religion, y = pct)) +
  geom_col()

# 9.7 통계 분석 
# t-test는 독립변수는 범주형, 종속변수는 연속형이여야 적합하다.
var.test(data = temp, marriage ~ religion)
t.test(data = temp, marriage ~ religion, var.equal = F)
# => p-value가 0.045로 종교유무에 따라 결혼상태가 다소 다를 수 있다.

############################

# 10. 지역별 연령대 비율: 노년층이 많은 지역은 어디일까? 
class(welfare$code_region)

# 10.1 결측치 확인 
table(welfare$code_region, useNA = "ifany")
table(!is.na(welfare$agegrade)) 
table(!is.na(welfare$code_region)) # 모두 결측치 없음 

# 10.2 region 파생변수 추가 
region_list <- data.frame(code_region = c(1:7),
                          region = c('서울',
                                     '수도권(인천/경기)',
                                     '부산/경남/울산',
                                     '대구/경북',
                                     '대전/충남',
                                     '강원/충북',
                                     '광주/전남/전북/제주도'))
View(region_list)

welfare <- left_join(welfare, region_list, by = 'code_region')
head(welfare)

table(welfare$code_region)
table(welfare$region)

# 10.3 지역별 연령대 비율을 도표 및 그래프로 분석 
region_agegrade <- welfare %>% 
  group_by(region, agegrade) %>% 
  summarise(n = n()) %>% # 지역별, 연령별 인구
  mutate(tot_group = sum(n)) %>% # 지역별 인구
  mutate(pct = round(n/tot_group*100, 2)) # 지역별 연령대 percent
edit(region_agegrade)

# 지역별 연령대 인구 
ggplot(data = region_agegrade,
       aes(x = reorder(region, n), y = n, fill = agegrade)) + 
  geom_col(position = "dodge") + 
  theme(axis.text.x = element_text(angle = 70, vjust = 0.7))
  # => 노년층이 가장 많은 지역: 광주/전남/전북/제주도

# 지역별 연령대 비율 
ggplot(data = region_agegrade,
       aes(x = reorder(region, n), y = pct, fill = agegrade)) + 
  geom_col(position = "dodge") + 
  theme(axis.text.x = element_text(angle = 70, vjust = 0.5))
  # => 노년층 비율이 가장 많은 지역: 대구/경북 

# 10.4 노년층이 많은 지역은 어디? 

# (1) 노년층이 많은 순
old_agegrade_region <- region_agegrade %>% 
  filter(agegrade == 'old') %>% 
  arrange(desc(n))
old_agegrade_region

ggplot(old_agegrade_region, aes(x = n, y = reorder(region, n))) +
  geom_col() +
  geom_text(aes(label = n), hjust = 0) +
  coord_cartesian(xlim = c(0, 1350))

cat("노년층 인구가 많은 순: ", old_agegrade_region$region)

# (2) 노년층 비율이 높은순
old_agegrade_region <- region_agegrade %>% 
  filter(agegrade == 'old') %>% 
  arrange(desc(pct))
old_agegrade_region

ggplot(old_agegrade_region, aes(x = pct, y = reorder(region, pct))) +
  geom_col() +
  geom_text(aes(label = paste(pct, '%')), hjust = 0, size = 3) +
  coord_cartesian(xlim = c(0, 50))

cat("노년층 비율이 높은 순: ", old_agegrade_region$region)

# 7개 변수 외에도 신체건강, 정신건강, 가족간의 관계, 주거환경, 교육수준 등 
# 957개의 변수가 있습니다. 흥미로운 주제를 찾아 
# 자신만의 데이터 분석 프로젝트를 수행해 보세요. 조사설계서 참조







