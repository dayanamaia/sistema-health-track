package br.com.healthtrack.bean;

import java.util.Calendar;
import br.com.healthtrack.util.CriptografiaUtils;

public class Usuario {
	private int id;
	private String nome;
	private Calendar dataNascimento;
	private char genero;
	private int altura;
	private String email;
	private String senha;
	private int status = 1;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int id, String nome, Calendar dataNascimento, char genero, int altura, String email, String senha, int status) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.altura = altura;
		this.email = email;
		setSenha(senha);
		this.status = status;
	}
	
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		setSenha(senha);
	}
	
	public Usuario(int id, String nome, int altura) {
		super();
		this.id = id;
		this.nome = nome;
		this.altura = altura;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int setStatus(){
		return status;
	}
	
	public void getStatus(int status) {
		this.status = status;
	}
}
