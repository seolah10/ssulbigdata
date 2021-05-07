# # # [5-1] dplyr 패키지를 이용한 전처리 

# 1. 외부파일 read / write
# 1.1 엑셀파일 읽어오기 - readxl 패키지 이용 
install.packages("readxl")
library(readxl)

  # 파일 경로 설정방법 
getwd()
exam <- read_excel("D:/BigData/src/07_R/inData/exam.xlsx") # 역슬래시(\)는 두번
exam <- read_excel("inData/exam.xlsx")
exam <- as.data.frame(exam)

head(exam)
nrow(exam)

exam[21, ] <- data.frame(id=1, class=1, math=90, engish=90, science=99)
tail(exam) # 행추가

exam$tot <- exam$math + exam$english + exam$science # 파생변수 추가 

mean(exam$tot) # 총점의 평균 
apply(exam[, 3:6], 2, mean) # 열별 평균 

# 1.2 데이터 쓰기 (파일(csv)로 쓰기 vs. 변수만 쓰기)
write.csv(exam, 'outData/05-1_exam.csv', row.names = TRUE) # 파일로 쓰기
save(exam, file = 'outData/05-1_exam.rda') # 파일로 저장 

rm(list=ls(all.names = TRUE)) # 모든 변수 삭제 
exam

load('outData/05-1_exam.rda') # 불러오기 
exam 

##########################

# 2. 데이터 파악하기

  # ex. mpg 데이터셋 파악하기 
mpg <- as.data.frame(ggplot2::mpg)

head(mpg) # 첫 여섯행
tail(mpg) # 마지막 여섯행 
edit(mpg) # view 창 
View(mpg)
dim(mpg) # 차원 확인 
summary(mpg) # 최소값, 1사분위수, 중위수, 3사분위수, 최대값


install.packages("dplyr")
library(dplyr)

mpg <- rename(mpg, city=cty) # 변수명 변경
mpg <- rename(mpg, highway=hwy)

colnames(mpg)

mpg$total = (mpg$city + mpg$highway) / 2 # 파생변수 추가 
head(mpg, 3)

boxplot(mpg$total) # 시각화 
hist(mpg$total)
install.packages("vioplot")
library(vioplot)
vioplot(mpg$total, col='red')

par(mfrow = c(1,3)) # 시각화 그래프를 1행 3열로 출력 
boxplot(mpg$total)
hist(mpg$total) 
vioplot(mpg$total, col='red')
par(mfrow = c(1,1)) # 플롯공간 원상복귀 

mean(mpg$total)
mpg$test <- ifelse(mpg$total>=mean(mpg$total), 'pass', 'fail')
table(mpg$test) # 빈도표 출력 

library(ggplot2)
qplot(mpg$test, color=mpg$test) # 빈도그래프
hist(mpg$total)

  # ex. midwest 데이터셋 파악하기 
midwest <- as.data.frame(ggplot2::midwest)

  # 1) 데이터 특성 파악 
head(midwest)
View(midwest)
dim(midwest)
str(midwest)
summary(midwest)

  # 2) 변수명 변경 
colnames(midwest)

midwest <- rename(midwest, total=poptotal)
midwest <- rename(midwest, asian=popasian)

colnames(midwest)

  # 3) 전체 인구대비 아시아 인구 백분율 파생변수 추가 
midwest$ratioasian <- midwest$asian / midwest$total * 100 
midwest[, c('total', 'asian', 'ratioasian')]

  # 4) 'large', 'small'
boxplot(midwest$ratioasian)
mean(midwest$ratioasian)

midwest$group <- ifelse(midwest$ratioasian > mean(midwest$ratioasian),
                        "large", "small")
head(midwest[, c('total', 'asian', 'ratioasian', 'group')])
dim(midwest)

  # 5) 'large'와 'small'에 해당하는 지역의 빈도표 확인 
table(midwest$group)
nrow(midwest)

###########################

# 3. 파악한 데이터를 dplyr 패키지를 이용하여 전처리 및 분석 
  # dplyr 패키는 %>% 기호를 이용해서 함수들을 나열하는  코딩
  # cf) '%>%'입력키:  ctrl+shift+m

# 3.1 조건에 맞는 데이터 추출: filter() 
exam <- read.csv('inData/exam.csv', header = T)

exam %>% 
  filter(class==1) # class가 1인 데이터만 추출 

  # ex. class가 1이거나 2거나 3인 데이터만 추출 
exam %>% 
  filter(class==1 | class==2 | class==3)
exam %>% 
  filter(class %in% c(1,2,3))

  # ex. class가 1이고, 영어 점수가 80 이상인 데이터  
exam %>% 
  filter(class==1 & english>=80)

# 3.2 필요한 변수 추출: select()
exam %>% 
  select(class, english, math) # 추출할 변수만 입력 
exam %>% 
  select(-math) # -: 제외할 변수 입력 

  # ex. class가 1이거나 2인 행 중에서 영어, 수학 데이터만 출력 
exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(english, math)

  # ex. class가 1이나 2, 혹은 3인 행 중에서 영어, 수학 데이터를 첫 다섯행만 추출
exam %>% 
  filter(class %in% c(1,2,3)) %>% 
  select(english, math) %>% 
  head(5)

# 3.3 정렬: arrange()
exam %>% arrange(math) # 오름차순
exam %>% arrange(desc(math)) # 내림차순
exam %>% arrange(-math)  
exam %>% arrange(class, desc(math)) # class오름차순, class같으면 math 내림차순 
exam %>% arrange(class, -math)

  # ex. id가 1~10인 학생의 영어, 수학 성적을 영어 성적 순서대로 top 6 출력 
exam %>% 
  filter(id %in% 1:10) %>% 
  select(english, math) %>% 
  arrange(desc(english)) %>% 
  head

# 3.4 파생변수 추가: mutate()
exam %>% 
  mutate(total = math + english + science) %>% 
  filter(total >= 150)

exam %>% # 파생변수 두개 이상 추가하기 
  mutate(total = math + english + science,
         avg = round((math+english+science)/3)) %>% 
  select(-id) %>% 
  arrange(desc(total)) %>% 
  head(3)

# 3.5 요약하기: summarise()
# summarise안에 들어갈 수 있는 요약함수들
#               : mean, sd, sum, min, max, median, n
exam %>% 
  summarise(mean_math = mean(math))
exam %>% 
  summarise(mean_math = mean(math),
            mean_english = mean(english),
            sd_math = sd(math),
            sd_eng = sd(english))

# 3.6 집단별로 요약하기: group_by() + summarise()
exam %>% 
  group_by(class) %>% 
  summarise(mean_math = mean(math),
            n = n(),
            max_eng = max(english)) %>% 
  arrange(mean_math)

  # ex. 클래스별 수학, 영어, 과학 점수의 평균 
exam %>%  
  group_by(class) %>% 
  summarise(mean_math = mean(math),
            mean_english = mean(english),
            mean_sci = mean(science))

library(doBy)
summaryBy(math+english+science ~ class, exam)

  # ex. mpg 회사별(manufacturer)로 "suv 자동차의 도시 및 
  #     고속도로 통합 연비 평균을 구해 내림차순으로 정렬하고, 
  #     1~5위 까지 출력하기
mpg <- as.data.frame(ggplot2::mpg)
nrow(mpg)
table(mpg$class)

mpg %>% 
  filter(class=='suv') %>% 
  group_by(manufacturer) %>% 
  mutate(avg = (cty+hwy)/2) %>% 
  summarise(tot_mean = mean(avg)) %>% 
  arrange(desc(tot_mean)) %>% 
  head(5)

############################

# <실전 분석> - 1

# Q1. 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 합니다. 
#     displ(배기량)이 4 이하인 자동차와 5 이상인 자동차 중 
#     어떤 자동차의 hwy(고속도로 연비)가 평균적으로 더 높은지 알아보세요
# (1) dplyr 패키지 이용
# (2) apply계열 함수 이용 : tapply, by, summaryBy(doBy), aggregate

# Q2. 자동차 제조 회사에 따라 도시 연비가 다른지 알아보려고 합니다. 
#     "audi"와 "toyota" 중 어느 manufacturer(자동차 제조 회사)의 
#     cty(도시 연비)가 평균적으로 더 높은지 알아보세요.
#(1) 


# Q3. "chevrolet", "ford", "honda" 자동차의 
#     고속도로 연비 평균을 알아보려고 합니다. 
#     이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요.
# (1) 방법


# <실전 분석> - 2 

# Q1. mpg 데이터는 11개 변수로 구성되어 있습니다. 
#     이 중 일부만 추출해서 분석에 활용하려고 합니다. 
#     mpg 데이터에서 class(자동차 종류), cty(도시 연비) 변수를 추출해 
#     새로운 데이터를 만드세요. 새로 만든 데이터의 일부를 출력해서 
#     두 변수로만 구성되어 있는지 확인하세요.


#Q2. 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 
#    앞에서 추출한 데이터를 이용해서 class(자동차 종류)가 
#   "suv"인 자동차와 "compact"인 자동차 중 어떤 자동차의 cty(도시 연비)가 
#   더 높은지 알아보세요.
table(mpg$class)


# Q3. "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 
#     hwy(고속도로 연비)가 높은지 알아보려고 합니다. 
#     "audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 
#     자동차의 데이터를 출력하세요.
# 방법(1)


# <실전 분석> - 3 

# Q1. mpg 데이터 복사본을 만들고, 
#    cty와 hwy를 더한 '합산 연비 변수'를 추가하세요.

# Q2. 앞에서 만든 '합산 연비 변수'를 2로 나눠 '평균 연비 변수'를 추가세요.

# Q3. '평균 연비 변수'가 가장 높은 자동차 3종의 데이터를 출력하세요.

# Q4. 1~3번 문제를 해결할 수 있는 하나로 연결된 dplyr 구문을 만들어 출력하세요. 
#     데이터는 복사본 대신 mpg 원본을 이용하세요.


# <실전 분석> - 4 

#Q1. mpg 데이터의 class는 "suv", "compact" 등 
#    자동차를 특징에 따라 일곱 종류로 분류한 변수입니다. 
#    어떤 차종의 연비가 높은지 비교해보려고 합니다. 
#    class별 cty 평균을 구해보세요.
table(mpg$class)

#Q2. 앞 문제의 출력 결과는 class 값 알파벳 순으로 정렬되어 있습니다. 
#    어떤 차종의 도시 연비가 높은지 쉽게 알아볼 수 있도록 
#    cty 평균이 높은 순으로 정렬해 출력하세요.

#Q3. 어떤 회사 자동차의 hwy(고속도로 연비)가 가장 높은지 알아보려고 합니다. 
#    hwy 평균이 가장 높은 회사 세 곳을 출력하세요.
# (1) 방법

# Q4. 어떤 회사에서 "compact"(경차) 차종을 가장 많이 생산하는지 
#     알아보려고 합니다. 각 회사별 "compact" 차종 수를 
#     내림차순으로 정렬해 출력하세요.

############################################

# 4. 데이터 합치기 
# 4.1 열(가로) 합치기: cbind(), left_join()
test1 <- data.frame(id = c(1, 2, 3, 4, 5),
                    midterm = c(70, 80, 90, 95, 99))
test2 <- data.frame(id = c(1, 2, 3, 4, 5),
                    final = c(90, 80, 70, 60, 99),
                    teacherid = c(1, 1, 2, 2, 3))
teacher <- data.frame(teacherid=c(1, 2, 3),
                      teachername=c('Kim','Park','Ryu'))

cbind(test1, test2)
merge(test1, test2)
left_join(test1, test2, by='id')

# cbind(test2, teacher) 불가
left_join(test2, teacher, by='teacherid')
merge(test2, teacher, by='teacherid', all=T)


test2 <- data.frame(id=c(1, 2, 3, 4, 5),
                    final = c(90, 80, 70, 60, 99),
                    teacherid=c(1, 1, 2, 2, 4))
teacher <- data.frame(teacherid=c(1, 2, 3),
                      teachername=c('Kim','Park','Ryu'))

left_join(test2, teacher, by='teacherid')
merge(test2, teacher, by='teacherid', all=T)

# 4.2 행(세로) 합치기: rbind(), bind_rows()
group_a <- data.frame(id=c(1, 2, 3, 4, 5),
                      test=c(60, 70, 80, 90, 95))
group_b <- data.frame(id=c(6, 7, 8, 9, 10),
                      test=c(90, 95, 94, 93, 92))

rbind(group_a, group_b) # 두 데이터프레임의 변수가 일부 다를 경우
bind_rows(group_a, group_b)
merge(group_a, group_b, all = T)
merge(group_a, group_b) # 불가 

###########################

# 5. 데이터 정제하기 - 결측치(NA), 이상치 
# 5.1 결측치 정제하기 
df <- data.frame(name = c('kim', 'lee', 'park', 'choi', 'jung'),
                 gender=c('M', 'F', 'F', 'M', 'F'),
                 score=c(5, 4, 3, 4, NA),
                 income=c(2000, 3000, 4000, 4500, 4600))
df

is.na(df)
dim(df)
table(is.na(df))
table(is.na(df$score))

na.omit(df) # 결측치가 하나라도 있는 행 모두 제거

df %>% 
  filter(!is.na(score)) %>% 
  summarise(mean_score = mean(score))

mean(df$score, na.rm = T) # 결측치 제거 후 평균 계산 
tapply (df$score, df$gender, mean, na.rm=T)

# 5.2 결측치 대체하기 (평균값 or 중앙값)
x <- c(1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 100)
mean(x)
median(x)

exam <- read.csv("inData/exam.csv", header = T)
exam

table(is.na(exam))
colnames(exam)
exam[c(3,8,15), 'math'] <- NA # 결측치 인위적으로 넣기 
exam[1:2, 'english'] <- NA

table(is.na(exam))
apply(exam[3:5], 2, mean, na.rm = T)
tapply(exam[, 3], exam$class, mean, na.rm = T)

exam %>% 
  summarise(math = mean(math, na.rm = T),
            english = mean(english, na.rm = T),
            science = mean(science, na.rm = T))

exam$math # 결측치 확인 
exam$math <- ifelse(is.na(exam$math), 
                    median(exam$math, na.rm = T),
                    exam$math) # 중앙값으로 대체 
exam$math <- ifelse(is.na(exam$math), 
                    round(mean(exam$math, na.rm = T)),
                    exam$math) # 평균값으로 대체 
exam$math # 대체여부 확인 

exam$english # 결측치 확인 
exam$english <- ifelse(is.na(exam$english), 
                       round(median(exam$english, na.rm = T)),
                             exam$english) # 대체
exam$english #대체 확인 


table(is.na(exam))

exam <- read.csv("inData/exam.csv")
exam[c(1,3,8),'math'] <- NA
exam[1:2, 'english'] <- NA
exam[1, 'science'] <- NA
head(exam)

median <- round(apply(exam[3:5], 2, median, na.rm = T))
median['math']; median['english']; median['science']

  # 결측치 대체 방법 1
exam <- within(exam, {
    math <- ifelse(is.na(math), median['math'], math)
    english <- ifelse(is.na(english), median['english'], english)
    science <- ifelse(is.na(science), median['science'], science)  
})
table(is.na(exam))
colSums(is.na(exam)) # 변수별 결측치 수 확인 

  # 결측치 대체 방법 2 (dplyr 패키지 이용)
exam <- exam %>% 
  mutate(
    math <- ifelse(is.na(math), median['math'], math),
    english <- ifelse(is.na(english), median['english'], english),
    science <- ifelse(is.na(science), median['science'], science)
  )
exam

# 5.3 이상치(=극단치) 정제하기 
  # 극단적인 이상치(정상범위 기준에서 벗어난 값)
  # 논리적인 이상치(ex. 성별에 남여가 아닌 값)
  # 이상치는 결측치로 대체

# (1) 논리적인 이상치
outlier <- data.frame(gender = c(1, 2, 1, 3, 2),
                      score = c(90, 95, 100, 99, 101))
table(outlier$gender)

 # gender 1은 남, 2는 여, 3은 이상치 처리  
outlier$gender <- ifelse(outlier$gender==3, NA, outlier$gender)
outlier$gender <- ifelse(outlier$gender!= 1 & outlier$gender!=2, NA, outlier$gender)
outlier

  # 100점을 초과하는 score 이상치 처리 
outlier$score <- ifelse(outlier$score>100, NA, outlier$score)
outlier

# (2) 정상범위 기준으로 많이 벗어난 이상치 : 상하위 0.3% 또는 평균+3*표준편차
mpg <- as.data.frame(ggplot2::mpg)

mpg$hwy
mean(mpg$hwy) + 3 * sd(mpg$hwy)
mean(mpg$hwy) - 3 * sd(mpg$hwy)

result <- boxplot(mpg$hwy)$stats
result[1]; result[5]

mpg$hwy <- ifelse(mpg$hwy>result[5] | mpg$hwy<result[1], NA, mpg$hwy)
table(is.na(mpg$hwy))

rm(list=ls())

####################################

# <실전 분석> -5 

#Q1. mpg 데이터에는 연료 종류를 나타낸 fl 변수는 있지만 
#    연료 가격을 나타낸 변수는 없습니다. 
#    위에서 만든 fuel 데이터를 이용해서 
#    mpg 데이터에 price_fl(연료 가격) 변수를 추가하세요.


#Q2. 연료 가격 변수가 잘 추가됐는지 확인하기 위해서 
#    model, fl, price_fl 변수를 추출해 앞부분 5행을 출력해 보세요.


# <실전 분석> - 6

# Q1. popadults는 해당 지역의 성인 인구, poptotal은 전체 인구를 나타냅니다. 
#     midwest 데이터에 '전체 인구 대비 미성년 인구 백분율' 변수를 추가하세요.

# Q2. 미성년 인구 백분율이 가장 높은 상위 5개 county(지역)의 
#     미성년 인구 백분율을 출력하세요.


# Q3. 분류표의 기준에 따라 미성년 비율 등급 변수를 추가하고,
#     각 등급에 몇 개의 지역이 있는지 알아보세요.

# Q4. popasian은 해당 지역의 아시아인 인구를 나타냅니다. 
#     '전체 인구 대비 아시아인 인구 백분율' 변수를 추가하고, 
#     하위 10개 지역의 state(주), county(지역명), 
#     아시아인 인구 백분율을 출력하세요.
# 방법1


# <실전 분석> - 7 

# Q1. drv에 이상치가 있는지 확인하세요. 이상치를 결측 처리한 다음 
#     이상치가 사라졌는지 확인하세요. 
#     결측 처리 할 때는 %in% 기호를 활용하세요.


# Q2. 상자 그림을 이용해서 cty에 이상치가 있는지 확인하세요. 
#     상자 그림의 통계치를 이용해 정상 범위를 벗어난 값을 
#     결측 처리한 후 다시 상자 그림을 만들어 이상치가 사라졌는지 확인하세요.

# Q3. 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다. 
#     이상치를 제외한 다음 drv별로 cty 평균이 어떻게 다른지 알아보세요. 
#     하나의 dplyr 구문으로 만들어야 합니다.