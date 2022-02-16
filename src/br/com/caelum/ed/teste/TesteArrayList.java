package br.com.caelum.ed.teste;

import java.util.ArrayList;

import br.com.caelum.ed.Aluno;

public class TesteArrayList {

	public static void main(String[] args) {
		//ArrayList vetor = new ArrayList();
		ArrayList<Aluno> vetor = new ArrayList<Aluno>();

		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		Aluno aluno3 = new Aluno();
		Aluno aluno4 = new Aluno();
		
		vetor.add(aluno1);
		vetor.add(aluno2);
		vetor.add(0, aluno3);
		
		int tamanho = vetor.size();
		System.out.println(tamanho);
		
		if (tamanho != 3) {
			System.out.println("Erro: O tamanho da lista está errado.");
		}
		if (!vetor.contains(aluno1)) {
			System.out.println("Erro: Não achou um aluno que deveria estar na lista");

		}
		vetor.remove(2);
		tamanho = vetor.size();
		System.out.println(tamanho);
		if (tamanho != 2) {
			System.out.println("Erro: O tamanho da lista está errado.");
		}
		if (vetor.contains(aluno4)) {
			System.out.println("Erro: Achou um aluno que não deveria estar na lista");

		}
	}

}
