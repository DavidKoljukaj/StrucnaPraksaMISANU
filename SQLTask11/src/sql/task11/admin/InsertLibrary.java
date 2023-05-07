package sql.task11.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertLibrary {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/bazabib";
		String username = "adminBib";
		String password = "adminPassword";
		
		System.out.println("Povezivanje...");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			System.out.println("Uspesno povezivanje sa bazom.");
			
			String sqlinsert = "INSERT INTO biblioteke(bibliotekaID, naziv, ulica, broj, grad, telefon)VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sqlinsert);
			ps.setString(1, "3");
			ps.setString(2, "Biblioteka grada Beograda");
			ps.setString(3, "Knez Mihailova");
			ps.setString(4, "56");
			ps.setString(5, "Beograd");
			ps.setString(6, "20 24 011");
			
			int unetiPodatak = ps.executeUpdate();
			
			if(unetiPodatak > 0 ) {
				System.out.println("Podatak je upisan.");
			}
			
String sqlinsert2 = "INSERT INTO biblioteke(bibliotekaID, naziv, ulica, broj, grad, telefon)VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps2 = conn.prepareStatement(sqlinsert2);
			ps2.setString(1, "4");
			ps2.setString(2, "Vladislav Petkovic Dis");
			ps2.setString(3, "Sindjeliceva");
			ps2.setString(4, "24");
			ps2.setString(5, "Cacak");
			ps2.setString(6, "+381 (0)32 340-960");
			
			int unetiPodatak2 = ps2.executeUpdate();
			
			if(unetiPodatak2 > 0 ) {
				System.out.println("Podatak je upisan.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
