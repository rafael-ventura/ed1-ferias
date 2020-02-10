package trabalho3;

public class Main {

	public static void main(String[] args) {
		String expressao = "3+8*5"; 
		Pilha<Character> pilha = new Pilha<>(); 
		System.out.println(pilha.posFix(expressao));
	}	

}
