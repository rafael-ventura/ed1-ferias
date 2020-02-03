package trabalho1;

public class Main {
    public static void main(String[] args) {
        LSEO<Integer> lista1 = new LSEO<>();

        lista1.inserirListaCrescente(8);
        lista1.inserirListaCrescente(2);
        lista1.inserirListaCrescente(7);
        lista1.inserirListaCrescente(4);

        System.out.println(lista1);
        System.out.println(lista1.getQuantidade());

        lista1.removerInicio();
        System.out.println(lista1.getQuantidade());
        lista1.removerFim();
        System.out.println(lista1.getQuantidade());
        System.out.println(lista1);





    }
}
