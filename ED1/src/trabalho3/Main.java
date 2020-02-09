package trabalho3;

public class Main {

	public static void main(String[] args) {
		IPilha<Integer> pv1 = new Pilha<>();
		IPilha<Integer> pv2 = new Pilha<>();
		IPilha<Integer> pv3 = new Pilha<>();
		IPilha<Integer> pv4;
		
		pv1.push(2);
		pv1.push(7);
		pv1.push(3);
		
		pv4 = pv1.copiar();
		
		pv2.push(2);
		pv2.push(7);
		pv2.push(3);
		
		pv3.push(6);
		pv3.push(9);
		pv3.push(4);
		
		System.out.println(pv1);
		System.out.println(pv2);
		System.out.println(pv3);
		System.out.println(pv4);
		System.out.println(pv1.igual(pv2));
		System.out.println(pv1.igual(pv3));
		System.out.println(pv1.concatenar(pv3));
		System.out.println(pv1);
		System.out.println(pv2);
		System.out.println(pv3);
		System.out.println(pv4);
	}

}
