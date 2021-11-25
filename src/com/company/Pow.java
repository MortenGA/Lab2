package com.company;

import java.text.NumberFormat;

public class Pow implements Function{

    private  final Function term;
    private  final double coef;
    private  final double power;
    public  Pow (double pow,Function term,double coef)
    {
        this.coef=coef;
        this.term=term;
        power = pow;
    }

    @Override
    public double calculate(double x)
    {
            return coef*Math.pow(term.calculate(x),power);
    }
    @Override
    public Function derivative()
    {
        if(power==1)
            return new Multiplication(Const.of(coef),term,term.derivative());
        if(power==2)
            return new Multiplication(Pow.of(1,term,coef*power),term.derivative());
        else
           return new Multiplication( Pow.of(power-1,term,power*coef),term.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(coef!=1)
           return String.format("%s*(%s)^%s",nf.format(coef),term.toPrettyString(nf),nf.format(power));
        else
            return String.format("(%s)^%s",term.toPrettyString(nf),nf.format(power));
    }
    public  static Pow of(double pow,Function term,double coef)
    {
        return new Pow(pow,term,coef);
    }

}
