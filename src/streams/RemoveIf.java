package streams;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.junit.Assert;

import domain.Album;

public class RemoveIf {
	public static void main(String args[]) {

		List<Album> albums = Album.getAlbums().collect(toList());
		Assert.assertEquals(3, albums.get(0).getTrackList().size());

		System.out.println(albums.get(0).getTrackList());
		albums.get(0).getTrackList().removeIf(track -> {
			System.out.println(track);
			return track.getLength() < 90;
		});
		System.out.println(albums.get(0).getTrackList());
		Assert.assertEquals(1, albums.get(0).getTrackList().size());

	}
}
