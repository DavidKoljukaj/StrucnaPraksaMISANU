package sql.task11.librarian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateStanje {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/bazabib";
		String username = "librarianOne";
		String password = "libOnePass";
		
		System.out.println("Povezivanje...");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			System.out.println("Uspešno povezivanje sa bazom.");
			HashMap<String, String> knjigeStanje = new HashMap<>();
			knjigeStanje.put("9788663030428", "4");
			knjigeStanje.put("978868119615", "2");
			knjigeStanje.put("9781408856772", "3");
			knjigeStanje.put("9788662632951", "1");
			knjigeStanje.put("9788610028157", "2");
			String sqlupdate = "UPDATE knjige SET stanje =? WHERE knjige.ISBN = ?";
			
			for(String key : knjigeStanje.keySet()) {
				PreparedStatement ps = conn.prepareStatement(sqlupdate);
				
				ps.setString(1, knjigeStanje.get(key));
				ps.setString(2, key);
				
				int promenjenPodatak = ps.executeUpdate();
				
				if(promenjenPodatak > 0) {
					System.out.println("Uspešno ste promenili stanje.");
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
