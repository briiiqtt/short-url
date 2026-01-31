# backend 규칙

## 디렉토리 구조 지향점

backend/···/shorturl  
├── common/　　　　　　# 공통 예외, 유틸리티, 상수, Response 규격  
├── config/　　　　　　　# Security, Swagger, Database 등 설정  
├── controller/　　　　　　# API 엔드포인트 및 요청 유효성 검증  
├── service/　　　　　　　# 비즈니스 로직 및 트랜잭션 관리  
├── repository/　　　　　# DB 접근 로직 (Spring Data JPA 등)  
├── domain/　　　　　　　# JPA Entity 및 관련 Enum (DB 테이블 매핑)  
├── dto/　　　　　　　　# 데이터 전송 객체  
│ ├── request/　　　　　　# 클라이언트 요청 데이터  
│ └── response/　　　　　# 서버 응답 데이터  
└── mapper/　　　　　　　# (Optional) Entity <-> DTO 변환 로직

## Entity

Entity는 API 응답시에는 반드시 DTO로 변환하여 반환합니다.

`@NoArgsConstructor(access = AccessLevel.PROTECTED)`로 명확한 의미를 가진 생성자로만 객체를 생성합니다.

`@Data`는 Setter 생성을 막기 위해 사용을 지양합니다.  
`@Getter`, `@Builder`, `@RequiredArgsConstructor`를 주로 사용하되, 값 설정은 명확한 의미를 가진 메서드로만 합니다.

## API 응답 규격

HTTP Response Body의 형식은

```json
// HTTP status: 200 OK
{
  "id": 91287,
  "name": "briiiqtt"
}
```

혹은

```json
// HTTP status: 400 Bad Request
{
  "status": 400,
  "code": "INVALID_INPUT",
  "message": "입력값이 올바르지 않습니다.",
  "timestamp": "2026-01-29T04:15:19.507943357"
}
```

의 형식을 사용합니다.
http status, isSuccess 등

## 비즈니스 로직 분리

Controller: 요청을 받고 응답을 넘겨주는 역할만 수행합니다.

Service: 하나의 메서드에서는 하나의 비즈니스 흐름만 제어합니다.

Domain: 도메인 내의 데이터 변경이나 단순한 로직은 Entity 내부에서 메서드로 처리합니다.

## 예외 처리

@RestControllerAdvice를 사용하여 전역 에러 핸들러를 구현합니다.

비즈니스 예외 발생 시 커스텀 익셉션을 던지고, 상황에 맞는 HTTP 상태 코드를 반환합니다.

시스템 예외 발생 시 내장 익셉션을 던지고, 남기는 로그는 slf4j->elastic search로 추적이 쉽도록 체계화합니다. _미구현, 작업필요_

## 환경 설정 및 보안

API key, DB PW 등의 secret은 어디에도 직접 입력하지 않고 환경 변수를 사용합니다.

공통 환경 설정으로 `application.yml`,  
개발, 배포 분리 설정으로 `application-dev.yml`, `application-prod.yml`로 관리합니다.  
그리고 compose.yml에서 SPRING_PROFILES_ACTIVE: dev | prod 로 사용합니다.

Swagger: 컨트롤러와 DTO에 SpringDoc 어노테이션을 사용하여 API 문서를 최신 상태로 유지합니다. _미구현, 작업필요_
