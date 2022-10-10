import java.util.*;

public class Card {  // a class for creating playing card objects
    private String faceName, suitName;  // fields of the Card object

    public Card(String faceName, String suitName) {  // Card constructor that takes a faceName and a suitName
        setFaceName(faceName);  // call the setFaceName method that checks for a valid faceName
        setSuitName(suitName);  // call the setSuitName method that checks for a valid suitName
    }

    public String getFaceName() {  // returns the face name of a Card object
        return faceName;
    }

    public static List<String> getValidFaceNames() {  //returns a list of valid face names
        return Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace");
    }

    public void setFaceName(String faceName) {  // sets the face name of a Card object
        List<String> validFaceNames = getValidFaceNames();  // get the list of valid face names
        if (validFaceNames.contains(faceName.toLowerCase())) {  // check the face name. allows "Jack" to match "jack"
            this.faceName = faceName;  // set the face name
        } else {  //throw an exception if the face name is not valid
            throw new IllegalArgumentException("Valid face names are " + validFaceNames);
        }
    }

    public String getSuitName() {  //returns the suit name of a card object
        return suitName;
    }

    public static List<String> getValidSuitNames() {  // returns the list of valid suit names
        return Arrays.asList("clubs", "diamonds", "hearts", "spades");
    }

    public void setSuitName(String suitName) {  // sets the suit name of a Card object
        List<String> validSuitNames = getValidSuitNames();  //  get the list of valid suit names
        if (validSuitNames.contains(suitName.toLowerCase())) {  //check the suit name. allows "Clubs" to match "clubs"
            this.suitName = suitName;   // sets the suit name
        } else {  // throw an exception if the suit name is not valid
            throw new IllegalArgumentException("Valid suit names are " + validSuitNames);
        }
    }

    public String toString() {  // returns the string representation of the object as "jack of diamonds"
        return String.format("%s of %s", faceName, suitName);
    }
}
