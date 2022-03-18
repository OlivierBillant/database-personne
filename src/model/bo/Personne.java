package model.bo;

public class Personne {
	private int id;
	private String nom;
	private String prenom;
	
	public Personne(int id, String nom, String prenom) {
		super();
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	public Personne() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	@Override
	public String toString() {
		return id +" "+ nom +" "+ prenom;
	}
	
	
	
}
