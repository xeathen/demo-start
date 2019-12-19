CREATE TABLE IF NOT EXISTS `orders` (
  `id`           INT           AUTO_INCREMENT,
  `order_number` VARCHAR(50)   NOT NULL,
  `customer_id`  INT NOT NULL,
  `order_date`   TIMESTAMP(6)  NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `create_by`    VARCHAR(50)   NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uk_orders_order_number` (`order_number` ASC)
)
    DEFAULT CHARACTER SET = utf8;




