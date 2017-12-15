package br.com.healthtrack.bean;

import java.util.Calendar;

public class Peso {
	private int id;
	private Calendar data;
	private double peso;
	
	public Peso() {
		super();
	}
	
	public Peso(int id, Calendar data, double peso) {
		super();
		this.id = id;
		this.data = data;
		this.peso = peso;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
}