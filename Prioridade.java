import java.util.Comparator;
import java.util.List;

public class Prioridade implements Escalonador {
    private final List<ProcessoPrioridade> processos;

    public Prioridade(List<ProcessoPrioridade> processos) {
        this.processos = processos;
        ordenarPorPrioridade();
    }

    private void ordenarPorPrioridade() {
        processos.sort(new Comparator<ProcessoPrioridade>() {
            @Override
            public int compare(ProcessoPrioridade o1, ProcessoPrioridade o2) {
                return Integer.compare(o1.getPrioridade(), o2.getPrioridade());
            }
        });
    }
    
    public void executar() {
        int tempoCurrent = 0;
        int tempoRetorno = 0;
        for (ProcessoPrioridade processo : processos) {
            processo.setTempoChegada(tempoCurrent);
            processo.setTempoRetorno(tempoRetorno + processo.getTempoExecucao());

            tempoCurrent += processo.getTempoExecucao();
            tempoRetorno += processo.getTempoRetorno();
        }
    }

    public int tempoMedioRetorno(){
        int retorno = 0;

        for (ProcessoPrioridade processo : processos) {
            retorno += processo.getTempoRetorno();
        }

        return retorno / this.processos.size();
    }

    public int tempoMedioChegada(){
        int chegada = 0;

        for (ProcessoPrioridade processo : processos) {
            chegada += processo.getTempoChegada();
        }
        return chegada / this.processos.size();
    }

    @Override
    public List<ProcessoPrioridade> getProcessos() {
        return this.processos;
    }
}
