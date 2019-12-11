package net.esprit.rh.domain;



import javax.persistence.*;

@Entity
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

   

    public Competence() {
    }
    
	public Competence(String libelle) {
		super();
		this.libelle = libelle;
		

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

		 
}