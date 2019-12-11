package net.esprit.rh.domain;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ab", nullable = false, updatable = false)
    private Long id_ab;

    // Username with unique constraint
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "nbj", nullable = false)
    private Long nbj;
    @Column(name = "motif", nullable = false)
    private String motif;
    @Column(name = "email", nullable = false)
    private String email;
    

    public Absence() {
    }


	public Absence(Long id_ab, String nom, String prenom, Date date, Long nbj, String motif, String email) {
		super();
		this.id_ab = id_ab;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.nbj = nbj;
		this.motif = motif;
		this.email = email;
	}


	public Long getId_ab() {
		return id_ab;
	}


	public void setId_ab(Long id_ab) {
		this.id_ab = id_ab;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Long getNbj() {
		return nbj;
	}


	public void setNbj(Long nbj) {
		this.nbj = nbj;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
  
	

}