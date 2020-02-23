package com.udemy.javaee.clase295.beans;

import javax.ejb.Remote;

@Remote
public interface HolaMundoEJBRemote {
    public int sumar(int a, int b);
}
