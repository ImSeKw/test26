
DROP TABLE IF EXISTS `city_file`;
CREATE TABLE IF NOT EXISTS `city_file` (
  `city_file_id` int(10) NOT NULL AUTO_INCREMENT,
  `city_id` int(10) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_ext` varchar(50) DEFAULT NULL,
  `file_size` int(10) DEFAULT NULL,
  PRIMARY KEY (`city_file_id`),
  KEY `FK_city_file_city` (`city_id`),
  CONSTRAINT `FK_city_file_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;