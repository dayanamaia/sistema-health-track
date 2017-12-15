package br.com.healthtrack.teste;

import br.com.healthtrack.util.CriptografiaUtils;

public class CriptografiaTeste {
	public static void main(String[] args) {
		try{
			System.out.println(CriptografiaUtils.criptografar("senha123"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
