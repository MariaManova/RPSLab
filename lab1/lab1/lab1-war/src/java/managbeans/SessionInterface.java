/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managbeans;

import WebApp.Client;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface SessionInterface {
    public Client getClient();
    public void setClient(Client client);
}
