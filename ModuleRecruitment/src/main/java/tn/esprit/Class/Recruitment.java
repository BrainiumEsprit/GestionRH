package tn.esprit.Class;




import javax.persistence.*;

@Entity
public class Recruitment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref", nullable = false, updatable = false)
	private Long ref ;
    
    @Column(name = "post", nullable = true)
	private String post;
    
    @Column(name = "requiredskills", nullable = true)
	private String requiredskills;
    
    @Column(name = "description", nullable = true)
	private String description;
    
    @Column(name = "salary", nullable = true)
	private int salary;
    
    
    
    public Recruitment() {}



	public Recruitment(Long ref, String post, String requiredskills, String description, int salary) {
		super();
		this.ref = ref;
		this.post = post;
		this.requiredskills = requiredskills;
		this.description = description;
		this.salary = salary;
	}



	public Long getRef() {
		return ref;
	}



	public void setRef(Long ref) {
		this.ref = ref;
	}



	public String getPost() {
		return post;
	}



	public void setPost(String post) {
		this.post = post;
	}



	public String getRequiredskills() {
		return requiredskills;
	}



	public void setRequiredskills(String requiredskills) {
		this.requiredskills = requiredskills;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}
    
    

	
	
    
   
	

	
	
		 
}