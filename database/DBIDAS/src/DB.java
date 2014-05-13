import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
		
		public static void main(String[] args) throws SQLException, ClassNotFoundException{

			Connection c = null;
			Statement st = null;
			
			//add this to build path
			Class.forName("org.sqlite.JDBC");
			
			//the database we use
		    c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    
		    //create statement object
		    st = c.createStatement();
		    String sqlSt = "CREATE TABLE OUA " +
		    		" (ID INT PRIMARY KEY NOT NULL," +
		    		" NAME STRING, BREAKFAST INT, LUNCH INT, DINNER INT, NEEDS_SIDEDISH INT, IS_SIDEDISH INT, " +
		    		" CALORIES INT, PROTEINS INT, FATS INT, CARBS INT, FIBER INT, VITAMINS INT, MINERALS INT)";
		    String query = "SELECT * FROM LEGUME";
		    
		    //execute sql statement
		    st.execute(sqlSt);
		    
		    //execute query and put it in result set
		    //ResultSet rs = st.executeQuery(query);
		    
		    //iterate through result set (the rows retrieved by the query)
		    
//		    while(rs.next()){									
//		    	
//		    }
		    
		    //close everything
		  //  rs.close();
		    st.close();
		    c.close();
		}

	}