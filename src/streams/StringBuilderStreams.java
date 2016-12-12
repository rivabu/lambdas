package streams;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import domain.Artist;

public class StringBuilderStreams {
	
	List<Artist> allArtists;

	@Before
	public void setup() {
		allArtists = new ArrayList<>();
		allArtists.add(new Artist("rients", "London", 10, "NL"));
		allArtists.add(new Artist("suzan", "Paris", 100, "DE"));

	}
	@Test
	public void buildString() {

		
		StringBuilder builder = new StringBuilder("[");
		for (Artist  artist : allArtists) {
		    if (builder.length() > 1)
		        builder.append(", ");

		    String name = artist.getName();
		    builder.append(name);
		}
		builder.append("]");
		
		assertEquals("[rients, suzan]", builder.toString());
		
		/*
		 * joining
public static Collector<CharSequence,?,String> joining(CharSequence delimiter,
                                                       CharSequence prefix,
                                                       CharSequence suffix)

Returns a Collector that concatenates the input elements, separated by the specified delimiter, 
with the specified prefix and suffix, in encounter order.

		 */
		
		String result =
				allArtists.stream()
			              .map(Artist::getName)
			              .collect(Collectors.joining(", ", "[", "]"));
		assertEquals("[rients, suzan]", result);
		
	}
}
