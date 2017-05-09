package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public List<Country> loadAllCountries() {

		String sql = "SELECT ccode,StateAbb,StateNme " + "FROM country " + "ORDER BY StateAbb ";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			List<Country> nazioni = new ArrayList <Country>();

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Country c = new Country( rs.getInt("ccode"),rs.getString("StateAbb"));
				c.setNome( rs.getString("StateNme"));
				nazioni.add(c);
				// provo a stampare
				System.out.format("%d %s %s\n", rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme"));
			}

			conn.close();
			return nazioni;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
	}

	public List<Border> getCountryPairs(int anno) {
		
		String sql = "SELECT * "+
					"FROM contiguity "+
					"WHERE year <= ? AND conttype = 1";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,anno);
			
			List <Border> confini = new ArrayList <Border>();
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Country c1 = new Country( rs.getInt("state1no"),rs.getString("state1ab"));
				Country c2 = new Country( rs.getInt("state2no"),rs.getString("state2ab"));
				Border b = new Border(c1, c2, rs.getInt("year"), rs.getInt("dyad"));
				confini.add(b);
				
				//provo a stampare
				//System.out.format("%d %s %s\n", rs.getInt("ccode"), rs.getString("StateAbb"), rs.getString("StateNme"));
			}

			conn.close();
			return confini;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadCountryPairs");
			throw new RuntimeException("Database Error");
		}
		
	}
}
