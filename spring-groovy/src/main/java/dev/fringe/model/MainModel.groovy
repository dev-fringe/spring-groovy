package dev.fringe.model

<<<<<<< HEAD
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
class MainModel {
	@Id
	private String model
	private String type
	
=======
class MainModel {
	String model
	String type
	
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


>>>>>>> branch 'master' of https://github.com/dev-fringe/spring-groovy.git
	public String toString() {
		return "Car [model=" + model + ", type=" + type + "]";
	}
	
}
