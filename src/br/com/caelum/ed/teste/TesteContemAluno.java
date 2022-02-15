package br.com.caelum.ed.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Array;

public class TesteContemAluno {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		Aluno a4 = new Aluno();

		a1.setNome("Flavio");
		a2.setNome("Inez");
		a3.setNome("Aninha");
		
		Array lista = new Array();
		
		lista.adicionaAluno(a1);
		lista.adicionaAluno(a2);
		lista.adicionaAluno(a3);

		
		System.out.println(lista.contemAluno(a1));
		
		System.out.println(lista.contemAluno(a2));
		
		Aluno aluno = new Aluno();
		aluno.setNome("Ana");
		
		System.out.println(lista.contemAluno(a4));
		
		

	}

}
