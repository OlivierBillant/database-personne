package controller;

import java.util.List;
import model.bo.Personne;
import model.dal.Cnx;
import model.dal.PersonneDAO;

public class controllerPersonne {

	public static void main(String[] args) {
		//R�cup�rer la liste des personnes
		PersonneDAO personneDao = new PersonneDAO();
		List<Personne> personnes = personneDao.selectAll();
		for(Personne p : personnes) {
			System.out.println(p);
		}
		System.out.println("");
		
//		Ajouter une personne � la db
		Personne p = new Personne();
		p.setPrenom("Wat");
		p.setNom("Tambor");
		personneDao.insert(p);
		
		//Affiche liste � jour
		List<Personne> personnes1 = personneDao.selectAll();
		for(Personne p1 : personnes1) {
			System.out.println(p1);
		}
		
		System.out.println("");

		//R�cup�re 1 personne via index
		Personne p2 = personneDao.selectOne(24);
		System.out.println(p2);	
		//Update de la personne
		personneDao.update(p2);
		
		System.out.println("");

		List<Personne> personnes2 = personneDao.selectAll();
		for(Personne p3 : personnes2) {
			System.out.println(p3);
		}
		
	
		//Update de la personne
		personneDao.delete(p);;
		
		System.out.println("");

		List<Personne> personnes3 = personneDao.selectAll();
		for(Personne p5 : personnes3) {
			System.out.println(p5);
		}		
		}
	
	}
