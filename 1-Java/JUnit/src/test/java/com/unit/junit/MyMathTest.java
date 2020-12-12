package com.unit.junit;

import static org.junit.jupiter.api.Assertions.*;

import com.unit.junit.domain.MyMath;
import org.junit.jupiter.api.*;

class MyMathTest {
    @Test
    public void test() {
        MyMath math = new MyMath();
        assertTrue(26 == math.sum(new int[]{5,6,7,8}));
    }
}