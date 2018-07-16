/**
 * A class implementing a deck of 52 playing cards
 * @author Colin Howlin
 * @version 1.0
 */
 
import java.security.SecureRandom;

public class Deck{
    //instance variables
    private static final int NUMBER_OF_CARDS = 52;
    private Card[] deck;
    public int currentCard;
    
    //random number generator
    private static final SecureRandom rng = new SecureRandom();
    
    //constructor method
    public Deck(){
        deck = new Card[NUMBER_OF_CARDS];
        currentCard = 0;
        
        for (int i =0; i < deck.length; i++){
            deck[i] = new Card(i / 13, i % 13);
        }
    }
    
    //method to shuffle the deck
    public void shuffle(){
        currentCard = 0;
        Card temp;
        for (int first = 0; first < deck.length; first++){
            int second = rng.nextInt(NUMBER_OF_CARDS);
            temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }
    
    //method to deal one card
    public Card dealCard(){
        if (currentCard < deck.length){
            return deck[currentCard++];
        }else{
            return null;    //return null if all cards have been dealt
        }
    }
	
	//method to deal a hand
	public Card[] dealHand(int handSize){
		Card[] hand = new Card[handSize];
		for (int i = 0; i < handSize; i++){
			hand[i] = dealCard();
		}
		
		return hand;
	}
	
	//method to print a hand
	public void printHand(Card[] hand){
		for (Card card : hand){
			System.out.printf("%s, ",card);
		}
	}
}