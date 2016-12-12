package streams;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import domain.Artist;

public class Streams {

	List<Artist> allArtists;

	@Before
	public void setup() {
		allArtists = new ArrayList<>();
		allArtists.add(new Artist("rients", "London", 10, "NL"));
		allArtists.add(new Artist("suzan", "Paris", 100, "DE"));

	}

	@Test
	public void testFilters() {
		long count = 0;
		Iterator<Artist> iterator = allArtists.iterator();
		while (iterator.hasNext()) {
			Artist artist = iterator.next();
			if (artist.isFrom("London")) {
				count++;
			}
		}
		assertEquals(1, count);

		count = allArtists.stream().filter(artist -> artist.isFrom("London")).count();
		assertEquals(1, count);

		// return is needed because of the { }, it return true/false
		// without the .count() -> nothing printed
		count = allArtists.stream().filter(artist -> {
			print(artist.getName());
			return artist.isFrom("London");
		}).count();

		assertEquals(1, count);
	}

	private void print(String s) {
		System.out.println(s);
	}

	@Test
	public void testCollect() {
		List<String> collected = Stream.of("a", "b", "c").collect(toList());

		assertEquals(asList("a", "b", "c"), collected);

	}

	@Test
	public void testCollectWithFilter() {
		List<String> collected = Stream.of("a", "b", "c").filter(a -> a.equals("a")).collect(toList()); // collect
																										// is
																										// eager

		assertEquals(asList("a"), collected);

	}

	@Test
	public void testMap() {
		// old
		List<String> collected = new ArrayList<>();
		for (String string : asList("a", "b", "hello")) {
			String uppercaseString = string.toUpperCase();
			collected.add(uppercaseString);
		}

		assertEquals(asList("A", "B", "HELLO"), collected);

		// new
		// argument type blijft gelijk
		collected = Stream.of("a", "b", "hello").map(string -> string.toUpperCase()).collect(toList());
		assertEquals(asList("A", "B", "HELLO"), collected);
	}

	@Test
	public void testFilter() {
		// old
		List<String> beginningWithNumbers = new ArrayList<>();
		for (String value : asList("a", "1abc", "abc1")) {
			if (Character.isDigit(value.charAt(0))) {
				beginningWithNumbers.add(value);
			}
		}

		assertEquals(asList("1abc"), beginningWithNumbers);

		// new

		// filter content geeft true/false terug
		beginningWithNumbers = Stream.of("a", "1abc", "abc1").filter(value -> Character.isDigit(value.charAt(0)))
				.collect(toList());
		assertEquals(asList("1abc"), beginningWithNumbers);
	}

	@Test
	public void testFlatMap() {
		// maak van 2 lijsten 1 met flatmap
		/*
		 * Returns a stream consisting of the results of replacing each element
		 * of this stream with the contents of a mapped stream produced by
		 * applying the provided mapping function to each element. Each mapped
		 * stream is closed after its contents have been placed into this
		 * stream.
		 */
		List<Integer> together = Stream.of(asList(1, 2), asList(3, 4)).flatMap(numbers -> numbers.stream())
				.filter(i -> i >= 2).collect(toList());

		assertEquals(asList(2, 3, 4), together);
	}

	@Test
	public void testMin() {

		// .min(): Returns the minimum element of this stream according to the
		// provided Comparator. This is a special case of a reduction.
		// .get() : If a value is present in this Optional, returns the value,
		// otherwise throws NoSuchElementException.
		Artist smallest = allArtists.stream().min(Comparator.comparing(artist -> artist.getAge())).get();

		assertEquals(allArtists.get(0), smallest);
	}

	@Test
	public void testSumAges() {
		int total = allArtists.stream().collect(Collectors.summingInt(Artist::getAge));
		assertEquals(110, total);
	}

	@Test
	public void testReduce() {

		// reduce, tussenresultaat is de acc. Een functie wordt meegegeven als resultaat
		int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);

		assertEquals(6, count);

		// Integer::sum = a + b
		count = Stream.of(1, 2, 3).reduce(0, Integer::sum);

		assertEquals(6, count);

	}

}
