import java.util.List;

public interface Escalonador {
    void executar();
    int tempoMedioRetorno();
    int tempoMedioChegada();
    <T> List<T> getProcessos();
}
