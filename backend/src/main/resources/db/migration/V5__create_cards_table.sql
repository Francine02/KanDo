-- Tabela de cartões (cards)
CREATE TABLE tb_cards (
    id BIGSERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    status status_enum NOT NULL,
    board_id BIGINT,
    CONSTRAINT fk_card_board_id FOREIGN KEY (board_id) REFERENCES tb_boards(id) ON DELETE CASCADE
);