package br.com.healthtrack.bean;

import java.util.Calendar;

public class Colesterol {
	private int id;
	private Calendar data;
	private int colesterolTotal;
	private int triglicerides;
	private int ldl;
	private int hdl;
	private String observacao;
	
	public Colesterol() {
		super();
	}
	
	public Colesterol(int id, Calendar data, int colesterolTotal, int triglicerides, int ldl, int hdl, String observacao) {
		super();
		this.id = id;
		this.data = data;
		this.colesterolTotal = colesterolTotal;
		this.triglicerides = triglicerides;
		this.ldl = ldl;
		this.hdl = hdl;
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
	
	public int getColesterolTotal() {
		return colesterolTotal;
	}
	
	public void setColesterolTotal(int colesterolTotal) {
		this.colesterolTotal = colesterolTotal;
	}
	
	public int getTriglicerides() {
		return triglicerides;
	}
	
	public void setTriglicerides(int triglicerides) {
		this.triglicerides = triglicerides;
	}
	
	public int getLdl() {
		return ldl;
	}
	
	public void setLdl(int ldl) {
		this.id = ldl;
	}
	
	public int getHdl() {
		return hdl;
	}
	
	public void setHdl(int hdl) {
		this.hdl = id;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
