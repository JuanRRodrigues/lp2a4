import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Tarefa extends EventoBase {
    private LocalDate data;
    private LocalTime horario;

    public Tarefa(String titulo, LocalDate data, LocalTime horario, boolean seRepete, String descricao) {
        super(titulo, LocalDateTime.of(data, horario), seRepete, descricao);
        this.data = data;
        this.horario = horario;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setData(LocalDate data) {
        this.data = data;
        this.dataHora = LocalDateTime.of(data, horario);
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
        this.dataHora = LocalDateTime.of(data, horario);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Data: " + data + "\n" +
                "Horário: " + horario;
    }
}