package com.dylan.toollamda.beans.lambda;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;

public class MyLambda {

    public static void main(String[] args) {
        Callable<String> c = () -> "done";

        PrivilegedAction<String> a = () -> "done";


    }
}
