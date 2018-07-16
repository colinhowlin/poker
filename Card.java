/**
 * A class implementing a playing card
 * @author Colin Howlin
 * @version 1.0
 */

public class Card{
    //instance variables
    private int suit;
    private int rank;
	private static final String [] ranks = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
    private static final String [] suits = { "Hearts", "Diamonds", "Clubs", "Spades"};
    
    //constructor method
    public Card(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    //Getter and Setter methods
    public int getSuit(){
        return suit;
    }
    
    public int getRank(){
        return rank;
    }
    
    public String getRankString(int rank){
		return ranks[rank];
    }
	
	public String getSuitString(){
		return suits[suit];
	}
    
    public void setRank(int rank){
        this.rank = rank;
    }
    
    //toString method
    public String toString(){        
        return ranks[rank] + " of " + suits[suit];
    }
}