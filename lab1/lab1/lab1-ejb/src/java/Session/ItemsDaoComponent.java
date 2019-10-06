/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import WebApp.Dao;
import WebApp.Items;
import WebApp.ItemsDao;
import WebApp.OrderSingletonInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.interceptor.Interceptors;
import javax.sql.DataSource;

/**
 *
 * @author user
 */
@Stateless
public class ItemsDaoComponent  implements ItemsDao {
    
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    private DataSource mybase;
    
    @EJB
    OrderSingletonInterface os;
    
    @PostConstruct
    public void init(){
        
    }
    @Override
    public List<Items> getAll() throws SQLException {
        con = Dao.openConnection();
        stmt = con.prepareStatement("SELECT * FROM items");
        rs = stmt.executeQuery();
        List<Items> list = new ArrayList<>();
        while (rs.next()) {
            Items i = new Items();
            i.setId(rs.getInt("id"));
            i.setName(rs.getString("name"));
            i.setPrice(rs.getFloat("price"));
            list.add(i);
        }
        con.close();
        return list;
    }
    @Override
    public Items getItems(int id) throws SQLException {
        con = WebApp.Dao.openConnection();
        stmt = con.prepareStatement("SELECT * FROM items where id = ?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        Items i = new Items();
        while (rs.next()) {
            i.setId(rs.getInt("id"));
            i.setName(rs.getString("name"));
            i.setPrice(rs.getDouble("price"));
        }
        con.close();
        return i;
    }
    
    @Override
    public void create(Items i) throws SQLException {
        con = WebApp.Dao.openConnection();
        stmt = con.prepareStatement("INSERT INTO items (name, price) values (?, ?');");
        stmt.setString(1, i.getName());
        stmt.setDouble(2, i.getPrice());
        stmt.executeUpdate();
        con.close();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   
}
