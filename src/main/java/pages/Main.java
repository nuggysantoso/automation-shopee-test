package pages;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Nuggy Santoso on 10/12/2018
 */
public class Main {
    public static void main(String[] args){
        int length = 1000;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        System.out.println(generatedString);
    }
}
