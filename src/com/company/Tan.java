package com.company;

import java.text.NumberFormat;

public class Tan implements Function{
    private final Function term;
    private final double coef;

    public  Tan (Function term,double coef)
    {
        this.coef=coef;
        this.term=term;
    }

    @Override
    public double calculate(double x)
    {
        return coef * Math.tan(term.calculate(x));
    }
    @Override
    public Function derivative()
    {
        return new Divide(
                term.derivative(),
                Pow.of(2,Cos.of(term, coef),1)
        );
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(coef!=1)
            return String.format("%s*tg(%s)",nf.format(coef),term.toPrettyString(nf));
        else
            return String.format("tg(%s)",term.toPrettyString(nf));
    }
    public  static Tan of(Function term,double coef)
    {
        return new Tan(term,coef);
    }
}
