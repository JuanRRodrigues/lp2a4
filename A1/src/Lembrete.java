import java.time.LocalDateTime;

public class Lembrete extends EventoBase {
    public Lembrete(String titulo, LocalDateTime dataHora) {
        super(titulo, dataHora, false, "");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}