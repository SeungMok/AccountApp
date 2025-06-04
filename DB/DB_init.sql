CREATE TABLE `users` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(255) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `receipts` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `store_name` varchar(255),
  `payment_method` varchar(255),
  `total_price` integer,
  `receipt_date` datetime,
  `created_at` timestamp,
  `user_id` integer NOT NULL
);

CREATE TABLE `receipt_item` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `price` datetime,
  `quantity` int,
  `category` varchar(255),
  `receipt_id` integer NOT NULL
);

CREATE TABLE `category` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255)
);

ALTER TABLE `receipts` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `receipt_item` ADD FOREIGN KEY (`receipt_id`) REFERENCES `receipts` (`id`);
