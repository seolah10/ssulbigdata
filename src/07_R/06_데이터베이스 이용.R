# # # [6] 데이터 베이스 이용 

rm(list=ls(all.names = T))

# 1. SQL문을 이용한 데이터프레임 처리 
install.packages('sqldf') # fastmap, bit, cachem 등을 의존
library(sqldf)

sqldf("select * from iris")

  # 1) 중복행 제거 후 출력
sqldf("select distinct Species from iris")  

names(table(iris$Species))
library(dplyr)

iris %>% 
  group_by(Species) %>% 
  summarise()

  # 2) 행 제한 조건 설정 (virginica 종만 출력 )
sqldf("select * from iris where species=='virginica'") 
iris[iris$Species=='virginica', ]
iris %>% 
  filter(Species=='virginica')

  # cf) 컬럼명에 .이 있는 경우: ``로 처리 
      # ex. virginica 종이면서 꽃받침 길이가 7.5를 넘는 데이터 
sqldf("select * from iris 
        where Species=='virginica' and `Sepal.Length`>7.5")
iris[iris$Species=='virginica' & iris$Sepal.Length>7.5, ]
iris %>% 
  filter(Species=='virginica' & Sepal.Length>7.5)

    # ex. 종별 꽃받침 길이의 합
sqldf("select Species, sum(`Sepal.Length`) 
        from iris 
        group by Species")
tapply(iris$Sepal.Length, iris$Species, sum)
library(doBy)
summaryBy(Sepal.Length~Species, iris, FUN=sum)
aggregate(iris$Sepal.Length, by=list(iris$Species), sum)

  # 3) 정렬
    # ex. 꽃받침 길이 순서대로 1~5위 / 6~10위 
sqldf("select * from iris 
        order by `Sepal.Length` limit 5") # 0번째부터 5개
sqldf("select * from iris 
        order by `Sepal.Length` limit 5,5") # 5번째부터 5개

  # 4) sql함수(mySQL함수) 사용
    # ex. 종에 따른 Petal.Length, Petal.Width의 평균과 표준편차
sqldf("select avg(`Petal.Length`) as mean_length, 
              stdev(`Petal.Length`) as st_length,
              avg(`Petal.Width`) as mean_width,
              stdev(`Petal.Width`) as st_width
        from iris group by Species")
summaryBy(Petal.Length+Petal.Width ~ Species, iris, FUN=c(mean, sd))

sqldf("select round(avg(`Petal.Length`), 2) from iris")
iris %>% 
  summarise(mean = round(mean(Petal.Length), 2))

  # 5) 조인 
emp <- read.csv("inData/emp.csv", header=T)
dept <- read.csv("inData/dept.csv")
head(emp)
dept
      # 사번, 이름, 직책, 월급, 부서번호, 부서이름
sqldf("select empno, ename, job, sal, e.deptno, dname
        from emp e, dept d 
        where e.deptno = d.deptno")
sqldf("select empno, ename, job, sal, emp.deptno, dname
        from emp, dept  
        where emp.deptno = dept.deptno")
      
      # 사번, 이름, 부서번호, 부서이름
sqldf("select empno, ename, e.deptno, dname 
        from emp e join dept d
        on e.deptno = d.deptno")

rm(list=ls())
emp
dept

############################

# 2. 오라클 데이터베이스 연결 

# 사전작업: 자바를 설치 후 환경설정(JAVA_HOME), 
#           작업디렉토리(getwd())에 ojdbc6.JAR 

# 패키지 설치 밑 로드 
install.packages("RJDBC")
library(RJDBC)

Sys.setenv(JAVA_HOME='C:\\Program Files\\Java\\jre1.8.0_151')
Sys.setenv(JAVA_HOME='C:\\Program Files\\Java\\jdk1.8.0_271')

# 드라이버 클래스 로드 
drv <- JDBC("oracle.jdbc.driver.OracleDriver", classPath = "ojdbc6.jar")
drv

# 데이터베이스 연결 
con <- dbConnect(drv, "jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott","tiger")
con

# SQL전송(select) + 결과 받기 
emp <- dbGetQuery(con, "select * from emp")
emp
class(emp)
summary(emp)
tail(emp)
emp[1:2, 'EMPNO']

# 테이블 전체 데이터 조회
dept <- dbReadTable(con, "dept")
dept

# SQL전송(update, insert, delete) - DB 데이터 수정 
dbSendUpdate(con, "insert into dept values (50, 'IT', 'Busan')")
dbSendUpdate(con, "update dept set loc='Bucheon' where deptno=50")
dbSendUpdate(con, "delete from dept where deptno>=50")

# 데이터베이스 연결 해제 
dbDisconnect(con)

# 드라이버 언로드(DB연결 해제시 자동 언로드 됨)
dbUnloadDriver(drv)
detach("package:RJDBC", unload = TRUE)

#############################

# 3. MySql 데이터베이스 연결 
# MySQL Workbench에서 
# ALTER USER '아이디'@'localhost' IDENTIFIED WITH mysql_native_password BY '비밀번호';
# ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mysql';
install.packages("RMySQL")
library(RMySQL)

drv <- dbDriver("MySQL")
con <- dbConnect(drv, host='127.0.0.1', dbname='park', user='root', password='mysql')
rs <- dbSendQuery(con, "select * from personal")
personal <- fetch(rs, n=-1)

personal
class(personal)

dbDisconnect(con)
dbUnloadDriver(drv)
personal



