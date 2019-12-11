package net.esprit.rh.domain;

import javax.persistence.*;

@Entity
public class Indemnite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_indem", nullable = false, updatable = false)
    private Long id;

    // Username with unique constraint
    @Column(name = "code_indem", nullable = false, unique = true)
    private String codeindem;

    @Column(name = "lib_indem", nullable = false)
    private String libindem;

    @Column(name = "soumis_impot", nullable = false)
    private int soumis;
    @Column(name = "compte", nullable = false)
    private String compte;

    public Indemnite() {
    }
    
	public Indemnite(String codeindem, String libindem, int soumis, String compte) {
		super();
		this.codeindem = codeindem;
		this.libindem = libindem;
		this.soumis = soumis;
		this.compte = compte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeindem()
	{
		return codeindem;
	}
	public void setCodeindem(String codeindem) {
		this.codeindem = codeindem;
	}
	public String getLibindem() {
		return libindem;
	}
	public void setLibindem(String libindem) {
		this.libindem = libindem;
	}
	public int getSoumis() {
		return soumis;
	}
	public void setSoumis(int soumis) {
		this.soumis = soumis;
	}
	public String getCompte() {
		return compte;
	}
	public void setCompte(String compte) {
		this.compte = compte;
	}

}