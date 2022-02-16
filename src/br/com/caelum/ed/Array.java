package br.com.caelum.ed;

import java.util.Arrays;
import java.util.Objects;

public class Array {

	//Em vez de colocarmos um array de Aluno na classe Vetor vamos colocar um array de Object.
	//assim estamos generalizando a nossa estrutura de dados.
	//Desta forma, poderemos armazenar qualquer tipo de objeto.
	
	//private Aluno[] alunos = new Aluno[100];
	private Object[] objetos = new Object[100];

	
	//private int totalDeAlunos = 0;
	private int totalDeObjetos = 0;

	// adiciona Aluno fim da lista
	public void adicionaAluno(Object aluno) {

		this.garantaEspaco();
		/*
		 * Com esse método o consumo de tempo é muito alto , pois ele precisa rodar
		 * todas as vezes até achar a primeira posição vazia for (int i = 0; i <
		 * this.alunos.length; i++) { if(this.alunos[i]==null) { this.alunos[i]=aluno;
		 * break; } }
		 */

		// Agora, o consumo de tempo do método é sempre o mesmo não importa
		// quantos alunos estejam armazenados.Neste caso, dizemos que o consumo é
		// constante.
		this.objetos[this.totalDeObjetos] = aluno;
		totalDeObjetos++;

	}

	// adiciona aluno em uma determinada posição
	public void adicionaAluno(int posicao, Object aluno) {
		this.garantaEspaco();

		if ((!this.posicaoValidaAluno(posicao))) {
			throw new IllegalArgumentException("Posição inválida");

		}
		for (int i = this.totalDeObjetos - 1; i >= posicao; i--) {
			this.objetos[i + 1] = this.objetos[i];
		}

		this.objetos[posicao] = aluno;
		this.totalDeObjetos++;

	}

	public Object pegaAluno(int posicao) {

		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}

		return this.objetos[posicao];
	}

	public void removeAluno(int posicao) {

		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}

		for (int i = posicao; i < this.totalDeObjetos - 1; i++) {
			this.objetos[i] = this.objetos[i + 1];
		}

		this.totalDeObjetos--;

	}

	public boolean contemAluno(Object aluno) {

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

		for (int i = 0; i < this.totalDeObjetos; i++) {
			if (aluno.equals(this.objetos[i])) {
				return true;
			}
		}
		return false;

	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeObjetos;
	}

	public int totalAluno() {
		return this.totalDeObjetos;

	}

	private boolean posicaoValidaAluno(int posicao) {

		return posicao >= 0 && posicao <= this.totalDeObjetos;

	}

	private void garantaEspaco() {
		if (this.totalDeObjetos == this.objetos.length) {
			Object[] novoArray = new Aluno[this.objetos.length * 2];
			for (int i = 0; i < this.objetos.length; i++) {
				novoArray[i] = this.objetos[i];
			}
			this.objetos = novoArray;
		}

	}

	@Override
	public String toString() {
		if (this.totalDeObjetos == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < this.totalDeObjetos - 1; i++) {
			builder.append(this.objetos[i]);
			builder.append(", ");
		}
		builder.append(this.objetos[this.totalDeObjetos- 1]);
		builder.append("]");
		return builder.toString();
	}

	//// compara dois objetos do tipo Aluno
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(objetos);
		result = prime * result + Objects.hash(totalDeObjetos);
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
		return Arrays.deepEquals(objetos, other.objetos) && totalDeObjetos == other.totalDeObjetos;
	}

}
