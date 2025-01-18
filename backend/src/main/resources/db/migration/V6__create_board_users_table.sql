-- Tabela de permissões para usuários em quadros
CREATE TABLE tb_board_users (
    id BIGSERIAL PRIMARY KEY,
    board_id BIGINT,
    user_id BIGINT,
    permissions permissions_enum NOT NULL,
    CONSTRAINT fk_board_user_board_id FOREIGN KEY (board_id) REFERENCES tb_boards(id) ON DELETE CASCADE,
    CONSTRAINT fk_board_user_user_id FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE,
    CONSTRAINT unique_board_user UNIQUE (board_id, user_id)
);