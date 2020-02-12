package com.eduit.javaseweb.integrator.version1;

import com.eduit.javaseweb.integrator.models.Customer;
import com.eduit.javaseweb.integrator.models.Phone;
import com.eduit.javaseweb.integrator.models.Residence;

public class IntegratorVersion1 {
    public static void main(String[] args) {
        Phone phone = new Phone(1, "Mobile", "3543518545");
        Residence residence = new Residence(1, "San Juan", "Villa Allende", 1549);
        Customer customer = new Customer(2, 25, "LUCAS", "muÑoz", phone, residence);
        
        System.out.println(customer);
        System.out.println(customer.getFullName());
    }
}
