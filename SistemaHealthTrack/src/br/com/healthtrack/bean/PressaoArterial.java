package br.com.healthtrack.bean;

import java.util.Calendar;

public class PressaoArterial {
	private int id;
	private Calendar data;
	private int sistoticaMaior;
	private int diastoticaMenor;
	private String observacao;
	
	public PressaoArterial() {
		super();
	}
	
	public PressaoArterial(int id, Calendar data, int sistoticaMaior, int diastoticaMenor, String observacao) {
		super();
		this.id = id;
		this.data = data;
		this.sistoticaMaior = sistoticaMaior;
		this.diastoticaMenor = diastoticaMenor;
		this.observacao = observacao;
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
	
	public int getSistoticaMaior() {
		return sistoticaMaior;
	}
	
	public void setSistoticaMaior(int sistoticaMaior) {
		this.sistoticaMaior = sistoticaMaior;
	}
	
	public int getDiastoticaMenor() {
		return diastoticaMenor;
	}

	public void setDiastoticaMenor(int diastoticaMenor) {
		this.diastoticaMenor = diastoticaMenor;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
