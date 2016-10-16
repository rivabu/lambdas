package streams;

import java.util.List;

import domain.Artist;
import domain.ArtistBuilder;

public class SimpleTest {

	public static void main(String[] args) {
		List<Artist> artists = ArtistBuilder.getArtists();
		int countLondon = 0;
		for (Artist a: artists) {
			if (a.isFrom("London")) {
				countLondon++;
			}
		}
		System.out.println("countLondon: " + countLondon);
		
		// stream is ongeveer hetzelfde als iterator
		countLondon = (int) artists.stream()
				.filter(artist -> artist.isFrom("London")) // implicit return
				.count();

		System.out.println("countLondon: " + countLondon);

	
		// let op de return!, deze moet erin zitten
		countLondon = (int) artists.stream()
				.filter(artist ->  {
					return artist.isFrom("London");
				})
				.filter(artist ->  {
					System.out.println(artist.getName());
					return artist.isFrom("London");
				})
				.count();

		System.out.println("countLondon: " + countLondon);
}

}
