package Trabalho1;

import Trabalho1.LSEO.No;

public interface IListaOrdenada<T> {

	public boolean inserirNaLista(T elemento) ;
    //insere o elemento na lista e ordena de forma crescente e retorna verdadeiro se a operação foi executada

	public boolean inserirNaLIstaDecre(T elemento);
    //insere o item ns lista de forma decrescente

	public T removerInicio();
    //remove o elemnto do inicio da lista e o retorna

	public T removerFim();
    //remove o elemento do fim da lista e o retorna

    public T removerPosicao(int p);
    //remove o item da posicao passada e o retona. retorna nulo se o elemento nao existe na lista

    public T removerItem(T e);
    //remore o item passado e o retorna. retorna nulo se o elemento nao existe na lista

    public T getItem(int p);

    //retorna o item dado pela posicao p. retona nulo se o elemento nao existe na lista

    public boolean contem(T e);
    //verifica se o elemento existe na lista, caso exista retorna verdadeiro, caso contrario retorna falso

    public No getPosicao(T elemento) ;
    //prucura e retorna a posicao do item procurado

    public int getQuantidade();
    //retorna a quantidade de itens na lista
    
    public boolean estaVazia();
    // verifica se a lista esta vazia

    public void removerTodos();
    // apaga todos os elementos da lista
}

