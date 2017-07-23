/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoManager;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.write.Number;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author Aditya
 */
public class CheckStatusXL {

    File f;
    Workbook exist;
    WritableWorkbook myXL;
    WritableWorkbook myCopy;
    WritableSheet mySheet;
    Cell[] arr = new Cell[10];
    Cell search;
    String info[] = new String[10];
    Label[] head = new Label[10];
    Label[] lbl = new Label[8];
    String det[] = new String[8];
    Number nmb;

    String brand;
    int count;
    boolean t;

    public CheckStatusXL() {
        try {
            f = new File("F:\\Excel_Files\\StudentRec.xls");

        } catch (Exception e) {
        }

    }

    public void write(String feeStat, double fee, int pos) {
        try {
            try {
                exist = Workbook.getWorkbook(f);
            } catch (Exception e) {
            }

            try {
                myXL = Workbook.createWorkbook(f, exist);
                mySheet = myXL.getSheet("Sheet 1");
                lbl[0] = new Label(8,pos,feeStat);
                nmb = new Number(9, pos, fee);
                mySheet.addCell(nmb);
                mySheet.addCell(lbl[0]);
            } catch (Exception e) {
            }

            myXL.write();
            myXL.close();
            exist.close();
        } catch (Exception e) {
        }

    }

    public void read(int Id) {
        count = Id;
        try {
            Workbook myBook = Workbook.getWorkbook(f);
            Sheet sheet = myBook.getSheet("Sheet 1");
            Cell c1 = sheet.getCell(0, 100);
            int l = Integer.parseInt(c1.getContents());
            System.out.println(l);
            arr[0] = sheet.getCell(1, Id);
            info[0] = arr[0].getContents();
            arr[1] = sheet.getCell(2, Id);
            info[1] = arr[1].getContents();
            arr[2] = sheet.getCell(3, Id);
            info[2] = arr[2].getContents();
            arr[3] = sheet.getCell(4, Id);
            info[3] = arr[3].getContents();
            arr[4] = sheet.getCell(5, Id);
            info[4] = arr[4].getContents();
            arr[5] = sheet.getCell(6, Id);
            info[5] = arr[5].getContents();
            arr[6] = sheet.getCell(7, Id);
            info[6] = arr[6].getContents();
            arr[7] = sheet.getCell(8, Id);
            info[7] = arr[7].getContents();
            arr[8] = sheet.getCell(9, Id);
            info[8] = arr[8].getContents();
//                 arr[9] = sheet.getCell(10,Id);
//                info[9] = arr[9].getContents();
            new StudentStatus(info, Id).setVisible(true);
            myBook.close();
        } catch (BiffException e) {
            System.out.println("Stopped");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CheckStatusXL c = new CheckStatusXL();
        c.read(1);
    }
}
