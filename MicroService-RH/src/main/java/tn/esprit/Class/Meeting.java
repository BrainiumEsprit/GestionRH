package tn.esprit.Class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meeting {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref", nullable = false, updatable = false)
	private Long ref ;
    
    @Column(name = "app", nullable = true)
	private Long app;
    
    @Column(name = "employee", nullable = true)
	private Long employee;
    
    @Column(name = "date", nullable = true)
	private String date;

    public Meeting() {}
    public Meeting( Long app, Long employee) {
		super();
		
		this.app = app;
		this.employee = employee;
		
	}
	public Meeting(Long ref, Long app, Long employee, String date) {
		super();
		this.ref = ref;
		this.app = app;
		this.employee = employee;
		this.date = date;
	}
	
	public Long getRef() {
		return ref;
	}

	public void setRef(Long ref) {
		this.ref = ref;
	}

	public Long getApp() {
		return app;
	}

	public void setApp(Long app) {
		this.app = app;
	}

	public Long getEmployee() {
		return employee;
	}

	public void setEmployee(Long employee) {
		this.employee = employee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	


	
    
    
}
