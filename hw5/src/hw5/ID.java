/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.util.regex.*;
import java.util.stream.IntStream;

/**
 *
 * @author User
 */
public class ID {

    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String[] region = {"Taipei City", "Taichung City", "Keelung City", "Tainan City",
        "Kaohsiung City", "Taipei County", "Yilan County", "Taoyuan County",
        "ChiaYi City", "Hsinchu County", "Miaoli County", "Taichung County",
        "Nantou County", "Changhua County", "Hsinchu City", "Yunlin County",
        "Chiayi County", "Tainan County", "Kaohsiung County", "Pingtung County",
        "Huaien County", "Taitung County", "Kinmen County", "Penghu County",
        "Yangmingshan Administrative Bureau", "Lienchiang County"};
    private final int[] num = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};

    public void check(String id) {
        Pattern p = Pattern.compile("[A-Z][1-2]\\d{8}");    //regex
        Matcher m = p.matcher(id);

        if (m.matches() && decrypt(id)) {
            System.out.println("Correct ID!");
            int reg = alphabet.indexOf(id.charAt(0));
            int gender = Integer.parseInt("" + id.charAt(1));
            System.out.printf("The %s friend born in %s \n\n", (gender == 1) ? "male" : "female", region[reg]);
        } else if (m.matches() && !decrypt(id)) {
            System.out.println("Wrong ID!\n");
        } else {
            System.out.println("Wrong Fromat!\n");
        }
    }

    /**
     *
     * @param id ID
     * @return true if sum is divisible by 10
     */
    public boolean decrypt(String id) {
        int sum = 0;
        for (int i : IntStream.range(0, id.length()).toArray()) { // i from 0 to 9
            int pos = alphabet.indexOf(id.charAt(i));
            if (i == 0) {
                sum += num[pos] / id.length() + num[pos] % id.length() * 9;
            } else if (i != 0 && i != id.length() - 1) {
                sum += ((id.length() - 1) - i) * Integer.parseInt("" + id.charAt(i));
            } else if (i != 0 && i == id.length() - 1) {
                sum += Integer.parseInt("" + id.charAt(i));
            }
        }
        return sum % 10 == 0;
    }
}
