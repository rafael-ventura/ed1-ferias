package trabalho4;

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
		File arquivo = new File("C:\\dev\\eclipse-workspace\\ED1\\src\\trabalho4\\textos\\" + nome + ".txt");

		// fazendo um try para inserir o arquivo no bufferedReader e le-lo com maior
		// facilidade
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(arquivo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// declarando lista que recebera cada palavra
		System.out.println("Deseja imprimir a lista em ordem crescente ou decrescente?");
		
		entrada.close();

		ABB<String> arvoreBin = new ABB<String>();
		String linha;

		// le linha por linha e insere palavra/token em um n� diferente
		while ((linha = buffer.readLine()) != null) {
			StringTokenizer iteraArquivo = new StringTokenizer(linha);
			while (iteraArquivo.hasMoreTokens()) {
				String novoNo = new String(iteraArquivo.nextToken().toLowerCase());
				System.out.println(novoNo);
				arvoreBin.inserir(novoNo);
			}
		}
		
		System.out.println("Maior palavra contida no texto: " + arvoreBin.acharMaior(arvoreBin.raiz));

		System.out.println("Total de palavras distintas: " + arvoreBin.nrFolhas(arvoreBin.raiz) + " palavras");

		System.out.println("Lista de Palavras:");
		arvoreBin.print(arvoreBin.raiz);
	}

}
