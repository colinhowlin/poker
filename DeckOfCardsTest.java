public class DeckOfCardsTest {
    
    //execute application
    public static void main(String [] args) {
        DeckOfCards myDeck = new DeckOfCards();
        
        //print all 52 cards in the order they are generated
        for (int i = 1; i <= 52; i++) {
            System.out.printf("%-19s", myDeck.dealCard());
            
            if (i % 4 == 0) {
                System.out.println();
            }
        }
        
        System.out.println();
        
        //shuffle the deck
        myDeck.shuffle();
        
        //print all 52 cards in shuffled order
        for (int i = 1; i <= 52; i++) {
            System.out.printf("%-19s", myDeck.dealCard());
            
            if (i % 4 == 0) {
                System.out.println();
            }
        }
    }
}