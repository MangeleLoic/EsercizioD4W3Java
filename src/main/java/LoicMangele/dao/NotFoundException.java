package LoicMangele.dao;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("l'evento con id " + id + " non è stato trovato");
    }
}
