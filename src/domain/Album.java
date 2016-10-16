package domain;

import java.util.List;

public class Album {

	List<Track> trackList;

	public Album(List<Track> trackList) {
		super();
		this.trackList = trackList;
	}

	public List<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}


}
