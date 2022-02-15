package br.com.caelum.ed.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Array;

public class TesteAdicionaPorPosicao {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();

		a1.setNome("Flavio");
		a2.setNome("Inez");
		a3.setNome("Aninha");

		Array lista = new Array();
		/*
		 * lista.adicionaAluno(a1); lista.adicionaAluno(a2); lista.adicionaAluno(a2);
		 */

		System.out.println("Adicionando por Posição");
		lista.adicionaAluno(0, a3);
		lista.adicionaAluno(1, a1);
		lista.adicionaAluno(2, a2);

		System.out.println(lista);

	}

}
