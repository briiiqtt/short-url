# 프로젝트 개요

단축 URL 생성 및 리디렉션 서비스입니다.

## 기술 스택
- Backend: Spring Boot, JPA
- Frontend: React
- Cache: Redis
- DB: PostgreSQL
- Infra: OCI, Docker

## 실행 방법
`.env.example`을 참고하여 `.env.development`를 작성한 후 다음 명령을 실행합니다.
```
docker compose -f compose.dev.yml --env-file .env.development up -d --build
```

## 배포 방법
```
local > docker compose -f compose.prod.yml --env-file .env.production build
local > docker compose -f compose.prod.yml --env-file .env.production push

remote > git pull
remote > docker pull ghcr.io/briiiqtt/short-url-frontend
remote > docker pull ghcr.io/briiiqtt/short-url-backend
remote > docker compose -f compose.prod.yml --env-file .env.production up -d --build
```
`.env.development`, `.env.production` 으로 개발, 배포 설정을 분리합니다.

## 주요 기능

### 단축 URL 생성
URL을 입력하면 같은 목적지를 향하는 짧은 URL을 만들어줍니다. 같은 URL에 대해 여러 단축 URL을 생성할 수 있습니다.

### URL 리디렉션
단축 URL로 들어오는 GET 요청을 원본 URL로 리디렉트합니다.

## 아키텍처

아키텍처 다이어그램 이미지

## 요청 처리 흐름

### 단축 URL 생성
1. Frontend에서 사용자 입력값을 받아 Backend로 `POST /api/shorten` 요청을 보냅니다.
2. Backend에서는 받은 값에 대해 DB 저장 및 Redis 캐싱합니다.
3. 이후 Backend는 저장된 값의 정수 증가형 ID에 대해 Base62 인코딩된 값으로 Frontend로 응답합니다.


### 단축 URL 조회
1. 사용자가 브라우저에서 단축 URL로 접속함으로써 Backend로 `GET /{Base62EncodedKey}` 요청을 보냅니다.
2. Backend에서는 먼저 Redis 캐시에서 해당 값을 찾고, 없으면 DB를 조회합니다.
3. 만약 DB에서 값을 찾았다면 해당 값을 Redis에 캐싱합니다.
4. 원본 URL로 `302 Found` 상태 코드로 리디렉트합니다.


## URL 충돌 방지 전략
### 단축 URL의 path에 쓰이는 문자열은 `순차ID`를 Base62로 인코딩한 값입니다.  
이 방식은 다음의 장점을 가지기에 선택하였습니다.
- (일단은) 충돌이 없고, 구현이 단순합니다.
- 6자리까지만 해도 62^6=56,800,235,584개의 단축 경로를 생성 가능하기 때문에, 충분히 많고 충분히 짧습니다.

### 그러나 이런 단점도 가집니다.
- 서비스 초기의 매우 짧은 경로는 생소하게 느껴질 수 있어보입니다. (예를 들면 "/ab" 같은 주소를 보면 저라도 갸우뚱할 것 같습니다.)
- 생성된 URL 개수나 다음 URL을 제 3자가 예측할 수 있습니다.
- 분산 환경으로 확장하게 되면 Lock 또는 지연 문제가 생깁니다.

### 이 문제들은 순차ID 대신 `SnowflakeID`를 Base62로 인코딩하면 해결됩니다.
- URL은 이미 생성된 단축URL의 개수와 관계없이 거의 일정한 자릿수를 가집니다. (다만 조금은 길어지겠지요)
- 다음 URL를 예측할 수 없어지며, 분산 환경에 최적화됩니다.

### 그러면 URL이 길어지니, 서비스의 본질을 해치는 것은 아닐까요?
SnowflakeID는 64비트를 사용합니다. 이걸 Base62로 인코딩하면 약 10~11자리의 문자열이 됩니다.  
조금 길어지긴 하네요. 하지만 SnowflakeID의 구성요소 각 범위를 타협함으로써 해결할 수 있습니다.

- 부호비트 (1비트): 그냥 둡니다.
- 타임스탬프 (41비트): epoch를 기준으로 앞으로 담을 수 있는 시간 경과의 범위를 줄입니다.
- 워커ID (10비트): 분산할 수 있는 서버의 대수를 줄입니다.
- 시퀀스 (12비트): 같은 밀리초안에서 겹치는 ID에 대한 시퀀스 허용범위를 줄입니다.

여기에서 적절히 타협, 예를 들면 타임스탬프에서 10, 워커에서 5, 시퀀스에서 6비트를 줄입니다.  
총 41비트의 ID는 Base62 인코딩시 7~8자리를 가지게 되고, 보안과 분산, 짧은 url까지 만족시키게 됩니다.

**그러나, 개인 작업의 선에서는 불필요하기에 SnowflakeID는 사용하지 않았습니다.**

## REDIS 사용 이유
// TODO: 

## redis 캐시 전략
// TODO: 

## 301이 아닌 302인 이유
// TODO: 

## 개발 예정 기능
- 회원 등록시, 회원인 상태로 등록한 URL 삭제 기능
- (회원에 한해) 생성된 URL의 조회 횟수 기록 및 확인 기능