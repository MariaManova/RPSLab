/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managbeans;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author user
 */
@Singleton
@LocalBean
public class MySingletone implements Serializable {
    
    private int count;

    public MySingletone() {
        count = 0;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    @AroundInvoke 
    Object incOrders(InvocationContext ic) throws Exception {
        count++;
        return ic.proceed();
    }
}
