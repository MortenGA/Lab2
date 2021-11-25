package com.company;

import java.text.NumberFormat;

/* клас функцій виду f(x) = const */
public class Const extends Number implements Function {
    public static final Const ZERO = new Const(0);
    public static final Const ONE = new Const(1);
    public static final Const NEGATIVE_ONE = new Const(-1);

    private final double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double calculate(double x) {
        return value;
    }

    @Override
    public Function derivative() {
        return ZERO;
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return nf.format(value);
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    public static Const of(double value) {
        return new Const(value);
    }
}
