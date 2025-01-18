-- Tabela de links associados aos quadros
CREATE TABLE tb_board_links (
    uuid CHAR(36) PRIMARY KEY,
    board_id BIGINT UNIQUE,
    CONSTRAINT fk_board_id FOREIGN KEY (board_id) REFERENCES tb_boards(id) ON DELETE CASCADE
);