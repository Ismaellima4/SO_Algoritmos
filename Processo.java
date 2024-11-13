import java.util.Random;

public class Processo {
    private int tempoExecucao;
    private int tempoChegada;
    private int tempoRetorno;

    public Processo() {
        this.tempoExecucao = new Random().nextInt(20) + 1;
        this.tempoChegada = 0;
        this.tempoRetorno = 0;
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

    @Override
    public String toString() {
        return ""+this.tempoExecucao;
    }
}
