import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorConfiguracao {

    private static final Path ARQUIVO = Path.of("config.txt");

    private static GerenciadorConfiguracao instancia;
    private static int quantidadeLeituras = 0;

    private final ConfiguracaoJogo configuracao;

    private GerenciadorConfiguracao() {
        this.configuracao = lerArquivo();
    }

    public static GerenciadorConfiguracao getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorConfiguracao();
        }
        return instancia;
    }

    public static int getQuantidadeLeituras() {
        return quantidadeLeituras;
    }

    public ConfiguracaoJogo getConfiguracao() {
        return configuracao;
    }

    private static ConfiguracaoJogo lerArquivo() {
        try {
            List<String> linhas = Files.readAllLines(ARQUIVO);
            quantidadeLeituras++;
            Map<String, String> valores = new HashMap<>();
            for (String linha : linhas) {
                String[] partes = linha.split("=");
                valores.put(partes[0], partes[1]);
            }
            return new ConfiguracaoJogo(valores);
        } catch (IOException e) {
            throw new IllegalStateException("Nao foi possivel ler " + ARQUIVO, e);
        }
    }
}
