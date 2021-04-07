package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	
	/*
	 * The Deck class consists of 108 UNO Cards. There are four suits: Red, Green, Blue and Yellow
	 * Each consisting of one 0 card, two 1 cards, 2s, 3s, 4s, 5s, 6s, 7s, 8s, 9s; two Draw Two cards, two Skip cards; and two Reverse cards.
	 * In addition, there are four Wild cards and four Wild Draw Four cards.
	 */
	
	// UNO Card Deck consists of 108 cards
	private final List<Card> cards = new ArrayList<>(108);
	
	public CardDeck() {
		createCards();
	}

	// Note: unmodifiableList using for access to new value cards in Collections object 
	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}
	
	// Create card for the game
	private void createCards() {
		createNumberCards();
		// TODO: Another UNO cards
	}

	/*
	 * Each color contains 19 cards, one number 0 card and two sets of cards numbered 1-9.
	 * Total 76 number cards
	 */
	private void createNumberCards() {
		for (var color: CardColor.values()) {
			// 0 cards (one card for each numbers)
			cards.add(new NumberCard(0, color));
			
			
			// card from 1 to 9 (two cards with each numbers)
			for (var i = 1; i <= 9; ++i) {
				cards.add(new NumberCard(i, color));
				cards.add(new NumberCard(i, color));
			}
		}
	}
	

	// TODO: Create action cards
	
}
