
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *Connectivity solution inspired by ismalizd youtube
 */
public class JavaDBCon {
	public static void connection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connected");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//Used for connecting to the db server, returns that connection so that it might be used elsweyr
	public static Connection ConnectingSQL(){
		connection();
		String url = "jdbc:mysql://sql4.freemysqlhosting.net/";
		String dbName = "sql457127";
		String userName = "sql457127";
		String password = "uI9!rE8%";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);

			System.out.println("Worked");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
	//Inserts a team to the db based on the argument
	public static void InsertTeam(Team t){
		Connection conn = ConnectingSQL();
		try{
			PreparedStatement instatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateInsertTeam(t.getName(),t.getPnp(),t.isCl())); 
			instatement.execute();
			instatement.close();
			conn.close();
			System.out.println("BDJDS");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	//Integration testing not done
	public static void InsertMatch(Match m){
		Connection conn = ConnectingSQL();
		try{
			PreparedStatement instatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateInsertMatch(m.getHteam(),m.getAteam(),m.getHscore(),m.getAscore(),m.getDate()));
			instatement.execute();
			instatement.close();
			conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	//Integration testing not done
	public static Match[] getLatestMatches(Team t){
		Connection conn = ConnectingSQL();
		Match m= null;
		ResultSet rs = null;
		Match[] ma = null;
		int rsrows =0;
		try{
			PreparedStatement outstatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateGet5Matches(t.getName()));
			rs.last();
			rsrows= rs.getRow();
			rs.beforeFirst();
			ma = new Match[rsrows];
			System.out.println("Made a resultset");
		} catch(SQLException e){
			e.printStackTrace();
		}
		for(int i = 0; i<rsrows; i++){
			try{
				rs.next();
				m = new Match(rs.getString(2),rs.getString(3),rs.getString(6),rs.getInt(4),rs.getInt(5),rs.getInt(1));
			}catch(SQLException e){
				e.printStackTrace();
			}		ma[i]=m;
		}
		return ma;
	}
	//Integration testing not done
	public static Match[] getMatch(Team ht, Team at){
		Connection conn = ConnectingSQL();
		Match m= null;
		ResultSet rs = null;
		Match[] ma = null;
		int rsrows =0;
		try{
			PreparedStatement outstatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateGetMatch(ht.getName(), at.getName()));
			rs = outstatement.executeQuery();
			rs.last();
			rsrows= rs.getRow();
			rs.beforeFirst();
			ma = new Match[rsrows];
			System.out.println("Made a resultset");
		} catch(SQLException e){
			e.printStackTrace();
		}
		for(int i = 0; i<rsrows; i++){
			try{
				rs.next();
				m = new Match(rs.getString(2),rs.getString(3),rs.getString(6),rs.getInt(4),rs.getInt(5),rs.getInt(1));
				/*m.setMID(rs.getInt(1));
			m.setHteam(rs.getString(2));
			m.setAteam(rs.getString(3));
			m.setHscore(rs.getInt(4));
			m.setAscore(rs.getInt(5));
			m.setDate(rs.getString(6));*/
			}catch(SQLException e){
				e.printStackTrace();
			}		ma[i]=m;
		}
		return ma;
	}
	//Integration testing not done
	public static void updateTeamNamePnp(Team name, String newName, int pnp){
		Connection conn = ConnectingSQL();
		try{
			PreparedStatement instatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateUpdateTeam(name.getName(),newName,pnp)); 
			instatement.execute();
			instatement.close();
			conn.close();
			System.out.println("BDJDS");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	//Integration testing not done
	public static void updateTeamName(Team name, String newName){
		Connection conn = ConnectingSQL();
		try{
			PreparedStatement instatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateUpdateTeam(name.getName(),newName)); 
			instatement.execute();
			instatement.close();
			conn.close();
			System.out.println("BDJDS");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	//Integration testing not done
	public static void updateTeamCl(Team name, Boolean cl){
		Connection conn = ConnectingSQL();
		try{
			PreparedStatement instatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateUpdateTeam(name.getName(), cl)); 
			instatement.execute();
			instatement.close();
			conn.close();
			System.out.println("BDJDS");
		} catch(SQLException e){
			
			e.printStackTrace();
		}
	}
	//Integration testing not done
	public static void updateTeamPnp(Team name, int pnp){
		Connection conn = ConnectingSQL();
		try{
			PreparedStatement instatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateUpdateTeam(name.getName(),pnp)); 
			instatement.execute();
			instatement.close();
			conn.close();
			System.out.println("BDJDS");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	//Integration testing not done
	public static void deleteMatchWithID(Match m){
		Connection conn = ConnectingSQL();
		try{
			PreparedStatement instatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateDeleteMatch(m.getMID())); 
			instatement.execute();
			instatement.close();
			conn.close();
			System.out.println("BDJDS");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	//Integration testing not done
	public static void deleteMatch(Match m){
		Connection conn = ConnectingSQL();
		try{
			PreparedStatement instatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateDeleteMatch(m.getHteam(),m.getAteam(),m.getDate())); 
			instatement.execute();
			instatement.close();
			conn.close();
			System.out.println("BDJDS");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	// Returns an array of all teams from the db.
	public static Team[] GetTeams(){ 
		Connection conn = ConnectingSQL();
		Team t= null;
		ResultSet rs = null;
		Team[] ta = null;
		int rsrows =0;
		try{
			PreparedStatement outstatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateGetTeams());
			rs = outstatement.executeQuery();
			rs.last();
			rsrows= rs.getRow();
			rs.beforeFirst();
			ta = new Team[rsrows];
			System.out.println("Made a resultset");
		} catch(SQLException e){
			e.printStackTrace();
		}
		for(int i = 0; i<rsrows; i++){
			try{
				rs.next();
				t = new Team(rs.getString(1),rs.getInt(2),rs.getBoolean(3));
			}catch(SQLException e){
				e.printStackTrace();
			}		ta[i]=t;
		}
		return ta;
	}
	//Integration testing not done
	public static Team[] GetTeamsCL(){ 
		Connection conn = ConnectingSQL();
		Team t= null;
		ResultSet rs = null;
		Team[] ta = null;
		int rsrows =0;
		try{
			PreparedStatement outstatement = (PreparedStatement) conn.prepareStatement(TranslatorV1.translateGetTeamsCL());
			rs = outstatement.executeQuery();
			rs.last();
			rsrows= rs.getRow();
			rs.beforeFirst();
			ta = new Team[rsrows];
			System.out.println("Made a resultset");
		} catch(SQLException e){
			e.printStackTrace();
		}
		for(int i = 0; i<rsrows; i++){
			try{
				rs.next();
				t = new Team(rs.getString(1),rs.getInt(2),rs.getBoolean(3));
			}catch(SQLException e){
				e.printStackTrace();
			}		ta[i]=t;
		}
		return ta;
	}
	
	
	/*public static void testingrs(){
		Connection conn = ConnectingSQL();
		ResultSet rs = null;
		int rsrows;
		try{
			PreparedStatement outstatement = (PreparedStatement) conn.prepareStatement("SELECT * FROM Matches;");
			rs = outstatement.executeQuery();
			System.out.println("Made a resultset");
		}catch(SQLException e){
			e.printStackTrace();
		}
		/*
		try {
			rs.first();
			String s = rs.getString(1);
			String pnp = rs.getString(2);
			boolean cl = rs.getBoolean(3);
			System.out.println(s+pnp+cl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		 * try {
		 
			rs.first();
			int MID = rs.getInt(1);
			String ht = rs.getString(2);
			String at = rs.getString(3);
			int hs = rs.getInt(4);
			int as = rs.getInt(5);
			String dt = rs.getString(6);
			System.out.println(MID+ht+at+hs+as+dt);
		} catch(SQLException e){
			e.printStackTrace();
		}
		*/
	/*}
	public static void main(String[] args) {
		Team c = new Team("Chelsea", 1, true);
		Team ar = new Team("Arsenal", 4, true);
		Match[] ma =  getMatch(c, ar);
		System.out.println(ma[0].getHteam()+ma[0].getAteam()+ma[0].getHscore()+ma[0].getAscore()+ma[0].getDate());
		System.out.println(ma[1].getHteam()+ma[1].getAteam()+ma[1].getHscore()+ma[1].getAscore()+ma[1].getDate());
		//Team tempteam = new Team("fotör BK", 0,false);
		//InsertTeam(tempteam);
		
	
	}*/
	/*
	public static String TranslateInsertTeam(String x, int y, boolean c){
		String s ="INSERT INTO Teams(Name, PnP, CL)VALUES('"+x+"',"+y+","+c+")";
		return s;
	}
	*/
	
}