package domain;

import java.util.ArrayList;
import java.util.List;

public class ArtistBuilder {

	public static List<Artist> getArtists() {
		List<Artist> artists = new ArrayList<>();
		artists.add(new Artist("Rients", "London", 10));
		artists.add(new Artist("Janet", "Berlin", 11));
		artists.add(new Artist("Peter", "London", 12));
		artists.add(new Artist("Axel", "Paris", 13));
		artists.add(new Artist("Lana", "London", 14));

		return artists;

	}
}
