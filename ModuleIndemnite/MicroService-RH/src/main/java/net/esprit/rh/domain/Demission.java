package net.esprit.rh.domain;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Demission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dem", nullable = false, updatable = false)
    private Long id_dem;

    // Username with unique constraint
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;
    @Column(name = "motif", nullable = false)
    private String motif;

    @Column(name = "date_depart", nullable = false)
    private Date date_depart;
    
    
    
    

    public Demission() {
    }





	public Demission(Long id_dem, String nom, String prenom, String motif, Date date_depart) {
		super();
		this.id_dem = id_dem;
		this.nom = nom;
		this.prenom = prenom;
		this.motif = motif;
		this.date_depart = date_depart;
	}





	public Long getId_dem() {
		return id_dem;
	}





	public void setId_dem(Long id_dem) {
		this.id_dem = id_dem;
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





	public String getMotif() {
		return motif;
	}





	public void setMotif(String motif) {
		this.motif = motif;
	}





	public Date getDate_depart() {
		return date_depart;
	}





	public void setDate_depart(Date date_depart) {
		this.date_depart = date_depart;
	}


	

}