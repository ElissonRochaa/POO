package br.org.upe.eventhub.entities.enums;

public enum EventoEnum {
    PRESENCIAL("Presencial"),
    ONLINE("Online"),
    HIBRIDO("Hibrido");

    private final String tipoEvento;

    EventoEnum(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public String getTipoEvento() {
        return tipoEvento;
    }
}
