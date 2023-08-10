CREATE TABLE IF NOT EXISTS prices (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       brand_id BIGINT,
                       start_date DATETIME,
                       end_date DATETIME,
                       price_list BIGINT,
                       product_id BIGINT,
                       priority BIGINT,
                       price DECIMAL(10,2),
                       currency VARCHAR(3)
);
