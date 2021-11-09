package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person [] tabel = new Person[20];
        for (int i = 0; i < 20; i++) {
            tabel[i] = new Person();
        }
        int antalPersoner;
        antalPersoner = laesTxtFil(tabel);
        udskriv(tabel, antalPersoner);
        skrivDatFil(tabel, antalPersoner);
        antalPersoner = laesDatFil(tabel);
        udskriv(tabel, antalPersoner);
        skrivObjFil(tabel, antalPersoner);
        antalPersoner = laesObjFil(tabel);
        udskriv(tabel, antalPersoner);
    }

    static int laesTxtFil(Person [] a) {
        int i = 0;
        try {
            File nyFil = new File("NewFile.txt");
            Scanner ind = new Scanner(nyFil);
            while (ind.hasNext()) {
                a[i].setAlder(ind.nextInt());
                a[i].setNavn(ind.next());
                a[i].setTal(ind.nextDouble());
                i++;
            }
            ind.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void udskriv (Person [] a, int antal) {
        for (int i = 0; i < antal; i++) {
            System.out.format("%d %s %f \n", a[i].getAlder(), a[i].getNavn(), a[i].getTal());
        }
    }

    public static void skrivDatFil(Person [] a, int antal) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("PersonDatFil.dat"));
            for (int i = 0; i < antal; i++) {
                out.writeInt(a[i].getAlder());
                out.writeUTF(a[i].getNavn());
                out.writeDouble(a[i].getTal());
            }
            out.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int laesDatFil(Person[] a) {
        int i = 0;
        try{
            DataInputStream in = new DataInputStream(new FileInputStream("PersonDatFil.dat"));
            while (in.available() > 0) {
                a[i].setAlder(in.readInt());
                a[i].setNavn(in.readUTF());
                a[i].setTal(in.readDouble());
                i++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void skrivObjFil (Person[] a, int antal) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("PersonSerFil.ser"));
            for (int i = 0; i < antal; i++) {
                out.writeObject(a[i]);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int laesObjFil (Person[] a) {
        int i = 0;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("PersonSerFil.ser"));
            while (in.available() > 0) {
                a[i] = (Person) in.readObject();
                i++;
            }
            in.close();
            System.out.println("Hej.");
            udskriv(a,4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


        /*public static void skrivTilFil(Person p) {
        try {
            PrintWriter ud = new PrintWriter("NewPerson.txt");
            ud.format("%d %s %.3f", p.getAlder(), p.getNavn(), p.getTal());
            ud.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void skrivFil() {
        try {
            PrintWriter ud = new PrintWriter("NewFile.txt");
            int i = 1;
            String navn = "Pernille";
            float tal = (float) 10.5;
            ud.format("%d %s %.3f", i, navn, tal);
            ud.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void datFil() {
        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("Newdatfil"));
            int i = 1;
            String navn = "Pernille";
            float tal = (float) 10.5;
            output.writeInt(i);
            output.writeUTF(navn);
            output.writeFloat(tal);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void laesDatFil () {
        try {
            DataInputStream input = new DataInputStream(new FileInputStream("Newdatfil"));
            int i;
            String navn;
            float tal;
            i = input.readInt();
            navn = input.readUTF();
            tal = input.readFloat();
            System.out.format("%d %s %f \n", i, navn, tal);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
         */
}