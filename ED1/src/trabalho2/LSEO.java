package trabalho2;

import java.util.HashMap;


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
	public boolean inserir(T item , String ordem) {
		No no = new No(item); 
		No aux = head;
		if("crescente".equals(ordem.toLowerCase())) {
			//verifica se a lista esta vazia, se estiver, poe na primeira posicao
			if (qtdItens == 0) {
				head = no;
				no.prox = aux;
				qtdItens++;
				return true;
			}

			if (item.compareTo(head.item) < 0) {
				no.prox = head;
				head = no;
				qtdItens++;
			} else {
				No anterior = head.prox;
				No posterior = head;
				while (posterior != null) {
					if (item.compareTo(posterior.item) < 0) {
						break;
					}
					anterior = posterior;
					posterior = posterior.prox;
				}
				no.prox = anterior.prox;
				anterior.prox = no;
				qtdItens++;
			}
			return true;

		}   else if("decrescente".equals(ordem.toLowerCase())) {
			No lista = head;
			if(qtdItens == 0){	    	  
				lista = new No(item);
				lista.prox = null;
				head = lista;
				qtdItens++;
				return true;
			} else {
				if (head.item.compareTo(item) == 0 ) {
					lista.prox = lista;
					lista = new No(item);
					head = lista;
					return true;
				}
				while(lista.prox != null) {  
					if(lista.item.compareTo(item) == 1) {
						lista.prox = lista;
						lista = new No(item);
						return true;
					}
					if(lista.prox == null) {
						lista.prox = new No(item);
						qtdItens++;
						return true;
					}
					lista = lista.prox;
				}
				return true;
			}
		}
		else{
			System.out.println("Erro na defini�ao da ordem.");
			return false;
		}	
	}

	@Override
	public T removerInicio() {
		No no;
		T item;

		if (qtdItens == 0)
			return null;

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
		No ultimo, aux;
		T item;

		if (qtdItens == 0)
			return null;

		if (qtdItens == 1)
			return removerInicio();

		// Localiza o antepenultimo nó
		aux = localizarNo(qtdItens-2);

		// Localiza  último nó
		ultimo = aux.prox;

		aux.prox = null;

		item = ultimo.item;
		ultimo.item = null;

		qtdItens--;

		// Retorna o item removido
		return item;
	}


	@Override
	public T removerPosicao(int p) {
		No no, aux;
		T item;

		// Verifica se P é válido
		if (p < 0 || p >= qtdItens)
			return null;

		// Se P é a primeira posição, então é uma remoção do início
		// Se P é a ultima posição, então é uma remoção do fim
		if (p == 0)
			return removerInicio();
		else if (p == qtdItens-1)
			return removerFim();

		// AUX = nó da posição p-1
		aux = localizarNo(p-1);

		no = aux.prox;
		aux.prox = no.prox;

		item = no.item;
		no.item = null;
		no.prox = null;

		qtdItens--;

		return item;
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
	public T getItem(int p) {
		if (p < 0 || p >= qtdItens)
			return null;

		return localizarNo(p).item;
	}
	@Override
	public boolean contem(T e) {
		return getPosicao(e) != -1;
	}

	@Override
	public int getPosicao(T e) {
		No aux = head;
		int p = 0;

		while (aux != null) {
			if (e.equals(aux.item))
				return p;
			aux = aux.prox;
			p++;
		}

		return -1;
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
		No aux;

		while (head != null) {
			aux = head;
			head = head.prox;
			aux.item = null;
			aux.prox = null;
		}

		qtdItens = 0;
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

	public String pegaMaiorPalavra() {
		String maior = "";
		No atual = head;

		while (atual != null) {
			if (maior.length() < atual.item.toString().length()) {
				maior = atual.item.toString();
			}
			atual = atual.prox;
		}
		return maior;
	}


	public int totalPalavraDistintas() {
		HashMap<T, Integer> hash = new HashMap<T, Integer>();
		No atual;

		for (atual = head; atual != null; atual = atual.prox) {
			if (hash.containsKey(atual.item)) {
				hash.put(atual.item, hash.get(atual.item) + 1);
			}
			else {
				hash.put(atual.item, 1);
			}
		}
		return hash.size();
	}
	public void imprimeDistintas() {
		HashMap<T, Integer> hash = new HashMap<T, Integer>();
		No atual;

		for (atual = head; atual != null; atual = atual.prox) {
			if (hash.containsKey(atual.item)) {
				hash.put(atual.item, hash.get(atual.item) + 1);
			}
			else {
				hash.put(atual.item, 1);
			}
		}
		for (java.util.Map.Entry<T, Integer> entry : hash.entrySet()) {
			System.out.println(entry.getKey() + " :repetiu " + entry.getValue() + " vez(es).");
		}
	}
	
	public void imprimeLista() {
		No atual = head;
		System.out.println("[");
		while(atual != null) {
			System.out.println(atual.item);
			if(atual.prox != null) {
				System.out.println(",");
			}
			atual = atual.prox;
		}
		System.out.print("]");
	}
}

