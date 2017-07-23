/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aditya
 */
public class MainClass {

    private static String name = "F:\\StudentInfoMan\\StudentInfoMAnager\\src\\Resources\\times.txt";
    String pass;
    int check;

    public void write() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            int times = 1;

            fw = new FileWriter(name);
            bw = new BufferedWriter(fw);
            bw.write(String.valueOf(times));

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }

    public int read() {
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(name);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(name));

            while ((sCurrentLine = br.readLine()) != null) {
                pass = sCurrentLine;
            }
            check = Integer.parseInt(pass);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return check;
    }

    public static void main(String[] args) {
        MainClass o = new MainClass();
        int times = o.read();
        if (times == 0) {
            times++;
            o.write();
            new SetPass().setVisible(true);
        } else {
            new Security().setVisible(true);
        }
    }
}
