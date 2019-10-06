/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managbeans;

import WebApp.Client;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Пользователь
 */
/*@ManagedBean(name = "Session")
@SessionScoped*/

@ConversationScoped
@Named
@Stateful
public class Session implements SessionInterface {
    @Inject
    private Conversation cs;
    
    private Client client;

    /**
     * @return the client
     */
    @Override
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    @Override
    public void setClient(Client client) {
        this.client = client;
    }
}
