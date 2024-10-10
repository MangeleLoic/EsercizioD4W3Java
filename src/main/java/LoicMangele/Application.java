package LoicMangele;

import LoicMangele.dao.EventsDAO;
import LoicMangele.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("E4W3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO ev = new EventsDAO(em);


        Persona marioRossi = new Persona("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.of(1990, 5, 20), Sesso.MASCHIO);
        Persona luigiRosa = new Persona("Luigi", "Rosa", "luigi.rosa@gmail.com", LocalDate.of(1985, 3, 14), Sesso.MASCHIO);
        Persona francoNeri = new Persona("Franco", "Neri", "franco.neri@gmail.com", LocalDate.of(1988, 7, 30), Sesso.MASCHIO);
        Persona marthaWest = new Persona("Martha", "West", "martha.west@gmail.com", LocalDate.of(1992, 11, 22), Sesso.FEMMINA);
        Persona evelinaFusaro = new Persona("Evelina", "Fusaro", "evelina.fusaro@gmail.com", LocalDate.of(1991, 1, 5), Sesso.FEMMINA);
        Persona francescoPane = new Persona("Francesco", "Pane", "francesco.pane@gmail.com", LocalDate.of(1994, 9, 17), Sesso.MASCHIO);
        Persona enricoTorti = new Persona("Enrico", "Torti", "enrico.torti@gmail.com", LocalDate.of(1987, 4, 8), Sesso.MASCHIO);
        Persona annaBianchi = new Persona("Anna", "Bianchi", "anna.bianchi@gmail.com", LocalDate.of(1995, 8, 15), Sesso.FEMMINA);


        List<Persona> atleti = new ArrayList<>();
        atleti.add(marioRossi);
        atleti.add(annaBianchi);
        atleti.add(enricoTorti);
        atleti.add(francescoPane);
        atleti.add(francoNeri);
        atleti.add(evelinaFusaro);
        atleti.add(marthaWest);
        atleti.add(luigiRosa);

        Persona vincitore1 = marioRossi;
        Persona vincitore2 = enricoTorti;

        Concerto eminem = new Concerto("Concerto di Eminem", LocalDate.of(2024, 12, 10), "Grande evento di Eminem!", TipoEvento.CONCERTO, 50000, Genere.RAP, true);
        Concerto snoopDogg = new Concerto("Concerto di Snoop Dogg", LocalDate.of(2025, 6, 13), "Mega tour di Snoopy!", TipoEvento.CONCERTO, 40000, Genere.RAP, true);
        PartitaDiCalcio derby = new PartitaDiCalcio("Derby di Milano", LocalDate.of(2024, 9, 21), "Stracittadina di Milano", TipoEvento.CALCIO, 60000, "Inter", "Milan", "Milan", 1, 2);
        PartitaDiCalcio derby2 = new PartitaDiCalcio("Derby di Roma", LocalDate.of(2024, 11, 11), "Stracittadina di Roma", TipoEvento.CALCIO, 50000, "Roma", "Lazio", null, 2, 2);
        GaraDiAtletica gara1 = new GaraDiAtletica("200 metri", LocalDate.of(2024, 7, 21), "Competizione di velocità", TipoEvento.ATLETICA, 8, atleti, vincitore1);
        GaraDiAtletica gara2 = new GaraDiAtletica("100 metri", LocalDate.of(2024, 7, 21), "Competizione di velocità", TipoEvento.ATLETICA, 8, atleti, vincitore2);


        ev.save(marioRossi);
        ev.save(annaBianchi);
        ev.save(enricoTorti);
        ev.save(francescoPane);
        ev.save(francoNeri);
        ev.save(evelinaFusaro);
        ev.save(marthaWest);
        ev.save(luigiRosa);


        ev.save(eminem);
        ev.save(snoopDogg);
        ev.save(derby);
        ev.save(derby2);
        ev.save(gara1);
        ev.save(gara2);


        em.close();
        emf.close();
    }
}

