package com.example.mttp2024.exceptions;

public class ExisteException extends Exception {
    String s;

    public ExisteException(String s) {
        this.s = s;
    }

    public String toString() {
        return s;
    }

}
