  import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
  import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
   
  public class ReadCSV {
   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
   
  	ReadCSV obj = new ReadCSV();
  	obj.run();
   
    }
   
    public void run() throws SQLException, ClassNotFoundException{
   
    	Connection c = null;
		Statement st = null;
		//add this to build path
		Class.forName("org.sqlite.JDBC");
		
		//the database we use
	    c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    
	    //create statement object
	    st = c.createStatement();
	    
  	String csvFile = "/Users/Kinga/My Documents/GitHub/Intelligent-Diet-Arrangement-System/DB_ready_data_short/Bauturi.csv";
  	BufferedReader br = null;
  	String line = "";
  	String cvsSplitBy = ",";
  	int ID=1;
  	try {
   
  		br = new BufferedReader(new FileReader(csvFile));
  		while ((line = br.readLine()) != null) {
   
  		        // use comma as separator
  			String[] food = line.split(cvsSplitBy);
  			
  			String sqlIns = "INSERT INTO BAUTURI " +
		    		"(ID,NAME, BREAKFAST, LUNCH, DINNER, NEEDS_SIDEDISH, IS_SIDEDISH, " +
		    		" CALORIES, PROTEINS, FATS, CARBS,FIBER) VALUES ("+ID+",\'" + food[0]+"\'," + food[1]+","+
		    		food[2]+"," + food[3]+"," + food[4]+"," + food[5]+"," + food[6]+"," + food[7]+"," +
		    		food[8]+"," + food[9] + "," + food[10]+ ")";
  			st.execute(sqlIns);
  			ID++;
  		}
  			
   
  	} catch (FileNotFoundException e) {
  		e.printStackTrace();
  	} catch (IOException e) {
  		e.printStackTrace();
  	} finally {
  		if (br != null) {
  			try {
  				br.close();
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  		}
  	}
  	 st.close();
	 c.close();
  	System.out.println("Done");
    }
   
  }