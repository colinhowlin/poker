/**
 * A class implementing rules of poker including hand detection and evaluation
 * @author Colin Howlin
 * @version 1.0
 */

import java.util.Arrays;

public class Poker{
	private double value = 0.0;		//instance variable to hold value of hand
	
	/**method to count the number of occurences 
	 *of a particular card in a hand
	 *
	 *@return Integer array
	 *
	 */
	public static int[] getFreqs(Card[] hand){
		int [] frequencies = new int [13];
		
		for(Card card : hand){
			frequencies[card.getRank()]++;
		}
		
		return frequencies;
	}
	
	/**method to evaluate the players hand
	 *
	 *@return double representing the value of the hand
	 */
	public static double evaluateHand(Card[] hand){
		double handValue = 0.0;
		
		if (isStraightFlush(hand)){
			handValue = 8.0;
		} else if (isFours(hand)){
			handValue = 7.0;
		} else if (isFullHouse(hand)){
			handValue = 6.0;
		} else if (isFlush(hand)){
			handValue = 5.0;
		} else if (isStraight(hand)){
			handValue = 4.0;
		} else if (isTrips(hand)){
			handValue = 3.0;
		} else if (isTwoPair(hand)){
			handValue = 2.0;
		} else if (isPair(hand)){
			handValue = 1.0;
		} else {
			handValue = 0.0;
		}
		
		return handValue;
	}
	
	/**method to check for a pair
	 *
	 *@return Boolean
	 *
	 */
	public static boolean isPair(Card[] hand){
		int pairsCount = 0;
		int[] frequencies = getFreqs(hand);
		String rank = "";
		
		for (int i = 0; i < hand.length; i++){
			if (frequencies[i] == 2){
				pairsCount++;	
				rank = hand[i].getRankString(i);
			}
		}	
		
		if (pairsCount == 1){
			System.out.printf("%nYou got a pair of %s's 1111", rank);
			return true;
		} else {
			return false;
		}
	}
	
	/**method to check for two_pair
	 *
	 *@return Boolean
	 *
	 */
	public static boolean isTwoPair(Card[] hand){
		int pairsCount = 0;
		int[] frequencies = getFreqs(hand);
		String rank1 = "";
		String rank2 = "";
		
		for (int i = 0; i < hand.length; i++){
			if (frequencies[i] == 2){
				pairsCount++;
				if (pairsCount == 1){
					rank1 = hand[i].getRankString(i);
				} else {
					rank2 = hand[i].getRankString(i);
				}
			}
		}	
		
		if (pairsCount == 2){
			System.out.printf("%nYou got two pair, %s's and %s's 2222", rank1, rank2);
			return true;
		} else {
			return false;
		}
	}
	
	/**method to check for trips
	 *
	 *@return Boolean
	 *
	 */
	public static boolean isTrips(Card[] hand){
		int[] frequencies = getFreqs(hand);
		String rank = "";
		
		for (int i = 0; i < hand.length; i++){
			if (frequencies[i] == 3){
				rank = hand[i].getRankString(i);
				System.out.printf("%nThree of a Kind, %s's 3333", rank);
				return true;
			} 
		}
		return false;
	}
	
	/**method to check for a full house
	 *
	 *@return Boolean
	 *
	 */
	public static boolean isFullHouse(Card[] hand){
		if (isTrips(hand) && isPair(hand)){
			System.out.printf("%nFull House hhhh");
			return true;
		}
		return false;
	}
	
	/**method to check for four of a kind
	 *
	 *@return Boolean
	 */
	public static boolean isFours(Card[] hand){
		int[] frequencies = getFreqs(hand);
		
		for (int i = 0; i < hand.length; i++){
			if (frequencies[i] == 4){
				System.out.printf("%nFour of a Kind 4444");	
				return true;
			}
		}
		return false;
	}
	
	/**method to check for a straight
	 *
	 *@return Boolean
	 *
	 */
	public static boolean isStraight(Card[] hand){
		int [] sortedHand = new int [hand.length];
		for(int i = 0; i < hand.length; i++){
			sortedHand[i] = hand[i].getRank();
		}
		Arrays.sort(sortedHand);
		boolean isStraight = true;
		for (int i = 0; i < hand.length - 1; i++){
			if (sortedHand[i] + 1 != sortedHand[i + 1]){
				isStraight = false;
			}
		}
		int [] highStraight = {0,9,10,11,12};
		if (Arrays.equals(sortedHand, highStraight)){
			isStraight = true;
			return true;
		}
		if (isStraight){
			System.out.printf("%nIt's a straight ssss %n");
			return true;
		} else {
			//System.out.printf("%nNo Straight%n");
			return false;
		}
	}
	
	/**method to check for a flush
	 *
	 *@return Boolean
	 *
	 */
	public static boolean isFlush(Card[] hand){
		int [] suits = new int [5];
		boolean isFlush = true;
		String suit = "";
		for (int i = 0; i < hand.length - 1; i++){
			if (hand[i].getSuit() != hand[i + 1].getSuit()){
				isFlush = false;
			}
			suit = hand[i].getSuitString();
		}		
		
		if (isFlush){
			System.out.printf("%nIt's a flush of %s!ffff ", suit);
			return true;
		} else {
			//System.out.printf("No flush");
			return false;
		}
	}
	
	/**method to check for a Straight Flush
	 *
	 *@return Boolean
	 *
	 */
	public static boolean isStraightFlush(Card[] hand){
		if (isFlush(hand) && isStraight(hand)){
			System.out.printf("%nStraight Flush!!!!! sfsf");
			return true;
		}
		return false;
	}
	
	/**method to run all hand checks
	 *
	 *@return void
	 *
	 
	public static void checkHand(Card[] hand){
		
		isPair(hand);
		isTwoPair(hand);
		isTrips(hand);
		isStraight(hand);
		isFlush(hand);
		isFullHouse(hand);
		isFours(hand);
		isStraightFlush(hand);
	}
	*/
}