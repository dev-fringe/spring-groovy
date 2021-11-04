package dev.fringe.model

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


	public String toString() {
		return "Car [model=" + model + ", type=" + type + "]";
	}
	
}
