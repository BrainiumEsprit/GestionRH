package net.esprit.rh.domain;

import java.sql.Date;

import javax.persistence.*;



@Entity
public class conje {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;	 
    
    @Column(name = "date_d")   	
	private Date date_d;
    
    @Column(name = "date_f")	
	private Date date_f ;
    
	@Column(name = "id_emp")
    private Long mat_emp;   
    
    public conje() {
    }
   
    
    public conje(Long mat_emp) {
		super();
		this.mat_emp = mat_emp;
	}
	public conje(Date date_d , Date date_f,Long mat_emp) {
		super();
		this.date_d = date_d;
		this.date_f = date_f;
		this.mat_emp = mat_emp;
	}

	public Long getMat_emp() {
		return mat_emp;
	}

	public void setMat_emp(Long mat_emp) {
		this.mat_emp = mat_emp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate_d() {
		return date_d;
	}

	public void setDate_d(Date date_d) {
		this.date_d = date_d;
	}

	public Date getDate_f() {
		return date_f;
	}

	public void setDate_f(Date date_f) {
		this.date_f = date_f;
	}

	

}
