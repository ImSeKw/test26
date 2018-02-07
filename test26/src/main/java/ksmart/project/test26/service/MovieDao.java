package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(MovieDao.class);
	// 경로설정 중복처리
	private final String NAMESPACE = "ksmart.project.test26.mapper.MovieMapper."; 
	
	// 영화 삭제 처리
	public void deleteMovie(int movieId) {
		sqlSessionTemplate.delete(NAMESPACE + "deleteMovie", movieId);
	}
	
	// 영화 수정 처리
	public void updateMovie(Movie movie) {
		sqlSessionTemplate.update(NAMESPACE + "updateMovie", movie);
	}
	
	// 영화 수정 화면
	public Movie updateMovie(int movieId) {
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectMovieId", movieId);
	}
	
	// 영화 입력 처리
	public void insertMovie(String movieName) {
		sqlSessionTemplate.insert(NAMESPACE + "insertMovie", movieName);
	}
	
	// 영화 전체 목록
	public List<Movie> selectMovieList(){
		return sqlSessionTemplate.selectList(NAMESPACE + "selectMovieList");
	}
}
