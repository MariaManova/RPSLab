/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managbeans;

import WebApp.Items;
import WebApp.ItemsDao;
import WebApp.OrderSingletonInterface;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author user
 */
@ManagedBean(name="itemsBean", eager = true)
@RequestScoped
public class ItemsManagedBean implements Serializable{
    
    private String result;
    private Items item;
    private int orderCount;
    private int visited;
    private List<Items> il;
    private List<Items> selectedItems;
    
    @EJB
    private ItemsDao dao;        
    //Dao dao = new Dao();
    
    @EJB
    MySingletone ms;
    
    @EJB
    OrderSingletonInterface os;

    public void allItems() {
        try {
            il = (dao.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(ItemsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    /*private CartRemote getCart() throws NamingException {
        InitialContext context = new InitialContext();
        return(CartRemote) context.lookup(CartRemote.class.getName());
    }*/
        
   
    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the il
     */
    public List<Items> getIl() {
        allItems();
        return il;
    }

    /**
     * @param il the il to set
     */
    public void setIl(List<Items> il) {
        this.il = il;
    }

    /**
     * @return the selectedClients
     */
    public List<Items> getSelectedItems() {
        return selectedItems;
    }

    /**
     * @param selectedItems the selectedClients to set
     */
    public void setSelectedClients(List<Items> selectedItems) {
        this.selectedItems = selectedItems;
    }

    /**
     * @return the items
     */
    public Items getItems() {
        return item;
    }

    /**
     * @param item the items to set
     */
    public void setItems(Items item) {
        this.item = item;
    }

    

    /**
     * Creates a new instance of ItemsBean
     */
    public ItemsManagedBean() {
    }

    /**
     * @return the orderCount
     */
    public int getOrderCount() {
        orderCount = os.getCount();
        return orderCount;
    }

    /**
     * @param orderCount the orderCount to set
     */
    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    /**
     * @return the visited
     */
    public int getVisited() {
        visited = ms.getCount();
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(int visited) {
        this.visited = visited;
    }
    
}
