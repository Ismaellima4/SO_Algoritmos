
import java.util.List;

public class RoundRobin implements Escalonador {
    private final List<Processo> processos;
    private final int quantum;

    public RoundRobin(List<Processo> processos, int quantum) {
        this.processos = processos;
        this.quantum = quantum;
    }

    public void executar() {
        int processosExecutando = this.processos.size();
        int tempoAtual = 0;

        do {
            for (Processo processo : this.processos) {
                if (processo.getTempoChegada() == 0){
                    processo.setTempoChegada(tempoAtual);
                }
                System.out.println(processo.getTempoExecucao());
                if (processo.getTempoExecucao() > quantum) {
                    processo.setTempoExecucao(processo.getTempoExecucao() - quantum);
                } else {
                    processo.setTempoRetorno(tempoAtual - processo.getTempoChegada());
                    processosExecutando -= 1;
                }
                tempoAtual += quantum;
            }
        }while (processosExecutando >= 0);
    }

    public int tempoMedioRetorno() {
        int somaTemposRetorno = processos.stream().mapToInt(Processo::getTempoRetorno).sum();
        return somaTemposRetorno / processos.size();
    }

    public int tempoMedioChegada() {
        int somaTemposChegada = processos.stream().mapToInt(Processo::getTempoChegada).sum();
        return somaTemposChegada / processos.size();
    }

    @Override
    public List<Processo> getProcessos() {
        return this.processos;
    }
}
