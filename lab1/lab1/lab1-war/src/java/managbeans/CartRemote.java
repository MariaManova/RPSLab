/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managbeans;

import WebApp.Items;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Local
public interface CartRemote {
    public void addltem(Items item) throws java.rmi.RemoteException; 
    public void removeltem(Items item) throws java.rmi.RemoteException; 
    public double getTotalPrice() throws java.rmi.RemoteException;
    public List<Items> getContents() throws java.rmi.RemoteException;
    public void removeAll();
    public void getOrder();
    //void purchase () throws java.rmi.RemoteException;
}

