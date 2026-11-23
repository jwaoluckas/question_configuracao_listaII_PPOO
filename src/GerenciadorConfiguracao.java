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
        if (!Files.isReadable(ARQUIVO)) {
            throw new IllegalStateException("Arquivo de configuracao nao encontrado: " + ARQUIVO);
        }
        try {
            List<String> linhas = Files.readAllLines(ARQUIVO);
            quantidadeLeituras++;
            return new ConfiguracaoJogo(interpretar(linhas));
        } catch (IOException e) {
            throw new IllegalStateException("Nao foi possivel ler " + ARQUIVO, e);
        }
    }

    private static Map<String, String> interpretar(List<String> linhas) {
        Map<String, String> valores = new HashMap<>();
        for (String linha : linhas) {
            String[] partes = linha.trim().split("=", 2);
            if (partes.length < 2) {
                continue;
            }
            String chave = partes[0].trim();
            if (chave.isEmpty()) {
                continue;
            }
            valores.put(chave, partes[1].trim());
        }
        return valores;
    }
}
