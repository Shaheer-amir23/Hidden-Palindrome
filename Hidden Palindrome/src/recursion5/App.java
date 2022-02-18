package recursion5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String sentence, reverse, pals = "", longest = "";
        int i = 0, j = 0;
        System.out.print("Enter A Sentence: ");
        sentence = input.nextLine();
        reverse = new StringBuffer(sentence).reverse().toString();
        palindrome(sentence, reverse, pals, i, j, longest);
    }

    public static void palindrome(String sentence, String reverse, String pals, int i, int j, String longest) {
        if (j <= sentence.length()) {
            pals = sentence.substring(i, j);
            reverse = new StringBuffer(pals).reverse().toString();
            if (pals.replaceAll(" ", "").toLowerCase().equals(reverse.replaceAll(" ", "").toLowerCase())
                    && pals.replaceAll(" ", "").length() > longest.length()) {
                longest = pals;
            }
            j++;
            palindrome(sentence, reverse, pals, i, j, longest);
        } 
        else if (i < sentence.length()) {
            i++;
            j = i + 1;
            palindrome(sentence, reverse, pals, i, j, longest);
        }
        if (i == sentence.length() - 1) {
            if (longest.length() > 1) {
                    System.out.println("The Longest Palindrome is: " + longest.trim());
                    System.exit(0);

            } else {
                System.out.println("There is no Palindrome.");
                System.exit(0);
            }
        }
    }
}