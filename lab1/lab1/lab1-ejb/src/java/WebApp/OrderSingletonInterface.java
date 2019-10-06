/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebApp;

import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface OrderSingletonInterface {
    public int getCount();
    public void add();
}
