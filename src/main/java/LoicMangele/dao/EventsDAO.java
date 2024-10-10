package LoicMangele.dao;

import LoicMangele.entities.Concerto;
import LoicMangele.entities.Evento;
import LoicMangele.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventsDAO {
    private final EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Object entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            if (entity instanceof Evento) {
                System.out.println("L'evento " + ((Evento) entity).getTitolo() + " è stato creato con successo");
            } else if (entity instanceof Persona) {
                System.out.println("L'atleta " + ((Persona) entity).getNome() + " " + ((Persona) entity).getCognome() + " è stato creato con successo");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio dell'entità: " + e.getMessage());
        }
    }

    public List<Concerto> getConcertiInStreaming() {
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = true", Concerto.class);
        return query.getResultList();
    }
}
