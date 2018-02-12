-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- test 의 데이터베이스 구조 덤핑
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


-- 테이블 test의 구조를 덤프합니다. city
CREATE TABLE IF NOT EXISTS `city` (
  `city_id` int(10) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Dumping data for table test.city: ~32 rows (대략적)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`city_id`, `city_name`) VALUES
	(1, '전주'),
	(2, '익산'),
	(3, '군산'),
	(4, '서울'),
	(5, '부산'),
	(6, '울산'),
	(7, '대전'),
	(8, '광주'),
	(9, '뉴욕'),
	(10, '보스턴'),
	(11, '로스엔젤레스'),
	(12, '샌프란시스코'),
	(13, '샌디에고'),
	(14, '라스베가스'),
	(15, '아틀란타'),
	(16, '마이아미'),
	(17, '워싱턴'),
	(18, '하와이'),
	(19, '알래스카'),
	(20, '경주'),
	(21, '도쿄'),
	(22, '오사카'),
	(23, '상하이'),
	(24, '베이징'),
	(25, '홍콩'),
	(26, '나고야'),
	(27, '싱가포르'),
	(28, '타이페이'),
	(29, '광저우'),
	(30, '모스크바'),
	(31, '파리'),
	(32, '런던');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
