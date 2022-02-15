package br.com.caelum.ed;

import java.util.Objects;

public class Aluno {

	private String nome;

	public Aluno( ) {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + "]";
	}

	



}
