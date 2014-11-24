
public class TranslatorV1 
{
	
	//get all teams
	public static String translateGet5Matches(String name)
	{
		String s = 	"Select Top 5 * From Matches where name = HTeam or name = ATeam Order By Date Desc";
		return s;
	}
	
	//get all teams
	//not sure if u need all attributes, if so, just replace Name by *;
	public static String translateGetTeams()
	{
		String s = "SELECT * FROM Teams";
		return s;
	}
	
	//get all teams with the boolean CL true
	//not sure if u need all attributes, if so, just replace Name by *;
	public static String translateGetTeamsCL()
	{
		String s = "SELECT * FROM Teams WHERE CL = true";
		return s;
	}
	
	
	//get all games played between HTeam and ATeam
	public static String translateGetMatch(String HTeam, String ATeam)
	{
		String s = "SELECT * FROM Matches WHERE HTeam =" + HTeam + "and ATeam =" + 
	    ATeam;
		return s;
	}
	
	//create a Team, with the Name, pnp and the boolean CL
	public static String translateInsertTeam(String Name,int PnP,Boolean CL)
	{
		String s = "INSERT INTO Teams(Name, PnP, CL)VALUES('"+ Name +"'," +
	    PnP + "," + CL +")";
		System.out.println(s);
		return s;
	}
	
	//create a Match, with the name of homeTeam, awayTeam, homeScore and awayScore
	public static String translateInsertMatch(String HTeam, String ATeam, int HScore, int AScore, String Date)
	{
		String s = "insert into Matches(HTeam, ATeam, HScore, AScore, Date) values (" +
	    HTeam + "," + ATeam + "," + HScore + "," + AScore + "," + Date + ")";
		return s;
	}
	
	//update both a teams name and the pnp
	public static String translateUpdateTeam(String name, String newName , int pnp)
	{
		String s = "update Team set Name =" + newName + ", PnP =" +pnp + "where Name =" +
	    name;
		return s;
	}
	
	//update a team name
	public static String translateUpdateTeam(String name, String newName)
	{
		String s = "update Team set Name =" + newName + "where Name =" + name;
		return s;
	}
	
	//update the boolean of CL
	public static String translateUpdateTeam  (String name, int pnp)
	{
		String s = "update Team set PnP =" +pnp + "where Name =" + name;
		return s;
	}
	
	//delete a Match based on the match ID
	public static String translateDeleteMatch (int mid)
	{
		String s = "delete from Matches where MID =" + mid;
		return s;
	}
	
	//delete a match, depending on the name of the homeTeam, awayTeam and date of match
	public static String translateDeleteMatch (String hometeam, String awayTeam, String date)
	{
		String s = "delete from Matches where HTeam =" + hometeam + "and ATeam =" +
	    awayTeam + "and Date =" + date;
		return s;
	}	
}