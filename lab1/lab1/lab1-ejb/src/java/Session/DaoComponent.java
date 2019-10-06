/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import WebApp.Client;
import WebApp.DaoRemote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class DaoComponent implements DaoRemote {
    
    Connection con;
    ResultSet rs;
    PreparedStatement stmt;
    private DataSource mybase;
    
    @PostConstruct
    public void init(){
        
    }
    
     public List<Client> getAll() throws SQLException {
        con = WebApp.Dao.openConnection();
        stmt = con.prepareStatement("SELECT * FROM client");
        rs = stmt.executeQuery();
        List<Client> list = new ArrayList<>();
        while (rs.next()) {
            Client cl = new Client();
            cl.setId(rs.getInt("id"));
            cl.setFio(rs.getString("fio"));
            cl.setPhone(rs.getString("phone"));
            cl.setAddress(rs.getString("address"));
            cl.setBdate(rs.getDate("bdate"));
            list.add(cl);
        }
        con.close();
        return list;
    }

    public Client geClient(int id) throws SQLException {
        con = WebApp.Dao.openConnection();
        stmt = con.prepareStatement("SELECT * FROM client where id = ?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        Client cl = new Client();
        while (rs.next()) {
            cl.setId(rs.getInt("id"));
            cl.setFio(rs.getString("fio"));
            cl.setPhone(rs.getString("phone"));
            cl.setAddress(rs.getString("address"));
            cl.setBdate(rs.getDate("bdate"));
        }
        con.close();
        return cl;
    }

    public void create(Client cl) throws SQLException {
        con = WebApp.Dao.openConnection();
        stmt = con.prepareStatement("INSERT INTO client (fio, Phone, address) values (?, ?, ?');");
        stmt.setString(1, cl.getFio());
        stmt.setString(2, cl.getPhone());
        stmt.setString(3, cl.getAddress());
        stmt.executeUpdate();
        con.close();
    }

    public void delete(int id) throws SQLException {
        con = WebApp.Dao.openConnection();
        stmt = con.prepareStatement("DELETE FROM client WHERE id= ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        con.close();

    }

    public void change(Client cl) throws SQLException {
        con = WebApp.Dao.openConnection();
        stmt = con.prepareStatement("UPDATE client SET fio = ?, phone =  ?, bdate = ?, address = ? WHERE id= ?");
        stmt.setString(1, cl.getFio());
        stmt.setString(2, cl.getPhone());
        stmt.setDate(3, new java.sql.Date(cl.getBdate().getTime()));
        stmt.setString(4, cl.getAddress());
        stmt.setInt(5, cl.getId());
        stmt.executeUpdate();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
