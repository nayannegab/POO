package jogoDeDados;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = new Jogo();

        System.out.print("Digite a quantidade de jogadores: ");
        int qtdJogadores = scanner.nextInt();
        scanner.nextLine();
        while (qtdJogadores < 1 || qtdJogadores > 11){
            System.out.println("numero inválido! digite entre 1 e 11: ");
            qtdJogadores = scanner.nextInt();
            scanner.nextLine();
        }
        for (int i = 1; i <= qtdJogadores; i++) {
            System.out.print("Nome do jogador " + i + ": ");
            String nome = scanner.nextLine();

            int aposta;
            do {
                System.out.print("Aposta de " + nome + " (entre 2 e 12): ");
                aposta = scanner.nextInt();
                scanner.nextLine();
            } while (aposta < 2 || aposta > 12);

            jogo.adicionarJogador(new Jogador(nome, aposta));
        }

        jogo.jogar();
        scanner.close();
    }
}
