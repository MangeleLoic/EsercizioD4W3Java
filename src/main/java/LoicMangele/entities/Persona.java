package LoicMangele.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sesso sesso;

    @ManyToOne
    @JoinColumn(name = "gara_id")
    private GaraDiAtletica garaDiAtletica;



    public Persona() {}


    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public GaraDiAtletica getGaraDiAtletica() {
        return garaDiAtletica;
    }

    public void setGaraDiAtletica(GaraDiAtletica garaDiAtletica) {
        this.garaDiAtletica = garaDiAtletica;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                ", garaDiAtletica=" + (garaDiAtletica != null ? garaDiAtletica.getTitolo() : "Nessuna gara") +
                '}';
    }

}