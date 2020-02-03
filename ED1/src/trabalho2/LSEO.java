package trabalho2;

public class LSEO<T extends Comparable<T>> implements IListaOrdenada<T> {
    protected No head;
    private int qtdItens;

    protected class No {
        public T item;
        public No prox;

        public No(T item) {
            this.item = item;
            this.prox = null;
        }
    }
    @Override
	public boolean inserirListaCrescente(T elemento) {
        No no = new No(elemento);
        No aux = head;
        //verifica se a lista esta vazia, se estiver, poe na primeira posicao
        if (qtdItens == 0) {
            head = no;
            no.prox = aux;
            qtdItens++;
            return true;
        }
        	
        if (elemento.compareTo(head.item) < 0) {
            no.prox = head;
            head = no;
            qtdItens++;
        } else {
            No ant = head.prox;
            No post = head;
            while (post != null) {
                if (elemento.compareTo(post.item) < 0) {
                    break;
                }
                ant = post;
                post = post.prox;
            }
            no.prox = ant.prox;
            ant.prox = no;
            qtdItens++;
        }
        return true;
    }

    @Override
    public boolean  inserirListaDecrescente(T elemento) {
        No no = new No(elemento);
        No aux = head;
        //verifica se a lista esta vazia, se estiver, poe na primeira posicao
        if (qtdItens == 0) {
            head = no;
            no.prox = aux;
            qtdItens++;
            return true;
        }

        if (elemento.compareTo(head.item) > 0) {
            no.prox = head;
            head = no;
        } else {
            No post = head;
            while (post.prox != null) {
                if (elemento.compareTo(post.item) > 0) {
                    break;
                }
                post = post.prox;
            }
            no.prox = aux.prox;
            aux.prox = no;
            qtdItens++;
        }
        return true;
    }

    @Override
    public T removerInicio() {
        No no;
        T elemento;

        if (qtdItens == 0) {
            return null;
        }
        no = head;
        head = head.prox;

        elemento = no.item;
        no.item = null;
        no.prox = null;

        qtdItens--;

        return elemento;
    }

    @Override
    public T removerFim() {
        No ultimo;
        No aux;
        T elemento;

        if (qtdItens == 0) {
            return null;
        }

        if (qtdItens == 1) {
            return removerInicio();
        }

        aux = localizarNo(qtdItens - 2);

        ultimo = aux.prox;
        aux.prox = null;

        elemento = ultimo.item;
        ultimo.item = null;

        qtdItens--;

        return elemento;
    }

    @Override
    public T removerPosicao(int p) {
        No no, aux;
        T elemento;


        if (p < 0 || p >= qtdItens) {
            return null;
        }

        if (p == 0) {
            return removerInicio();
        } else if (p == qtdItens - 1) {
            return removerFim();
        }

        aux = localizarNo(p - 1);

        no = aux.prox;
        aux.prox = no.prox;

        elemento = no.item;
        no.item = null;
        no.prox = null;

        qtdItens--;

        return elemento;
    }

    @Override
    public T removerItem(T e) {
        if (e != null) {
            int p = getPosicao(e);

            if (p != -1) {
                T old = getItem(p);

                removerPosicao(p);

                return old;
            }
        }

        return null;
    }

    @Override
    public T getItem(int p) {
        if (p < 0 || p >= qtdItens)
            return null;

        return localizarNo(p).item;
    }

    @Override
    public int getPosicao(T e) {
        return 0;
    }

    @Override
    public int getQuantidade() {
        return qtdItens;
    }

    @Override
    public boolean estaVazia() {
        return head == null;
    }

    @Override
    public void removerTodos() {
        
    }

    protected No localizarNo(int p) {
        No aux = head;

        while (p > 0) {
            aux = aux.prox;
            p--;
        }

        return aux;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[");

        if (head != null) {
            No aux = head;

            while (aux.prox != null) {
                buffer.append(aux.item);
                buffer.append(", ");
                aux = aux.prox;
            }

            buffer.append(aux.item);
        }

        buffer.append("]");

        return buffer.toString();
    }



}

