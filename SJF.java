import java.util.Comparator;
import java.util.List;

public class SJF implements Escalonador {
    private final List<Processo> processos;

    public SJF(List<Processo> processes) {
        this.processos = processes;
        ordenarPorTempoDeExecucao();
    }

    private void ordenarPorTempoDeExecucao() {
        processos.sort(new Comparator<Processo>() {
            @Override
            public int compare(Processo p1, Processo p2) {
                return Integer.compare(p1.getTempoExecucao(), p2.getTempoExecucao());
            }
        });
    }

    public void executar() {
        int tempoCurrent = 0;
        int tempoRetorno = 0;
        for (Processo processo : processos) {
            processo.setTempoChegada(tempoCurrent);
            processo.setTempoRetorno(tempoRetorno + processo.getTempoExecucao());

            tempoCurrent += processo.getTempoExecucao();
            tempoRetorno += processo.getTempoRetorno();
        }
    }

    public int tempoMedioRetorno(){
        int retorno = 0;

        for (Processo processo : processos) {
            retorno += processo.getTempoRetorno();
        }

        return retorno / this.processos.size();
    }

    public int tempoMedioChegada(){
        int chegada = 0;

        for (Processo processo : processos) {
            chegada += processo.getTempoChegada();
        }
        return chegada / this.processos.size();
    }

    @Override
    public List<Processo> getProcessos() {
        return this.processos;
    }
}

