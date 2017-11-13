package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	ArrayList<Integer> buchstaben = new ArrayList<>();
	int factor = (int)Math.pow(26,4);
	for(int i = 0; i < 26; i++) {
	    buchstaben.add(i * factor);
    }
    int bereich1 = 6141468;
	int bereich2 = 6580867;
	for(int i : buchstaben) {
        if(i > bereich1 && i < bereich2) {
            System.out.println(i);
        }
    }
        System.out.println("BUCHSTABEN : ");
        for(int i : buchstaben) {
            System.out.println(i);
        }


    numberToWordParser.parser(6598443);
    }

}
