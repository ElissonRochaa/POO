package br.org.upe.eventhub.exceptions;

public class UsuarioExistenteException extends RuntimeException {
    public UsuarioExistenteException() {
        super("Usuario existente");
    }

    public UsuarioExistenteException(String mensagem) {
        super(mensagem);
    }
}
