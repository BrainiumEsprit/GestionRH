package net.esprit.rh.domain;




import javax.persistence.*;

@Entity
public class Matrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "compid", nullable = false)
    private String compid;

    @Column(name = "ne1", nullable = false)
    private int c1;

    @Column(name = "ne2", nullable = false)
    private int c2;
    
    @Column(name = "ne3", nullable = false)
    private int c3;
    @Column(name = "ne4", nullable = false)
    private int c4;
  
    public Matrice() {
    }
    
	public Matrice(String libelle, int c1, int c2 , int c3, int c4) {
		super();
		this.compid = libelle;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		this.c4 = c4;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompid() {
		return compid;
	}

	public void setCompid(String emp) {
		this.compid = emp;
	}

	public int getC1() {
		return c1;
	}
	
	public void setC1(int c1) {
		this.c1 = c1;
	}
	public int getC2() {
		return c2;
	}
	
	public void setC2(int c2) {
		this.c2 = c2;
	}
	public int getC3() {
		return c3;
	}
	
	public void setC3(int c3) {
		this.c3 = c3;
	}
	public int getC4() {
		return c4;
	}
	
	public void setC4(int c4) {
		this.c4 = c4;
	}


	
	
		 
}