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


-- 테이블 test의 구조를 덤프합니다. movie
CREATE TABLE IF NOT EXISTS `movie` (
  `movie_id` int(10) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0',
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

-- Dumping data for table test.movie: ~39 rows (대략적)
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` (`movie_id`, `movie_name`) VALUES
	(3, '코코코'),
	(4, '1987'),
	(5, '신과함께'),
	(7, '라라랜드'),
	(8, '세 얼간이'),
	(9, '드래고 길들이기'),
	(10, '클래식'),
	(11, '집으로 가는길'),
	(12, '여인의 향기'),
	(13, '소원'),
	(14, '에이리언 2'),
	(15, '헬프'),
	(16, '모노노케 히메'),
	(17, '글래디에이터'),
	(18, '라푼젤'),
	(19, '집으로'),
	(20, '아이언 자이언트'),
	(21, '캐스트 어웨이'),
	(22, '프리쿼시'),
	(23, '해리포터아 죽음의 성물-2부'),
	(24, '모던 타임즈'),
	(25, '바이센테니얼 맨'),
	(26, '코러스'),
	(27, '내 이름은 칸'),
	(28, '스피릿'),
	(29, '오세암'),
	(30, '다크 나이트'),
	(31, '시네마 천국'),
	(32, '굿 월 헌팅'),
	(33, '영웅'),
	(34, '블라인드 사이드'),
	(35, '아마데우스'),
	(36, '서유기'),
	(37, '트루먼쇼'),
	(38, '타잔'),
	(39, '사라은 비를 타고'),
	(40, '더록'),
	(41, '아이엠 샘'),
	(42, '록키');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
