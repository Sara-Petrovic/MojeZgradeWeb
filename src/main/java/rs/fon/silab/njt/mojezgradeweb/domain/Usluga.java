/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.domain;

import java.util.Objects;

/**
 *
 * @author Sara
 */
public class Usluga implements Entity{
    private Long uslugaId;
    private String naziv;
    private double cena;
    private JedinicaMere jedinicaMere;

    public Usluga() {
    }

    public Usluga(Long uslugaId, String naziv, double cena, JedinicaMere jedinicaMere) {
        this.uslugaId = uslugaId;
        this.naziv = naziv;
        this.cena = cena;
        this.jedinicaMere = jedinicaMere;
    }

    public Long getUslugaId() {
        return uslugaId;
    }

    public void setUslugaId(Long uslugaId) {
        this.uslugaId = uslugaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    @Override
    public String toString() {
        return "Usluga{" + "uslugaId=" + uslugaId + ", naziv=" + naziv + ", cena=" + cena + ", jedinicaMere=" + jedinicaMere + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usluga other = (Usluga) obj;
        if (!Objects.equals(this.uslugaId, other.uslugaId)) {
            return false;
        }
        return true;
    }
    
    
}
