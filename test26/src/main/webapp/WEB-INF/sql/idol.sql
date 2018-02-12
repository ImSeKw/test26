-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.5-10.1.30-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- test 의 데이터베이스 구조 덤핑
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;


-- 테이블 test의 구조를 덤프합니다. idol
CREATE TABLE IF NOT EXISTS `idol` (
  `idol_id` int(10) NOT NULL AUTO_INCREMENT,
  `idol_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- Dumping data for table test.idol: ~50 rows (대략적)
/*!40000 ALTER TABLE `idol` DISABLE KEYS */;
INSERT INTO `idol` (`idol_id`, `idol_name`) VALUES
	(1, '김연우'),
	(2, '소녀시대'),
	(3, 'EXO'),
	(4, '슈퍼주니어'),
	(5, '핑클'),
	(6, 'SES'),
	(7, 'GOD'),
	(8, '동방신기'),
	(9, '나잇뮤지스'),
	(10, '에이핑크'),
	(11, '나얼'),
	(12, '쥬얼리'),
	(13, '김범수'),
	(14, 'EXID'),
	(15, '멜로망스'),
	(16, '임재범'),
	(17, 'IOI'),
	(18, '길구봉구'),
	(19, 'SG워너비'),
	(20, '먼데이키즈'),
	(21, '버즈'),
	(22, '바이브'),
	(23, '40'),
	(24, '거미'),
	(25, '린'),
	(26, '포맨'),
	(27, 'V.O.S'),
	(28, '김종국'),
	(29, 'KCM'),
	(30, '마마무'),
	(31, '레드벨벳'),
	(32, '우주소녀'),
	(33, '방탄소년단'),
	(34, 'AOA'),
	(35, '워너원'),
	(36, '임창정'),
	(37, '10cm'),
	(38, '허각'),
	(39, '서인국'),
	(40, '울라라세션'),
	(41, '악동뮤지션'),
	(42, '씨스타'),
	(43, '볼빨간사춘기'),
	(44, '트와이스'),
	(45, '비투비'),
	(46, '하이라이트'),
	(47, '박효신'),
	(48, '소향'),
	(49, '박정현'),
	(50, '매드크라윤');
/*!40000 ALTER TABLE `idol` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
