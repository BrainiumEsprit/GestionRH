package net.esprit.rh.domain;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;	 
    
    @Column(name = "fullname")   	
	private String fullname;
    
    @Column(name = "cin")	
	private int cin ;
    
    @Column(name = "mat")
	private String mat;    
    
    @Column(name = "email")	
    private String email; 
    
	@Column(name = "tel")	
    private int tel  ;
    
	@Column(name = "sal")	
    private int sal ;
   
    
	@Column(name = "dateemb")	
    private Date dateemb ;
    
	//private Set<Course> courses = new HashSet<Course>(0);    
    
    public Employee() {
    }

	public Employee(String fullname, int cin, String mat, String email,int tel ,int sal,Date dateemb) {
		super();
		this.fullname = fullname;
		this.cin = cin;
		this.mat = mat;
		this.email = email;
		this.tel = tel;
		this.sal = sal;
		
		this.dateemb = dateemb;
	}

   	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setfullname(String fullname) {
		this.fullname = fullname;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	 public int getTel() {
			return tel;
		}
	 
	public void setTel(int tel) {
			this.tel = tel;
		}
	public int getSal() {
				return sal;
			}

	public void setSal(int sal) {
				this.sal = sal;
			}

	public Date getDateemb() {
		return dateemb;
	}
	
	public void setDateemb(Date dateemb) {
		this.dateemb = dateemb;
	}

}
