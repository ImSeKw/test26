package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Movie;
import ksmart.project.test26.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	// 영화 목록(페이징)
	@RequestMapping(value = "/Movie/MovieList", method = RequestMethod.GET)
	public String selectMovieListAndCountByPage(Model model, HttpSession httpSession
												, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
												, @RequestParam(value = "pagePerRow", required = false, defaultValue = "5") int pagePerRow
												, @RequestParam(value = "word", required = false) String word) {
		logger.debug("{} : <currentPage selectMovieListAndCountByPage MovieController", currentPage);
		logger.debug("{} : <pagePerRow selectMovieListAndCountByPage MovieController", pagePerRow);
		logger.debug("{} : <word selectMovieListAndCountByPage MovieController", word);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			Map<String, Object> map = movieService.selectMovieListAndCountByPage(currentPage, pagePerRow, word);
			List<Movie> list = (List<Movie>)map.get("list");
			int countPage = (Integer)map.get("countPage");
			word = (String)map.get("word");
			logger.debug("{} : >list selectMovieListAndCountByPage MovieController", list);
			logger.debug("{} : >countPage selectMovieListAndCountByPage MovieController", countPage);
			model.addAttribute("list", list);
			model.addAttribute("countPage", countPage);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("word", word);
			view = "movie/movieList";
		}
		return view;
	}
	
	// 영화 삭제 처리
	@RequestMapping(value = "/Movie/deleteMovie", method = RequestMethod.GET)
	public String deleteMovie(HttpSession httpSession, @RequestParam(value = "movieId") int movieId) {
		logger.debug("{} : <httpSession deleteMovie MovieController", httpSession);
		logger.debug("{} : <movieId deleteMovie MovieController", movieId);
		// 로그인 접근 처리
			if(httpSession.getAttribute("loginMember") != null) {
				movieService.deleteMovie(movieId);
			}
		return "redirect:/movie/movieList";
	}
	
	// 영화 수정 처리
	@RequestMapping(value = "/Movie/updateMovie", method = RequestMethod.POST)
	public String updateMovie(Movie movie) {
		logger.debug("{} : <movie updateMovie MovieController", movie);
		movieService.updateMovie(movie);
		return "redirect:/movie/movieList";
	}
	
	// 영화 수정 화면
	@RequestMapping(value = "/Movie/updateMovie", method = RequestMethod.GET)
	public String updateMovie(HttpSession httpSession, Model model, @RequestParam(value = "movieId") int movieId) {
		logger.debug("{} : <httpSession updateMovie MovieController", httpSession);
		logger.debug("{} : <model updateMovie MovieController", model);
		logger.debug("{} : <movieId updateMovie MovieController", movieId);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/Movie/movieList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			Movie movie = movieService.updateMovie(movieId);
			logger.debug("{} : >movie updateMovie MovieController", movie);
			model.addAttribute("movie", movie);
			view = "movie/updateMovie";
		}
		logger.debug("{} : >view updateMovie MovieController", view);
		return view;
	}
	
	// 영화 입력 처리
	@RequestMapping(value = "/Movie/insertMovie", method = RequestMethod.POST)
	public String insertMovie(@RequestParam(value="movieName") String movieName) {
		logger.debug("{} : <movieName insertMovie MovieController", movieName);
		movieService.insertMovie(movieName);
		return "redirect:/movie/movieList";
	}
	
	// 영화 입력 화면
	@RequestMapping(value = "/Movie/insertMovie", method = RequestMethod.GET)
	public String insertMovie(HttpSession httpSession) {
		logger.debug("{} : <httpSession insertMovie MovieController", httpSession);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/movie/movieList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			view = "movie/insertMovie";
		}
		logger.debug("{} : >view insertMovie MovieController", view);
		return view;
	}
	
	// 영화 전체 목록
	@RequestMapping(value = "/Movie/MovieListAll", method = RequestMethod.GET)
	public String movieList(HttpSession httpSession, Model model) {
		logger.debug("{} : <httpSession movieList MovieController", httpSession);
		logger.debug("{} : <model movieList MovieController", model);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			List<Movie> list = movieService.selectMovieList();
			logger.debug("{} : >list movieList MovieController", list);
			model.addAttribute("list", list);
			view = "movie/movieList";
		}
		logger.debug("{} : >view movieList MovieController", view);
		return view;
	}
}
