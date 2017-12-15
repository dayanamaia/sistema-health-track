package br.com.healthtrack.bean;

import java.util.Calendar;

public class CategoriaAlimentacao {
	private int id;
	private Calendar data;
	private String nome;
	
	public CategoriaAlimentacao() {
		super();
	}
	
	public CategoriaAlimentacao(int id, Calendar data,  String nome) {
		super();
		this.id = id;
		this.data = data;
		this.nome = nome;
	}
	
	public CategoriaAlimentacao(int id,  String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
