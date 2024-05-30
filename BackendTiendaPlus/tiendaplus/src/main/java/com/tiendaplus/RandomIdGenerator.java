package com.tiendaplus;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // Genera un número aleatorio como ID
    	long leftLimit = 10000L;
        long rightLimit = 99999L;
        long generatedId = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

        return generatedId;
    }
}