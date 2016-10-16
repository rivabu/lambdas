package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

import domain.Artist;
import domain.ArtistBuilder;

public class SimpleTestMap {

	public static void main(String[] args) {
		List<Artist> artists = ArtistBuilder.getArtists();

		// collect(toList());

		// omzetten van een stream naar een list
		List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
		Assert.assertEquals(Arrays.asList("a", "b", "c"), collected);

		// oude manier
		List<String> collected2 = new ArrayList<>();
		for (String string : Arrays.asList("a", "b", "hello")) {
			String uppercaseString = string.toUpperCase();
			collected2.add(uppercaseString);
		}
		Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected2);

		// nieuwe manier
		List collected3 = Stream.of("a", "b", "hello")
				.map(item -> item.toUpperCase()) // doe voor alle elementen
				.collect(Collectors.toList()); // zet resultaat om in nieuwe list

		Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected3);

		
		List collected4 = Stream.of("a", "b", "1hello")
				.filter(item -> item.startsWith("1")) 
				.map(item -> item.toUpperCase())
				.collect(Collectors.toList()); // zet resultaat om in nieuwe list

		Assert.assertEquals(Arrays.asList("1HELLO"), collected4);
		
		// stream lijst met 2 lists, flatMap maakt er 1 lijst van
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());

		Assert.assertEquals(Arrays.asList(1, 2, 3, 4), together);
		
		
		List<Artist> newArtists = ArtistBuilder.getArtists().stream()
				.filter(album -> { album.setName("Rients"); return true;})
				.collect(Collectors.toList());
		
		System.out.println(newArtists);
	}

}
