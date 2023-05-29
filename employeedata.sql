-- employee.employeedata definition

CREATE TABLE `employeedata` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(30) DEFAULT NULL,
                              `age` int NOT NULL,
                              `gender` varchar(2) NOT NULL,
                              `department` varchar(20) DEFAULT NULL,
                              `date` date NOT NULL,
                              `academic` varchar(30) DEFAULT NULL,
                              `mail` varchar(30) DEFAULT NULL,
                              `hobby` varchar(20) DEFAULT NULL,
                              `imgUrl` varchar(2083) DEFAULT NULL,
                              `phone` varchar(20) DEFAULT NULL,
                              `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                              `zipcode` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                              `username` varchar(45) DEFAULT NULL,
                              `password` varchar(45) DEFAULT NULL,
                              `del_flg` int NOT NULL DEFAULT '0',
                              `katakana` varchar(100) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;