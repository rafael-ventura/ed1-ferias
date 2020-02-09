package trabalho3;

public class Pilha<T> implements IPilha<T> {
    
	protected No  topo;
	protected int qtdItens;

	protected class No {
        public T  item;
        public No prox;

        public No(T item) {
            this.item = item;
            this.prox = null;
        }
    }
        
    @Override
    public boolean push(T e) {
        No no;
        
        try {
            no = new No(e);
        }
        catch(OutOfMemoryError ex) {
            return false;
        }
        
        no.prox = topo;
        topo = no;
        
        qtdItens++;
        
        return true;
    }

    @Override
    public T pop() {
        No aux;
        T item;
        
        if (qtdItens == 0)
            return null;
        
        aux = topo;
        topo = topo.prox;
        
        item = aux.item;
        aux.item = null;
        aux.prox = null;
        
        qtdItens--;
        
        return item;
    }

    @Override
    public T peek() {
        if (qtdItens == 0)
            return null;

        return topo.item;
    }

    @Override
    public int quantidade() {
        return qtdItens;
    }

    @Override
    public boolean estaVazia() {
        return qtdItens == 0;
    }

    @Override
    public void removerTodos() {
        No aux;
        
        while (topo != null) {
            aux = topo;
            topo = topo.prox;
            aux.item = null;
            aux.prox = null;
        }
        
        qtdItens = 0;
    }
    
    @Override
    public IPilha<T> copiar() {
    	IPilha<T> novaPilha = new Pilha<>();
    	IPilha<T> invertida = new Pilha<>();
    	No aux = topo;
    	
    	while (aux != null) {
    		invertida.push(aux.item);
    		aux = aux.prox;
    	}
    	
    	while (! invertida.estaVazia())
    		novaPilha.push(invertida.pop());
    	
    	return novaPilha;
    }
    
    @Override
    public boolean igual(IPilha<T> outraPilha) {
    	IPilha<T> invertida = new Pilha<>();
    	boolean mesmaPilha = true;
    	No aux = topo;
    	T e;
    	
    	if (qtdItens != outraPilha.quantidade())
    		return false;
    	
    	while (aux != null) {
    		e = outraPilha.pop();
    		invertida.push(e);
    		
    		if (! aux.item.equals(e)) {
    			mesmaPilha = false;
    			break;
    		}
    		aux = aux.prox;
    	}
    	
    	// Reconstroi a outra pilha
    	while (! invertida.estaVazia())
    		outraPilha.push(invertida.pop());
    	
    	return mesmaPilha;
    }
    
    @Override
    public IPilha<T> concatenar(IPilha<T> outraPilha) {
    	IPilha<T> novaPilha = new Pilha<>();
    	IPilha<T> invertida = new Pilha<>();
    	No aux = topo;
    	T e;
    	
    	while (! outraPilha.estaVazia())
    		invertida.push(outraPilha.pop());
    	
    	while (! invertida.estaVazia()) {
    		e = invertida.pop();
    		novaPilha.push(e);
    		outraPilha.push(e);
    	}
    			
    	while (aux != null) {
    		invertida.push(aux.item);
    		aux = aux.prox;
    	}
    	
    	while (! invertida.estaVazia())
    		novaPilha.push(invertida.pop());
    	
    	return novaPilha;
    }
    
    /**
     * Retorna uma string com os itens da pilha no formato [e1, e2, e3, ..., en].
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        
        buffer.append("[");
        
        if (topo != null) {
            No aux = topo;
            
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
