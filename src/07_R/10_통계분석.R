# # # [10] 통계분석 

# 두 그룹간 평균의 차이가 통계적으로 유의한지 검증 : t-test분석
# 세그룹 이상 집단의 평균 차이가 유의한지 검증 : ANOVA분석(분산분석)

# 1. 두 그룹 간의 평균 차이가 유의한지 분석하기 

# 순서 
# (0) 데이터 가져오기
# (1) 도표로 차이의 유의성을 표현 (tapply, by, summaryBy, aggregate.. 평균, 분산)
# (2) 그래프로 시각화된 유의성 표현(바이올린도표, 산점도, 상자도표)
# (3) 통계적으로 유의한지 검증

  ### ex. 비타민의 종류(supp)가 기니피그의 치아 길이(len)에 영향을 미치는가? 
# (0)
ToothGrowth
table(ToothGrowth$supp)

ToothGrowth <- rbind(ToothGrowth, ToothGrowth) # 데이터 부풀리기 (3번 실행)
nrow(ToothGrowth)
table(is.na(ToothGrowth))
colSums(is.na(ToothGrowth))

# (1) 도표
library(doBy)
library(dplyr)

summaryBy(len ~ supp, data = ToothGrowth, FUN = c(mean, sd))

ToothGrowth %>% 
  group_by(supp) %>% 
  summarise(len.mean = mean(len),
            len.sd = sd(len))

# (2) 시각화
library(ggplot2)

ToothGrowth %>% 
  group_by(supp) %>% 
  summarise(len.mean = mean(len)) %>% 
  ggplot(aes(x = supp, y = len.mean)) +
  geom_col(aes(fill = supp), width = 0.7)

ggplot(data = ToothGrowth, aes(x = supp, y = len)) +
  geom_violin() +
  geom_point(position = 'jitter', col = 'skyblue', alpha = 0.7) +
  geom_boxplot(aes(fill = supp), notch = T, width = 0.4)

# (3) 통계 분석 
# 1) 일원 표본 t.test 
table(ToothGrowth$supp, useNA = "ifany") # 결측치 빈도까지 출력 
table(ToothGrowth$supp, exclude = NULL)

a <- ToothGrowth[ToothGrowth$supp == 'OJ', 'len']
b <- ToothGrowth[ToothGrowth$supp == 'VC', 'len']

t.test(a - b)
t.test(a, b)
  # p-value가 0.05보다 작은 경우 귀무가설(두 그룹의 평균이 같다)을 기각함
  # p-value가 0.05보다 큰경우 귀무가설을 기각하지 못한다.

# 2) 이원표본 t.test (등분산성 테스트 -> t.test 분석)
var.test(len ~ supp, data = ToothGrowth)
  # p-value가 0.05보다 작은 경우 귀무가설(두 그룹의 분산이 같다)을 기각함
  #                                             - 등분산성이 성립되지 않음
  # p-value가 0.05보다 큰경우 귀무가설을 기각하지 못한다. - 등분산 성립
  #                                             - 등분산 성립 

t.test(len ~ supp, data = ToothGrowth, var.equal = F)
                        # var.equal=F : 두그룹의 등분산성이 성립되지 않는 경우
                        # var.equal=T : 두그룹의 등분산성이 성립되지 않는 경우
  # p-value가 0.05보다 작은 경우 : 귀무가설을 기각
  # p-value가 0.05보다 큰 경우 : 귀무가설을 기각할 수 없음

rm(list=ls())

  ### ex. 수면제(group)에 따른 수면량(extra)의 변화가 있는가?  
# (0) 데이터
sleep <- rbind(sleep, sleep) # 데이터 부풀리기 (4번 실행)
nrow(sleep)
head(sleep)
str(sleep)
table(sleep$group, useNA = "ifany")

# (1) 도표 
summaryBy(extra ~ group, data = sleep, FUN = c(mean, sd))

sleep %>% 
  group_by(group) %>% 
  summarise(mean = mean(extra),
            sd = sd(extra))

# (2) 시각화 
result <- summaryBy(extra ~ group, data = sleep, FUN = c(mean, sd))
ggplot(result, aes(x = group, y = extra.mean)) +
  geom_col(aes(fill = group, width = 0.7))

ggplot(data = sleep, aes(x = group, y = extra)) +
  geom_point(position = 'jitter', col = 'skyblue', alpha = 0.7) +
  geom_violin(width = 0.7) +
  geom_boxplot(aes(fill = group), notch = T, width = 0.5)

# (3) 통계 분석 
var.test(extra ~ group, data = sleep) # p-value > 0.05
t.test(extra ~ group, data = sleep, var.equal = T)
  # p-value가 0.05보다 작아 두 그룹사이의 평균이 같다는 귀무가설을 기각한다.  
  
####################################

# 2. 3개 이상의 그룹간 평균 차이 비교하기 

# 2.1 aov()
  ### ex. iris의 꽃받침 길이의 평균은 종에 따라 다른가? 
  #       (Species: 독립변수 / Sepal.Length: 종속 변수)
result <- aov(Sepal.Length ~ Species, data = iris) # Species: 범주형, 연속형   
summary(result) 
# F값이 0.05보다 작으면 귀무가설을 기각
# F값이 0.05보다 크면 귀무가설을 기각할 수 없다

# 2.2 anova()
  ### ex. 엔진의 기통수(cyl)에 따라 연비(mpg)의 평균이 다른가?
str(mtcars$cyl)
table(mtcars$cyl, useNA = "ifany")  

# cyl의 그룹 수 3개, 연속형 변수 

fit <- lm(mpg ~ cyl, data = mtcars)
fit
anova(fit)

  ### ex. 오렌지 나무의 연령(age)에 따른 둘레(circumference)의 평균이 상이한가?
head(Orange)
str(Orange$age)
nrow(Orange)

fit <- lm(circumference ~ age, data = Orange)
anova(fit)


