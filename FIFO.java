import java.util.List;

public class FIFO implements Escalonador {
    private final List<Processo> processos;

    public FIFO(List<Processo> processos) {
        this.processos = processos;
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