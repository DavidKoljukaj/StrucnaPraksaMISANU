package sql.task11.librarian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBook {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/bazabib";
		String username = "librarianOne";
		String password = "libOnePass";
		
		System.out.println("Povezivanje...");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			System.out.println("Uspešno povezivanje sa bazom.");
			
			String sqlinsert = "INSERT INTO knjige(ISBN,naziv,jezik,izdavac,bibliotekaID,stanje)VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sqlinsert);
			ps.setString(1, "9789811976766");
			ps.setString(2, "A Society 5.0 Perspective");
			ps.setString(3, "Engleski");
			ps.setString(4, "Springer Singapore");
			ps.setString(5, "4");
			ps.setString(6, "2");
			
			int unetiPodatak = ps.executeUpdate();
			
			if(unetiPodatak > 0 ) {
				System.out.println("Nova knjiga je dodata u inventar.");
			}
String sqlinsertAutor = "INSERT INTO autori(autorID,ime,prezime,ISBN)VALUES(?,?,?,?)";
			
			PreparedStatement psAutor = conn.prepareStatement(sqlinsertAutor);
			psAutor.setString(1, "7");
			psAutor.setString(2, " Lazar");
			psAutor.setString(3, "Z. Velimirović");
			psAutor.setString(4, "9789811976766");
			
			
			int unetiPodatak2 = psAutor.executeUpdate();
			
			if(unetiPodatak2 > 0 ) {
				System.out.println("Podaci o autoru su uspešno uneti.");
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
	}}

	
