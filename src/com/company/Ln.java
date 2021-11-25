package com.company;

import java.text.NumberFormat;

public class Ln implements Function{


    private  final Function term;
    private  final double coef;
    public  Ln (Function term,double coef)
    {
        this.coef=coef;
        this.term=term;
    }

    @Override
    public double calculate(double x)
    {
        return Math.log(term.calculate(x))*coef;
    }
    @Override
    public Function derivative()
    {
            return new Multiplication(Pow.of(-1,term,coef),term.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(coef!=1)
            return String.format("%s*ln|%s|",nf.format(coef),term.toPrettyString(nf));
        else
            return String.format("ln|%s|",term.toPrettyString(nf));
    }
    public  static Ln of(Function term,double coef)
    {
        return new Ln(term,coef);
    }

}
