package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Divide extends Composite{

    public Divide(){
        super();
    }
    public Divide(Function divided,Function divider){ this.divided=divided;this.divider=divider; }
    public Divide(ArrayList<Function> terms){
        super(terms);
    }

    private Function divided;
    private Function divider;

    @Override
    public double calculate(double x){
        double result;

        result = divided.calculate(x)/divider.calculate(x);

        return  result;
    }

    @Override
    public  Function derivative(){

        return  new Divide(
                (new Difference(
                        new Multiplication(divided.derivative(),divider),
                        new Multiplication(divider.derivative(),divided))
                ),
                new Pow(2,divider,1.0)
        );
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final String joiner = divided.toPrettyString(nf)+"/"+divider.toPrettyString(nf);
        return joiner;
    }
    public static Divide of(Function divided,Function divider){
        return  new Divide(divided,divider);
    }
}
