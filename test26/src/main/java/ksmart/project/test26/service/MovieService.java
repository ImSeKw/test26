package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieService {
	@Autowired
	MovieDao movieDao;
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	// 영화 목록(페이징)
	public Map<String, Object> selectMovieListAndCountByPage(int currentPage, int pagePerRow) {
		logger.debug("{} : <currentPage selectMovieListAndCountByPage MovieService", currentPage);
		logger.debug("{} : <pagePerRow selectMovieListAndCountByPage MovieService", pagePerRow);
		// 쿼리문 페이징 작업
		int startPage = 0;
		if(currentPage != 1) {
			startPage = (currentPage-1)*pagePerRow;
		}
		Map<String, Integer> map = new HashMap();
		map.put("startPage", startPage);
		map.put("pagePerRow", pagePerRow);
		List<Movie> list = movieDao.selectMovieListByPage(map);
		logger.debug("{} : >list selectMovieListAndCountByPage MovieService", list);
		// 총 영화 수
		int count = movieDao.selectMovieCountByPage();
		logger.debug("{} : >count selectMovieListAndCountByPage MovieService", count);
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : >countPage selectMovieListAndCountByPage MovieService", countPage);
		// 리턴 작업
		Map<String, Object> returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("countPage", countPage);
		return returnMap;
	}
	
	// 영화 삭제 처리
	public void deleteMovie(int movieId) {
		logger.debug("{} : <movieId deleteMovie MovieService", movieId);
		movieDao.deleteMovie(movieId);
	}
	
	// 영화 수정 처리
	public void updateMovie(Movie movie) {
		logger.debug("{} : <movie updateMovie MovieService", movie);
		movieDao.updateMovie(movie);
	}
	
	// 영화 수정 화면
	public Movie updateMovie(int movieId) {
		logger.debug("{} : <movieId updateMovie MovieService", movieId);
		return movieDao.updateMovie(movieId);
	}
	
	// 영화 입력 처리
	public void insertMovie(String movieName) {
		logger.debug("{} : <movieName insertMovie MovieService", movieName);
		movieDao.insertMovie(movieName);
	}
	
	// 영화 전체 목록
	public List<Movie> selectMovieList(){
		logger.debug("<selectMovieList MovieService");
		return movieDao.selectMovieList();
	}
}
