package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Movie;
import ksmart.project.test26.service.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	
	// 영화 삭제 처리
	@RequestMapping(value="/movie/deleteMovie", method=RequestMethod.GET)
	public String deleteMovie(@RequestParam(value="movieId") int movieId) {
		movieDao.deleteMovie(movieId);
		return "redirect:/movie/movieList";
	}
	
	// 영화 수정 처리
	@RequestMapping(value="/movie/updateMovie", method=RequestMethod.POST)
	public String updateMovie(Movie movie) {
		movieDao.updateMovie(movie);
		return "redirect:/movie/movieList";
	}
	
	// 영화 수정 화면
	@RequestMapping(value="/movie/updateMovie", method=RequestMethod.GET)
	public String updateMovie(Model model, @RequestParam(value="movieId") int movieId) {
		Movie movie = movieDao.updateMovie(movieId);
		model.addAttribute("movie", movie);
		return "movie/updateMovie";
	}
	
	// 영화 입력 처리
	@RequestMapping(value="/movie/insertMovie", method=RequestMethod.POST)
	public String insertMovie(@RequestParam(value="movieName") String movieName) {
		movieDao.insertMovie(movieName);
		return "redirect:/movie/movieList";
	}
	
	// 영화 입력 화면
	@RequestMapping(value="/movie/insertMovie", method=RequestMethod.GET)
	public String insertMovie() {
		return "movie/insertMovie";
	}
	
	// 영화 전체 목록
	@RequestMapping(value="/movie/movieList")
	public String movieList(Model model) {
		List<Movie> list = movieDao.selectMovieList();
		model.addAttribute("list", list);
		return "movie/movieList";
	}
}
