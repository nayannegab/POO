package jogoDeDados;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private List<Jogador> jogadores = new ArrayList<>();
    private Dados dados = new Dados();

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void jogar() {
        dados.lancar();
        int soma = dados.getSoma();

        System.out.println("\n Dados lançados: " + dados.getDado1() + " e " + dados.getDado2());
        System.out.println(" Soma: " + soma);

        boolean houveGanhador = false;

        for (Jogador jogador : jogadores) {
            if (jogador.getAposta() == soma) {
                System.out.println( jogador.getNome() + " venceu com a aposta " + jogador.getAposta() + "!");
                Persistencia.salvarVitoria(jogador.getNome(), soma);
                houveGanhador = true;
            }
        }

        if (!houveGanhador) {
            System.out.println(" O computador venceu! Ninguém acertou.");
        }
        Persistencia.exibirTop5();
    }
}
