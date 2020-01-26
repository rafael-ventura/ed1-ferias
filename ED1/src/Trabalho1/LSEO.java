package Trabalho1;

public class LSEO<T extends Comparable<T>> implements IListaOrdenada {
	
	protected No head;
	protected No rabo;
    public int qtdItens;
    
	protected class No {
        public T item;
        public No prox;
		
		
        public No(T item) {
            this.item = item;
            this.prox = null;
        }
           
	public No() {
			// TODO Auto-generated constructor stub
		}
	public boolean inserirNaLista(T elemento) {
		// TODO Auto-generated method stub
		No lista = new No(head.item);
	    if(qtdItens == 0){	    	  
	           lista.item = elemento;
	           lista.prox = null;
	           head = lista;
	           qtdItens++;
	           return true;
	         } 
	       else {
	    	   if (head.item.compareTo(elemento) < 0) {
	    			  lista.prox = lista;
	    			  lista = new No(elemento);
	    			  head = lista;
	    			  return true;
	    		  }
	    	  while(lista.prox != null) {
	    		  
	    		  if(lista.item.compareTo(elemento) < 0) {
	    			  lista.prox = lista;
	    			  lista = new No(elemento);
	    			  return true;
	    		  }
	    		  
	    		  if(lista.prox == null) {
	    			  lista.prox = new No(elemento);
	    			  qtdItens++;
	    			  return true;
	    		  }
	    		lista = lista.prox;
	    	  }
	    	  return false;
	       }
	  	}
	public boolean inserirNaLIstaDecre(T elemento) {
		// TODO Auto-generated method stub
		No lista = new No(head.item);
	    if(qtdItens == 0){	    	  
	           lista.item = elemento;
	           lista.prox = null;
	           head = lista;
	           qtdItens++;
	           return true;
	         } 
	       else {
	    	   if (head.item.compareTo(elemento) > 0) {
	    			  lista.prox = lista;
	    			  lista = new No(elemento);
	    			  head = lista;
	    			  return true;
	    		  }
	    	  while(lista.prox != null) {
	    		  
	    		  if(lista.item.compareTo(elemento) >= 0) {
	    			  lista.prox = lista;
	    			  lista = new No(elemento);
	    			  return true;
	    		  }
	    		  
	    		  if(lista.prox == null) {
	    			  lista.prox = new No(elemento);
	    			  qtdItens++;
	    			  return true;
	    		  }
	    		lista = lista.prox;
	    	  }
	    	  return false;
	       }
	  	}
	}
	@Override
	public T removerInicio() {
		// TODO Auto-generated method stub
		No no;
        T item;

        if (qtdItens == 0) {
            return null;
        }
        no = head;
        head = head.prox;

        item = no.item;
        no.item = null;
        no.prox = null;

        qtdItens--;

        return item;
	}
	@Override
	public T removerFim() {
		// TODO Auto-generated method stub
		No ant = head;
		No aux = head;
	    	while(aux.prox != null) {
	    		if (aux.prox == null) {	
	        		ant.prox = null;
	        		qtdItens--;
	        		return ant.prox.item;
	    			}
	    		ant = aux;
	    		aux = aux.prox;
	        	}
	    	return null;
	        }

	public No getPosicao(T elemento) {
		// TODO Auto-generated method stub
        No auxiliar = this.head;
      
        while(auxiliar != null & auxiliar.item != elemento ){
        	auxiliar = auxiliar.prox;
        	if (auxiliar.item == elemento) {
        		return auxiliar;
        	}
        }
		return null;
	}
	
	
	public void listarLista() {
		No aux = this.head;
		
		while (aux.prox != null) {
			System.out.println("Lista: [ " + aux.item);		;
			aux = aux.prox;
		}
		System.out.println("]");
	}
	
	
	@Override
	public boolean inserirNaLista(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean inserirNaLIstaDecre(Object elemento) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object removerPosicao(int p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object removerItem(Object e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getItem(int p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean contem(Object e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public No getPosicao(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getQuantidade() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean estaVazia() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void removerTodos() {
		// TODO Auto-generated method stub
		
	}
}
