package rs.fon.silab.njt.mojezgradeweb.domain;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sara
 */
@javax.persistence.Entity
@Table(name ="mesto")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "mesto.findAll", query = "SELECT * FROM mesto")
//    , @NamedQuery(name = "mesto.findById", query = "SELECT c FROM mesto c WHERE c.mestoid = :mestoid")
//    , @NamedQuery(name = "mesto.findByNaziv", query = "SELECT c FROM mesto c WHERE c.naziv = :naziv")})
//   
public class Mesto implements Entity {

    @Id
    @Basic(optional = false)
    @Column(name = "mestoid")
    private Long mestoId;
    @Basic(optional = false)
    @Column(name = "ptt")
    private String ptt;
     @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;

    public Mesto() {
    }

    public Mesto(Long mestoId, String ptt, String naziv) {
        this.mestoId = mestoId;
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getMestoId() {
        return mestoId;
    }

    public void setMestoId(Long mestoId) {
        this.mestoId = mestoId;
    }

    public String getPtt() {
        return ptt;
    }

    public void setPtt(String ptt) {
        this.ptt = ptt;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.mestoId, other.mestoId)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String getTableName() {
//        return " mesto ";
//    }
//
//    @Override
//    public String getColumnNamesForInsert() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getInsertValues() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getAlijas() {
//        return " as m ";
//    }
//
//    @Override
//    public void setId(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getUpdateValues() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getPrimaryKeyValue() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String getJoin() {
//        return "";
//    }
//
//    @Override
//    public String selectWhere() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<GenericEntity> makeList(ResultSet rs) throws Exception {
//        List<GenericEntity> lista = new ArrayList<>();
//        while (rs.next()) {
//            Mesto mesto = new Mesto();
//            mesto.setMestoId(rs.getLong("mestoid"));
//            mesto.setNaziv(rs.getString("naziv"));
//            mesto.setPtt(rs.getString("ptt"));
//            lista.add(mesto);
//            System.out.println(mesto);
//        }
//        rs.close();
//        return lista;
//    }
}
