package com.company;

public class Person implements java.io.Serializable {
    private int alder;
    private String navn;
    private double tal;

    public Person() {
    }

    public Person(int alder, String navn, double tal) {
        this.alder = alder;
        this.navn = navn;
        this.tal = tal;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getTal() {
        return tal;
    }

    public void setTal(double tal) {
        this.tal = tal;
    }
}