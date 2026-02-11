# 🚀 dev-project-curd (Backend API)

이 프로젝트는 **Spring Boot 3**와 **멀티 모듈 구조**를 기반으로 한 사용자 관리 및 인증 API 서버입니다. 
프론트엔드(Vue3)와의 원활한 협업을 위해 Swagger API 명세서를 제공합니다.

---

## 🛠 Tech Stack
* **Language**: Java 17
* **Framework**: Spring Boot 3.2.2
* **Database**: H2 Database (File-based)
* **ORM**: MyBatis
* **Security**: Spring Security & JWT
* **Docs**: Swagger (SpringDoc OpenAPI 2.6.0)

---

## 📁 Project Structure
본 프로젝트는 효율적인 관리를 위해 멀티 모듈로 구성되어 있습니다.
* **`api-module`**: 실제 API 엔드포인트와 비즈니스 로직이 포함된 실행 모듈입니다.
* **`core-module`**: 공통 설정, 보안 구성(Security), 데이터 모델(Entity/Mapper), 유틸리티가 포함된 라이브러리 모듈입니다.

---

## ⚙️ Setup & Running
1. **Repository Clone**
   ```bash
   git clone [https://github.com/Jxun-h/dev-project-curd.git](https://github.com/Jxun-h/dev-project-curd.git)
