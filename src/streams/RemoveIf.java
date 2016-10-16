package streams;

import java.util.List;

import domain.Album;
import domain.AlbumBuilder;
import org.junit.Assert;

public class RemoveIf {
	public static void main(String args[]) {

		List<Album> albums = AlbumBuilder.getAlbums();
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
