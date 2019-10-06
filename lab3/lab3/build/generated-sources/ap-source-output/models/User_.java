package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Spisanie;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-29T17:18:11")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, Double> balance;
    public static volatile SingularAttribute<User, String> lname;
    public static volatile ListAttribute<User, Spisanie> spisanieList;
    public static volatile SingularAttribute<User, String> fname;

}