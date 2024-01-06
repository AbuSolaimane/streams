package fadili.mostafa.streams.ch11.exercise;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fadili.mostafa.streams.ch07.exercise.Movie;
import fadili.mostafa.streams.ch07.exercise.MovieUtil;

//Solution to Movies_flatMapping exercise.
public class MovieTest {
	
	public static List<Movie> movies = MovieUtil.getMovieData();
	
	public static void main(String[] args) {
		
		List<String> stars = movies.stream()
			.filter(mov -> "Martin Scorsese".equals(mov.getDirectorName()))
			.flatMap(mov -> mov.getCast().stream())
			.collect(Collectors.toList());
		
		System.out.println(stars);
		
		//Exercise 1: Find list of stars who have acted in Martin Scorsese movies
		List<String> starCast = starsInMartinMovies();
		System.out.println(starCast);
		
		List<String> distinctStars = movies.stream()
			.filter(mov -> "Martin Scorsese".equals(mov.getDirectorName()))
			.flatMap(mov -> mov.getCast().stream())
			.distinct()
			.collect(Collectors.toList());
		
		System.out.println(distinctStars);
		
		System.out.println(movies.stream()
				.filter(mov -> "Martin Scorsese".equals(mov.getDirectorName()))
				.flatMap(mov -> mov.getCast().stream())
				.collect(Collectors.toSet()));
		
		//Exercise 2: Find unique list of stars who have acted in Martin Scorsese movies
		Set<String> starCastUnique = uniqueStarsInMartinMovies();
		System.out.println(starCastUnique);	
	}

	public static List<String> starsInMartinMovies() {
		return movies.stream()
					 .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
		             .flatMap(movie -> movie.getCast().stream())
		             .collect(Collectors.toList());
	}
	
	public static Set<String> uniqueStarsInMartinMovies() {
		return movies.stream()
					 .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
		             .flatMap(movie -> movie.getCast().stream())
		             .collect(Collectors.toSet());
	}
	
}
