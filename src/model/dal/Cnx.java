package model.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bo.Personne;

public class Cnx {
	private static String database;
	private static String url;
	private static String user;
	private static String psw;
	
	
	public static Connection mysql() {
		database = "liste_personne";
		url ="jdbc:mysql://localhost:3306/"; // 8889
		url+=database;url+="?autoReconnect=true&useSSL=false";
		user = "root";
		psw = "";
		Connection cnx = null;
			try{
				cnx = DriverManager.getConnection(url, user, psw);
				cnx.setAutoCommit(false);
			}catch(SQLException e)
			{
			e.printStackTrace();
		}
			return cnx;
	}

	
	public static void deco(Connection c) {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
	public void sqlserver() {
		database = "liste_personne";
		url ="jdbc:mysql://localhost:3306/"; // 8889
		url+=database;url+="?autoReconnect=true&useSSL=false";
		user = "root";
		psw = "";
		Connection cnx = null;
			try{
				cnx = (Connection) DriverManager.getConnection(url, user, psw);
				((java.sql.Connection) cnx).setAutoCommit(false);
			}catch(SQLException e)
			{
			e.printStackTrace();
		}
	}

}
