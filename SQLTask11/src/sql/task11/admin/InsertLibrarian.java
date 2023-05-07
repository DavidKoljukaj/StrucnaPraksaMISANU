package sql.task11.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertLibrarian {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/bazabib";
		String username = "adminBib";
		String password = "adminPassword";
		
		System.out.println("Povezivanje...");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			System.out.println("Uspesno povezivanje sa bazom.");
			
			String sqlinsert = "INSERT INTO bibliotekari(sifraZaposlenog, ime, prezime, ulica, broj, grad, JMBG, bibliotekaID)VALUES(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sqlinsert);
			ps.setString(1, "665529");
			ps.setString(2, "Milan");
			ps.setString(3, "Gocic");
			ps.setString(4, "Jednosmernih struja");
			ps.setString(5, "32");
			ps.setString(6, "Cacak");
			ps.setString(7, "1001977882931");
			ps.setString(8, "4");
			
			
			int unetiPodatak = ps.executeUpdate();
			
			if(unetiPodatak > 0 ) {
				System.out.println("Podatak je upisan.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
