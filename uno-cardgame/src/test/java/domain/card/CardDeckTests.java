package domain.card;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardDeckTests {

	private CardDeck cardDeck;

	@BeforeEach
	public void init() {
		cardDeck = new CardDeck();
	}
	
	@Test
    public void WhenInitialized_ShouldBeImmutable() {
        var cards = cardDeck.getCards();

        Assertions.assertThrows(UnsupportedOperationException.class, () -> cards.remove(0));
    }
	
	/*
	 * A UNO deck consists of 108 cards, of which there are 76 Number cards, 24 Action cards and 8 Wild cards.
	 * UNO cards have four color "suits", which are red, yellow, blue and green.
	 */
	@Test
	public void UnoCardsDeckFullyTest() {
		assertEquals(108, cardDeck.getCards().size());
	}
	
	/*
	 * 76 Number cards from 0 to 9
	 */
	@Test
	public void UnoNumberCardsTest() {
		var cards = cardDeck.getCards();
		
		/*
		 * four 0 cards
		 * eight card for each number[1-9] cards
		 */
		var numberCounts = new int[10];
		var expectedNumberCounts = new int[] {4, 8, 8, 8, 8, 8, 8, 8, 8, 8};
		
		var colorCounts = new int[4];
		var expectedColorCounts = new int[] {19, 19, 19, 19};
		
		for (var card: cards) {
			if (card.getType() == CardType.NUMBER) {
				var numberCard = (NumberCard)card;
				
				numberCounts[numberCard.getValue()] += 1;
				// ordinal() method returns the order of an numberCard enum instance 
				colorCounts[numberCard.getColor().ordinal()] += 1;
			}
		}
		
		assertEquals(76, Arrays.stream(numberCounts).sum());
		assertArrayEquals(numberCounts, expectedNumberCounts);
		assertArrayEquals(colorCounts, expectedColorCounts);
	}
}
