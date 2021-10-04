/*
 *  UCF COP3330 Fall 2021 Assignment 37 Solution
 *  Copyright 2021 Garrett Adams
 */

package Exercise37;

//Imports all java util
import java.util.*;

public class Solution37 {

    public static String PassWordFormation(int UserInputtedSpecialNum, int LengthOfPass,  int UserInputtedNumNum)
    {
        //Declares all the variables that we will need for PassWordFormation
        ArrayList<Character> PasswordArrayList = new ArrayList<Character>();
        String UserFinalPassword = "";
        String SetOfNumbers = "0123456789";
        String SetOfSpecials = "*@%!^$&#";
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        //Sets up our random
        Random RandomNum = new Random();


        //Loop that adds the special characters to the password
        {
            int i=0;
            while (i<UserInputtedSpecialNum) {
                // Adds a random special character to the password
                PasswordArrayList.add(SetOfSpecials.charAt(RandomNum.nextInt(SetOfSpecials.length())));
                //Adds 1 to i
                i = i + 1;
            }
        }

        //Loop that adds the numbers to the password
        {
            int i=0;
            while (i<UserInputtedNumNum) {
                //Adds a random number from the list the password
                PasswordArrayList.add(SetOfNumbers.charAt(RandomNum.nextInt(SetOfNumbers.length())));
                //Adds 1 to i
                i = i + 1;
            }
        }

        //Loop that adds letters to password
        {
            int i = PasswordArrayList.size() - 1;
            while (i < LengthOfPass) {
                // find random letter and add it to the list
                PasswordArrayList.add(Alphabet.charAt(RandomNum.nextInt(Alphabet.length())));
                //Adds 1 to i
                i = i + 1;
            }
        }

        // For loop that generates the final password
        for (int i = 0, temp = PasswordArrayList.size(); i < temp; i++) {
            Character temp1 = PasswordArrayList.get(i);
            UserFinalPassword = new StringBuilder().append(UserFinalPassword).append((temp1)).toString();
        }

        //Returns the full password
        return UserFinalPassword;
    }

    public static void main(String[] args)
    {
        //Declares our variables for main
        int MinimumLength;
        int NumOfSpecialCharacters;
        int SetOfNumbers;
        ArrayList<Character> PasswordArrayList = new ArrayList<Character>();
        String UserFinalPassword = "";
        String SetOfSpecials = "*@%!^$&#";
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        //Sets up our random
        Random RandomNum = new Random();
        //Sets up our scanner
        Scanner ScanWord = new Scanner(System.in);

        //Prompts user for input
        System.out.print("What is   the minimum length? ");
        //Scans user input to MinimumLength
        MinimumLength = ScanWord.nextInt();;

        //Prompts user for input
        System.out.print("How many special characters? ");
        //Scans user input to NumOfSpecialCharacters
        NumOfSpecialCharacters = ScanWord.nextInt();;

        //Prompts user for input
        System.out.print("How many  numbers? ");
        //Scans user input to SetOfNumbers
        SetOfNumbers = ScanWord.nextInt();;

        //Prints out the final password
        System.out.println("The password is " + PassWordFormation(NumOfSpecialCharacters, MinimumLength, SetOfNumbers));
    }
}

