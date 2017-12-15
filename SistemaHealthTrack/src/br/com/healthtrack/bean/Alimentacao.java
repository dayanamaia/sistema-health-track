package br.com.healthtrack.bean;

import java.util.Calendar;

public class Alimentacao {
	private int id;
	private Calendar data;
	private String nome;
	private int quantidade;
	private int calorias;
	private CategoriaAlimentacao categoriaAlimentacao;
	
	public Alimentacao() {
		super();
	}
	
	public Alimentacao(int id, Calendar data, String nome, int quantidade, int calorias) {
		super();
		this.id = id;
		this.data = data;
		this.nome = nome;
		this.quantidade = quantidade;
		this.calorias = calorias;
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getCalorias() {
		return calorias;
	}
	
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public CategoriaAlimentacao getCategoriaAlimentacao() {
		return categoriaAlimentacao;
	}

	public void setCategoriaAlimentacao(CategoriaAlimentacao categoriaAlimentacao) {
	    this.categoriaAlimentacao = categoriaAlimentacao;
	}
}
