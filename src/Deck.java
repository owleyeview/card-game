import java.util.*;

public class Deck {  // a class for creating deck objects for use in different games
    private Stack<Card> deck;  // field variable of each Deck object is a Stack of Card objects

    public Deck(Stack<Card> deck) {  // 1 argument constructor for passing custom deck contents
        this.deck = deck;
    }

    public Deck() {  // 0 argument constructor creates a standard 52 card deck
        List<String> suits = Card.getValidSuitNames(); //gets the list of valid suit names
        List<String> faceNames = Card.getValidFaceNames(); //gets the list of valid face names
        deck = new Stack<>();
        // nested for/each loops
        for (String suit : suits) {  // for each suit in the list of suits
            for (String faceName : faceNames) {  // for each face name in the list of face names
                deck.push(new Card(faceName, suit)); //create a new card for each suit and face name
            }
        }
    }

    // returns true if there are any cards in the deck
    public boolean hasCards() {
        if (deck.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    // returns a Deck object
    public Stack<Card> getDeck() {
        return deck;
    }

    // assigns a Stack of Card objects to the deck
    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }

    // returns the top card in the deck
    public Card getTopCard() {
        return deck.pop();
    }

    // method for shuffling a Deck object
    public void shuffle() {
        Collections.shuffle(deck);  // Java library shuffle method

//        int deckSize = deck.size();
//        Queue<Card> cut = new LinkedList<Card>();
//        Stack<Card> shuffledDeck = new Stack<Card>();
//        for (int i = 0; i < deckSize/2; i++) {
//            cut.add(deck.pop());  // 'Cuts' half the deck off the top.  I want to add some randomness to the size of this Queue
//        }
//        while (!deck.isEmpty() && !cut.isEmpty()) {  // This stacks the shuffledDeck with one card from each half of the original deck. Some randomness is needed here too
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
