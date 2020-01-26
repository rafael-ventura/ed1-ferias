package Trabalho1;


public class Main {

	public static void main(String[] args) {

		LSEO<Integer> lista = new LSEO();

		lista.inserirNaLista(3);
		lista.inserirNaLista(4);
		lista.inserirNaLista(7);
		lista.inserirNaLista(6);
		lista.inserirNaLista(44);
		lista.inserirNaLista(8);
		lista.inserirNaLista(420);
		lista.inserirNaLista(58);
		
		lista.removerInicio();
		lista.removerInicio();
		//lista.removerFim();

		//lista.listarLista();
		


	}


}
