//class for card object

public class Card {
    
    //instance variables to represent face and suit of card
    private final String face;
    private final String suit;
    
    //constructor method
    public Card (String face, String suit) {
        this.face = face;
        this.suit = suit;
    }
    
    //method to return string representation of card.
    public String toString () {
        return face + " of " + suit;
    }
}