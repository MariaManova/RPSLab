/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sb;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Spisanie;
import models.User;

/**
 *
 * @author user
 */
@Stateless
public class SpisanieFacade extends AbstractFacade<Spisanie> {

    @PersistenceContext(unitName = "lab3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpisanieFacade() {
        super(Spisanie.class);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean createSpisRQ(double sum, int usrId) {
        User usr = em.find(User.class, usrId);
        if ((usr.getBalance() - sum) >= 0) {
            usr.setBalance(usr.getBalance() - sum);
            Spisanie sp = new Spisanie();
            sp.setUserId(usr);

            sp.setSum(sum);

            em.merge(usr);
            em.merge(sp);

            return true;
        }
        return false;
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public boolean createSpis(double sum, int usrId) {
        User usr = em.find(User.class, usrId);
        if ((usr.getBalance() - sum) >= 0) {
            usr.setBalance(usr.getBalance() - sum);
            Spisanie sp = new Spisanie();
            sp.setUserId(usr);

            sp.setSum(sum);

            em.merge(usr);
            em.merge(sp);

            return true;
        }
        return false;
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public boolean createSpisEX(double sum, int usrId) {
        User usr = em.find(User.class, usrId);
        if ((usr.getBalance() - sum) >= 0) {
            usr.setBalance(usr.getBalance() - sum);
            Spisanie sp = new Spisanie();
            sp.setUserId(usr);

            sp.setSum(sum);

            em.merge(usr);
            em.merge(sp);

            throw new EJBException();
        }
        return false;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean createSpisNS(double sum, int usrId) {
        User usr = em.find(User.class, usrId);
        if ((usr.getBalance() - sum) >= 0) {
            usr.setBalance(usr.getBalance() - sum);
            Spisanie sp = new Spisanie();
            sp.setUserId(usr);

            sp.setSum(sum);

            em.merge(usr);
            em.merge(sp);

            return true;
        }
        return false;
    }
}
