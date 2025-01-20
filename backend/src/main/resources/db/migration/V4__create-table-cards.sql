-- Tabela de cartões (cards)
CREATE TABLE tb_cards (
    id BIGSERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    status TEXT NOT NULL CHECK (status IN ('TO_DO', 'DOING', 'DONE')),
    board_id BIGINT,
    CONSTRAINT fk_tb_cards_board_id FOREIGN KEY (board_id) REFERENCES tb_boards(id) ON DELETE CASCADE
);