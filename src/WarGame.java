//made by Cece, Derek, Rashaan, Brian, and Nathan

import java.util.*;

import static java.util.Collections.shuffle;

// our game of war
public class WarGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numGames = 0;
        int numWins = 0;
        intro();
        char playing;
        do {
            numGames++;
            int thisGame = game();  // plays a game and returns 1 if the game is won, 0 otherwise
            if (thisGame == 1) {
                System.out.println();
                System.out.println("********** YOU WIN!!! **********");
            } else {
                System.out.println();
                System.out.println("---------- you have lost ----------");
            }
            numWins += thisGame;  // tallys the number of wins
            System.out.println("          ......Hungry for more?");
            playing = scan.next().charAt(0);
        } while (playing == 'y' || playing == 'Y');
        System.out.printf("You won %d out of %d games", numWins, numGames);
    }

    // plays one game, returns 1 if the player won, returns 0 if the player lost
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
            if (playerStack.isEmpty()) {  // checking if the discard stacks need to be shuffled in
                playerStack = shuffleIn(playerStack, playerWinStack);
                if (playerStack.isEmpty()) {
                    return 0;
                }
            }
            if (opponentStack.isEmpty()) {
                opponentStack = shuffleIn(opponentStack, opponentWinStack);
                if (opponentStack.isEmpty()) {
                    return 1;
                }
            }
            playerBattleStack.push(playerStack.pop());  // flipping cards
            opponentBattleStack.push(opponentStack.pop());
            System.out.format("Your %s of %s vs their %s of %s%n",  // display what cards are battling
                        playerBattleStack.peek().getFaceName(), playerBattleStack.peek().getSuitName(),
                        opponentBattleStack.peek().getFaceName(), opponentBattleStack.peek().getSuitName());
            int battleResult = compare(playerBattleStack.peek(), opponentBattleStack.peek());  // determine the winner
            if (battleResult == 1) {  // the player wins
                System.out.format("*****  Your %s of %s wins!%n", playerBattleStack.peek().getFaceName(),
                                                            playerBattleStack.peek().getSuitName());
                while (!playerBattleStack.isEmpty()) { // the cards on the table go to the player
                    playerWinStack.push(playerBattleStack.pop());
                }
                while (!opponentBattleStack.isEmpty()) {
                    playerWinStack.push(opponentBattleStack.pop());
                }
            } else if (battleResult == 2) {  //  the opponent wins
                System.out.format("       Their %s of %s wins!  *****%n", opponentBattleStack.peek().getFaceName(),
                                                                opponentBattleStack.peek().getSuitName());
                while (!playerBattleStack.isEmpty()) {  // the cards on the table go to the opponent
                    opponentWinStack.push(playerBattleStack.pop());
                }
                while (!opponentBattleStack.isEmpty()) {
                    opponentWinStack.push(opponentBattleStack.pop());
                }
            } else if (battleResult == 0) {  // the cards have the same value
                System.out.println("       Tie! It's a flippin war!");
                System.out.println("     *****     *****     *****");
                for (int i = 0; i < 3; i++) {  // both players flip 3 cards onto the table
                    if (playerStack.isEmpty()) {  // checking if the discard stacks need to be shuffled in
                        playerStack = shuffleIn(playerStack, playerWinStack);
                        if (playerStack.isEmpty()) {  // if the play stack is still empty after including the discard stack, the game is over
                            return 0;
                        }
                    }
                    if (opponentStack.isEmpty()) {
                    opponentStack = shuffleIn(opponentStack, opponentWinStack);
                        if (opponentStack.isEmpty()) {  // if the play stack is still empty after including the discard stack, the game is over
                            return 1;
                        }
                    }
                    playerBattleStack.push(playerStack.pop());    // flipping cards into the war 3x
                    opponentBattleStack.push(opponentStack.pop());
                }
            }
        // continue playing while no player has all the cards
        } while (playerStack.size() + playerWinStack.size() < 52 && opponentStack.size() + opponentWinStack.size() < 52);
        if (playerStack.size() >= 52) {  // the player has all the cards
            return 1;  // win count goes up
        } else if (opponentStack.size() >= 52) {  // the opponent has all the cards
            return 0;
        } else {
            return 0;
        }
    }

    // given 2 Stacks of cards, the stack of won cards is shuffled into the play stack and returned
    public static Stack<Card> shuffleIn(Stack<Card> playStack, Stack<Card> winStack) {
        while (!winStack.isEmpty()) {
            playStack.push(winStack.pop());
        }
        shuffle(playStack);
        return playStack;
    }

    // introduces the player to the game
    public static void intro() {
        System.out.println("Welcome to War");
        System.out.println("This is not a game");
        System.out.println("See you on the battlefield");
        System.out.println();
        System.out.println("--press the return key to flip cards--");
    }

    // given a Card object, returns an int value
    public static int valueAssign(Card card) {
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

    // given 2 Cards, compares them and returns an int value indicating which one is higher of if they are equal
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
