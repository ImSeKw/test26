package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

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
	
	// 총 영화 수(페이징)
	public int selectMovieCountByPage(Map map) {
		logger.debug("{} : <word selectMovieCountByPage MovieDao", map.get("word"));
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectMovieCountByPage", map);
	}
	
	// 영화 목록(페이징)
	public List<Movie> selectMovieListByPage(Map map) {
		logger.debug("{} : <startPage selectMovieListByPage MovieDao", map.get("startPage"));
		logger.debug("{} : <PagePerRow selectMovieListByPage MovieDao", map.get("pagePerRow"));
		logger.debug("{} : <word selectMovieListByPage MovieDao", map.get("word"));
		return sqlSessionTemplate.selectList(NAMESPACE + "selectMovieListByPage", map);
	}
	
	// 영화 삭제 처리
	public void deleteMovie(int movieId) {
		logger.debug("{} : <movieId deleteMovie MovieDao", movieId);
		sqlSessionTemplate.delete(NAMESPACE + "deleteMovie", movieId);
	}
	
	// 영화 수정 처리
	public void updateMovie(Movie movie) {
		logger.debug("{} : <movie updateMovie MovieDao", movie);
		sqlSessionTemplate.update(NAMESPACE + "updateMovie", movie);
	}
	
	// 영화 수정 화면
	public Movie updateMovie(int movieId) {
		logger.debug("{} : <movieId updateMovie MovieDao", movieId);
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectMovieId", movieId);
	}
	
	// 영화 입력 처리
	public void insertMovie(String movieName) {
		logger.debug("{} : <movieName insertMovie MovieDao", movieName);
		sqlSessionTemplate.insert(NAMESPACE + "insertMovie", movieName);
	}
	
	// 영화 전체 목록
	public List<Movie> selectMovieList(){
		logger.debug("<selectMovieList MovieDao");
		return sqlSessionTemplate.selectList(NAMESPACE + "selectMovieList");
	}
}
