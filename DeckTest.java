//Class to test implementation of Deck and Card classes

public class DeckTest{

	
    public static void main(String [] args){
		
		Deck myDeck = new Deck();

        myDeck.shuffle();       //shuffle the deck
        System.out.println();
		
		Card[] hand1 = myDeck.dealHand(5);
		Card[] hand2 = myDeck.dealHand(5);
		
		System.out.printf("%nPlayer 1 hand: %n");
		myDeck.printHand(hand1);
		Poker.checkHand(hand1);
		System.out.printf("%nHand value is %.2f", Poker.evaluateHand(hand1));
		
		System.out.printf("%n%nPlayer 2 hand: %n");
		myDeck.printHand(hand2);
		Poker.checkHand(hand2);
		System.out.printf("%nHand value is %.2f", Poker.evaluateHand(hand2));
		
		/*******************************
		//Tests
		/*******************************
		Card [] testHand = {new Card(0,12),new Card(0,10),new Card(0,0),new Card(0,9),new Card(0,11),};
		for (Card card : testHand){
			System.out.printf(" %s ",card);
		}
		Poker.checkPairs(testHand);
		Poker.isStraight(testHand);
		Poker.isFlush(testHand);
		
		
        //create a new deck
        
        
        /print out the shuffled deck
        for(int i = 0; i < 52; i++){
            System.out.printf("%-19s", myDeck.dealCard());
            if (i % 4 == 3){
                System.out.println();
            }
        }
		
		

		for(int i = 0; i < 100000; i++){
			myDeck.shuffle();
			Card[] hand = myDeck.dealHand(5);
			System.out.println();
				for(Card card : hand){
					System.out.printf("%-19s", card);
				}
			System.out.println();
			//System.out.printf("Current card is %d%n", myDeck.currentCard);
			
			Poker.isPair(hand);
			Poker.isTwoPair(hand);
			Poker.isTrips(hand);
			Poker.isFullHouse(hand);
			Poker.isFours(hand);
			Poker.isStraight(hand);
			Poker.isFlush(hand);
			Poker.isStraightFlush(hand);
			System.out.printf("%n******************************************%n");
		}
		*/
    }
}