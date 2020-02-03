package trabalho2;

public interface IListaOrdenada<T> {
	//- Interface est� incorreta: deveria ter somente um m�todo inserir(T e) que insere cescente e decrescente.
    boolean inserirListaCrescente(T elemento);
    //insere o elemento na lista e ordena de forma crescente e retorna verdadeiro se a operação foi executada
    //- Interface est� incorreta: deveria ter somente um m�todo inserir(T e) que insere cescente e decrescente.
    boolean  inserirListaDecrescente(T elemento);
    //insere o item ns lista de forma decrescente

    public T removerInicio();

    public T removerFim();
    public T removerPosicao(int p);
    public T removerItem(T e);
    public T getItem(int p);
    public int getPosicao(T e);
    public int getQuantidade();
    public boolean estaVazia();
    public void removerTodos();

}


