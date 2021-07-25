# 왓챠 과제

## 모듈
.
+-- `app` 앱 모듈
+-- `database` 로컬 저장을 위한 모델 및 데이터베이스 정의
+-- `model` 네트워크에서 얻어오기 위한 데이터 모델 정의
+-- `shared` Use Case, Repository, Data Source 등 정의


## 오픈소스 라이브러리
1. **Room** - Favorites 목록 저장
2. **Hilt** - 보일러플레이트 코드 제거
3. **Fuel** - 네트워크 요청 코드의 단순화 (원래는 Retrofit을 사용하였으나 API 21+ 제약으로 인해 변경)
4. **kotlinx.serialization** - JSON 파싱
5. **Jetpack Paging** - 긴 노래 목록을 가져오고 표시
6. **Glide** - 이미지 불러오기 및 캐싱

## 기능
- [x] 트랙 목록
	- [x] 고정된 키워드 "greenday"
	- [x] 페이지네이션
	- [x] 정보 표시 UI 구성
	- [x] 관심 목록에 추가/삭제
- [x] 관심 목록
	- [x] 재시작 후에도 유지
	- [x] 정보 표시 UI 구성
- [x] 기타
	- [x] Bottom Navigation
	- [x] Target API 29 / Min API 19