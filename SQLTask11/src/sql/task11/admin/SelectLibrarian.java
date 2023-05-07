package sql.task11.admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectLibrarian {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/bazabib";
		String username = "adminBib";
		String password = "adminPassword";
		
		System.out.println("Povezivanje sa bazom...");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			System.out.println("Uspesna konekcija sa bazom.");
			
			String sqlselect = "SELECT * FROM bibliotekari";
			
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sqlselect);
			
			while(result.next()) {
				String sifraZaposlenog = result.getString(1);
				String ime = result.getString(2);
				String prezime = result.getString(3);
				String ulica = result.getString(4);
				String broj = result.getString(5);
				String grad = result.getString(6);
				String jmbg = result.getString(7);
				String telefon = result.getString(8);
				String bibID = result.getString(9);
				
				StringBuilder builder = new StringBuilder();
				builder.append("\nŠifra zaposlenog: ");
				builder.append(sifraZaposlenog);
				builder.append("\nIme bibliotekara: ");
				builder.append(ime+" "+prezime);
				builder.append("\nAdresa: ");
				builder.append(ulica+" "+broj+", "+grad);
				builder.append("\nJMBG: ");
				builder.append(jmbg);
				builder.append("\nTelefon: ");
				builder.append(telefon);
				builder.append("\nID biblioteke: ");
				builder.append(bibID);
				
				System.out.println(builder.toString());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
