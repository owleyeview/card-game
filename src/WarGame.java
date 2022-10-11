//made by Cece, Derek, Rashaan, Brian, and Nathan

import java.util.*;


public class WarGame {//our game of war

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numGames = 0;
        int numWins = 0;
        intro();
        char playing;
        do {
            numGames++;
            int thisGame = game();  // plays a game and returns 1 if the game is won, 0 otherwise
            numWins += thisGame;  // tallys the number of wins
            System.out.println("Hungry for more?");
            playing = scan.next().charAt(0);
        } while (playing == 'y' || playing == 'Y');
        System.out.printf("You won %d out of %d games", numWins, numGames);
    }

    public static int game() {
        Scanner s = new Scanner(System.in);
        Deck deck = new Deck();//makes deck
        deck.shuffle();
        Stack<Card> playerStack = new Stack<Card>();//main play stacks
        Stack<Card> opponentStack = new Stack<Card>();
        Stack<Card> playerBattleStack = new Stack<Card>();//"center of table" battlefield
        Stack<Card> opponentBattleStack = new Stack<Card>();//could be considered "in play" too
        Stack<Card> playerWinStack = new Stack<Card>();//win piles
        Stack<Card> opponentWinStack = new Stack<Card>();

        while (deck.hasCards()) { // deal the cards
            playerStack.push(deck.getTopCard());  // players cards
            opponentStack.push(deck.getTopCard());  // opponents cards
        }
        do {
            try {System.in.read();}  // wait for press of the return key
            catch(Exception e) {}
            playerBattleStack.push(playerStack.pop());  // flipping cards
            opponentBattleStack.push(opponentStack.pop());
            System.out.format("Your %s of %s vs their %s of %s%n",  // display what cards are battling
                        playerBattleStack.peek().getFaceName(), playerBattleStack.peek().getSuitName(),
                        opponentBattleStack.peek().getFaceName(), opponentBattleStack.peek().getSuitName());
            int battleResult = compare(playerBattleStack.peek(), opponentBattleStack.peek());  // determine the winner
            if (battleResult == 1) {  // the player wins
                System.out.format("Your %s of %s wins!%n", playerBattleStack.peek().getFaceName(),
                                                            playerBattleStack.peek().getSuitName());
                while (!playerBattleStack.isEmpty()) { // the cards on the table go to the player
                    playerWinStack.push(playerBattleStack.pop());
                }
                while (!opponentBattleStack.isEmpty()) {
                    playerWinStack.push(opponentBattleStack.pop());
                }
            } else if (battleResult == 2) {  //  the opponent wins
                System.out.format("Their %s of %s wins!%n", opponentBattleStack.peek().getFaceName(),
                                                                opponentBattleStack.peek().getSuitName());
                while (!playerBattleStack.isEmpty()) {  // the cards on the table go to the opponent
                    opponentWinStack.push(playerBattleStack.pop());
                }
                while (!opponentBattleStack.isEmpty()) {
                    opponentWinStack.push(opponentBattleStack.pop());
                }
            } else if (battleResult == 0) {  // the cards have the same value
                System.out.println("Tie! It's a flippin war!");
                for (int i = 0; i < 3; i++) {  // both players flip 3 cards onto the table
                    playerBattleStack.push(playerStack.pop());
                    opponentBattleStack.push(opponentStack.pop());
                }
            }
        } while (playerStack.size() < 52 && opponentStack.size() < 52);
        if (playerStack.size() >= 52) {
            return 1;
        } else if (opponentStack.size() >= 52) {
            return 0;
        } else {
            return 0;
        }
    }



    public static void intro() {
        System.out.println("Welcome to War");
        System.out.println("This is not a game");
        System.out.println("See you on the battlefield");
        System.out.println();
        System.out.println("--press the return key to flip cards--");
    }
    public static int valueAssign(Card card) {  // assigns rank value to card
        int value;
        if (card.getFaceName().equals("jack")) {
            value = 11;

        } else if (card.getFaceName().equals("queen")) {
            value = 12;

        } else if (card.getFaceName().equals("king")) {
            value = 13;

        } else if (card.getFaceName().equals("ace")) {
            value = 14;

        } else {
            value = Integer.parseInt(card.getFaceName());

        }
        return value;
    }

    public static int compare(Card card1, Card card2) {
        int cardValue1 = valueAssign(card1);
        int cardValue2 = valueAssign(card2);
        if (cardValue1 > cardValue2) {
            return 1;
        } else if (cardValue2 > cardValue1) {
            return 2;
        } else {
            return 0;

        }
    }
}
