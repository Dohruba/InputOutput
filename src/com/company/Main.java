package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String someText = "I Love Fried Chicken \n";
        byte[] textAsByte = someText.getBytes();

        InputStream is = null;

        //Array von das was gelesen würde
        byte[] readBuffer = new byte[100];

        try {
            //File Finden oder erzäugen
            String filename = "testFile.txt";
            OutputStream os = new FileOutputStream(filename);

            //Drauf schreiben
            os.write(textAsByte);

            //File lesen
            is = new FileInputStream(filename);

            //readBuffer liest (und speichert in einem byte Array?) was in is FileInputStream ist
            is.read(readBuffer);

            //Aus dem Buffer ein String machen
            String readString = new String(readBuffer);
            System.out.println("read something: "  + readString);

            //DOS konvertiert verschiedene Datentypen in Bytes fürs OS zu schreiben auf File
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(42);
            dos.writeChars("\n");


            //
            DataInputStream dis = new DataInputStream(is);
            int readIntValue = dis.readInt();
            System.out.println("Read Integer: " + readIntValue);

            //PrintStreams
            PrintStream ps = new PrintStream(os);
            ps.println("Hello \n PStreams");

            //die Bytes gelesen von is werden an isr abgegeben, der die bytes in char konvertiert
            //Dann br nimm diese Charachteren und liest sie bis zum Ende der Linie
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            readString = br.readLine();
            System.out.println("read: " + readString);

            //

            System.out.println("Bitte was eingeben");
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr); //Referenz zu isr
            readString = br.readLine(); //Befehl an br, was er mit dder Charakteren con isr machen soll
            System.out.println("las: " + readString);


        } catch (FileNotFoundException ex) {
            System.err.println("Couldn´t open file - fatal");
            System.exit(0); //Brutal exception handling
            //Für´s erzäugen, finden oder drauf schreiben, man muss das File finden
        } catch (IOException ex) {
            System.err.println("Couldn´t write Data(Fatal)");
            System.exit(0);
        } /*catch (IOException ex){
            System.err.println("Couldn´t read data (fatal)");
            System.exit(0);
        }*/



    }

}
