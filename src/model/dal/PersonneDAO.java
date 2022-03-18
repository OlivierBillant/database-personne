package model.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import model.bo.Personne;

public class PersonneDAO {
	public List<Personne> selectAll() {
		Connection cnx = Cnx.mysql();
		List<Personne> personnes = new ArrayList<Personne>();
		String sql = "SELECT * from listing";
		try {
			// je demande d'avoir le nom des colonnes
			Statement state = cnx.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			// j excecute ma query
			ResultSet result = state.executeQuery(sql);
			//tant qu'il y a des lignes ds la pile : je boucle
		
			while(result.next()) {
				// j'exploite la ligne extraite pas result.next
				Personne p = new Personne();
				p.setId(result.getInt("id"));
				p.setNom(result.getString("nom"));
				p.setPrenom(result.getString("prenom"));
				personnes.add(p);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		Cnx.deco(cnx);
		return personnes;
	}
	
	public Personne selectOne(int index) {
		Connection cnx = Cnx.mysql();
		Personne p = new Personne();		
		String sql = "SELECT * from listing WHERE id = "+index;
		try {
			Statement state = cnx.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = state.executeQuery(sql);
		
			while(result.next()) {
				p.setId(result.getInt("id"));
				p.setNom(result.getString("nom"));
				p.setPrenom(result.getString("prenom"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		Cnx.deco(cnx);
		return p;
	}
	
	public void insert(Personne p) {
		Connection cnx = Cnx.mysql();
		String sqlPrepared = "INSERT INTO `listing` (`id`, `nom`, `prenom`) VALUES (NULL, ?, ?)";
		//Statement : 
		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, p.getPrenom());
			pStmt.setString(2, p.getNom());
			pStmt.executeUpdate();
			ResultSet resultset = pStmt.getGeneratedKeys();
			resultset.next();
			p.setId(resultset.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Cnx.deco(cnx);
	}
	
	public void update(Personne p) {
		Connection cnx = Cnx.mysql();
		String sqlPrepared = "UPDATE `listing` SET `prenom` = ? WHERE id = ?";
		//Statement : 
		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, "Kenobi?");
			pStmt.setInt(2, p.getId());
			pStmt.executeUpdate();
			ResultSet resultset = pStmt.getGeneratedKeys();
			resultset.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Cnx.deco(cnx);
	}
	
	public void delete(Personne p) {
		Connection cnx = Cnx.mysql();
		String sqlPrepared = "DELETE FROM `listing` WHERE `listing`.`id` = ?";
		//Statement : 
		try {
			PreparedStatement pStmt = cnx.prepareStatement(sqlPrepared, Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, p.getId());
			pStmt.executeUpdate();
			ResultSet resultset = pStmt.getGeneratedKeys();
			resultset.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Cnx.deco(cnx);
	}
	 
	
}
