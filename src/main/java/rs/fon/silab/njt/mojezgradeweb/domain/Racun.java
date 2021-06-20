/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.domain;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sara
 */
public class Racun implements Entity{
    
    private Long racunId;
    private double ukupnaVrednost;
    private Date datumIzdavanja;
    private Status status;

    public Racun() {
    }

    public Racun(Long racunId, double ukupnaVrednost, Date datumIzdavanja, Status status) {
        this.racunId = racunId;
        this.ukupnaVrednost = ukupnaVrednost;
        this.datumIzdavanja = datumIzdavanja;
        this.status = status;
    }

    public Long getRacunId() {
        return racunId;
    }

    public void setRacunId(Long racunId) {
        this.racunId = racunId;
    }

    public double getUkupnaVrednost() {
        return ukupnaVrednost;
    }

    public void setUkupnaVrednost(double ukupnaVrednost) {
        this.ukupnaVrednost = ukupnaVrednost;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Racun{" + "racunId=" + racunId + ", ukupnaVrednost=" + ukupnaVrednost + ", datumIzdavanja=" + datumIzdavanja + ", status=" + status + '}';
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
        final Racun other = (Racun) obj;
        if (!Objects.equals(this.racunId, other.racunId)) {
            return false;
        }
        return true;
    }
    
    
    
}
