### [4] R프로그래밍; 제어문, 연산자, function 

# 1. 제어문 
# 1.1 조건문 
# (1) if문 

num <- 9

if(num%%2 == 0) {
  print(paste(num, ': 짝수'))
}else {
  cat(num, ': 홀수')
}

# (2) ifelse() 함수 
(nums <- c(10, 9, 16, 17, 20))
result <- ifelse(num%%2 == 0, "짝", "홀")
result

m <- matrix(c(nums, result), 
            ncol = 5, byrow = TRUE,
            dimnames = list(c('수', '홀짝'),
                            c('1회', '2회', '3회', '4회', '5회')))
m

# (3) switch() 함수 
switch(2, "red", "green", "blue")
x <- switch(4, "red", "green", "blue")
x # NULL

  # ex. 사용자로부터 color값을 받아 해당 color를 출력 
?readline
colorValue <- as.integer(readline(
  prompt = 'color: (red:1, green:2, blue:3)'))
class(colorValue)

color <- switch(colorValue, "red", "green", "blue")
color
colorValue <- switch(color, "red"=1, "green"=2, "blue"=3)
cat('선택한 색상 ', color, "의 색상값: ", colorValue)

  # ex. 점수(50~100)를 입력받아 학점을 계산하는 프로그램 구현
  #     100:perfect, 90점대:A, 80점대:B, 70점대:C, 60점대:D, 50점대:F
score <- as.integer(readline(prompt = "점수(50~100): "))
grade <- switch((as.integer(score/10)-4), 
                'F', 'D', 'C', 'B', 'A', 'Perfect')

getGrade <- function() {
  score <- as.integer(readline(prompt = "점수(50~100): "))
  grade <- switch((as.integer(score/10)-4), 
                  'F', 'D', 'C', 'B', 'A', 'Perfect')
  cat('점수: ', score, ', 학점: ', grade)
}
getGrade()

# 1.2 반복문 
# (1) for문 
1:10; seq(1,10); seq(10)

x <- c(-2, 5, 4, 8)

for(val in x) {
  cat(val, '\t')
}

count <- 0
for(val in x) {
  if(val%%2 == 0) {
    count = count + 1;
  }
}

for(val in 1:10) {
  cat(val, "안녕하세요")
}

  # ex. factorial 계산 함수 작성하기 
fact <- function(num) {
  result = 1
  
  if(num < 0) {
    cat('음수값을 위한 팩토리얼은 없습니다.')
    # return()
  } else if(num == 0) {
    cat('0! = 1')
    # return(1)
  } else {
    for(i in num:1) {
      result= result * i 
    }
    cat(num, '! = ', result)
    # return(result)
  }
}
fact(-4) 
fact(0) 
fact(4)

rm(list=ls())
fact(4)

getwd() # 현재 working 디렉토리
setwd('D:/Bigdata/src/07_R') # 디렉토리 설정 
getwd()

source('04_factorial.R', encoding = 'utf-8') # 파일 불러오기 
fact(7)

# (2) while: 조건이 참일 때 반복 
i <- 1

while(i < 6) {
  print(i)
  i = i + 1 
}

# (3) repeat: 반복 
i <- 1

repeat {
  if(i > 6) break
  print(i)
  i <- i + 1 
}

## break, next(자바에서의 continue)
x <- 1

while(x < 10) {
  x <- x + 1
  # if(x == 3) break;
  if(x == 3) next;
  cat(x, '\t')
}

#########################

# 2. 연산자 
# 2.1 논리연산자 
TRUE && TRUE
TRUE & TRUE

x <- c(T, T, F, F)
y <- c(T, F, T, F)

x & y # 모든 요소를 다 체크 
x | y

x && y # 첫번째 요소만 체크 
x || y

# 2.2 중위연산자 
5 + 7 
'+'(5, 7)

'%add%' <- function(x, y) {
  return(x + y)
}
'%add%'(5, 7)
5 %add% 7

c <- c(10, 23, 30)
10 %in% c 

strings <- c('Hello', 'World', 'R')
strings %in% 'R' 

  # %o% : 외적
  # %*% : 내적(행렬의 곱)
a <- c(2, 3, 4)
b <- c(10, 20, 30)
a %o% b

a <- c('2', '3', '4')
b <- c('a', 'b', 'c')
outer(a, b, FUN=paste)

(matrix.a <- matrix(1:6, nrow=3, ncol = 2))
(matrix.b <- matrix(1:6, nrow=3, ncol = 2))
matrix.a %*% matrix.b
solve(matrix.a)

###################

# 3. 함수 
pow <- function(x, y){
  return(x + y);
}
pow
pow(2, 3)

  # 가변 인자 함수; total(), total(1), total(2, 3, 4)
total <- function(...){
  args <- list(...)
  sum <- 0
  for(val in args) {
    sum <- sum + val
    cat(val, '의 합은 ', sum, '\n')
  }
  return(sum)
}
total()
total(1)
total(2, 3, 4)

  # 재귀 호출: 함수 내에서 자기 함수를 호출하는 함수 
rm(list=ls())

fact <- function(num){
  if(num < 0){
    return()
    
  } else if(num == 1) {
    return(1)
    
  } else {
    return(num * fact(num-1))
  }
}
# fact(3) = 3* fact(2)
#   = 3 * 2 * fact(1)
#   = 3 * 2 * 1
# fact(num) = num * fact(num-1) (단, num이 1보다 클 때, fact(1)=1)
fact(3)

#####################

# 4. R환경 
environment()
ls()

f <- function(f_x) {
  g <- function(g_x) {
    print('g함수 안')
    print(environment())
    print(paste('g함수 영역에서의 변수들 ', ls()))
  }
  g(5)
  print('f함수 안')
  print(environment())
  cat('f함수 영역에서의 변수들 ', ls())
}
f(10)

#################### 

# <문제> 매개변수가 소수인지 아닌지 여부를 return하는 함수 만들기
is.prime <- function(num) {
  flag = FALSE 
  
  if(num == 2) {
    return(TRUE)
  
  }else if(num > 1) {
    flag = TRUE
    for(i in 2:(num-1)){
      if((num%%i) == 0){
        cat(i,'는 ', num, '의 약수라서 소수가 아님', '\n')
        flag = FALSE
        break
      }
    }
  }
  return(flag)
}
is.prime(12)
