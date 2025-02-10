import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while(continuar) {
            System.out.println("Digite um número de conta:");
            int numero = scanner.nextInt();

            System.out.println("Digite a agencia:");
            String agencia = scanner.next();

            System.out.println("Digite o nome do cliente:");
            String nomeCliente = scanner.next();

            System.out.println("Digite o saldo do cliente:");
            double saldo = scanner.nextDouble();

            if (validarInformacoes(numero, agencia, nomeCliente, saldo)) {
                System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", " +
                        "conta " + numero + " e seu saldo " + saldo + " já está disponível para saque");
                continuar = false;
            } else {
                System.out.println("Deseja tentar novamente? (Sim/Nao)");
                String resposta = scanner.next();

                if (!resposta.equalsIgnoreCase("Sim")) {
                    continuar = false;
                    System.out.println("Bank agradece o contato, tenha um bom dia!");
                }
            }
        }
    }

    static boolean validarInformacoes(int numero, String agencia, String nomeCliente, double saldo) {
        boolean dadosValidos = true;

        if (numero == 0) {
            System.out.println("O número da conta não pode ser zero.");
            dadosValidos = false;
        }

        if (agencia == null || agencia.trim().isEmpty()) {
            System.out.println("A agência não pode ser nula ou vazia.");
            dadosValidos = false;
        }

        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            System.out.println("O nome do cliente não pode ser nulo ou vazio.");
            dadosValidos = false;
        }

        if (saldo < 0) {
            System.out.println("O saldo não pode ser negativo.");
            dadosValidos = false;
        }

        return dadosValidos;
    }
}