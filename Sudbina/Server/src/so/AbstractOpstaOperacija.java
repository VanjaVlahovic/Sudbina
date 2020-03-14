/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import database.broker.DatabaseBroker;
import database.connection.ConnectionFactory;
import java.sql.SQLException;

/**
 *
 * @author Vanja Vlahović
 */
public abstract class AbstractOpstaOperacija {

    protected DatabaseBroker databaseBroker;

    public AbstractOpstaOperacija() {
        databaseBroker = new DatabaseBroker();
    }

    public final Object izvrsi(Object objekat) throws Exception {
        try {
            preduslovi(objekat);
            pokreniTransakciju();
            Object result = izvrsiOperaciju(objekat);
            commitTransaction();
            return result;
        } catch (Exception ex) {
            //ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        }
    }

    protected abstract void preduslovi(Object entity) throws Exception;

    private void pokreniTransakciju() throws SQLException {
        ConnectionFactory.getInstance().getConnection().setAutoCommit(false);
    }

    protected abstract Object izvrsiOperaciju(Object entity) throws Exception;

    private void commitTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().commit();
    }

    private void rollbackTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().rollback();
    }
}
