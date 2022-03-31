1. 시스템 개요

1) 시스템 개요

- 회원 관리 시스템은 사용자들이 회원으로 가입하며, 로그인 후에는 개인정보를 수정할 수 있다. 회원은 회원탈퇴가 가능하며, 회원으로 가입 시 주요정보(필수입력정보)는 아이디, 비밀번호, 이름, 나이, 휴대폰번호가 있으며 선택정보는 이메일이 있다.
- 프로그램 신청 시스템은 회원으로 가입한 경우, 프로그램명, 인원수, 희망날짜를 선택하여 신청할 수 있다.

2. 주요기능

주요기능 설명
회원가입 회원으로 가입한다.
로그인 회원 여부를 확인한다.
개인정보관리 회원으로 가입한 경우, 회원의 개인정보를 조회하거나 개인정보를 수정한다.
회원탈퇴 회원으로 가입한 경우, 회원을 탈퇴한다.
프로그램신청 원하는 프로그램과 인원수, 희망날짜를 신청한다.

2. 데이터베이스 설계 및 구축

1) ERD(Entity Relationship Diagram, 개체관계도)

- 회원관리를 위한 테이블 간의 관계를 도식화한 ERD에서 서로 중복된 데이터를 갖는 회원, 프로그램 테이블을 구성한다.

2. 테이블 구성도
   a. 회원 테이블(member)

컬럼 이름 영문 이름 데이터 형식 길이 NULL KEY 비고
아이디 id CHAR 10 NOT NULL PK
비밀번호 pwd VARCHAR 20 NOT NULL
이름 name VARCHAR 15 NOT NULL
나이 age INT NOT NULL CHECK (age>=19)
휴대폰번호 phone CHAR 11 NOT NULL
이메일 email VARCHAR 25
회원가입일 register DATE

b. 프로그램 테이블(program)

컬럼 이름 영문 이름 데이터 형식 길이 NULL KEY 비고
번호 num INT NOT NULL PK AUTO_INCREMENT
아이디 id CHAR 10 NOT NULL FK REFERENCES member(id),
on delete cascade
프로그램명 pname VARCHAR 20 NOT NULL
이름 name VARCHAR 15 NOT NULL
휴대폰번호 phone CHAR 11 NOT NULL
인원수 numofpeople INT NOT NULL
희망날짜 hopedate DATETIME NOT NULL

3. 개발 환경

1) 개발 환경

- 개발 플랫폼 환경
  - 운영체제 : macOS Big Sur v11.6
  - 하드웨어 : Apple M1 칩, Macintosh HD
- WAS 애플리케이션 개발환경
  - 개발언어 : Java, Servlet
  - 컴파일러 버전 : JDK 8.235
  - WAS : Apache Tomcat v9.0
  - 통합개발도구 : Eclipse
- DB 관리 : Dbeaver

2. 초기 디렉토리 구성 및 설치 파일

- 홈디렉토리의 구조와 디렉토리에 해당하는 파일 유형을 설명, C:₩jsp.pro 디렉토리를 홈디렉토리로 설정하고 다음과 같은 구조의 디렉토리들과 라이브러리를 설치한다.

디렉토리명 파일유형 비고
css _.css 스타일시트 파일
imgs _.jpg, _.png 이미지사진 파일
Include _.jsp 공통스크립트 파일
jqueryUIplugin UIplugin 라이브러리 프로그램 신청 UI 관련 파일
Js _.js 자바스크립트 파일
user _.jsp 서브 페이지 관련 파일
login \*.jsp 로그인 관련 파일
WEB-INF/lib cos.jar 파일 업로드 라이브러리
standard.jar jstl 라이브러리
jstl.jar jstl 라이브러리
mysql-connector-java-8.0.20.jar mysql 커넥터 라이브러리

4. 화면과 JSP 스크립트

1) 공통 스크립트

- 헤더(header.jsp) : 로그인 전후가 다름

2. 화면과 JSP

화면 설명
메인페이지
(index.jsp) 프로그램 정보와 신청 버튼을 출력함. 헤더는 로그인 전에는 로그인, 회원가입을 출력하며, 로그인 후에는 마이페이지, 로그아웃을 출력함
회원등록
(join.jsp) 회원등록 폼에서 회원정보(아이디, 비밀번호, 이름, 나이, 휴대폰번호, 이메일)을 입력 받고 회원등록을 처리하며 정상적이면 로그인페이지로 이동한다.
로그인
(login.jsp) 로그인 폼에서 아이디와 비밀번호를 입력 받고 로그인 처리를 하며, 메인페이지로 이동한다. 로그인 후에는 로그아웃할 수 있다.
개인정보관리
(mypage.jsp) 개인정보(아이디, 이름, 나이, 휴대폰번호, 이메일)를 출력한 후에 개인정보 수정이 가능하며, 비밀번호 변경도 가능하다. 필요 시 회원탈퇴가 가능하다. 회원탈퇴 시에는 로그아웃 처리를 거쳐 메인페이지로 이동한다.
프로그램신청
(program.jsp) 프로그램 신청 폼에서 신청정보(프로그램명, 인원수, 희망날짜)를 입력 받아 신청 받는다.
