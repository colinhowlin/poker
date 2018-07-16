//Class to represent a deck of cards

import java.security.SecureRandom;

public class DeckOfCards {
    
    //instance variables
    private Card [] deck;       //array of card objects
    private int currentCard;    //next card to be dealt from the deck
    private static final int NUMBER_OF_CARDS = 52;  //total cards in deck
    
    //random number generator
    private static final SecureRandom rng = new SecureRandom();
    
    //constructor method
    public DeckOfCards() {
        String [] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String [] suits = { "Hearts", "Diamonds", "Clubs", "Spades"};
        
        //create an array of card objects
        deck = new Card[NUMBER_OF_CARDS];
        currentCard = 0;    //first card dealt will be deck[0]
        
        //populate deck with card objects
        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }
    }
    
    //method to shuffle deck of cards with one pass algorithm
    public void shuffle() {
        currentCard = 0;
        
        //for each card, pick another random card and swap them
        for (int first = 0; first < deck.length; first++) {
            //select random number between 0 and 51
            int second = rng.nextInt(NUMBER_OF_CARDS);
            
            //swap current card with randomly selected card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }
    
    //method to deal one card
    public Card dealCard() {
        if (currentCard < deck.length) 
            return deck[currentCard++];
        else 
            return null;    //return null to indicate all cards were dealt
    }
}