package edu.csudh.figueroa.datastructures.project;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random(); // to determine the number of cut and shuffles
        random.setSeed(System.currentTimeMillis());

        GameManager newGame = new GameManager(random.nextInt(100+2));





    }
}
