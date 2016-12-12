package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Album {

	public static Stream<Artist> getMusicians() {
		List<Artist> allArtists = new ArrayList<>();
		allArtists.add(new Artist("The rients", "London", 10, "NL"));
		allArtists.add(new Artist("The suzan", "Paris", 10, "DE"));
		allArtists.add(new Artist("The peter", "Paris", 10, "DE"));
		return allArtists.stream();
	}

	public static Stream<Album> getAlbums() {
		List<Album> albums = new ArrayList<>();
		albums.add(new Album());
		albums.add(new Album());
		albums.add(new Album());
		return albums.stream();
	}

	public List<Track> getTrackList() {
		return Arrays.asList(new Track(100, "test"), new Track(50, "short"));
	}

}

