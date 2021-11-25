package com.company;

import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        final Function expression1 =
                Difference.of(
                        Multiplication.of(
                                Pow.of(2,Linear.X,1),
                                Pow.of(0.333,
                                        Abs.of(Difference.of(
                                                Multiplication.of(
                                                        Const.of(-7.0),
                                                        Pow.of(2,Tan.of(Linear.X,1),1)
                                                ),Const.of(1.0))
                                        ),1)
                        ),
                        Ln.of(
                                Sum.of(Linear.X,Const.of(5.0))
                        ,1)
                                    );
        final NumberFormat nf = NumberFormat.getInstance();
        System.out.format("f(x) = %s",expression1.toPrettyString(nf)).println();
        System.out.format("f'(x) = %s",expression1.derivative().toPrettyString(nf)).println();
        System.out.format("f(-0.1) = %f",expression1.calculate(1)).println();
        System.out.format("f'(-0.1) = %f",expression1.derivative().calculate(1)).println();

        final Function expression2 =
                Divide.of(
                        Sum.of(
                        Multiplication.of(
                                Linear.X,
                                Exp.of(
                                        Pow.of(0.5,
                                                Multiplication.of(
                                                        Const.of(-7.0),
                                                        Linear.X)
                                        ,1)
                                ,1)
                                ),Const.of(5.0)
                        ),
                        Abs.of(
                                Sin.of(
                                        Pow.of(3,
                                                Sum.of(
                                                        Multiplication.of(
                                                                Const.of(-7.0),
                                                                Linear.X),
                                                        Const.of(5.0)
                                                ),1)
                                ,1)
                        )
                );
        System.out.format("f(x) = %s",expression2.toPrettyString(nf)).println();
        System.out.format("f'(x) = %s",expression2.derivative().toPrettyString(nf)).println();
        System.out.format("f(-0.1) = %f",expression2.calculate(1)).println();
        System.out.format("f'(-0.1) = %f",expression2.derivative().calculate(1)).println();
    }
}


