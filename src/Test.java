public class Test {   // a class for testing purposes
    public static void main(String[] args) {
        Card card1 = new Card("jack", "spades");
        System.out.println(card1);
        System.out.println(card1.getFaceName());
        System.out.println(card1.getSuitName());
        Deck deck1 = new Deck();
        System.out.println(deck1);
        System.out.println(deck1.seeTopCard()); // display the top card
        deck1.shuffle();  // shuffle deck1
        System.out.println(deck1);
        System.out.println(deck1.seeTopCard());  // display the top card of the deck after shuffling
         // remove the top card
    }
}
