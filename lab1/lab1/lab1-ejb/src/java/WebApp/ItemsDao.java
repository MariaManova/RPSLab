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
public interface ItemsDao {
    public List<Items> getAll() throws SQLException;
    public Items getItems(int id) throws SQLException;
    public void create(Items i) throws SQLException;
    //public void createOrder();
}
