
public class Match {
	private String Hteam;	// This should be the same as a name from an existing Team,
	private String Ateam;
	private String Date;	// You can not have a match without 2 existing teams.
	private int Hscore;		// Int for a score
	private int Ascore;	
	private int MID;		// Match ID
	/**
	 * Need 2 names for the teams that compete
	 * First score is for the first team
	 * Second score is for the second team
	 * The MID should only ever be specified by the DB
	 */
	Match(String ht, String at, String d, int hs, int as, int id){
		this.setHteam(ht);
		this.setAteam(at);
		this.setDate(d);
		this.setHscore(hs);
		this.setAscore(as);
		this.setMID(id);
	}

	public String getHteam() {
		return Hteam;
	}

	public void setHteam(String hteam) {
		Hteam = hteam;
	}

	public String getAteam() {
		return Ateam;
	}

	public void setAteam(String ateam) {
		Ateam = ateam;
	}

	public int getHscore() {
		return Hscore;
	}

	public void setHscore(int hscore) {
		Hscore = hscore;
	}

	public int getAscore() {
		return Ascore;
	}

	public void setAscore(int ascore) {
		Ascore = ascore;
	}

	public int getMID() {
		return MID;
	}

	public void setMID(int mID) {
		MID = mID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

}
