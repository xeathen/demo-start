CREATE TABLE IF NOT EXISTS `customers` (
  `id`           INT AUTO_INCREMENT,
  `customer_id`       INT NOT NULL,
  `order_date` DATETIME                    NOT NULL,
  PRIMARY KEY (`id`)
);
