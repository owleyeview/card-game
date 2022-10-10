import java.util.*;

public class Card {
    private String faceName, suitName;

    public Card(String faceName, String suitName) {
        setFaceName(faceName);
        setSuitName(suitName);
    }

    public String getFaceName() {
        return faceName;
    }

    public static List<String> getValidFaceNames() {
        return Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace");
    }

    public void setFaceName(String faceName) {
        List<String> validFaceNames = getValidFaceNames();
        if (validFaceNames.contains(faceName.toLowerCase())) {
            this.faceName = faceName;
        } else {
            throw new IllegalArgumentException("Valid face names are " + validFaceNames);
        }
    }

    public String getSuitName() {
        return suitName;
    }

    public static List<String> getValidSuitNames() {
        return Arrays.asList("clubs", "diamonds", "hearts", "spades");
    }

    public void setSuitName(String suitName) {
        List<String> validSuitNames = getValidSuitNames();
        if (validSuitNames.contains(suitName.toLowerCase())) {
            this.suitName = suitName;
        } else {
            throw new IllegalArgumentException("Valid suit names are " + validSuitNames);
        }
    }

    public String toString() {
        return String.format("%s of %s", faceName, suitName);
    }
}
