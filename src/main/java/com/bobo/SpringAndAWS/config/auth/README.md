## 스프링 시큐리티
* 인증과 인과 기능을 가진 프레임워크
* 사실상 스프링 기반의 애플리케이션에서는 보안을 위한 표준
* 인터셉터, 필터 기반의 보안 기능을 구현하는 것보다 스프링 시큐리티를 통해 구현하는 것을
    적극 권장하고 있음

* 로그인 기능을 id/password 방식보다는 구글, 페이스북, 네이버 로그인과 같은 소셜 로그인 기능을 사용하는 이유
    * 로그인 시 보안
    * 비밀번호 찾기
    * 회원가입 시 이메일 혹은 전화번호 인증
    * 비밀번호 변경
    * 회원정보 변경
    * OAuth 로그인 구현 시 앞선 목록의 것들을 모두 구글, 페이스북, 네이버 등에 맡기면 되니
        서비스 개발에 집중할 수 있음


## config.auth
* 시큐리티 관련 클래스는 모두 이곳에 담음

