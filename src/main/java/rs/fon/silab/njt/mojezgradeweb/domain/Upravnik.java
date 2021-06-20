/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.domain;



/**
 *
 * @author Sara
 */
public class Upravnik implements Entity{ //Upravnik je korisnik sistema

    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;

    public Upravnik() {
    }

    public Upravnik(Long id, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

//    @Override
//    public String getTableName() {
//        return " korisnik ";
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
//        return " as k ";
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
//        return " where korisnickoime = '" + email + "' and lozinka = '" + lozinka + "' ";
//    }
//
//    @Override
//    public List<GenericEntity> makeList(ResultSet rs) throws Exception {
//        List<GenericEntity> lista = new ArrayList<>();
//        while(rs.next()){
//                Upravnik korisnik = new Upravnik();
//                korisnik.setId(rs.getLong("id"));
//                korisnik.setIme(rs.getString("ime"));
//                korisnik.setPrezime(rs.getString("prezime"));
//                korisnik.setLozinka(rs.getString("lozinka"));
//                korisnik.setEmail(rs.getString("korisnickoIme"));
//                lista.add(korisnik);
//            }
//            rs.close();
//            return lista;
//    }
//
//  
   

    
}
