package trabalho3;

/**
 * Define as operações básicas da estrutura de dados PILHA
 * @param <T> Tipo a ser armazenado na pilha
 */
public interface IPilha<T> {

    /**
     * Insere o item e no topo da pilha.
     * 
     * @param e Item a ser inserido.
     * @return Verdadeiro, se a operação foi bem sucedida; ou falso, caso contrário.
     */
    public boolean push(T e);

    /**
     * Remove o item do topo da pilha e o retorna.
     * 
     * @return Item do topo da pilha; ou null, se a pilha estiver vazia.
     */
    public T pop();
    
    /**
     * Retorna o item do topo da pilha sem removê-lo.
     * 
     * @return Item do topo da pilha; ou null, se a pilha estiver vazia.
     */
    public T peek();
    
    /**
     * Retorna a quantidade de itens da pilha.
     * 
     * @return Quantidade de itens da pilha
     */
    public int quantidade();

    /**
     * Verifica se a pilha está vazia.
     * @return Verdadeiro, se a pilha estiver vazia; ou falso, caso contrário 
     */
    public boolean estaVazia();
    
    /**
     * Remove todos os itens da pilha.
     */
    public void removerTodos();
    
    /**
     * Gera uma cópia da pilha
     * @return Cópia da pilha
     */
    IPilha<T> copiar();
    
    /**
     * Verifica se duas pilhas são iguais
     * @param outraPilha A outra pilha que será usada na comparação
     * @return Verdadeiro, se as pilhas são iguais; Falso, caso contrário
     */
    boolean igual(IPilha<T> outraPilha);
    
    /**
     * Concatena duas pilhas, de forma que os elementos da primeira
     * fiquem sobre os elementos da segunda
     * @param outraPilha A outra pilha que será usada na concatenação
     * @return Uma nova pilha que é o resultado da concatenação
     */
    IPilha<T> concatenar(IPilha<T> outraPilha);
}
