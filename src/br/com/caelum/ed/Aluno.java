package br.com.caelum.ed;

import java.util.Objects;

public class Aluno {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//imprime os objetos na tela
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + "]";
	}

	////compara dois objetos do tipo Aluno
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(nome, other.nome);
	}
	
	
	

}
