/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface DaoRemote {
    public List<Client> getAll() throws SQLException;
    public Client geClient(int id) throws SQLException;
    public void create(Client cl) throws SQLException;
    public void delete(int id) throws SQLException;
    public void change (Client cl) throws SQLException;
}
