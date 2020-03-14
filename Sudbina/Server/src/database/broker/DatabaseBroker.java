/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.broker;

import database.connection.ConnectionFactory;
import domain.IOpstiObjekat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanja Vlahović
 */
public class DatabaseBroker {

    public IOpstiObjekat kreiraj(IOpstiObjekat opstiObjekat) throws Exception {
        try {
            
            //throw new Exception();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(opstiObjekat.getNazivTabele())
                    .append(" ()")
                    .append(" VALUES ()");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                opstiObjekat.setSifra(id);
            }
            statement.close();          
            return opstiObjekat;
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<IOpstiObjekat> selektuj(IOpstiObjekat opstiObjekat) throws Exception {
        List<IOpstiObjekat> objekti = new ArrayList<>();
        try {
            //throw new Exception();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ")
                    .append(opstiObjekat.getNaziviKolonaZaSelect())
                    .append(" FROM ")
                    .append(opstiObjekat.getNazivTabele())
                    .append(opstiObjekat.joinUslov())
                    .append(opstiObjekat.getWhereUslov())
                    .append(opstiObjekat.getOrderByUslov());
            String query = sb.toString();
            System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                List<Object> lista = null;
                if (opstiObjekat.imaAsocijaciju()) {
                    lista = vratiObjekteUAsocijaciji(opstiObjekat, rs.getLong(1));
                }
                objekti.add(opstiObjekat.napuniObjekat(rs, lista));
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
        return objekti;
        
    }

    public Object insert(IOpstiObjekat objekat) throws Exception {
        try {
            //throw new Exception();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(objekat.getNazivTabele())
                    .append(" (").append(objekat.getNaziviKolonaZaInsert()).append(")")
                    .append(" VALUES (").append(objekat.getVrednostiZaInsert()).append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return objekat;
            
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

     public Object insertAsocijacija(IOpstiObjekat objekat, int i) throws Exception {
        try {
            //throw new Exception();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(objekat.getNazivTabeleAsocijacije())
                    .append(" (").append(objekat.getNaziviKolonaZaInsertAsocijacije()).append(")")
                    .append(" VALUES (").append(objekat.getVrednostiZaInsertAsocijacije(i)).append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return objekat;
            
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private List<Object> vratiObjekteUAsocijaciji(IOpstiObjekat opstiObjekat, Long sifra) throws Exception {
        List<Object> objekti = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ")
                    .append(opstiObjekat.getNaziviKolonaZaSelectAsocijacije())
                    .append(" FROM ")
                    .append(opstiObjekat.getNazivTabeleAsocijacije())
                    .append(opstiObjekat.joinUslovAsocijacije())
                    .append(opstiObjekat.getWhereUslovAsocijacije())
                    .append(sifra);
            String query = sb.toString();
            //System.out.println(query);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                objekti.add(opstiObjekat.napuniObjekatAsocijacije(rs));
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
        return objekti;
    }

    
     public Object update (IOpstiObjekat objekat) throws Exception {
        try {
            //throw new Exception();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(objekat.getNazivTabele())
                    .append(" SET ").append(objekat.getVrednostiZaUpdate())
                    .append(" WHERE ")
                    .append(objekat.getWhereUpdateUslov());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return objekat;            
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void delete(IOpstiObjekat objekat) throws Exception {
        try {
            //throw new Exception();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ").append(objekat.getNazivTabele())
            .append(" WHERE ")       
            .append(objekat.getWhereUpdateUslov());
                    
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void deleteAsocijacija(IOpstiObjekat objekat, int i) throws Exception {
        try {
            //throw new Exception();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ").append(objekat.getNazivTabeleAsocijacije())
            .append(" WHERE ")       
            .append(objekat.getWhereDeleteUslovAsocijacije(i));
                    
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
