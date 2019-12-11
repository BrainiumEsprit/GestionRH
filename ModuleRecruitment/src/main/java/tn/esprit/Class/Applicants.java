package tn.esprit.Class;




import javax.persistence.*;

@Entity
public class Applicants {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
	private Long id ;
    
    @Column(name = "name", nullable = true)
	private String name;
    
    @Column(name = "lastname", nullable = true)
	private String lastname;
    
    @Column(name = "email", nullable = true)
	private String email;
    
    @Column(name = "degree", nullable = true)
	private String degree;
    
    @Column(name = "job", nullable = true)
  	private String job;
    
    @Column(name = "cv", nullable = true)
   	private String cv;
    
    @Column(name = "motivation", nullable = true)
   	private String motivation;
    
  
    
    public Applicants() {}



	public Applicants(Long id, String name, String lastname, String email, String degree, String job, String cv,
			String motivation) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.degree = degree;
		this.job = job;
		this.cv = cv;
		this.motivation = motivation;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDegree() {
		return degree;
	}



	public void setDegree(String degree) {
		this.degree = degree;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getCv() {
		return cv;
	}



	public void setCv(String cv) {
		this.cv = cv;
	}



	public String getMotivation() {
		return motivation;
	}



	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}






    
    
    
}    
	
    
   
	