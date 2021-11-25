package com.company;

import java.text.NumberFormat;

public class Cos implements Function{
    private  final Function term;
    private  final double coef;

    public  Cos (Function term,double coef)
    {
        this.coef=coef;
        this.term=term;
    }

    @Override
    public double calculate(double x)
    {
        return coef*Math.cos(term.calculate(x));
    }
    @Override
    public Function derivative()
    {
        return new Multiplication(
                Sin.of(term,-coef),
                term.derivative()
        );
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(coef!=1)
            return String.format("%s*cos(%s)",nf.format(coef),term.toPrettyString(nf));
        else
            return String.format("cos(%s)",term.toPrettyString(nf));
    }
    public  static Cos of(Function term,double coef)
    {
        return new Cos(term,coef);
    }

}
