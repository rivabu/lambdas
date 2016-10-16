package streams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Album;
import domain.AlbumBuilder;
import domain.Track;

public class Refactoring {

	public static void main(String[] args) {
		List<Album> albums = AlbumBuilder.getAlbums();
		System.out.println(findLongTracks(albums));
		System.out.println(findLongTracks2(albums));
		System.out.println(findLongTracks3(albums));
		System.out.println(findLongTracks4(albums));

		
	}
	
	// old style
	public static Set<String> findLongTracks(List<Album> albums) {
	    Set<String> trackNames = new HashSet<>();
	    for(Album album : albums) {
	        for (Track track : album.getTrackList()) {
	            if (track.getLength() > 60) {
	                String name = track.getName();
	                trackNames.add(name);
	            }
	        }
	    }
	    return trackNames;
	}
	
	public static Set<String> findLongTracks2(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
	    albums.stream()
	          .forEach(album -> {
	              album.getTrackList()
	                   .forEach(track -> {
	                       if (track.getLength() > 60) {
	                           String name = track.getName();
	                           trackNames.add(name);
	                       }
	                   });
	          });
	    return trackNames;
	}
	
	public static Set<String> findLongTracks3(List<Album> albums) {
	    Set<String> trackNames = new HashSet<>();

	    albums.stream()
	          .flatMap(album -> album.getTrackList().stream())
	          .filter(track -> track.getLength() > 60)
	          .map(track -> track.getName())
	          .forEach(name -> trackNames.add(name));

	    return trackNames;
	}
	
	public static Set<String> findLongTracks4(List<Album> albums) {
		// 1. neem albums
		// 2. maak een flatlist van alle tracks
		// 3. filter alle tracks > 60 erug
		// 4. maak een map van alle names
		// 5. convert to set
		
	    return albums.stream()
	                 .flatMap(album -> album.getTrackList().stream())
	                 .filter(track -> track.getLength() > 60)
	                 .map(track -> track.getName())
	                 .collect(Collectors.toSet());
	}

}
