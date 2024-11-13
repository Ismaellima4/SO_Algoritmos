import java.util.Random;

public class ProcessoPrioridade {
    private int tempoExecucao;
    private int tempoChegada;
    private int tempoRetorno;
    private int prioridade;

    public ProcessoPrioridade() {
        Random gerador = new Random();
        this.tempoExecucao = gerador.nextInt(20) + 1;
        this.tempoChegada = 0;
        this.tempoRetorno = 0;
        this.prioridade = gerador.nextInt(5) + 1;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public int getTempoRetorno() {
        return tempoRetorno;
    }

    public void setTempoRetorno(int tempoRetorno) {
        this.tempoRetorno = tempoRetorno;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return ""+this.tempoExecucao;
    }
}
