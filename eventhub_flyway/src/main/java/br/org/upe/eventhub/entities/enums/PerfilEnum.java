package br.org.upe.eventhub.entities.enums;

public enum PerfilEnum {
    ADMINISTRADOR("Administrador"),
    PARTICIPANTE("Participante"),;

    private final String nomePerfil;

    PerfilEnum(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

}
