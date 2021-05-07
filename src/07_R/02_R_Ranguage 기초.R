### [2] R Language 기초

# 1. 도움말 기능 
# 1.1 도움말 
iris
?iris       
help(iris) 

# 1.2 검색 기능 
??iris
help.search('iris')

# 1.3 패키지 도움말 
library(help='datasets')

# 1.4 함수 도움말 
methods(as) # 형변환 함수들
as.integer(1.25)
?as.integer
example("as.integer") # 예제 출력

data <- c(10,20,30) # 할당
mean(data) # data값의 평균
?mean
example(mean) #열이름, 행이름, 타입 

# #: 주석 
# Tab: 자동완성
R.version # R 버전 정보 확인 

# 1.5 정보 조회
edit(iris)
attributes(iris)

#######################

# 2. 패키지 (R 안에 있는 기본 패키지 이외의 패키지는 다운을 받아 사용한다.)
# 2.1 패키지 설치 
  # 설치 : install.package("패키지명")
  # 설치된 패키지를 메모리에 로드 library("패키지명")
  # 패키지 내의 데이터나 함수들 막 사용
  # 패키지 언로드 : detach("package:패키지명", unload=TRUE)
iris
detach("package:datasets", unload=TRUE)
iris # 언로드 확인

install.packages('arules')
library('arules')
?apriori
detach("package:arules", unload=TRUE)
arules

  # 데이터의 경우, 메모리에 패키지 로드 없이 사용 가능 
data(iris, package='datasets') 
iris

########################

# 3. 변수 
  # 변수 : 특수문자 중 ., _ 사용가능
  # 할당 : <-, <<-
result <- 0 # 전역변수 result
class(result) # 타입 확인

add <- function(a,b) {
  # result <- a+b # 지역변수
  result <<- a+b # 전역변수에 할당
  return(result)
}
add(10,20)
result

  # 변수 목록 조회
x <- 10
y <- 10
(z <- x+y)
ls() # 현재까지 생성된 변수들 출력 
?ls
ls(all.names = TRUE) # 히든 변수까지 포함하여 출력

################### 

# 4. 출력 
result
print(result)
(z <- z+10)

paste('Hello', 'World') # Hello World
paste('result값은', result)
paste('Hello', 'World', sep=', ') 

1:3 
paste(c(1,2,3), c('하나','둘','셋'), sep='은 ')
paste(c(1,2,3), c('하나','둘','셋'), sep='은 ', collapse=' / ')

month.name
(nth <- paste(1:12, c('st','nd','rd',rep('th',9)), sep=''))

###################

# 5. 변수 삭제 
rm(z) # z변수 삭제
rm(list=ls()) # 히든 변수를 제외한 일반 변수들 삭제
rm(list=ls(all.names = TRUE)) # 히든 변수들까지 전부 삭제제

###################

# 6. 확장명
  # ~.R : R 스크립트 파일(R실행코드 저장)
  # ~.RData : R작업공간
  # ~.Rhistory : 콘솔창에 실행한 R명령어들의 history 저장 

###################

# <문제>
# 문1.  kor 변수에 '한국','일본','미국'
#       usa 변수에 'Korea', 'Japan', 'America'
#       출력은 한국:Korea, 일본:Japen, 미국:Ameria
#       "한국:Korea" "일본:Japen" 미국:Ameria"
kor <- c('한국', '일본', '미국') # 동질자료형
usa <- c('Korea', 'Japan', 'America')
(str <-paste(kor, usa, sep=':', collapse=', '))
(strVector <- paste(kor, usa, sep = ':'))

# 문2. MASS::Cars93 데이터를 출력하기
install.packages("MASS")
library(MASS)
Cars93
edit(Cars93)
head(Cars93) # 첫 여섯행만 출력 

