package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int randomNumber;
    private static int score = 2;
    
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};
    private static String strComputerHelp = "";
    private static int letter = 0;

    public static void main(String[] args) {

        System.out.println("\nПоиграть в угадайку чисел, нажмите 1, если хотите поиграть в угадайку слов, то нажмите 2");
        Scanner scanner = new Scanner(System.in);
        int games = scanner.nextInt();
        if (games == 1){
            taskFirst();
            scanner.close();
        } else {
            taskSekond();
            scanner.close();
        }

    }

    private static void taskFirst(){
        firstMSG();
        createRandomNamber();
        task1();
    }

    private static void taskSekond(){

        int wordsComputer = createWords();

        System.out.println("Я загадал слово, попробуйте отгадать...");
        System.out.println(Arrays.toString(words));

        answerMathod(wordsComputer);
    }

    private static void answerMathod(int wordsComputer) {
        Scanner scanner = new Scanner(System.in);
        String userWords = scanner.next();
        if (userWords.equals(words[wordsComputer])) {
            System.out.println("Вы победили!\n Правильный ответ: "
                    + words[wordsComputer]);
        } else {
            lookBook(userWords, wordsComputer);
        }

    }

    private static void lookBook(String userWords, int wordsComputer){
        try {
            char a = words[wordsComputer].charAt(letter);
            char b = userWords.charAt(letter);

        if (a == b){
            strComputerHelp = strComputerHelp + a;
            letter++;
            lookBook(userWords, wordsComputer);
        } else {
            System.out.println(strComputerHelp + "###############");
            answerMathod(wordsComputer);
        }
        } catch (Exception e) {
            System.out.println(strComputerHelp + "###############");
            answerMathod(wordsComputer);}
    }

    private static int createWords() {
        Random random = new Random();
        return random.nextInt(26);
    }

    private static void task1() {

        int userNamber = scanner.nextInt();

        if (userNamber == randomNumber){
            System.out.println("Вы угадали!!! \n Правильный ответ: " + randomNumber);
            finishGames();
        } else if (score == 0){
            System.out.println("Вы потратили все попытки, игра окончена.\nЗагаданное число было - " + randomNumber);
            finishGames();
        } else if (userNamber > randomNumber){
            System.out.printf("Ваше число слишком большое, попробуйте ввести поменьше \n Осталось %s попытки(а) \n", score);
            score--;
            task1();
        } else {
            System.out.printf("Ваше число слишком маленькое, попробуйте ввести побольше \n Осталось %s попыткаи(а) \n", score);
            score--;
            task1();
        }
    }

    private static void firstMSG(){
        System.out.println("\n Попробуйте угадать загаданное число от 0 до 9. \n Введите число от 0 до 9");
    }

    private static void createRandomNamber() {
        Random random = new Random();
        randomNumber = random.nextInt(10);
    }

    private static void finishGames(){
        System.out.println("Попробовть снова? \n 1 – да / 0 – нет");
        int gamesNew = scanner.nextInt();
        if (gamesNew == 1){
            score = 2;
            firstMSG();
            createRandomNamber();
            task1();
        } else {
            scanner.close();
            System.out.println("Спасибо за игру. Досвидания!");
        }
    }
}
