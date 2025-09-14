/*
# Programmers:  Sofia CB
# Course:  CS212
# Due Date: 2/13/25
# Assignment: 1
# Problem Statement: This program simulates the card game War
# Data In: User's choice skip/play
# Data Out:  the card game, including cards and scores
# Credits: N/A
*/


import java.util.Scanner;
public class Main{

    //Checks user input to make sure they input a 1 or a 2
    //parameters: s, the user's input
    //return: validated input as a string
    public static String checkInput(String s){

        Scanner input = new Scanner(System.in);

        while(!(s.trim().equals("1") || s.trim().equals("2"))){
            System.out.println("Please enter 1 or 2");
            s = input.next();
        }

        return s;
    }


    public static void main(String[] args) {

        //initializing variables
        System.out.println("Welcome to War!");
        int round = 0;
        int userScore = 0;
        int computerScore = 0;
        int skips = 2;

        //playing the game
        do{
            //current score and round is outputted every round
            System.out.println("---------------------");
            System.out.println("Score: Player " + userScore + " - " + computerScore + " Computer");
            System.out.println("Round " + round + ":");

            //player and computer get a new card
            Card userCard = new Card(1);
            Card computerCard = new Card(2);

            System.out.println("Player: " + userCard);
            System.out.println("Computer: " + computerCard);

            //user's choice
            System.out.println("Type 1 to play. Type 2 to skip. Skips remaining: " + skips);

            Scanner input = new Scanner(System.in);
            String temp = checkInput(input.next());//checks that user inputs a 1 or a 2

            int choice = Integer.parseInt(temp);

            //plays user's card if they choose to or automatically if they're out of skips
            if(choice == 1 || skips <= 0){

                //runs only if user has no skips left but still chose skip
                if (choice == 2){
                    System.out.println("You have no skips remaining. Playing your card.");
                }

                //makes computer's card not hidden
                Card.changeStatus(computerCard);

                System.out.println("Player: " + userCard);
                System.out.println("Computer: " + computerCard);


                if(Card.compareCards(userCard, computerCard) == 1){//user wins

                    System.out.println("Your card wins!");
                    userScore ++;

                }else if (Card.compareCards(userCard, computerCard) == 2){//computer wins
                    System.out.println("Computer wins. :/");
                    computerScore ++;
                }else{
                    System.out.println("Tie");//tie
                }

            //if user chooses 2 and they do have skips left
            }else{
                skips--;

            }

            round ++;

        }while(userScore < 5 && computerScore < 5); //when user or computer reaches score of 5 game over

        System.out.println("Final Score: Player " + userScore + " - " + computerScore + " Computer");

        //checking who won
        if(userScore > computerScore){
            System.out.println("Congratulations! You won this match. Thanks for playing.");
        }else{
            System.out.println("Sorry, the computer won this match. Thanks for playing.");
        }
    }
}
