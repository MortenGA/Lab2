package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Difference extends Composite{
    private Function firstTerm;
    private Function lastTerm;
    public Difference(){
        super();
    }
    public Difference(ArrayList<Function> terms){
        super(terms);
    }
    public Difference(Function firstTerm,Function lastTerm){
        this.firstTerm=firstTerm;
        this.lastTerm=lastTerm;
    }
    @Override
    public double calculate(double x){
        double result=0.0;
        result = firstTerm.calculate(x)-lastTerm.calculate(x);
        return  result;
    }
    @Override
    public  Function derivative(){

        return  new Difference(firstTerm.derivative(),lastTerm.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        String result = firstTerm.toPrettyString(nf)+"-"+lastTerm.toPrettyString(nf);

        return String.format("(%s)",result).replace("--","+");
    }
    public static Difference of(Function firstTerm,Function lastTerm){
        return  new Difference(firstTerm,lastTerm);
    }

}
