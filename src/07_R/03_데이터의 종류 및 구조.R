### [3] 데이터의 종류 및 구조 

# 1.데이터의 종류
  # 기본데이터타입(문자, 숫자, logical)=스칼라타입
  # # 팩터, 벡터, 리스트, 행렬, 배열, 데이터프레임, 날짜, 특별한 값(결측치...)


# 2. 기본데이터 타입 : character, numeric, logical
a <- 'Hello'
b <- 'Hello 
R'

cat(a) # print와 비슷, \n 수행
cat('a값은', a)

b <- 10.1
b <- 10

strB <- as.character(b) # as.*: *타입으로 형변환
strB

c <- TRUE;
c
is.logical(c) # methods(is) -> is.*(): *형이나 값을 물어본다.

class(strB)
class(a)
class(b)
class(c)

#####################

# 3. 특별한 값(Null, NA;결측치, NaN, Inf)
# 3.1 Null
result <- 0
add <- function(a,b) {
  result <<- a*5+b # 전역변수 result에 할당
  # return(result)
  return()
}
(temp <- add(1,2)) # 일반변수 temp에 할당
(temp <- add(a=1, b=2))
(temp <- add(b=10, a=5))
(temp <- add(a=1, b=3)) # NULL; empty value
is.null(temp)
 
# 3.2 NA(결측치)
  # is.na(d) # 결측치인지 아닌지 NA가 있으면 TRUE
  # complete.case(d) #NA가 없으면 TRUE
  # na.omit(d) ; 결측치 제외
  # na.pass(d) ; NA여부 상관없이 처리

d <- c(2, 4, NA, 6, NaN, 10/0) # vector(동일자료형 집합)
d 

is.na(d[3])
is.na(d)
?is.na
complete.cases(d) # is.na와 반대의 결과
na.omit(d)
na.pass(d)

mean(d) # 평균 계산시 결측치가 있을 경우 평균값은 결측치 

d <- c(2, 3, 4, 5, NA, 12)
mean(d, na.rm=TRUE) # 결측치 제외하고 평균값 출력해
boxplot(d)

###################

# 4. 팩터(Factor): 범주형데이터, 명명식, 순서식 
gender1 <- c('남', '남', '여')
gender1[3]
class(gender1)

gender1[4] <- '?'
gender1

gender <- factor(c('남','남','여'), levels=c('남','여')) # 범주 설정 
class(gender)
gender[3]
gender
str(gender)
gender[4] <- '?'
gender


level <- factor(c('좋음','보통','보통'),
                levels = c('싫음','보통','좋음'),
                ordered = T)
level
level <- ordered(c('좋음','보통','보통'),
                levels = c('싫음','보통','좋음'))
level                

level[4] <- '모름'
level

nlevels(level) # level변수의 범주 갯수
nlevels(gender)
levels(level) # level변수의 범주들들

####################

# 5. 구조형 변수와 복합형 변수 ; 변수하나에 여러 값을 가져야 함 
# (1)구조형 변수 : 동일자료형
#    ex. 벡터, 행렬(회귀식 용이), 배열
# (2)복합형 변수 : 서로 다른 자료형을 가질 수 있음
#    ex. 리스트, 데이터프레임(csv)

# 6. 벡터(Veotor): 동일 자료형의 집합 
data <- c(11, 22, 33, 'Test') # 숫자, 문자 -> 문자
data <- c(11, 22, 33, TRUE) # 숫자, logical -> 숫자(T:1, F:0) 
data <- c(TRUE, 'TEST') # logical, 문자 -> 문자
data

  # 행과 열의 정보 조회
NROW(data) # 항목의 수
length(data) 

  # 특정 값 조회 
data <- c(1:4)
data
names(data) <- c('A','B','C','D')
data

data[1]
data['A열']
data[c(1,2)]
data[c(1:2)]
data[c('A','B')]
data[-2] # 2열만 제외하고 반환
data[data > 2] # 2열보다 큰 열만 반환
data[c(TRUE, FALSE, FALSE, TRUE)] # TRUE인 열만 반환환
2 %in% data # data변수 안에 2가 포함되어 있니?

  # ex. 시험점수 변수들 만들어 출력하고 ②전체 평균을 구한 후 출력
score <- c(80,60,70,50,90, NA)
cat(score)

(avg <- mean(score, na.rm = T))

names(score)
names(score) <- c('Kim', 'Lee', 'park', 'Choi', 'Jung', 'Cho')
score
score[score > 80]

class(score) # class함수 이용시 벡터 요소 하나하나의 타입 
is.vector(score)

# 6.1 character()
charArr <- character() # charArr length가 0인 벡터 생성 
is.vector(charArr)
length(charArr)

charArr <- character(5) # charArr length가 5인 벡터 생성 
charArr[1] <- '안녕'; charArr[2]='R'; charArr[3]='공부중'
charArr[7] <- '테스트' # 인덱스 범위를 벗어난 곳도 값이 설정됨 
charArr 
  # (인덱스 범위 안의 빈 인덱스: ""(빈 스트링) 
  # (인덱스범위를 벗어난 곳: 값이 설정되지 않았을 경우 결측치) 

# 6.2 numeric()
intArr <- numeric()
class(intArr)
is.vector(intArr)

intArr[1] <- 1
intArr[3] <- 3
intArr # 값이 설정되지 않은 곳은 결측치 

# 6.3 logical()
logicArr <- logical(2) 
logicArr[1] <- TRUE
logicArr[2] <- FALSE
logicArr[3] <- T
logicArr 

# 6.4 seq(): 순서 객체를 만드는 함수
a <- seq(from=1, to=10)
a <- seq(from=1, to=10, by=2)
a <- 1:10

is.vector(a)

seq(10, -10, -2)
seq(0, 1, 0.1)
seq(1, 9, by = pi)

# 6.5 rep(): 반복 객체를 만드는 함수 
rep(1:4, each=2)
rep(1:4, c(1,2,3,4))
rep(1:4, each=2, len=6)
rep(1:4, times=2)

# 6.6 벡터의 연산 
  # 기본 연산 
a <- c(1,2,3)
b <- c(10,20,30)
a + b  
a - b
a ^ b
a * b
a %% b  # 나머지 연산자
c(a, b) # 벡터의 결합 

a <- c(1,2,3)
b <- c('Hello', 'R')
c <- c(TRUE, FALSE)
(z <- c(a,b,c))
a <- append(a, c(4,5,6))
a <- append(a, 7)
a[8] <- 8
a

  # 벡터의 집합 연산 
a <- c(1, 2, 3, 4, 5, 6)
b <- c(2, 4, 6, 8, 10, 12)

union(a, b) # 합집합
intersect(a, b) # 교집합
setdiff(a, b) # 차집합 
setdiff(b, a)
setequal(a, b) # 비교
setequal(a, c(intersect(a, b), setdiff(a, b)))

####################

# 7. 리스트
student <- list(name='Park', age=30)
student
studentVector <- unlist(student)
studentVector

s <- c('Park', 30)
names(s) <- c('name', 'age')
student <- as.list(s)

student['name']
student$name
student[1]
student[[1]] # 내용만 출력 

student$age <- NULL #student의 age 제거 
student

NROW(student) # 항목의 수 
length(student)

####################

# 8. 행렬 
colMatrix <- matrix(1:15, nrow=5, ncol=3)
colMatrix
colMatrix <- matrix(1:15, nrow=5, byrow=FALSE)
colMatrix

rowMatrix <- matrix(1:15, nrow=5, ncol=3, byrow=T,
                    dimnames = list(c('R1','R2','R3','R4','R5'),
                                    c('C1','C2','C3'))
                    )
rowMatrix

dim(rowMatrix) # 행과 열의 수
nrow(rowMatrix)
NROW(rowMatrix)
ncol(rowMatrix)
NCOL(rowMatrix)
dimnames(rowMatrix) # 행과 열의 이름
rownames(rowMatrix)
colnames(rowMatrix)

dimnames(rowMatrix) <- list(c('1월','2월','3월','4월','5월'),
                            c('kim','lee','park')) # 행과 열 이름 수정 
dimnames(rowMatrix)
rowMatrix

  # 행렬의 곱을 이용한 선형회귀식 도출 
x <- c(2, 4) # 공부한 시간 
y <- c(40, 60) # 점수

X <- matrix(c(x, rep(1, NROW(x))), nrow = 2, ncol = 2, byrow = F)
X
Y <- matrix(y, ncol = 1) 
Y

    # X %*% ab = Y
    # solve(X) %*% X %*% ab = solve(X) %*% Y
ab <- solve(X) %*% Y
ab
ab[1] # x의 기울기 
ab[2] # 절편 

plot(x, y) # 시각화
lines(x, x*ab[1]+ab[2])


x <- c(32, 64, 96, 118, 126, 144, 152.5, 158) #독립변수
y <- c(18, 24, 61.5, 49, 52, 105, 130.3, 125)

X <- matrix(c(x, rep(1, NROW(x))), ncol = 2)
X
Y <- matrix(y, ncol = 1)
Y

  # 전치행렬을 곱하여 정방행렬로 만들기
t(X) # X의  전치행렬
t(X) %*% X # 2x8 %*% 8x2 => 2x2 정방행렬

  # X %*% ab = Y
  # t(X) %*% X %*% ab = t(X) %*% Y
  # solve(t(X) %*% X) %*% t(X) %*% X %*% ab = solve(t(X) %*% X) %*% t(X) %*% Y
  # ab = solve(t(X) %*% X) %*% t(X) %*% Y
ab = solve(t(X) %*% X) %*% t(X) %*% Y
ab
plot(x, y)
lines(x, x*ab[1]+ab[2])

  # 다변량에서의 회귀분석 도출
x1 <- c(60, 65, 55) # 몸무게
x2 <- c(5.5, 5.0, 6.0) # 키
x3 <- c(1, 0, 1) # 흡연유무 
y <- c(66, 74, 78)

X <- matrix(c(x1, x2, x3), ncol = 3)
X
Y <- matrix(y, ncol = 1)
Y

ab = solve(X) %*% Y
ab

  # Q. 몸무게 80kg, 키 6.5ft, 금연자의 예상 수명은? 
80*ab[1] + 6.5*ab[2] + 0*ab[3]

# 행렬의 연산 
a <- matrix(1:4, nrow=2, ncol=2)
a
b <- matrix(seq(10,40,10), nrow=2, ncol=2)
b
a + b
a * b
a ^ b 
a %% b

# 행렬의 곱 (%*%)
payMatrix <- matrix(c(12000, 26000, 18000), ncol=3)
payMatrix
dimnames(payMatrix) <- list(c('시간당수당'),
                            c('길동', '둘리', '또치'))
payMatrix

workerMatrix <- matrix(c(c(5, 4, 9), c(7, 3, 2)),
                       ncol=2)
workerMatrix
dimnames(workerMatrix) <- list(c('길동', '둘리', '또치'),
                               c('1월', '2월'))
workerMatrix

cost <- payMatrix %*% workerMatrix # 1x3 %* 3x2 => 1x2
cost
rownames(cost) <- c('인건비')
cost

#######################

# 9. 배열
dataArray <- array(1:24, dim=c(3,4,2))
dataArray

dataArray[1,1,1] # 1행 1열 1면
dim(dataArray) # 차원의 크기 조회
nrow(dataArray) # 행의 수
NROW(dataArray)
ncol(dataArray) # 열의 수 
NCOL(dataArray)
length(dataArray) # 요소의 갯수 
dimnames(dataArray) <- list(c('1행', '2행', '3행'), # 행, 열, 면 이름 수정 
                            c('1열', '2열', '3열', '4열'),
                            c('x면', 'y면'))

dim(dataArray) <- c(3,8) # reshape
dataArray
dim(dataArray) <- c(8,3)
attr(dataArray, 'dim') <- c(3,8)
dataArray

#######################

# 10. 데이터 프레임 ★★
# 10.1 데이터프레임 생성 
student_id <- c('20211', '20212', '20213', '20214')
student_name <- c('Crystal', 'Mimi', 'Bella', 'Elena')
student_eng <- c(60,85,90,95)
student_kor <- c(100,95,95,80)
student_gender <- c('여', '여', '여', '여')

student_data <- data.frame(student_id, student_name, 
                           student_eng, student_kor, student_gender)
student_data

# 10.2 열 추가 및 삭제 
student_data$mat <- c(100, 100, 99, 98) # 추가
student_data
class(student_data$student_gender)
student_data$student_id <- NULL # 삭제 
student_data

# 10.3 열의 형변환 
student_data$student_gender <- as.factor(student_data$student_gender)
class(student_data$student_gender)
str(student_data) # 구조 확인
summary(student_data)

# 10.4 열 이름 변경 
install.packages("reshape")
library(reshape)
require(reshape)

student <- rename(student_data, c("student_name"="name"))
student <- rename(student,
                  c(student_eng='eng', 
                    student_kor='kor',
                    student_gender='gender'))

names(student_data) <- c('name', 'eng', 'kor','gender', 'mat')
student_data

# 10.5 데이터 프레임 합치기 
  # (1) 행 합치기: rbind
newStudent <- rbind(student_data, student)
newStudent

  # (2) 열 합치기: cbind
id = data.frame(student_id)
id
student <- cbind(id, student)
student
names(student) <- c('id', 'name', 'eng', 'kor', 'gender', 'mat')
student

# 10.6 부분 데이터 조회 
student <- rbind(student, student) # 2회 실행 -> 16행 (데이터 부풀리기)
nrow(student) 

student[1,1] # 1행 1열 
student[1,'id'] 
student[1,] # 1행 
student[,1] # 1열 
student[c(1:3), ] # 1~3행
student[ ,c(2,3,4,6)] # 2,3,3,6열
student[c(-2,-4,-6), ] # 2, 4, 6행을 제외 
student[ ,c(-1,-5)] # 1, 5열 제외
student[c(1:3), c(-1,-5)]  # 1~3행 중 1,5열을 제외
head(student) # 처음 여섯행만 
head(student, 3) # 처음 세 행만

  # subset 
  # ex. 국어점수가 100점인 학생의 데이터 
subset(student, subset=(student$kor==100))
subset(student, student$mat>99)

  # ex. 특정 열만 포함, 혹은 특정 열만 제외 
subset(student, select=c(1,4))
subset(student, select=c(-1,-4))
subset(student, select=c('name', 'kor', 'mat')

  # ex. 수학점수가 90점 이상인 여학생만 출력 
subset(student, subset=(student$mat>=99 & student_gender=='여'))

#######################

# <문제> 
emp <- read.csv(file.choose()) # 탐색기에서 선택한 csv파일을 emp변수에 할당
head(emp)
class(emp)

# 1) 직원이름만 
emp$ename
emp[ ,2]
emp[ ,2, drop=FALSE] # 데이터프레임 형태로 반환 
emp[ ,'ename']
emp[ ,'ename', drop=FALSE]

# 2) 직원이름, 업무, 급여 
emp[ ,c(2,3,6)]
emp[ ,c('ename', 'job', 'sal')]
subset(emp, select=c(2,3,6))
subset(emp, select=c('ename', 'job', 'sal'))

# 3) 이름이 KING인 직원의 사원번호, 업무, 입사일, 급여 
subset(emp, 
       subset=(emp$ename=='KING'), 
       select=c('empno', 'job', 'hiredate', 'sal'))

# 4) 급여가 2000 이상인 직원들의 사원번호, 이름, 급여 
subset(emp, 
       subset=(emp$sal>=2000),
       select=c('empno', 'ename', 'sal'))

# 5) 급여가 2000이상, 3000이하인 직원들의 이름과 급여
subset(emp,
       subset=(emp$sal>=2000 & emp$sal<=3000),
       select=c('ename', 'sal'))

########################

# 11. 타입 판별 및 타입 변환 
tail(emp) # 뒤의 여섯행 출력 
class(emp) # 타입 
str(emp) # 구조 
emp$deptno <- as.factor(emp$deptno) # 타입 변환 
str(emp)

class(iris)
edit(iris)
str(iris)

iris$Species <- as.character(iris$Species)
str(iris)
iris$Species <- as.factor(iris$Species)
str(iris)
levels(iris$Species)

class(iris$Species) # 타입 판별
is.factor(iris$Species)
str(iris$Species)

####################

# 12. 문자열과 날짜 
# 12.1 length / nchar 
name <- "Jay"
length(name) # 요소 갯수
nchar(name) # 요소의 문자 수

names <- c("Jacob", "David", "Paul")
nchar(names)
length(names)

# 12.2 substr(): 하위 문자열 추출 
substr('JOSEPH', 1, 4) # 1~4번째 문자 추출출
substr('JOSEPH', 4, 10) # 없는 번째의 문자는 ""로 처리됨
substr(names, 1, 2) 

  # ex. names변수 데이터들 각각의 끝에서 두번째와 가장 끝 문자 
substr(names, nchar(names)-1, nchar(names))

# 12.3 paste(), paste0(): 문자열 연결 
names <- c('Jacob', 'Daivd', 'Paul')
paste(names, 'loves', 'GOD')
paste(names, 'loves', 'GOD', sep='_')
paste(names, 'loves', 'GOD', sep='_', collapse=", and ")
paste0(names, 'loves', 'GOD')

name<-c("Yun","Lim","Lee") 
hobby<-c("swim",'sleep','eat')
cat(paste(name, hobby, sep='의 취미는 ', collapse='이고, '))

# 12.4 strsplit(): 문자열 분할(구분자 분할)
path <- 'home/hadoop/data/speech.csv';
strsplit(path, '/')

customerInfo <- 'Jin@gmail.com, 010-9999-9999, Seoul Korea'
strsplit(customerInfo, '010-9999-9999')

customers <-c('jin@gmail.com,010-9999-8888,seoul Korea',
              'yun@naver.com,02-716-1006,pusan korea',
              'yun@naver.com,011-716-1006,pusan korea')
strsplit(customers, '[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}')

# 12.5  sub(oldStr, newStr, string)
    #   gsub(oldStr, newStr, string): 문자열 대체
s <- 'Curly is the smart one. Curly is funny, too.'

sub('Curly', 'Eric', s)
gsub('Curly', 'Eric', s)
gsub(' ', '', s)

# 12.6 outer(): 외적 / 문자열의 모든 쌍별 조합 생성 
a <- c('aa', 'bb', 'cc')
b <- c('11', '22', '33')

outer(a, b, FUN="paste")
outer(a, b, FUN="paste", sep=' ~ ')

# 12.7 날짜 
today = Sys.Date()
class(today)
  
  # %Y : 년도4자리 %y : 년도 2자리 %m:월 %d 일
thatday = as.Date("21-04-30", "%y-%m-%d")
thatday
if(today < thatday) {
  cat('today보다 thatday 후')
}

####################

# <문제> 

# 1. iris 데이터셋의 기본 정보 확인 
# 1) 차원 확인 
iris <- dim(iris)
rm(list=ls())
dim(iris)

# 2) 컬럼명 확인 
colnames(iris)
names(iris)

# 3) 구조 확인 
str(iris)

# 4) 속성 확인 
colnames(iris)

# 5) 요약통계 정보 
summary(iris)


# 2. iris 데이터셋의 부분 데이터 추출 
# 1) 꽃받침 길이의 처음 10행 
head(iris$Sepal.Length, 10)
iris[c(1:10), 'Sepal.Length']
iris[c(1:10), 'Sepal.Length', drop=FALSE] 

# 2) virginica 종만 추출 
levels(iris$Species)

virginica <- iris[iris$Species == 'virginica']
virginica <- subset(iris, iris$Species == 'virginica')
virginica <- subset(iris, subset=(iris$Species == 'virginica'))
virginica <- subset(iris, subset=iris$Species == 'virginica')
head(virginica)

# 3) setosa 종만 추출 
setosa <- iris[iris$Species == 'setosa']
setosa <- subset(iris, iris$Species == 'setosa')
setosa <- subset(iris, subset=(iris$Species == 'setosa'))
setosa <- subset(iris, subset=iris$Species == 'setosa')
head(setosa)

# 4) 2)와 3)의 데이터 합치기 
rbind(virginica, setosa)

# 5) setosa 종의 꽃받침의 폭과 길이 추출 
subset(iris, 
       subset=(iris$Species == 'setosa'),
       select=c('Sepal.Length', 'Sepal.Width'))


# 3. 근로자 kim, lee의 시급과 작업 시간을 보고 급여 구하기기
pay <- matrix(c(12000, 26000, 18000), ncol=3)
pay

dimnames(pay) <- list(c('시급'),
                      c('작업A', '작업B', '작업C'))
pay

work <- matrix(c(c(5,4,9), c(7,3,2)),
               ncol=2)
dimnames(work) <- list(c('작업A', '작업B', '작업C'),
                       c('kim', 'lee'))
work

salary_cost <- pay %*% work
salary_cost

rownames(salary_cost) <- c('급여')
salary_cost











