package sql.task11.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectUser {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/bazabib";
		String username = "memberOne";
		String password = "memberOnePassword";
		
		System.out.println("Povezivanje sa bazom...");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			System.out.println("Uspesna konekcija sa bazom.");
			
			String sqlselect = "SELECT * FROM knjige";
			
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sqlselect);
			
			while(result.next()) {
				String ISBN = result.getString(1);
				String naziv = result.getString(2);
				String jezik = result.getString(3);
				String izdavac = result.getString(4);
				String bibliotekaID = result.getString(5);
				String stanje = result.getString(6);
				
				StringBuilder builder = new StringBuilder();
				builder.append("\nISBN: ");
				builder.append(ISBN);
				builder.append("\nNaslov: ");
				builder.append(naziv);
				builder.append("\nJezik: ");
				builder.append(jezik);
				builder.append("\nIzdavač: ");
				builder.append(izdavac);
				builder.append("\nBibliotekaID: ");
				builder.append(bibliotekaID);
				builder.append("\nStanje: ");
				builder.append(stanje);
				
				System.out.println(builder.toString());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
