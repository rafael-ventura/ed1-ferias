package trabalho4;

/**
 * Define as operações básicas da estrutura de dados �?RVORE BIN�?RIA DE BUSCA
 *
 * @param <T> Tipo a ser armazenado na árvore
 */
public interface IABB<T> {
	
	/**
	 * Insere o elemento e na árvore.
	 * 
	 * @param e Elemento a ser inserido.
	 */
	public void inserir(T e);
	
	/**
	 * Remove o elemento e da árvore.
	 * 
	 * @param e Elemento a ser removido.
	 */
	public void remover(T e);
	
	/**
	 * Percorre os elementos da árvore em ordem, imprimindo cada um.
	 */
	public void emOrdem();
	
	/**
	 * Percorre os elementos da árvore em pré-ordem, imprimindo cada um.
	 */
	public void preOrdem();
	
	/**
	 * Percorre os elementos da árvore em pós-ordem, imprimindo cada um.
	 */
	public void posOrdem();
	
	/**
	 * Verifica se a árvore contém o elemento e.
	 * 
	 * @param e Elemento a ser buscado.
	 * @return Verdadeiro se a árvore contém o elemento e; falso, caso contrário.
	 */
	public boolean contem(T e);
	
	/**
	 * Retorna a quantidade de elementos da árvore.
	 * 
	 * @return Quantidade de elementos da árvore.
	 */
	public int quantidade();
	
	/**
	 * Verifica se a árvore está vazia.
	 * 
	 * @return Verdadeiro se a árvore está vazia; falso se tem algum elemento.
	 */
	public boolean estaVazia();
	
	/**
	 * Remove todos os elementos da árvore.
	 */
	public void removerTodos();

	/**
	 * Calcula a altura da árvore.
	 * 
	 * @return Altura da árvore.
	 */
	public int altura();
	
	/**
	 * Calcula o número de folhas da árvore.
	 * 
	 * @return Número de folhas da árvore.
	 */
	public int nrFolhas();
	
	/**
	 * Calcula o menor elemento da árvore.
	 * 
	 * @return Menor elemento da árvore.
	 */
	public T menor();
	
	/**
	 * Calcula o maior elemento da árvore.
	 * 
	 * @return Maior elemento da árvore.
	 */
	public T maior();
	
	/**
	 * Calcula a posição do elemento e.
	 * 
	 * @param e Elemento a ser procurado.
	 * @return Posição do elemento e; ou -1, se e não existir.
	 */
	public int posicao(T e);

	/**
	 * Retorna o elemento da posição p.
	 * 
	 * @param p Posição do elemento
	 * @return Elemento da posição p; ou null, se p é inválido.
	 */
	public T getItem(int p);

	/**
	 * Imprime a árvore de forma decrescente.
	 */
	public void imprimirDecrescente();

	/**
	 * Verifica se a árvore é estritamente binária.
	 * 
	 * @return Verdadeiro, se a árvore é estritamente binária; falso, caso contrário.
	 */
	public boolean ehEstritamenteBinaria();

	/**
	 * Verifica se a árvore é completa.
	 * 
	 * @return Verdadeiro, se a árvore é completa; falso, caso contrário.
	 */
	public boolean ehCompleta();

	/**
	 * Verifica se a árvore é cheia.
	 * 
	 * @return Verdadeiro, se a árvore é cheia; falso, caso contrário.
	 */
	public boolean ehCheia();

	/**
	 * Imprime o fator de balanceamento de todos os nós internos da árvore. 
	 * Fator de balanceamento de um nó k é a diferença absoluta entre as alturas 
	 * das subárvores esquerda e direita de k.
	 */
	public void fatorBalanceamento();
}
