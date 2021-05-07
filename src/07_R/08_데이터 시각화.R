# # # [8] 데이터 시각화 

# 1. 시각화 개요: 
#   원본데이터, 분석된 결과 데이터를 그래프로 표현. 
#   사용자에게 효과적으로 정보전달이 목적

# 1.1 R의 그래픽 시스템
# (1) base graphics system - 전통적인 함수 이용. 
#    그래프 종류별 함수가 각기 달라 정교한 그래프 이용시 노력 필요

# (2) grid graphics system - base graphics system 한계 극복을 위해 탄생한 패키지(ggplot2)
#    유연한 그래프 환경 제공. 
# ex. 
library(ggplot2)

ggplot(data = mtcars, aes(x=wt, y=mpg)) +
  geom_point() +
  labs(title = '그래프 첫 예제') +
  geom_smooth()

# 1.2 그래프 함수 
# (1) 고수준 그래프 함수 
  # plot, barplot, boxplot, hist, pie, ....
  # 그래프 함수를 호출할 때마다, 그래프 영역에 새로운 그래프를 시작
# (2) 저수준 그래프 함수 
  # lines, abline(회귀라인), point, text, ...
  # 새로운 그래프를 생성하지 않음. 이미 그려진 그래프 위에 점, 라인, 글씨..

# 1.3 그래프 파라미터 : bty(박스유형), ....
# (1) par() : 그래프를 조정하거나 특성을 지정. 
#             par()함수의 리턴값은 실행전의 특성을 리턴한다
?cars
plot(cars)

?par
oldPar <- par(bty = ']')
par(oldPar) # oldPar 설정으로 복귀 
plot(cars) # 고수준 그래프 함수 

# fit <- lm(cars$dist ~ cars$speed)
fit <- lm(dist ~ speed, data = cars)
fit
abline(fit, col='red') # 저수준 그래프 함수 

  # ex. par함수의 다른 파라미터 사용 
x <- 1:100
y1 <- rnorm(100) # 평균0이고 표준편차가 1인 수 100개 추출(표준정규분포)
y2 <- rnorm(100) + 100 # 평균은 100이고 표준편차는 1인 수 100개(정규분포)

oldPar <- par(mar = c(5,5,5,5)) # 그래프 여백(하 좌 상 우)

plot(x, y1, 
     pch=0, type='b', 
     col='deeppink4',
     ylim=c(-8, 2), yaxt='n', ylab="")
  # pch ; 0:네모, 1:원, 2세모, 3:십자, 4:x, 5:다이아몬드 ...
  #       문자해당문자
  # type: p:점, l:선, b:점선동시, o:점선겹치면서동시, h:히스토그램,
  #       s:계단모양, n:좌표찍지않음
  # col ; 1:black, 2:red, 3:green, 4:blue, 5:cyan, 6:purple, 7:yellow, 8:gray
  # ylim, xlim ; y눈금, x눈금 조정
  # yaxt : y축 눈금 없애기
  # bty : 그래프 박스 타입 (o, L, 7, U, C, n)

axis(side = 2, at = c(-2,0,2))
  # side : 1하, 2좌, 3상, 4우
  # at : 위치

mtext("red line(y1)",
      side = 2, line = 2,
      at = 0, col = 2)

colors() # 사용 가능한 색상 확인 

par(new=TRUE) # 기존 그래프 영역을 지우지 않고 덧그림
plot(x, y2, 
     pch=1, type='b', 
     col='blue', bty='n',
     ylim=c(98, 108), yaxt='n', ylab='')
axis(side = 4, at = c(98, 100, 102))
mtext("blue line(y2)",
      side = 4, line = 2,
      at = 100, col = 'blue')

par(oldPar) # 그래프 영역 설정 원상 복구 

############################

# 2. 고수준 그래프 함수 
# 2.1 plot : type에 따라 여러 유형의 그래프를 그림. 산점도 그래프 함수
plot(cars,
     main = 'Speed and Stopping Distance of Cars',
     xlab = 'speed(mph)', ylab = 'stopping distance(ft)',
     las = 1)
    # las;축눈금라벨방향; 0:축과평행, 1:가로, 2:축과수직 3:세로

  # ex. 2행3열로 그래프 영역 분리 후 type 속성에 따른 그래프 그리기
oldPar <- par(mfrow = c(2,3))

plot(cars, type='p', main='p타입') # 산점도
plot(cars, type='l', main='l타입') # 추세선
plot(cars, type='b', main='b타입') # 선점(겹치지 않게)
plot(cars, type='s', main='s타입') # 계단
plot(cars, type='n', main='n타입') # 그리지 않음
plot(cars, type='o', main='o타입') # 선과 점이 겹치게 

par(oldPar)

# 2.2 barplot: 막대그래프 
VADeaths

barplot(VADeaths,
        main = "버지니아주 사망률", 
        font = 2, border = 'red',
        legend = rownames(VADeaths), # legend ; 오른쪽 상단 범례 
        angle = c(10, 30, 50, 70, 120), # angle ; 막대그래프에 칠할 빗금의 각도
        density = 50, col =  rainbow(5)) # density ; 막대그래프 안에 칠할 선의 수

barplot(VADeaths,
        main = "버지니아주 사망률", 
        font = 2, border = 'red',
        legend = rownames(VADeaths),  
        angle = c(10, 30, 50, 70, 120),
        density = 50, col =  rainbow(5),
        beside = TRUE)

# 2.3 boxplot: 사분위수 그래프 
InsectSprays

boxplot(InsectSprays$count)
boxplot(count ~ spray, data = InsectSprays, col = 'tomato4')
tapply(InsectSprays$count, InsectSprays$spray, median)

# 2.4 hist: 히스토그램(도수분포표)
x <- c(1, 1, 2, 2, 2, 3, 4, 4)
hist(x)

h <- hist(x, breaks = c(0, 1, 2, 3, 4)) # breaks; 구간
h

text(h$mids, h$counts, h$counts, adj = c(0,-.5), col = 'black') 
text(h$mids, h$counts, h$counts, adj = c(0, 0), col = 'red')
text(h$mids, h$counts, h$counts, adj = c(1, 0), col = 'blue')
text(h$mids, h$counts, h$counts, adj = c(0, 1), col = 'green')
text(h$mids, h$counts, h$counts, adj = c(1, 1), col = 'purple')
                               # adj; 위치 재조정  

islands # 1만 평방마일을 초과하는 주요대륙 넓이 정보
class(islands)
is.vector(islands)
hist(sqrt(islands), breaks = c(2, 35, 70, 100, 140))

# 2.5 pie 
pie.sales <- c(0.1, 0.3, 0.2, 0.15, 0.1, 0.15)
sum(pie.sales)
names(pie.sales) <- c("c", "java", "python", "R", "oracle", "hadoop")
pie.sales

pie(pie.sales) # 반시계 방향으로(default)
pie(pie.sales, clockwise = T,  # 시계 방향 
    col = c('red','orange','yellow','green','white','cornsilk'))
pie(pie.sales, clockwise = T, col = rainbow(6))

# 2.6 mosaicplot
?Titanic
class(Titanic)
Titanic

mosaicplot(Titanic, color = T)
mosaicplot(~Sex+Age+Survived, data = Titanic, color = T)

#############################

# 3. 저수준 그래프 함수 

# 3.1 points 
plot(-4:4, -4:4, type='n') 
points(rnorm(100), rnorm(100), 
       col = 'brown', pch = 3)

# 3.2 lines 
plot(cars, main = 'Speed and Distance')
fit <- lm(dist ~ speed, cars)
fit
lines(cars$speed, 
      3.932*cars$speed-17.579, col='blue')

# 3.3 abline: 회귀식 선 
abline(fit, col = 'red', lty = 'dashed')
                       # lty: 라인의 스타일  

# 3.4 text(x, y, 출력할 텍스트, 그 외 옵션들 )
plot(1:5, 1:5, type='n')
text(3, 3, 'A', adj=c(0,0), col='red')
text(2, 4, 
     expression(hat(beta) == (X^t^X)^{-1} * X^t^Y),
     cex = 2, adj = c(0,0))

#############################

# 4. ggplot2 패키지 함수
install.packages("ggplot2")
library(ggplot2)
  # 1: 그래프초기화(데이터셋, 변수설정)하는 ggplot - 그 자체로는 그래프 표현X   
  #   2: 그래프의 결과물에 대응하는 geom함수  
  # 3: 부가 요소를 추가 함수
  # +기호를 이용해서 함수들을 연결하는 방식으로 그래프 생성

# ggplot(data, aes(x=, y=, )) +
#  geom함수() + #어떤 그래프를 그릴지
#  labs(제목, x축 , y축에 label) +
#  scale함수() +
#  theme() +
#  coord_cartesian()
ggplot(data = mtcars, aes(x = wt, y = mpg)) +
  geom_point(aes(size = mpg, color = cyl)) +
  labs(title = "wt & Fuel consumption",
       x = "weight(1,000lbs)",
       y = "Fuel consumption (miles per gallon)",
       subtitle = "(차량 무게와 연비의 관계)",
       caption = "source: mpg datasets")

# 4.1 산점도, 적합도, text...
  # ex. x축 iris$Petal.Length,  y축 iris$Petal.Width의 산점도
  #     점의 색은 종별로 다르게
ggplot(data = iris, aes(x = Petal.Length, y = Petal.Width)) +
  geom_point(aes(color = Species)) +
  scale_color_manual(values = c('black', 'red', 'orange')) +
  labs(title = 'iris 데이터의 산점도',
       x = "꽃잎 길이", y = "꽃잎 너비") +
  coord_cartesian(ylim = c(0, 2)) + 
  geom_smooth()

  # ex. airquality$Ozone과 airquality$Solar.R과의 관계를 표현하는 산점도
  #       월별로 점의 색을 다르게
head(airquality)

ggplot(data = airquality, aes(x = Ozone, y = Solar.R)) +
  geom_point(aes(color = Month)) +
  labs(title = "오존량과 태양 복사량의 관계") +
  geom_smooth(method = "lm")

  # ex. mtcars데이터셋에서 차량 무게와 연비의 관계 
ggplot(data = mtcars, aes(x = wt, y = mpg)) +
  geom_point(shape = 25, color = 'blue', 
             bg = 'red', stroke = 2, size = 2) + 
  # shape = par의 pch / stroke 테두리 두께 / size 점크기
  geom_smooth(method = 'lm', color = 'red', 
              size = 2, linetype = 2) + 
  geom_text(label = rownames(mtcars), 
            hjust = 0, vjust = 0, 
            size = 3, nudge_y = 0.5) + 
  labs(x = "차량 무게(1,000lbs)", y = "연비",
       title = "차량 무게와 연비의 관계", 
       caption = "참조: datasets의 mtcars")

# 4.2 히스토그램 
rm(list=ls())

head(mtcars)
dim(mtcars)
str(mtcars)

mtcars$cyl <- factor(mtcars$cyl, 
                     levels = c(4, 6, 8),
                     labels = c('4 cylinders',
                                '6 cylinders',
                                '8 cylinders'))
head(mtcars)
str(mtcars$cyl)

ggplot(data = mtcars, aes(x = mpg)) +
  geom_histogram() +
  facet_grid(cyl ~.) + # 3개의 패널에 그리는 함수
  labs(title = 'cyl에 따른 연비 히스토그램',
       x = '연비', y = '횟수수')

  # !! 히스토그램은 연속형 자료형에서의 도수분포표이다. 
  ggplot(data = mtcars, aes(x = cyl)) +
    geom_histogram() # cyl은 연속형 자로형이 아니라서 실행 불가 
  
  # ex.ggplot2::mpg 데이터셋에서 displ도수분포표 
  #    (class에 따라 그래프의 색을 다르게) 
str(mpg$displ)
  
ggplot(mpg, aes(x = displ)) +
  geom_histogram(aes(fill = class)) +
  theme(axis.text.x = element_text(color = 'red', size = 15),
        axis.line = element_line(color = 'black', size = 2),
        axis.text.y = element_blank(),
        panel.background = element_rect(fill = 'lightblue',
                                        linetype = 'dotted',
                                        color = "black"),
        plot.background = element_rect(fill = 'lightgreen'))

ggplot(mpg, aes(x = displ)) +
  geom_histogram(aes(fill = class), 
                 binwidth = 0.1) + # binwidth: bin의 넓이
  labs(title = "Histogram with Auto Bining",
       subtitle = "(Engine Displacement across Vehicle Classes)") +
  theme(legend.position = "bottom")
  
ggplot(mpg, aes(x = displ)) +
  geom_histogram(aes(fill = class),
                 bins = 5, color = "black") 
               # bin의 갯수(default: 30) / binwidth를 지정하면 bins는 무시됨 
    
# 4.3 상자도표(boxplot)
boxplot(iris$Sepal.Length)$stat # for 이상치 처리 

ggplot(iris, aes(y = Sepal.Length)) +
  geom_boxplot()

  # ex. 종별로 꽃받침 길이의 차이가 있는가? 
tapply(iris$Sepal.Length, iris$Species, mean) # 도표 

ggplot(iris, aes(y = Sepal.Length, x = Species)) + # 시각화
  geom_boxplot(aes(fill = Species), col = 'dimgray') + 
  scale_fill_manual(values = c('#FF0000', 'yellow', 'green'))

library(RColorBrewer)  
display.brewer.all() # 팔레트 표 
pal <- brewer.pal(8, 'Set2')

ggplot(iris, aes(y = Sepal.Length, x = Species)) +
  geom_boxplot(aes(fill = Species), col = 'dimgray') + 
  scale_fill_manual(values = pal)

  # ex. 대륙별로 GDP에 차이가 있는가? 
install.packages("gapminder")
library(gapminder)  
table(gapminder$country)  
dim(gapminder) # 대륙별, 나라별 인구와 GDP 데이터 

table(gapminder$continent)
ggplot(gapminder, aes(x = continent, y = gdpPercap)) + 
  geom_boxplot(aes(fill = continent)) + 
  coord_cartesian(ylim = c(0, 30000))

  # ex. 교수들의 직급별 연봉이 상이한가? 
install.packages("car")
library(car)
Salaries
dim(Salaries)
colnames(Salaries)

ggplot(Salaries, aes(x = rank, y = salary)) +
  geom_boxplot(aes(col = rank), 
               fill = "lightyellow",
               notch = T) + 
  # notch = T : 중위수에 대해서 95% 신뢰구간 표현, 신뢰구간이 겹치는지 파악
  geom_point(position = 'jitter', # 산점도 분산시키기 
             col = 'brown', alpha = 0.3, pch = 2) +
  geom_rug(col = 'dimgray', sides = "1")
  # 관측값의 밀도 상태 표현 
  # (데이터가 많은 곳은 빽빽하게, 데이터가 적은 곳은 하얗게)
  
  # ex. mtcars데이터에서 cyl갯수에 따른 연비(mpg)의 95% 중위수 신뢰구간 시각화
head(mtcars)
str(mtcars$cyl)  

ggplot(data = mtcars, aes(y = cyl, x = mpg, fill = cyl)) + 
  geom_boxplot(notch = T)
  
# 4.4 바이올린 도표; 상자도표 + 밀도도표 
  # ex. 합창부 단원의 key와 성악부 part의 관계 
singer <- lattice::singer
head(singer)  
View(singer)  
str(singer)

ggplot(data = singer, aes(x = voice.part, y = height)) +
  geom_boxplot()

ggplot(data = singer, aes(x = voice.part, y = height)) +
  geom_violin(fill = 'honeydew2') + 
  geom_boxplot(width = 0.3, fill = 'green')

# 4.5 밀도 도표 
  # ex. 실린더 수(cyl)에 따른 연비(mpg)의 밀도 도표
head(mtcars, 1)

ggplot(data = mtcars, aes(x = mpg, fill = cyl)) + 
  geom_density() + 
  labs(title = '밀도 도표',
       x = 'Miles per Gallon') + 
  theme(legend.position = c(0.7, 0.8))

# 4.6 추세선 (시계열에서 데이터의 흐름을 표현)
  # ex. 시간(date)에 따른 실업률(unemploy)
economics
colnames(economics)

ggplot(data = economics, aes(x = date, y = unemploy)) +
  geom_line() + # 추세선 
  geom_smooth(method = 'lm') # 적합도선

# 4.7 막대 도표(geom_bar함수 / geom_col함수)
# 도수분포표 ; 막대도표, 히스토그램 모두 
  # 히스토스램 : 연속형 자료를 계급으로 나누어 계급별 도수를 나타냄
                # geom_histogram()함수
  # 막대도표 : 범주형 자료의 빈도를 나타냄
                # geom_bar(), geom_col()함수

  # ex. mpg 데이터셋에서, 제조회사별 빈도표 나타내기
str(mpg$manufacturer)

ggplot(data = mpg, aes(x = manufacturer)) + 
  geom_histogram() # 실행 불가 

ggplot(data = mpg, aes(x = manufacturer)) +
  geom_bar(stat = "count") # stat = "count" : 빈도를 시각화 

str(mpg$class)

ggplot(data = mpg, aes(x = manufacturer, fill = class)) + 
  geom_bar() +
  theme(legend.position = "bottom", 
        axis.text.x = element_text(angle = 60, vjust = 0.7)) +
  scale_fill_manual(values = topo.colors(7)) +
  labs(title = '제조사 별 class 빈도표')

  # ex. 다이아몬드의 품질(cut)별 빈도 수 
head(diamonds)
str(diamonds)
table(diamonds$cut)

ggplot(diamonds, aes(x = cut, fill = cut, col = cut)) +
  geom_bar(stat = "count") +
  scale_fill_manual(values = topo.colors(5)) +
  scale_color_manual(values = rainbow(5))

  # ex. 다이아몬드의 품질별 색상 수 
table(diamonds$cut, diamonds$color)
table(diamonds$color)

library(dplyr)

diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x = cut, fill = color, y = n)) +  
  geom_bar(stat = "identity")

diamonds %>%  # 위와 결과 동일 
  group_by(cut, color) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x = cut, fill = color, y = n)) +  
  geom_col()

  # ex. 다이아몬드의 품질별, 색상별 막대그래프 
diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x = cut, fill = color, y = n)) + 
  geom_bar(stat = "identity", position = 'dodge')

diamonds %>% 
  group_by(cut, color) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x = cut, fill = color, y = n)) + 
  geom_col(position = 'dodge')

  # ex. 다이아몬드의 품질별 table별 빈도수 시각화 
diamonds %>% 
  group_by(cut, table) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x = table, y = n)) + 
  geom_bar(stat = "identity") + 
  facet_wrap(~cut) + # cut별로 시각화 다르게
  coord_cartesian(ylim = c(0, 3000), xlim = c(50, 80))

  # ex. 다이아몬드의 품질별 table의 종류 수 
diamonds %>% 
  group_by(cut, table) %>% 
  summarise(n = n()) %>%
  group_by(cut) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x = cut, y = n, fill = cut)) + 
  # geom_bar(stat = 'identity')
  geom_col()

diamonds %>% 
  group_by(cut) %>% 
  summarise(n = n_distinct(table)) %>%  # cut별 table 종류 수 
  ggplot(aes(x = cut, y = n, fill = cut)) + 
  # geom_bar(stat = 'identity')
  geom_col()

# 4.8 그래프를 파일에 저장하기 
# (1) basic 그래프, ggplot2 그래프 모두 저장 
jpeg('outData/08_iris.jpg')
boxplot(iris$Sepal.Length)
dev.off()
getwd()

png('outData/08_iris.png', width = 300, height = 150)
ggplot(iris, aes(x = Sepal.Length, y = Sepal.Width)) + 
  geom_point() +
  facet_wrap(~Species)
dev.off()

# (2) ggplot2 그래프에서만 저장
ggplot(iris, aes(x = Sepal.Length, y = Petal.Length, col = Species)) + 
  geom_point(aes(size = Petal.Width), pch = 2, alpha = 0.5)
ggsave('outData/08_iris2.jpg') 

# 4.9 차트 분할 출력 
install.packages("gridExtra")
library(gridExtra)

g1 <- ggplot(iris, aes(x = Petal.Width, y = Petal.Length)) +
        geom_point()
g2 <- ggplot(iris, aes(x = Sepal.Width, y= Sepal.Length)) + 
        geom_point()

grid.arrange(g1, g2, ncol = 2)

##############################

# 5. 산점도 행렬 
plot(iris[-5])
pairs(iris[-5], panel = panel.smooth)
              # panel = panel.smooth: 추세선 추가

##############################

# <참고> 

# 1. 밀도함수 dnorm
x <- seq(-3, 3, length = 200)
y <- dnorm(x, mean = 0, sd = 1)

plot(x, y, type = 'l', 
     main = '정규분포 x~N(0,1)')

# 2. 누적분포함수 pnorm
x <- seq(-3,3, length=200)
y <- pnorm(x, mean=0, sd=1)

plot(x, y, type = 'l')

random_norm_10000 <- rnorm(10000, mean = 0, sd = 1)
hist(random_norm_10000)
