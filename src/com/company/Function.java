package com.company;

import java.text.NumberFormat;

/* інтерфейс функції */
public interface Function {
    double calculate(double x);

    Function derivative();

    String toPrettyString(NumberFormat nf);
}
