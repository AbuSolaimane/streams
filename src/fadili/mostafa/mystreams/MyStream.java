package fadili.mostafa.mystreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {

	public static void main(String[] args) {
		
		String str = "Automation";
        StringBuilder str2 = new StringBuilder();
        str2.append(str);
        str2 = str2.reverse();
       System.out.println(str2);
		
		List<String> strings = new ArrayList<>(List.of("as", "hg", "mnb", "b"));
		strings.forEach(s -> s = "n,mn");
		
		Stream.of("as", "hg", "mnb", "b")
			.sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
			.forEach(System.out::println);
		
//		Stream.iterate(1, i -> i * 3).filter(a -> a%2 == 0).skip(2).limit(10).sorted()
//		.forEach(System.out::println);
		
		
//		Arrays.asList("a", "b", "a", "c").stream()
//		.collect(Collectors)
		
		Stream.iterate(0, i -> i+1).limit(10)
		.filter(num -> {
			System.out.println("is " + num + " even");
			return num % 2 == 0;
		}).filter(num -> {
			System.out.println("is " + num + " > 3");
			return num > 3;
		}).forEach(System.out::println);
		
		Integer findFirst = Arrays.asList(7, 11).stream()
			.sorted((a, b) -> b - a)
			.skip(2)
			.findFirst()
			.orElse(-1);
		
		System.out.println(findFirst);
		
		Map<Integer, Long> collect = Arrays.asList(7, 11, 7, 11, 8, 8, 9, 13, 5, 9).stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(collect);
	}
	
}
