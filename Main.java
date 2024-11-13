import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("FIFO");
        var fifo = new FIFO(createProcessos());
        displayEscalonador(fifo);

        System.out.println("RoundRobin");
        var rr = new RoundRobin(createProcessos(), 5);
        displayEscalonador(rr);

        System.out.println("SJF");
        var sjf = new SJF(createProcessos());
        displayEscalonador(sjf);

        System.out.println("Prioridade");
        var processos = new ArrayList<ProcessoPrioridade>();
        for (int i = 0; i <= 5 ; i++) {
            processos.add(new ProcessoPrioridade());
        }
        var prioridade = new Prioridade(processos);
        displayEscalonador(prioridade);
    }

    private static List<Processo> createProcessos() {
        List<Processo> processos = new ArrayList<>();

        for (int i = 0; i <= 5 ; i++) {
            processos.add(new Processo());
        }

        return processos;
    }


    private static void displayEscalonador(Escalonador escalonador){
        System.out.println("Processos: ");
        System.out.println(escalonador.getProcessos());
        escalonador.executar();
        System.out.println("Tempo Medio de chegada: ");
        System.out.println(escalonador.tempoMedioChegada());
        System.out.println("Tempo Medio de  Retorno: ");
        System.out.println(escalonador.tempoMedioRetorno());
    }
}
