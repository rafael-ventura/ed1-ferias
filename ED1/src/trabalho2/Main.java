package trabalho2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite arquivo a verificar: ");
		String nome = entrada.next();
		File arquivo = new File("C:\\Users\\raf4a\\eclipse-workspace\\ED1\\src\\trabalho2\\textos\\" + nome + ".txt");

		// fazendo um try para inserir o arquivo no bufferedReader e le-lo com maior facilidade
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(arquivo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// declarando lista que recebera cada palavra
		System.out.println("Deseja imprimir a lista em ordem crescente ou decrescente?");
		String ordem = entrada.next().toLowerCase();
		entrada.close();
		LSEO<String> listaOrdenada = new LSEO<String>();
		String linha;

		// le linha por linha e insere palavra/token em um nó diferente
		while ((linha = buffer.readLine()) != null) {
			StringTokenizer iteraArquivo = new StringTokenizer(linha);
			while (iteraArquivo.hasMoreTokens()) {
				String novoNo = new String(iteraArquivo.nextToken().toLowerCase());
				listaOrdenada.inserir(novoNo, ordem);
			}
		}
		System.out.println("Maior palavra contida no texto: " + listaOrdenada.pegaMaiorPalavra());
		System.out.println("Total de palavras distintas: " + listaOrdenada.totalPalavraDistintas());

		System.out.println("Lista de Palavras:");
		listaOrdenada.imprimeDistintas();
	}
}
