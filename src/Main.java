import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] componentes = {"Renderizador", "Rede", "Audio", "Conquistas", "Atualizador"};

        ExecutorService pool = Executors.newFixedThreadPool(componentes.length);
        CountDownLatch largada = new CountDownLatch(1);
        List<Future<GerenciadorConfiguracao>> resultados = new ArrayList<>();

        for (String componente : componentes) {
            resultados.add(pool.submit(() -> {
                largada.await();
                GerenciadorConfiguracao gerenciador = GerenciadorConfiguracao.getInstance();
                System.out.println(componente + " obteve a instancia " + System.identityHashCode(gerenciador));
                return gerenciador;
            }));
        }

        largada.countDown();

        GerenciadorConfiguracao primeira = resultados.get(0).get();
        boolean todasIguais = true;
        for (Future<GerenciadorConfiguracao> resultado : resultados) {
            todasIguais = todasIguais && resultado.get() == primeira;
        }
        pool.shutdown();

        System.out.println();
        System.out.println("Todos os componentes receberam a mesma instancia (==): " + todasIguais);
        System.out.println("Quantidade de leituras do arquivo: " + GerenciadorConfiguracao.getQuantidadeLeituras());

        ConfiguracaoJogo configuracao = GerenciadorConfiguracao.getInstance().getConfiguracao();

        System.out.println();
        System.out.println("Acesso individual aos campos:");
        System.out.println("UserName = " + configuracao.getUserName());
        System.out.println("Language = " + configuracao.getLanguage());
        System.out.println("BuildId = " + configuracao.getBuildId());
        System.out.println("DLCName = " + configuracao.getDlcName());
        System.out.println("ApplicationPath = " + configuracao.getApplicationPath());
        System.out.println("WorkingDirectory = [" + configuracao.getWorkingDirectory() + "]");

        System.out.println();
        System.out.println("Todas as configuracoes carregadas:");
        System.out.println(configuracao);
    }
}
