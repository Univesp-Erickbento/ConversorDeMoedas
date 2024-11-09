package com.ErickBento.Conversor.de.Moedas;

import com.ErickBento.Conversor.de.Moedas.conversor.ConversorDeMoedasUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConversorDeMoedasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversorDeMoedasApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		int option;

		do {
			System.out.println("Menu:");
			System.out.println("1. Dólar para Peso Argentino");
			System.out.println("2. Peso Argentino para Dólar");
			System.out.println("3. Dólar para Real Brasileiro");
			System.out.println("4. Real Brasileiro para Dólar");
			System.out.println("5. Dólar para Peso Colombiano");
			System.out.println("6. Peso Colombiano para Dólar");
			System.out.println("7. Sair");
			System.out.print("Escolha uma opção válida: ");
			option = scanner.nextInt();

			if (option >= 1 && option <= 6) {
				System.out.print("Digite o valor a ser convertido: ");
				double valor = scanner.nextDouble();
				switch (option) {
					case 1:
						System.out.println("Convertendo Dólar para Peso Argentino...");
						ConversorDeMoedasUtil.converterMoeda("USD", "ARS", valor);
						break;
					case 2:
						System.out.println("Convertendo Peso Argentino para Dólar...");
						ConversorDeMoedasUtil.converterMoeda("ARS", "USD", valor);
						break;
					case 3:
						System.out.println("Convertendo Dólar para Real Brasileiro...");
						ConversorDeMoedasUtil.converterMoeda("USD", "BRL", valor);
						break;
					case 4:
						System.out.println("Convertendo Real Brasileiro para Dólar...");
						ConversorDeMoedasUtil.converterMoeda("BRL", "USD", valor);
						break;
					case 5:
						System.out.println("Convertendo Dólar para Peso Colombiano...");
						ConversorDeMoedasUtil.converterMoeda("USD", "COP", valor);
						break;
					case 6:
						System.out.println("Convertendo Peso Colombiano para Dólar...");
						ConversorDeMoedasUtil.converterMoeda("COP", "USD", valor);
						break;
				}
			} else if (option == 7) {
				System.out.println("Saindo...");
			} else {
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
			}
		} while (option != 7);

		scanner.close();
	}
}


