package dir;

import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("     _ _                 ____      \n"
        			     + "    | (_)               /\\' .\\    _____     \n"
        	             + "  __| |_  ___ ___      /: \\___\\  / .  /\\   \n"
        		         + " / _` | |/ __/ _ \\     \\' / . / /____/..\\  \n"
        		         + "| (_| | | (_|  __/	\\/___/  \\'  '\\  /      \n"
        		       + " \\__,_|_|\\___\\___|	         \\'__'\\/        ");
        
        boolean continuar = true;

        while (continuar) {
        	System.out.println("--------------------------------------------------------------------------");
            System.out.println("Digite a entrada no formato XdY, XdY+Z ou XdY-Z (ou 'sair' para encerrar):");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                continuar = false;
            } else {
                String[] partes = entrada.split("[d\\+\\-\\*\\/]");

                if (partes.length >= 2) {
                    int numeroDeDados = Integer.parseInt(partes[0]);
                    int numeroDeFaces = Integer.parseInt(partes[1]);

                    Random random = new Random();

                    int resultadoTotal = 0;
                    for (int i = 0; i < numeroDeDados; i++) {
                        int resultadoDoDado = random.nextInt(numeroDeFaces) + 1;
                        System.out.println("Resultado do dado " + (i + 1) + ": " + resultadoDoDado);
                        resultadoTotal += resultadoDoDado;
                    }

                    if (partes.length == 3 && partes[2].length() > 0) {
                        char operador = entrada.charAt(partes[0].length() + partes[1].length() + 1);
                        int valorOperacao = Integer.parseInt(partes[2]);

                        if (operador == '+') {
                            resultadoTotal += valorOperacao;
                            System.out.println("Soma adicional: " + valorOperacao);
                        } else if (operador == '-') {
                            resultadoTotal -= valorOperacao;
                            System.out.println("Subtração adicional: " + valorOperacao);
                        } else if (operador == '*') {
                        	resultadoTotal *= valorOperacao;
                        	System.out.println("Multiplicação adicional: " + valorOperacao);
                        } else if (operador == '/') {
                        	resultadoTotal /= valorOperacao;
                        	System.out.println("Divisão adicional: " + valorOperacao);
                        }
                    }

                    System.out.println("Resultado total: " + resultadoTotal);
                } else {
                    System.out.println("Formato inválido. Use o formato XdY, XdY+Z, ou XdY-Z, ou digite 'sair' para encerrar.");
                }
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}


