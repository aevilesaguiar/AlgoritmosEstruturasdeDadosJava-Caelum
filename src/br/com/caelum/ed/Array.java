package br.com.caelum.ed;

import java.util.Arrays;
import java.util.Objects;

public class Array {

	private Aluno[] alunos = new Aluno[100];

	private int totalDeAlunos = 0;

	// adiciona Aluno fim da lista
	public void adicionaAluno(Aluno aluno) {
		/*
		 * Com esse método o consumo de tempo é muito alto , pois ele precisa rodar
		 * todas as vezes até achar a primeira posição vazia for (int i = 0; i <
		 * this.alunos.length; i++) { if(this.alunos[i]==null) { this.alunos[i]=aluno;
		 * break; } }
		 */

		// Agora, o consumo de tempo do método é sempre o mesmo não importa
		// quantos alunos estejam armazenados.Neste caso, dizemos que o consumo é
		// constante.
		this.alunos[this.totalDeAlunos] = aluno;
		totalDeAlunos++;

	}

	// adiciona aluno em uma determinada posição
	public void adicionaAluno(int posicao, Aluno aluno) {

		if ((!this.posicaoValidaAluno(posicao))) {
			throw new IllegalArgumentException("Posição inválida");

		}
		for (int i = this.totalDeAlunos - 1; i >= posicao; i--) {
			this.alunos[i + 1] = this.alunos[i];
		}

		this.alunos[posicao] = aluno;
		this.totalDeAlunos++;

	}

	public Aluno pegaAluno(int posicao) {

		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}

		return (Aluno) this.alunos[posicao];
	}

	public int removeAluno(int posicao) {
		return posicao;
	}

	public boolean contemAluno(Aluno aluno) {

		/*
		 * método é ineficiente quando a Lista tem poucos elementos. Perceba que ele
		 * sempre percorre o array todo. Não é necessário percorrer o array inteiro
		 * basta percorrer as posições ocupadas,ou seja, o laço.tem que ir até a última
		 * posição ocupada. Nós podemos obter a última posição ocupada através do
		 * atributo totalDeAlunos. Nós estamos comparando os alunos com o operador ==.
		 * Este operador compara o conteúdo das variáveis. No Java, as variáveis de
		 * tipos não primitivos, como o tipo Aluno, guardam referências para objetos.
		 * Então, na verdade, estamos comparando a referências e não os objetos
		 * propriamente. Para comparar objetos devemos usar o método equals(Object).
		 * Lembrando que reescrevemos este método para considerar que dois objetos do
		 * tipo Aluno são iguais quando os seus atributos nome são iguais.
		 * 
		 * for (int i = 0; i < this.alunos.length; i++) { if(aluno==this.alunos[i]) {
		 * return true; }
		 */

		for (int i = 0; i < this.totalDeAlunos; i++) {
			if (aluno.equals(this.alunos[i])) {
				return true;
			}
		}
		return false;

	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeAlunos;
	}

	public int totalAluno() {
		return this.totalDeAlunos;

	}

	private boolean posicaoValidaAluno(int posicao) {

		return posicao >= 0 && posicao <= this.totalDeAlunos;

	}

	@Override
	public String toString() {
		if (this.totalDeAlunos == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < this.totalDeAlunos - 1; i++) {
			builder.append(this.alunos[i]);
			builder.append(", ");
		}
		builder.append(this.alunos[this.totalDeAlunos - 1]);
		builder.append("]");
		return builder.toString();
	}

	//// compara dois objetos do tipo Aluno
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(alunos);
		result = prime * result + Objects.hash(totalDeAlunos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Array other = (Array) obj;
		return Arrays.deepEquals(alunos, other.alunos) && totalDeAlunos == other.totalDeAlunos;
	}

}
