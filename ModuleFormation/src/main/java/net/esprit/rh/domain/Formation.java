package net.esprit.rh.domain;


import java.sql.Date;

import javax.persistence.*;

@Entity
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "libformation", nullable = false)
    private String libelle;

    @Column(name = "dateformation", nullable = false)
    private Date dateF;

    @Column(name = "nbjformation", nullable = false)
    private int nbjours;
    
    @Column(name = "nbpformation", nullable = false)
    private int nbplaces;

    public Formation() {
    }
    
	public Formation(String libelle, Date date, int nbj , int nbp) {
		super();
		this.libelle = libelle;
		this.dateF = date;
		this.nbjours = nbj;
		this.nbplaces = nbp;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateF() {
		return dateF;
	}
	
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	public int getNbjours() {
		return nbjours;
	}

	public void setNbjours(int nbjours) {
		this.nbjours = nbjours;
	}
	
	public int getNbplaces() {
		return nbplaces;
	}

	public void setNbplaces(int nbplaces) {
		this.nbplaces = nbplaces;
	}
		 
}