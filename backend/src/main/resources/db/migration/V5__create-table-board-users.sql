-- Tabela de permissões para usuários em quadros
CREATE TABLE tb_board_users (
    id BIGSERIAL PRIMARY KEY,
    board_id BIGINT,
    user_id BIGINT,
    CONSTRAINT fk_tb_board_users_board_id FOREIGN KEY (board_id) REFERENCES tb_boards(id) ON DELETE CASCADE,
    CONSTRAINT fk_tb_board_users_user_id FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE,
    CONSTRAINT uq_tb_board_users_board_user UNIQUE (board_id, user_id)
);