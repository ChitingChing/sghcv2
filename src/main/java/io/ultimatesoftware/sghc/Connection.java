package io.ultimatesoftware.sghc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

public class Connection {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sghc");



}
