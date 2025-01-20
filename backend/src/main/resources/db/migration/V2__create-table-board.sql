-- Tabela de quadros (boards)
CREATE TABLE tb_boards (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    user_id BIGINT,
    CONSTRAINT fk_tb_boards_user_id FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE
);