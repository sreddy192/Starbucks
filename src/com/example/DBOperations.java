package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class DBOperations {
	Connection con = null;
	boolean test = false;
	Menu s;

	public DBOperations() {
		test = connection();
	}

	public boolean connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystarbucks?useSSL=false", "root",
					"Shreya1994");

		} catch (Exception e2) {
			System.out.println(e2);
			return false;
		}

		return true;
	}

	public boolean insertion(Menu s) {
		try {
			if (test) {
				String exp = "insert into menu (item,price) values(?,?)";
				PreparedStatement ps = con.prepareStatement(exp);
				ps.setString(1, s.getItem());
				ps.setString(2, s.getPrice());

				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			return false;
		}
	}

	public boolean update(Menu s) {
		try {
			if (test) {
				String exp = "UPDATE menu SET price = ? WHERE item = ?";
				PreparedStatement ps = con.prepareStatement(exp);
				ps.setString(2, s.getItem());
				ps.setString(1, s.getPrice());
				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return false;
		}
	}

	public boolean delete(Menu s) {
		try {
			if (test) {
				String exp = "DELETE FROM menu WHERE price= ?";
				PreparedStatement ps = con.prepareStatement(exp);
				ps.setString(1, s.getPrice());
				int i = ps.executeUpdate();
				if (i > 0)
					return true;
				else
					return false;
			}
			return false;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return false;
		}
	}

	public Menu find(String item) {
		Statement stmt = null;
		try {
			if (test) {
				s = new Menu();
				stmt = (Statement) con.createStatement();
				String price = null;
				String exp = "select * from menu WHERE item =\"" + item + "\"";

				ResultSet rs = stmt.executeQuery(exp);
				while (rs.next()) {
					s.setItem(rs.getString("item"));
					s.setPrice(rs.getString("price"));
				}
				return s;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}

	public String display() {
		Statement stmt = null;
		String result = "";
		try {
			if (test) {
				s = new Menu();
				stmt = (Statement) con.createStatement();
				String exp = "select item, price from menu";
				ResultSet rs = stmt.executeQuery(exp);

				while (rs.next()) {
					result += rs.getString("item") + " ";
					result += rs.getString("price") + "<br>";
				}
				return result;
			}
			return null;
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
			return null;
		}
	}
}
