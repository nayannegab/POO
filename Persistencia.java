package jogoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Persistencia {
    private static final String ARQUIVO = "vencedores.csv";

    public static void salvarVitoria(String nome, int somaDados) {
        Map<String, String[]> mapa = new LinkedHashMap<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(",");
                mapa.put(partes[0], partes);
            }
        } catch (IOException e) {
            // ok se o arquivo ainda não existir
        }

        if (mapa.containsKey(nome)) {
            String[] dados = mapa.get(nome);
            int vitorias = Integer.parseInt(dados[2]) + 1;
            mapa.put(nome, new String[]{nome, String.valueOf(somaDados), String.valueOf(vitorias)});
        } else {
            mapa.put(nome, new String[]{nome, String.valueOf(somaDados), "1"});
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (String[] dados : mapa.values()) {
                escritor.write(String.join(",", dados));
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo.");
        }
    }

    public static void exibirTop5() {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }

            //System.out.println("\n Top 5 últimos vencedores:");
            int start = Math.max(0, linhas.size() - 5);
            for (int i = start; i < linhas.size(); i++) {
                //tring[] partes = linhas.get(i).split(",");
                //System.out.println( partes[0] + " | Soma: " + partes[1] + " | Vitórias: " + partes[2]);
            }

        } catch (IOException e) {
            System.out.println("Ainda não há vencedores registrados.");
        }
    }
}
