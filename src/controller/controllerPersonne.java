package controller;

import java.util.List;
import model.bo.Personne;
import model.dal.Cnx;
import model.dal.PersonneDAO;

public class controllerPersonne {

	public static void main(String[] args) {
		//Récupérer la liste des personnes
		PersonneDAO personneDao = new PersonneDAO();
		List<Personne> personnes = personneDao.selectAll();
		for(Personne p : personnes) {
			System.out.println(p);
		}
		System.out.println("");
		
//		Ajouter une personne à la db
		Personne p = new Personne();
		p.setPrenom("Wat");
		p.setNom("Tambor");
		personneDao.insert(p);
		
		//Affiche liste à jour
		personnes = personneDao.selectAll();
		for(Personne ptemp : personnes) {
			System.out.println(ptemp);
		}
		
		System.out.println("");

		//Récupère 1 personne via index
		Personne p2 = personneDao.selectOne(24);
		System.out.println(p2);	
		//Update de la personne
		personneDao.update(p2);
		
		System.out.println("");

		//Affiche liste à jour
		personnes = personneDao.selectAll();
			for(Personne ptemp : personnes) {
				System.out.println(ptemp);
			}
		
	
		//Update de la personne
		personneDao.delete(p);;
		
		System.out.println("");

		//Affiche liste à jour
				personnes = personneDao.selectAll();
				for(Personne ptemp : personnes) {
					System.out.println(ptemp);
				}	
		}
	
	}
