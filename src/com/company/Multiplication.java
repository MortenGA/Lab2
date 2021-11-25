package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Multiplication extends Composite {
    public Multiplication() {
        super();
    }

    public Multiplication(Function... terms) {
        super(terms);
    }

    public Multiplication(ArrayList<Function> terms) {
        super(terms);
    }

    public void clear()
    {
        terms().clear();
    }

    @Override
    public double calculate(double x) {
        double result = 1.0;
        for (Function function : terms()) {
            result *= function.calculate(x);
        }
        return result;
    }

    @Override
    public Function derivative() {
        final Multiplication multier = new Multiplication();
        final Sum sumer = new Sum();
        for(int i= terms().size()-1;i!=0;i--){
            multier.clear();
            for(int j=0;j<terms().size();j++)
            {
                if(j!=i)
                    multier.terms().add(terms().get(j));
                else
                    multier.terms().add(terms().get(i).derivative());
            }
            sumer.terms().add(multier);
        }
        return sumer;
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)",
                joiner.toString()).replace("*/", "/");
    }

    public static Multiplication of(Function... terms) {
        return new Multiplication(terms);
    }
}
