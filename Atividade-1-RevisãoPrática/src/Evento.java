import java.time.LocalDateTime;

public class Evento extends EventoBase {
    private LocalDateTime dataHoraFinal;
    private String local;

    public Evento(String titulo, LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal,
                  boolean seRepete, String local, String descricao) {
        super(titulo, dataHoraInicial, seRepete, descricao);
        this.dataHoraFinal = dataHoraFinal;
        this.local = local;
    }

    public LocalDateTime getDataHoraFinal() {
        return dataHoraFinal;
    }

    public String getLocal() {
        return local;
    }

    public void setDataHoraFinal(LocalDateTime dataHoraFinal) {
        this.dataHoraFinal = dataHoraFinal;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Data e hora final: " + dataHoraFinal + "\n" +
                "Local: " + local;
    }
}