/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import WebApp.OrderSingletonInterface;
import java.io.Serializable;
import javax.ejb.ConcurrencyManagement;
import static javax.ejb.ConcurrencyManagementType.BEAN;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author user
 */
@ConcurrencyManagement(BEAN)
@Singleton
public class OrdersSingleton implements OrderSingletonInterface, Serializable {
    private int count;
    private String count1;
    
    public OrdersSingleton(){
        count=0;
        count1="0";
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     * @return the count
     */
    @Override
    public int getCount() {
        return count;
    }
    
    @Override
    //@AroundInvoke
    public void add()
    {
        count++;
        
    }

    
}
