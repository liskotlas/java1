package ru.progwards.java1.lessons.Training;

import java.math.BigDecimal;

public class T8_3 {
    static class Rectangle {

        Rectangle(BigDecimal a, BigDecimal b) {
            this.a = a;
            this.b = b;
        }
        public BigDecimal a;
        public BigDecimal b;
    }
    boolean rectCompare(Rectangle r1, Rectangle r2){
        BigDecimal sr1 = r1.a.multiply(r1.b);
        BigDecimal sr2 = r2.a.multiply(r2.b);
        return sr1.compareTo(sr2) == 0;
    }

}
