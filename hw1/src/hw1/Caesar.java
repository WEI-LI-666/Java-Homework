/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

/**
 *
 * @author B10409009
 */
public class Caesar {

    private String plaintext;
    private String cyphertext = "";
    private int key;
    private String encryptList = "qwertyuiopasdfghjklzxcvbnm";

    public Caesar(String plaintext, int key) {
        this.plaintext = plaintext.toLowerCase();
        this.key = key;
    }

    public void setCyphertext(String cyphertext) {
        this.cyphertext = cyphertext;
    }

    public void encrypt() {
        
        //use StringBuilder to append character to @cyphertext to be more efficient
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            int offset = encryptList.indexOf(ch) + key;
            //convert plaintext to cyphertext
            //make sure offset won't overflow
            if (offset > encryptList.length() - 1) {
                stringBuilder.append(encryptList.charAt(offset - encryptList.length()));
            } else if(offset < 0){
                stringBuilder.append(encryptList.charAt(offset + encryptList.length()));
            } else{
                stringBuilder.append(encryptList.charAt(offset));
            }
        }
        cyphertext = stringBuilder.toString();
    }

    public String getCyphertext() {
        return cyphertext;
    }

}
