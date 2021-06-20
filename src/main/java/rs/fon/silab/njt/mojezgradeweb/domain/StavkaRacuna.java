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
public class StavkaRacuna implements Entity{
    
    private int redniBroj;
    private double cena;
    private Usluga usluga;
    private Racun racun;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int redniBroj, double cena, Usluga usluga, Racun racun) {
        this.redniBroj = redniBroj;
        this.cena = cena;
        this.usluga = usluga;
        this.racun = racun;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    @Override
    public String toString() {
        return "StavkaRacuna{" + "redniBroj=" + redniBroj + ", cena=" + cena + ", usluga=" + usluga + ", racun=" + racun + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        if (!Objects.equals(this.racun, other.racun)) {
            return false;
        }
        return true;
    }
    
    
}
