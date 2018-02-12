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
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `test`;


-- 테이블 test의 구조를 덤프합니다. company
CREATE TABLE IF NOT EXISTS `company` (
  `company_id` int(10) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- Dumping data for table test.company: ~39 rows (대략적)
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`company_id`, `company_name`) VALUES
	(1, '하이텍크'),
	(2, 'LG'),
	(3, '삼성'),
	(4, 'SK'),
	(5, '현대'),
	(6, '한화'),
	(7, 'sktelecom'),
	(8, '유한제지'),
	(9, '롯데'),
	(10, '엘지전자'),
	(12, '유한킴벌리'),
	(13, 'CJ'),
	(14, '명성식품'),
	(15, '명성기업'),
	(16, 'KT'),
	(17, '명인 철광'),
	(18, '포스코'),
	(19, '아마존'),
	(20, '애플'),
	(21, '구글'),
	(22, '페이스북'),
	(23, '마이크로소프트'),
	(24, '월마트'),
	(25, '버라이즌'),
	(26, '토요타'),
	(27, '케논'),
	(28, '소니'),
	(29, 'BP'),
	(30, 'AT&T'),
	(31, 'TOTAL'),
	(32, 'COASTCO'),
	(33, '중국은행'),
	(34, 'BMW GROUP'),
	(35, 'IBM'),
	(36, 'TESCO'),
	(37, 'SK HOLDDINGS'),
	(38, 'PHILIPS'),
	(39, '금호 타이어'),
	(40, 'AIG');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
