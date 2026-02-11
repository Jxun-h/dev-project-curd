-- 기존 테이블이 있다면 삭제 (개발 단계에서 초기화 용도)
DROP TABLE IF EXISTS users;

-- 사용자 테이블 생성
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'ROLE_USER'
);