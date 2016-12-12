package streams;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import domain.Album;
import domain.Track;

public class ArtistStreams {

	@Test
	public void test() {

		Set<String> origins = Album.getMusicians().filter(artist -> artist.getName().startsWith("The"))
				.map(artist -> artist.getNationality()).collect(toSet());

		assertEquals(new TreeSet<String>(Arrays.asList("DE", "NL")), origins);
	}

	@Test
	public void findLongestTrack() {
		List<Album> albums = Album.getAlbums().collect(toList());

		Set<String> trackNames = new HashSet<>();
		for (Album album : albums) {
			for (Track track : album.getTrackList()) {
				if (track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			}
		}

		assertEquals(new TreeSet<String>(Arrays.asList("test")), trackNames);

	}

	@Test
	public void getTracksFromAlbumGt60() {
		List<Album> albums = Album.getAlbums().collect(toList());

		Set<String> trackNames = new HashSet<>();

		albums.stream().forEach(album -> {
			album.getTrackList().forEach(track -> {
				
				if (track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			});
		});

		assertEquals(new TreeSet<String>(Arrays.asList("test")), trackNames);
		
		Set<String> trackNames2 = new HashSet<>();
		albums.stream().forEach(album -> {
			album.getTrackList().stream().filter(track -> track.getLength() > 60).map(track -> track.getName())
					.forEach(name -> trackNames2.add(name));
		});

		assertEquals(new TreeSet<String>(Arrays.asList("test")), trackNames2);
		
		

	}
}
