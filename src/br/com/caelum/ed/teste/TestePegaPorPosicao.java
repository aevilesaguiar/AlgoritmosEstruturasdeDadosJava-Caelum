package br.com.caelum.ed.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Array;

public class TestePegaPorPosicao {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();

		a1.setNome("Flavio");
		a2.setNome("Inez");
		a3.setNome("Aninha");

		Array lista = new Array();

		lista.adicionaAluno(a1);
		lista.adicionaAluno(a2);
		lista.adicionaAluno(a3);

		Aluno aluno1 = (Aluno) lista.pegaAluno(0);
		Aluno aluno2 = (Aluno) lista.pegaAluno(1);

		System.out.println(aluno1);
		System.out.println(aluno2);

	}

}
