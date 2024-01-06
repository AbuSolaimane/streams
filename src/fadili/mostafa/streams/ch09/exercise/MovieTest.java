package fadili.mostafa.streams.ch09.exercise;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fadili.mostafa.streams.ch07.exercise.Movie;
import fadili.mostafa.streams.ch07.exercise.MovieUtil;

//Solution for exercise Movies_min_max_sum
public class MovieTest {
	
	public static List<Movie> movies = MovieUtil.getMovieData();
	
	public static void main(String[] args) {
		
//		Movie movie = movies.stream()
//			.reduce((m1, m2) -> m1.getGrossEarning() > m2.getGrossEarning() ? m1 : m2)
//			.orElseGet(() -> new Movie("Unknown", "Unknown"));
//		
//		Optional<Movie> mov2 = movies.stream()
//			.max(Comparator.comparing(Movie::getGrossEarning));
//		
//		System.out.println(movie);
//		System.out.println(mov2);
		
//		Optional<Movie> movie = movies.stream()
//			.filter(mov -> mov.getDateOfRelease().getYear() == 2020)
//			.reduce((m1, m2) -> m1.getGrossEarning() < m2.getGrossEarning() ? m1 : m2);
//		
//		System.out.println(movie);
//		
//		Optional<Movie> mov2 = movies.stream()
//				.filter(mov -> mov.getDateOfRelease().getYear() == 2020)
//				.min(Comparator.comparing(Movie::getGrossEarning));
//		
//		System.out.println(mov2);
		
//		movies.stream()
//			.filter(mov -> "Martin Scorsese".equals(mov.getDirectorName()))
//			.mapToLong(Movie::getGrossEarning)
//			.reduce((ge1, ge2) -> ge1 + ge2)
//			.ifPresent(System.out::println);
//		
//		long sum2 = movies.stream()
//			.filter(mov -> "Martin Scorsese".equals(mov.getDirectorName()))
//			.mapToLong(Movie::getGrossEarning)
//			.sum();
//		
//		System.out.println(sum2);
		
//		movies.stream()
//			.filter(mov -> mov.getDateOfRelease().getYear() >= 2017)
//			.mapToInt(mov -> 1)
//			.reduce((v1, v2) -> v1 + v2)
//			.ifPresent(System.out::println);
//		
//		movies.stream()
//		.filter(mov -> mov.getDateOfRelease().getYear() >= 2017)
//		.count();
		
		
		
		//Exercise one - Find the highest grossing movie.
		Optional<Movie> highestEarningMovie = highestGrossingMovie();
		System.out.println(highestEarningMovie);
		
		//Exercise two - find the lowest grossing movie in the year 2020
		Optional<Movie> lowestEarningMovieIn2020 = lowestGrossingMovieIn2020();
		System.out.println(lowestEarningMovieIn2020);
		
		//Exercise three - Total money - films made by Martin Scorsese
		long sum = sumGrossMoviesByMartinScorsese();
		System.out.println(sum);
		
		//Exercise four - How many movies released in last 5 years ?
		long noLastFiveYears = noOfMoviesInLastFiveYears();
		System.out.println(noLastFiveYears);

	}

	private static long noOfMoviesInLastFiveYears() {
		
		LocalDate lastTenYears = LocalDate.now().minusYears(10);
		
		return movies.stream()
					 .filter(movie -> movie.getDateOfRelease().isAfter(lastTenYears))
					 .count();		
	}

	public static Optional<Movie> highestGrossingMovie() {
		
		Comparator<Movie> byGrossEarning = Comparator.comparing(Movie::getGrossEarning);
		
		return movies.stream()
					 .max(byGrossEarning);
	}
	
	public static Optional<Movie> lowestGrossingMovieIn2020() {
		
		Comparator<Movie> byGrossEarning = Comparator.comparing(Movie::getGrossEarning);
		
		return movies.stream()
					 .filter(movie -> movie.getDateOfRelease().getYear() == 2020)
					 .min(byGrossEarning);
	}
	
	public static long sumGrossMoviesByMartinScorsese() {
		
		return movies.stream()
					 .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
					 .mapToLong(movie -> movie.getGrossEarning())
					 .sum();
	}


	
	
}
