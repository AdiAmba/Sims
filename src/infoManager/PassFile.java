/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoManager;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author Aditya
 */
public class PassFile {

    private static String name = "F:\\StudentInfoMan\\StudentInfoManager\\src\\Resources\\pass.txt";
    String pass;

    public void write(String p) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(name);
            bw = new BufferedWriter(fw);
            bw.write(p);

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

    public String read() {
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
        return pass;
    }
}
