# spring-playground

Spring Boot 공부용 개인 플레이그라운드입니다.

## Stack

- Java 21
- Spring Boot 4.1
- Spring Data JPA + PostgreSQL
- SpringDoc (Swagger UI)

## 실행

PostgreSQL이 떠 있어야 합니다. DB 설정은 `application-local.properties`를 참고하세요.

```bash
./gradlew bootRun
```

- 서버: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html

## 개발 시 참고

Express처럼 저장만으로는 반영되지 않습니다. DevTools는 **컴파일된 클래스** 변경을 감지합니다.

```bash
# 터미널 1: 저장 시 자동 컴파일
./gradlew classes --continuous -x test

# 터미널 2: 앱 실행
./gradlew bootRun
```

## API

| Method | Path         | 설명                                     |
| ------ | ------------ | ---------------------------------------- |
| GET    | `/health`    | 헬스체크                                 |
| GET    | `/intro`     | API 소개                                 |
| GET    | `/logs`      | 로그 목록 (페이지네이션, `keyword` 검색) |
| GET    | `/logs/{id}` | 로그 상세                                |
| POST   | `/logs`      | 로그 생성                                |
| PATCH  | `/logs/{id}` | 로그 수정                                |
| DELETE | `/logs/{id}` | 로그 삭제                                |

목록 조회 예시: `GET /logs?page=0&size=10&keyword=Spring`
