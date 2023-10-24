import java.time.LocalDateTime;

public class EventoBase {
    protected String titulo;
    protected LocalDateTime dataHora;
    protected boolean seRepete;
    protected String descricao;

    public EventoBase(String titulo, LocalDateTime dataHora, boolean seRepete, String descricao) {
        this.titulo = titulo;
        this.dataHora = dataHora;
        this.seRepete = seRepete;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean isSeRepete() {
        return seRepete;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setSeRepete(boolean seRepete) {
        this.seRepete = seRepete;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Evento: " + titulo + "\n" +
                "Data e hora: " + dataHora + "\n" +
                "Se repete: " + seRepete + "\n" +
                "Descrição: " + descricao;
    }
}