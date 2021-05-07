# # # [14] 지도 시각화 

# 1. 미국 주별 강력 범죄율 시각화 
View(USArrests)

# 1.1 패키지 설치 및 로드
install.packages("ggiraphExtra") # 지도 시각화를 위한 패키지 
install.packages("mapproj") # ggChoropleth함수 사용을 위한 패키지
install.packages("maps")  # map_data함수를 통해 지도 정보 이용

library(ggiraphExtra)
library(mapproj)
library(maps)
library(ggplot2)
library(tibble) # 행이름(지역명)을 변수로 하기 위해 

# 1.2 행 이름을 변수로 
head(USArrests, 1)

crime <- rownames_to_column(USArrests, var = "state")
head(crime, 3)

crime$state <- tolower(crime$state) # 주 이름들을 소문자로 
head(crime, 3)

# (3) 미국 지도 주 정보 가져오기 
state_map <- map_data("state")

# (4) 지도 시각화 
ggChoropleth(data = crime,         # 지도에 표현할 데이터
             aes(fill = Assault,   # 지도에 채워질 변수
                 map_id = state),  # 지역 변수
             map = state_map,      # 위도 경도 지도 데이터
             interactive = T)      # 인터렉티브 속성성

############################

# 2. 대한민국 시도별 인구, 결핵 환자수  단계 구분도 만들기 

# 2.1 데이터 불러오기 
install.packages("stringi")
install.packages("devtools")
devtools::install_github("cardiomoon/kormaps2014")

library(kormaps2014)
library(dplyr)

head(korpop1)
# korpop1 : 2015년 센서스 데이터(시도별)
# korpop2 : 2015년 센서스 데이터(시군구별)
# korpop3 : 2015년 센서스 데이터(읍면동별)

# 2.2 변수명 변경 
korpop1 <- rename(korpop1,
                  pop = 총인구_명,
                  name = 행정구역별_읍면동)


# 2.3 인코딩 변경 
str(changeCode(korpop1))
head(korpop1)

head(changeCode(kormap1))
head(changeCode(korpop1[, c('name', 'pop', 'code')]))

korpop1$name <- iconv(korpop1$name, 'UTF-8', 'CP949')

head(changeCode(tbc))
tbc$name1 <- iconv(tbc$name1, 'UTF-8', 'CP949')
tbc$name <- iconv(tbc$name, 'UTF-8', 'CP949')
head(tbc)

# 2.4 지도 시각화 
ggChoropleth(data = korpop1, # 시도별 인구수 지도시각화 
             aes(fill = pop,
                 map_id = code,
                 tooltip = name),
             map = kormap1,
             interactive = T)

ggChoropleth(data = tbc, # 결핵환자 수 지도시각화 
             aes(fill = NewPts,
                 map_id = code,
                 tooltip = name1),
             map = kormap1,
             interactive = T)

# 한국행정지도(2014) 패키지 kormaps2014 안내
# https://rpubs.com/cardiomoon/222145

