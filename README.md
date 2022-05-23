# 칵테일러 v.2

## 1. 시스템 개요

### 1) 시스템 개요

- 회원 관리 시스템은 사용자들이 회원으로 가입하며, 로그인 후에는 개인정보를 수정할 수 있다. 회원은 회원탈퇴가 가능하며, 회원으로 가입 시 주요정보(필수입력정보)는 아이디, 비밀번호, 이름, 나이, 휴대폰번호가 있으며 선택정보는 이메일이 있다.
- 프로그램 신청 시스템은 회원으로 가입한 경우, 프로그램명, 인원수, 희망날짜를 선택하여 신청할 수 있다.

### 2) 주요기능

- 회원가입:  회원으로 가입한다.
- 로그인:  회원 여부를 확인한다.
- 개인정보관리: 회원으로 가입한 경우, 회원의 개인정보를 조회하거나 개인정보를 수정한다.
- 회원탈퇴: 회원으로 가입한 경우, 회원을 탈퇴한다.
- 프로그램신청: 원하는 프로그램과 인원수, 희망날짜를 신청한다.

## 2. 데이터베이스 설계 및 구축

### 1) ERD(Entity Relationship Diagram, 개체관계도)

- 회원관리를 위한 테이블 간의 관계를 도식화한 ERD에서 서로 중복된 데이터를 갖는 회원, 프로그램 테이블을 구성한다.
<img width="345" src="https://user-images.githubusercontent.com/94106976/169775052-b740c8d8-3c16-49fc-9d0d-df1556f66b94.png">


### 2) 테이블 구성도
#### a. 회원 테이블(member)
![image](https://user-images.githubusercontent.com/94106976/169775184-226cd469-9ddb-4f5f-84c8-dbab298ec634.png)


#### b. 프로그램 테이블(program)
![image](https://user-images.githubusercontent.com/94106976/169775352-538bc042-a0e3-4bc9-b31d-3cbdf2f83310.png)


## 3. 개발 환경

### 1) 개발 환경

- 개발 플랫폼 환경
  - 운영체제 : macOS Big Sur v11.6
  - 하드웨어 : Apple M1 칩, Macintosh HD
- WAS 애플리케이션 개발환경
  - 개발언어 : Java, Servlet
  - 컴파일러 버전 : JDK 8.235
  - WAS : Apache Tomcat v9.0
  - 통합개발도구 : Eclipse
- DB 관리 : Dbeaver

### 2) 초기 디렉토리 구성 및 설치 파일

- 홈디렉토리의 구조와 디렉토리에 해당하는 파일 유형을 설명, C:₩jsp.pro 디렉토리를 홈디렉토리로 설정하고 다음과 같은 구조의 디렉토리들과 라이브러리를 설치한다.
![image](https://user-images.githubusercontent.com/94106976/169775480-9e81ca93-9e8b-49bc-b382-a0d424bee751.png)


## 4. 화면과 JSP 스크립트

### 1) 공통 스크립트

- 헤더(header.jsp) : 로그인 전후가 다름

### 2) 화면과 JSP
![image](https://user-images.githubusercontent.com/94106976/169775576-7890b672-8109-45ff-95ba-b385ef6327f1.png)
