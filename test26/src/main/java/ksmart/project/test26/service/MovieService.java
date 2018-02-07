package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieService {
	@Autowired
	MovieDao movieDao;
	
	// 영화 삭제 처리
	public void deleteMovie(int movieId) {
		movieDao.deleteMovie(movieId);
	}
	
	// 영화 수정 처리
	public void updateMovie(Movie movie) {
		movieDao.updateMovie(movie);
	}
	
	// 영화 수정 화면
	public Movie updateMovie(int movieId) {
		return movieDao.updateMovie(movieId);
	}
	
	// 영화 입력 처리
	public void insertMovie(String movieName) {
		movieDao.insertMovie(movieName);
	}
	
	// 영화 전체 목록
	public List<Movie> selectMovieList(){
		return movieDao.selectMovieList();
	}
}
