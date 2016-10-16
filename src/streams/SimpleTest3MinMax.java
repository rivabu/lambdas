package streams;

import java.util.Comparator;
import java.util.List;

import org.junit.Assert;

import domain.Artist;
import domain.ArtistBuilder;

public class SimpleTest3MinMax {

	public static void main(String[] args) {
		List<Artist> artists = ArtistBuilder.getArtists();

		Artist a = artists.stream()
				.min(Comparator.comparing(artist -> artist.getAge()))
				.get();

		Assert.assertEquals(artists.get(0), a);
	}

}
