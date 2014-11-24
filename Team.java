
public class Team {
	private String name;		// A simple string with the name of the team
	private int pnp;			// A simple number of players not playing
	private int[] games;		// Array with MatchIds
	private int[] hstatistic; 	// H: 40-10-50 Dashes are added in the graphical part
	private int[] astatistic; 	// A: 30-10-60
	private boolean cl;			// True is for champions league, false is for not champions league
	
	/**
	 * The constructor needs a a name for the team, 
	 * one int with players not playing,
	 * Int array for the five latest games MID's, Can be null?
	 * Int arrays for home statistics and away statistics, Can be null?
	 * And a boolean for champions leauge,
	 * You can not have a team without all of these.
	 */
	Team(String n, int p, int[] g, int[] hs, int[] as, boolean c){ 
		this.setName(n);
		this.setPnp(p);
		this.setGames(g);
		this.setHstatistic(hs); 
		this.setAstatistic(as); 
		this.setCl(c);
	}
	/**
	 * Constructor for inserting into db where you don't need the latest games and statistics
	 */
	Team(String n, int p, boolean c){
		this.setName(n);
		this.setPnp(p);
		this.setCl(c);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPnp() {
		return pnp;
	}

	public void setPnp(int pnp) {
		this.pnp = pnp;
	}

	public int[] getGames() {
		return games;
	}

	public void setGames(int[] g) {
		this.games = g;
	}

	public boolean isCl() {
		return cl;
	}

	public void setCl(boolean cl) {
		this.cl = cl;
	}

	public int[] getHstatistic() {
		return hstatistic;
	}

	public void setHstatistic(int[] hstatistic) {
		this.hstatistic = hstatistic;
	}

	public int[] getAstatistic() {
		return astatistic;
	}

	public void setAstatistic(int[] astatistic) {
		this.astatistic = astatistic;
	}
	
}
