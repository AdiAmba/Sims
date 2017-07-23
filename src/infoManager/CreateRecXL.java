/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoManager;

import java.io.File;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;

/**
 *
 * @author Aditya
 */
public class CreateRecXL {
    File f;
    Workbook exist;
    WritableWorkbook myXL;
    WritableWorkbook myCopy;
    WritableSheet mySheet;
    Label[] head = new Label[10];
    Label[] lbl = new Label[8];
    String det[] = new String[8];
    Number[] nmb = new Number[2];
    Number c;
    String brand;
    int count=1;
    boolean t;

    CreateRecXL() {
        try {
            f = new File("F:\\Excel_Files\\StudentRec.xls");
            
            t=f.exists();
            if(f.exists()){
                System.out.println(f.exists());
                exist = Workbook.getWorkbook(f);
                count = read();
            }
            else{
                try{
                count=1;
                }
                catch(Exception e){}
            }
            try{
                 myXL = Workbook.createWorkbook(f);
            }
            catch(Exception e){}
            if(t==false){
                try{
            mySheet = myXL.createSheet("Sheet 1", 0);
                }
                catch(Exception e){}
            }
            else if(t==true){
                try{
            myXL = Workbook.createWorkbook(f, exist);
            mySheet = myXL.getSheet("Sheet 1");
                }
                catch(Exception e){}
            }
           head[9] = new Label(0,0,"Std ID"); 
           head[0] = new Label(1,0,"Name");
           head[1] = new Label(2,0,"D.O.B.");
           head[2] = new Label(3,0,"Father's Name");
           head[3] = new Label(4,0,"Mob. No.");
           head[4] = new Label(5,0,"Email ID");
           head[5] = new Label(6,0,"Course Name");
           head[6] = new Label(7,0,"Course ID");
           head[7] = new Label(9,0,"Fee");
           head[8] = new Label(8,0,"Fee Status");
            for (int i = 0; i < 10; i++) {
                mySheet.addCell(head[i]);
            }
        } catch (Exception e) {
        }

        
    }
    public int write(String det[], double fee){
        this.det = det;
        try{
           nmb[0] =new Number(0,count,count);
            for (int i = 0; i < 8; i++) {
                lbl[i]= new Label(i+1,count,this.det[i]);
                mySheet.addCell(lbl[i]);
            }
            nmb[1] = new Number(9,count,fee);
            mySheet.addCell(nmb[0]);
            mySheet.addCell(nmb[1]);
        } catch(Exception e){
        }
       
        int tmp= count;
        try{
            count++;
            c = new Number(0,100,count);
            mySheet.addCell(c);
            myXL.write();
            myXL.close();
            exist.close();
        }
        catch(Exception e){}
        return tmp;
    }
    public void fClose(){
        try{
             myXL.write();
            myXL.close();
            exist.close();
        } catch(Exception e){
        }
    }
    public int read(){
        int n = 2;
        try{
        Workbook myBook = Workbook.getWorkbook(f);
        Sheet sheet = myBook.getSheet("Sheet 1");
        Cell c1 = sheet.getCell(0,100);
        n=Integer.parseInt(c1.getContents());
        } catch(Exception e){
        }
        return n;
    }
    public static void main(String[] args) {
        CreateRecXL c= new CreateRecXL();
        
    }
}
