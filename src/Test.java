public class Test {
    public static void main(String[] args) {
        Card card1 = new Card("jack", "spades");
        System.out.println(card1);
        Deck deck1 = new Deck();
        System.out.println(deck1);
        System.out.println(deck1.getTopCard());
        deck1.shuffle();
        System.out.println(deck1);
        System.out.println(deck1.getTopCard());
    }
}
