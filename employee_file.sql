-- employee.emoloyee_file definition

CREATE TABLE `emoloyee_file` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT 'ファイルネーム',
  `type` varchar(255) DEFAULT NULL COMMENT 'ファイル形式',
  `size` bigint DEFAULT NULL COMMENT 'ファイルサイズ(kb)',
  `url` varchar(255) DEFAULT NULL COMMENT 'ファイルURL',
  `is_delete` tinyint DEFAULT '0' COMMENT '削除状態 0は未削除　1は削除状態',
  `enable` tinyint DEFAULT '1' COMMENT 'リンク制限 1は使用可 0は不可',
  `md5` varchar(255) DEFAULT NULL COMMENT 'md5識別',
  PRIMARY KEY (`id`),
  KEY `emoloyee_file_md5_IDX` (`md5`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;