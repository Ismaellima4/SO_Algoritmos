import java.util.*;

public class LOT implements Escalonador{

   private final List<Processo> processos;
    private List<Integer> temposRetorno = new ArrayList<>();
    private List<Integer> temposChegada = new ArrayList<>();


    public LOT(List<Processo> processos) {
        this.processos = processos;
    }


    @Override
    public void executar() {
        int tempoAtual = 0;

        while (!processos.isEmpty()) {
            Random random = new Random();
            int indiceSorteado = random.nextInt(processos.size());

            Processo processo = processos.get(indiceSorteado);

            processo.setTempoChegada(tempoAtual);
            processo.setTempoRetorno(tempoAtual + processo.getTempoExecucao());

            processos.remove(indiceSorteado);

            tempoAtual += processo.getTempoExecucao();

            temposRetorno.add(processo.getTempoRetorno());
            temposChegada.add(processo.getTempoChegada());

            System.out.println(processo);

        }
    }

    @Override
    public int tempoMedioRetorno() {
        if (temposRetorno.isEmpty()) {
            return 0;
        }
        int soma = temposRetorno.stream().mapToInt(Integer::intValue).sum();
        return  soma / temposRetorno.size();
    }

    @Override
    public int tempoMedioChegada() {
        if (temposChegada.isEmpty()) {
            return 0;
        }
        int soma = temposChegada.stream().mapToInt(Integer::intValue).sum();
        return  soma / temposChegada.size();
    }

    @Override
    public List<Processo> getProcessos() {
        return this.processos;
    }
}
