import java.util.*;

public class Deck {
    private Stack<Card> deck;

    public Deck(Stack<Card> deck) {
        this.deck = deck;
    }

    public Deck() {
        List<String> suits = Card.getValidSuitNames();
        List<String> faceNames = Card.getValidFaceNames();
        deck = new Stack<>();
        for (String suit : suits) {
            for (String faceName : faceNames) {
                deck.push(new Card(faceName, suit));
            }
        }
    }

    public Card getTopCard() {
        return deck.pop();
    }
    public void shuffle() {
        Collections.shuffle(deck);
//        int deckSize = deck.size();
//        Queue<Card> cut = new LinkedList<Card>();
//        Stack<Card> shuffledDeck = new Stack<Card>();
//        for (int i = 0; i < deckSize/2; i++) {
//            cut.add(deck.pop());
//        }
//        while (!deck.isEmpty() && !cut.isEmpty()) {
//            shuffledDeck.push(deck.pop());
//            shuffledDeck.push(cut.remove());
//        }
//        while (!deck.isEmpty() || !cut.isEmpty()) {
//            if (!deck.isEmpty()) {
//                shuffledDeck.push(deck.pop());
//            } else if (!cut.isEmpty()) {
//                shuffledDeck.push(deck.pop());
//            }
//        }
//        deck = shuffledDeck;
    }
}
