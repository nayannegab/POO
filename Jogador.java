
package jogoDeDados;

public class Jogador {
    private String nome;
    private int aposta;

    public Jogador(String nome, int aposta) {
        this.nome = nome;
        this.aposta = aposta;
    }

    public String getNome() {
        return nome;
    }

    public int getAposta() {
        return aposta;
    }
}
