package com.company;

import java.text.NumberFormat;

public class Abs implements Function{

    private Function term;

    public  Abs (Function term)
    {
        this.term=term;
    }

    @Override
    public double calculate(double x)
    {
        return Math.abs(term.calculate(x));
    }
    @Override
    public Function derivative()
    {
        return new Multiplication(
                new Divide(
                        term,
                        Abs.of(term)
                ),
                term.derivative()
        );

    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
            return String.format("|%s|",term.toPrettyString(nf));
    }
    public  static Abs of(Function term)
    {
        return new Abs(term);
    }

}
