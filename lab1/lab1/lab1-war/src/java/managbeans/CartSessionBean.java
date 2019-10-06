package managbeans;

import WebApp.Items;
import WebApp.ItemsDao;
import WebApp.OrderSingletonInterface;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 *
 * @author user
 */

@Named(value = "myCart")
@ConversationScoped
@Stateful
public class CartSessionBean implements CartRemote, Serializable {
    
    @Inject
    Conversation cs;
    
    @EJB
    OrderSingletonInterface os;
    
    List<Items> contents = new ArrayList<>();
    
    @Override
    public void addltem(Items item) throws RemoteException {
        if(cs.isTransient()){
            cs.begin();
        }
        contents.add(item);
    }

    @Override
    public void removeltem(Items item) throws RemoteException {
        contents.remove(item);
    }

    @Override
    public double getTotalPrice() throws RemoteException {
        double price = 0;
        
        for(Items item: contents){
            price += item.getPrice();
        }
        return price;
    }

    @Override
    public List<Items> getContents() throws RemoteException {
        return contents;
    }
    
    @Override
    public void removeAll(){
        if (!cs.isTransient()) {
            cs.end();
            contents = new ArrayList<>();
        }
    }
    
    @Override
    @Interceptors(MySingletone.class)
    public void getOrder() {
        if (!cs.isTransient()) {
            cs.end();
            
            os.add();
            contents = new ArrayList<>();
        }
    }
}
