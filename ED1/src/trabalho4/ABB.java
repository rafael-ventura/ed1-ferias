package trabalho4;

public class ABB<T extends Comparable<T>> implements IABB<T> {

	protected No raiz; // referência para o nó raiz

	protected class No {

		public T item; // item armazenado no nó
		public No esq; // referência para o nó da esquerda
		public No dir; // referência para o nó da direita
		public int qntRepeticoes;

		public No(T item) {
			this.item = item;
		}
	}

	@Override
	public void inserir(T e) {
		raiz = inserir(raiz, e);
	}

	@Override
	public void remover(T e) {
		raiz = remover(raiz, e);
	}

	@Override
	public void emOrdem() {
		emOrdem(raiz);
	}

	@Override
	public void preOrdem() {
		preOrdem(raiz);
	}

	@Override
	public void posOrdem() {
		posOrdem(raiz);
	}

	@Override
	public boolean contem(T e) {
		return busca(raiz, e) != null;
	}

	@Override
	public int quantidade() {
		return quantidade(raiz);
	}

	@Override
	public boolean estaVazia() {
		return raiz == null;
	}

	@Override
	public void removerTodos() {
		remover(raiz);
		raiz = null;
	}

	/**
	 * Retorna uma string com os itens da árvore em formato de indentação.
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();

		imprimir(raiz, 0, buffer);

		return buffer.toString();
	}

	@Override
	public int altura() {
		return altura(raiz);
	}

	@Override
	public int nrFolhas() {
		return nrFolhas(raiz);
	}

	@Override
	public T menor() {
		return menor(raiz);
	}

	@Override
	public T maior() {
		return maior(raiz);
	}

	@Override
	public int posicao(T e) {
		No r = raiz;
		int p = 0;

		while (r != null) {
			if (e.equals(r.item))
				return p + quantidade(r.esq);
			else {
				if (e.compareTo(r.item) < 0)
					r = r.esq;
				else {
					p += quantidade(r.esq) + 1;
					r = r.dir;
				}
			}
		}

		return -1;
	}

	@Override
	public T getItem(int p) {
		int qtdEsq;
		No r = raiz;

		while (r != null) {
			qtdEsq = quantidade(r.esq);
			if (p == qtdEsq)
				return r.item;
			else if (p < qtdEsq)
				r = r.esq;
			else {
				p -= qtdEsq + 1;
				r = r.dir;
			}
		}

		return null;
	}

	@Override
	public void imprimirDecrescente() {
		emOrdemInvertido(raiz);
	}

	@Override
	public boolean ehEstritamenteBinaria() {
		return ehEstritamenteBinaria(raiz);
	}

	@Override
	public boolean ehCompleta() {
		return ehCompleta(raiz, 0, altura());
	}

	@Override
	public boolean ehCheia() {
		return ehCheia(raiz, 0, altura());
	}

	@Override
	public void fatorBalanceamento() {
		if (raiz == null)
			return;

		fatorBalanco(raiz);
	}

	private No inserir(No r, T e) {
		No procura = busca(r, e);
		if (procura != null) {
			procura.qntRepeticoes++;
			return procura;
		}
		if (r == null) {
			r = new No(e);
			r.qntRepeticoes++;
		} else {
			int comparacao = r.item.compareTo(e); // ou -1 ou 0 ou 1

			if (comparacao < 0)
				r.esq = inserir(r.esq, e);
			else if (comparacao > 0)
				r.dir = inserir(r.dir, e);
		}
		return r;
	}

	private No remover(No r, T e) {
		No pai = null, p = r;

		// Busca o nó com o valor especificado e seu pai
		while (p != null && !p.item.equals(e)) {
			if (p.item.compareTo(e) > 0) {
				pai = p;
				p = p.esq;
			} else if (p.item.compareTo(e) < 0) {
				pai = p;
				p = p.dir;
			}
		}

		// Achou o nó!!!
		if (p != null) {
			// 1o caso: nnó folha
			if (p.esq == null && p.dir == null & p.qntRepeticoes < 1) {
				if (pai == null)
					r = null;
				else if (pai.esq == p)
					pai.esq = null;
				else
					pai.dir = null;
				p.item = null;
			}
			// 2o caso: nó sem filho à esquerda
			else if (p.esq != null && p.dir == null & p.qntRepeticoes < 1) {
				if (pai == null) {
					r = p.esq;
				} else if (pai.esq == p) {
					pai.esq = p.esq;
				} else {
					pai.dir = p.esq;
				}
				p.item = null;
			}
			// 2o caso: nó sem filho à direita
			else if (p.esq == null && p.dir != null & p.qntRepeticoes < 1) {
				if (pai == null)
					r = p.dir;
				else if (pai.esq == p)
					pai.esq = p.dir;
				else
					pai.dir = p.dir;
				p.item = null;
			}
			// 3o caso: nó tem filhos à esquerda e à direita
			else if (p.esq != null & p.dir != null) {
				// Descobre o MAIOR nó da ESQUERDA OU o MENOR nó da DIREITA (tanto faz!)
				No pm = maiorNo(p.esq);
				T m = pm.item;
				remover(p, m);
				p.item = m;
			} else {
				p.qntRepeticoes--;
			}
		}
		return r;
	}

	private No maiorNo(No r) {
		if (r == null)
			return null;

		while (r.dir != null)
			r = r.dir;

		return r;
	}

	private void emOrdem(No r) {
		if (r == null)
			return;

		emOrdem(r.esq);
		System.out.print(r.item + " ");
		emOrdem(r.dir);
	}

	private void preOrdem(No r) {
		if (r == null)
			return;

		System.out.print(r.item + " ");
		preOrdem(r.esq);
		preOrdem(r.dir);
	}

	private void posOrdem(No r) {
		if (r == null)
			return;

		posOrdem(r.esq);
		posOrdem(r.dir);
		System.out.print(r.item + " ");
	}

	private No busca(No r, T e) {
		if (r == null) {
			return null;
		}
		while (r != null && !r.item.equals(e)) {
			if (e.compareTo(r.item) < 0)
				r = r.esq;
			else
				r = r.dir;
		}

		return r;
	}

	private int quantidade(No r) {
		if (r == null)
			return 0;

		return quantidade(r.esq) + quantidade(r.dir) + 1;
	}

	private void remover(No r) {
		if (r == null)
			return;

		remover(r.esq);
		remover(r.dir);

		r.esq = null;
		r.dir = null;
		r.item = null;
	}

	private void imprimir(No r, int nivel, StringBuilder buffer) {

		if (r == null)
			return;

		for (int i = 0; i < nivel; i++)
			buffer.append("..");

		buffer.append(r.item.toString());
		buffer.append("\n");

		nivel++;

		imprimir(r.esq, nivel, buffer);
		imprimir(r.dir, nivel, buffer);
	}

	private int altura(No r) {
		if (r == null)
			return -1;

		int he = altura(r.esq);
		int hd = altura(r.dir);

		return (he > hd ? he : hd) + 1;
	}

	int nrFolhas(No r) {
		if (r == null)
			return 0;

		if (r.esq == null && r.dir == null)
			return 1;

		return 1 + nrFolhas(r.esq) + nrFolhas(r.dir);
	}

	private T menor(No r) {
		if (r == null)
			return null;

		while (r.esq != null)
			r = r.esq;

		return r.item;
	}

	private T maior(No r) {
		if (r == null)
			return null;

		while (r.dir != null)
			r = r.dir;

		return r.item;
	}

	private void emOrdemInvertido(No r) {
		if (r == null)
			return;

		emOrdemInvertido(r.dir);
		System.out.print(r.item);
		System.out.print(" ");
		emOrdemInvertido(r.esq);
	}

	private boolean ehEstritamenteBinaria(No r) {
		if (r == null)
			return true;

		if ((r.esq == null && r.dir != null) || (r.esq != null && r.dir == null))
			return false;

		return ehEstritamenteBinaria(r.esq) && ehEstritamenteBinaria(r.dir);
	}

	private boolean ehCompleta(No r, int nivel, int h) {
		if (r == null)
			return true;

		if (r.esq == null && r.dir == null)
			return nivel == h || nivel == h - 1;
		else
			return ehCompleta(r.esq, nivel + 1, h) && ehCompleta(r.dir, nivel + 1, h);
	}

	private boolean ehCheia(No r, int nivel, int h) {
		if (r == null)
			return true;

		if ((r.esq == null && r.dir != null) || (r.esq != null && r.dir == null))
			return false;
		else if (r.esq == null && r.dir == null)
			return nivel == h;
		else
			return ehCheia(r.esq, nivel + 1, h) && ehCheia(r.dir, nivel + 1, h);
	}

	private int fatorBalanco(No r) {
		if (r == null)
			return -1;

		if (r.esq == null && r.dir == null) {
			System.out.printf("%d => 0\n", r.item);
			return 0;
		}

		int hEsq = fatorBalanco(r.esq);
		int hDir = fatorBalanco(r.dir);
		int fator = hEsq > hDir ? hEsq - hDir : hDir - hEsq;

		System.out.printf("%d => %d\n", r.item, fator);

		return (hEsq > hDir ? hEsq : hDir) + 1;
	}

	public String acharMaior(No no) {
		if (no == null) {
			return "";
		}
		String aux = no.item.toString();
		String auxEsq = acharMaior(no.esq);
		String auxDir = acharMaior(no.dir);

		if (auxEsq.length() > aux.length()) {
			aux = auxEsq;
		}
		if (auxDir.length() > aux.length()) {
			aux = auxDir;
		}
		return aux;
	}

	public int totalDistintas(No no) {
		int contador = 1;
		if (raiz != null && raiz.esq == null && raiz.dir == null) {
			return 1;
		}
		if (no == null) {
			return 0;
		}
		contador = contador + totalDistintas(no.esq); // somando a quantidade de nos
		contador = contador + totalDistintas(no.dir);
		return contador;
	}

	public void print(No no) {
		if (no == null) {
			return;
		}

		System.out.println("O nó: " + no.item + " apareceu: " + no.qntRepeticoes + " vezes.");

		print(no.esq);
		print(no.dir);

	}
}
