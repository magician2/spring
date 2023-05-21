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
  `address` varchar(30) DEFAULT NULL,
  `katakana` varchar(20) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `del_flg` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;