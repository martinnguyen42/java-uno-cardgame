package domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.card.Card;

public class DealerService {
	
	/*
	 * Cards are shuffled using the modern version of Fisher-Yates shuffle.
	 * Reference: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
	 * @param cards list will not be modified
	 * @return a new shuffled cards list 
	 */
	public static List<Card> shuffle(List<Card> cards) {
		var shuffledCards = new ArrayList<>(cards);
		var rand = new Random();
		
		for (int current = 0; current < shuffledCards.size() - 1; ++current) {
			// get a random index for remaining positions, i.e. [i, CARDS_SIZE - 1]
			var randomIndex = current + rand.nextInt(cards.size() - current);
			
			swapCard(shuffledCards, current, randomIndex);
		}
		
		return shuffledCards;
	}
	
	private static void swapCard(List<Card> shuffledList, int currentIndex, int randomIndex) {
		var randomCard = shuffledList.get(randomIndex);
		
		shuffledList.set(randomIndex, shuffledList.get(currentIndex));
		shuffledList.set(currentIndex, randomCard);
	}
}
