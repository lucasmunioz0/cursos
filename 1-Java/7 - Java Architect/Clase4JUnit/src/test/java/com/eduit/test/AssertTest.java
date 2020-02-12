package com.eduit.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertTest {
    
    @Test
    public void test(){
        assertEquals("3 es distinto de 20", 3, 20);
        assertNotEquals(3,3);
        assertNotNull(null);
        
    }
}
