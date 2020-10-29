package com.eduit.clase3;

import com.eduit.clase3.manager.SessionFactoryManager;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = SessionFactoryManager.getSessionFactory();
    }
}
