/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

import hw6.ID;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author User
 */
public class IDChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException {

        ID idVer = new ID();

        URL path = IDChecker.class.getResource("input.txt");
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter cfw = null;
        FileWriter efw = null;
        BufferedWriter cbw = null;
        BufferedWriter ebw = null;
        File inF, cF, eF = null;
        if(path == null){
            System.out.println("File not found.");
        } else {
            try {
                inF = new File(path.toURI());
                fr = new FileReader(inF);
                br = new BufferedReader(fr);
                
                String cLine;
                cF = new File("correct.txt");
                eF = new File("error.txt");
                if(!cF.exists()) cF.createNewFile();
                if(!eF.exists()) eF.createNewFile();
                cfw = new FileWriter(cF, false);
                cbw = new BufferedWriter(cfw);
                efw = new FileWriter(eF, false);
                ebw = new BufferedWriter(efw);
                while(br.ready()){
                    cLine = br.readLine();
                    System.out.println(cLine);
                    try {                       
                        idVer.check(cLine);
                        if(ID.CORRECT){
                            cbw.write(cLine + ",\t" + idVer.check(cLine));
                            cbw.newLine();
                        } else {
                            ebw.write(cLine + ",\t" + idVer.check(cLine));
                            ebw.newLine();
                        }
                    } catch (IOException ew) {
                        ew.printStackTrace();
                    }
                }
                cbw.close();
                ebw.close();
                cfw.close();
                efw.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        

    }
}
