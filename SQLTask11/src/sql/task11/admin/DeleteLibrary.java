package sql.task11.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteLibrary {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/bazabib";
		String username = "adminBib";
		String password = "adminPassword";
		
		System.out.println("Povezivanje...");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			System.out.println("Uspešno povezivanje sa bazom.");
			String sqldelete = "DELETE FROM biblioteke WHERE bibliotekaID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sqldelete);
			ps.setString(1, "3");
			
			int obrisanPodatak = ps.executeUpdate();
			
			if(obrisanPodatak > 0) {
				System.out.println("Biblioteka je uspešno izbrisana iz registra.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
