# BODA

공공데이터를 활용해 공익 콘텐츠를 탐색하고, 시민이 직접 퀴즈와 캠페인 아이디어를 제안할 수 있도록 만든 Android 애플리케이션입니다. 2025년 제1회 방송통신위원회 공공데이터 분석·활용 공모전을 위해 제작했습니다.

## 주요 기능

- 방송통신위원회 공공데이터 조회
- 공익 콘텐츠 탐색 및 추천
- 사회문제 리포트 확인
- 공익 퀴즈 아이디어 제안과 미리보기
- 사용자 마이페이지

## 기술 구성

- Java
- Android SDK 34 (minSdk 24)
- AndroidX AppCompat, Material Components, ConstraintLayout
- 공공데이터포털 방송통신위원회 Open API

## 실행 방법

1. Android Studio에서 프로젝트를 엽니다.
2. `local.properties.example`을 `local.properties`로 복사합니다.
3. 로컬 Android SDK 경로와 공공데이터포털 인증키를 입력합니다.
4. Gradle Sync 후 앱을 실행합니다.

```properties
sdk.dir=C\:\\Users\\YOUR_NAME\\AppData\\Local\\Android\\Sdk
KCC_API_KEY=YOUR_DATA_GO_KR_API_KEY
```

`local.properties`는 Git에 포함되지 않습니다. 실제 인증키를 소스 코드에 직접 작성하지 마세요.

## 문서

- `docs/공공데이터_BODA.pptx`: 프로젝트 발표자료
- `docs/공모전_BODA.pdf`: 공모전 제출용 소개자료

개인정보가 포함된 공모전 참가신청서는 공개 저장소에서 제외했습니다.
