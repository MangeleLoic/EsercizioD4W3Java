package LoicMangele.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genere genere;

    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;


    public Concerto() {}


    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }


    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }


    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "id=" + getId() +
                ", titolo='" + getTitolo() + '\'' +
                ", dataEvento=" + getDataEvento() +
                ", descrizione='" + getDescrizione() + '\'' +
                ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti() +
                ", genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
