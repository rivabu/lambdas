package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlbumBuilder {

	public static List<Album> getAlbums() {
		List<Album> albums = new ArrayList<>();
		Track t1 = new Track(100, "name1");
		Track t2 = new Track(10, "name2");
		Track t3 = new Track(11, "name3");
		Track t4 = new Track(120, "name4");
		Track t5 = new Track(190, "name5");
		
		List<Track> trackList1 = Stream.of(t1, t2, t3).collect(Collectors.toList());
		List<Track> trackList2 = Stream.of(t5, t4).collect(Collectors.toList());
		List<Track> trackList3 = Arrays.asList(t1, t2, t3);
		List<Track> trackList4 = Arrays.asList(t5, t4);
		
		Album a = new Album(trackList1);
		Album b = new Album(trackList2);
		albums.add(a);
		albums.add(b);
		return albums;
			
	}
}
