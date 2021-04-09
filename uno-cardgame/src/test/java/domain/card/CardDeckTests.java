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
		var cards = cardDeck.getImmutableCards();

		Assertions.assertThrows(UnsupportedOperationException.class, () -> cards.remove(0));
	}

	/*
	 * A UNO deck consists of 108 cards, of which there are 76 Number cards, 24
	 * Action cards and 8 Wild cards. UNO cards have four color "suits", which are
	 * red, yellow, blue and green.
	 */
	@Test
	public void UnoCardsDeckFullyTest() {
		assertEquals(108, cardDeck.getImmutableCards().size());
	}

	/*
	 * When initialized, Card deck should have 76 Number cards 0(1 card), 1-9(2
	 * cards) for each colors Total = 1 + 9x2 = 19 (cards each types)
	 */
	@Test
	public void UnoNumberCardsTest() {
		var cards = cardDeck.getImmutableCards();

		/*
		 * four 0 cards eight card for each number[1-9] cards
		 */
		var numberCounts = new int[10];
		var expectedNumberCounts = new int[] { 4, 8, 8, 8, 8, 8, 8, 8, 8, 8 };

		var colorCounts = new int[4];
		var expectedColorCounts = new int[] { 19, 19, 19, 19 };

		for (var card : cards) {
			if (card.getType() == CardType.NUMBER) {
				var numberCard = (NumberCard) card;

				numberCounts[numberCard.getValue()] += 1;
				// ordinal() method returns the order of an numberCard enum instance
				colorCounts[numberCard.getColor().ordinal()] += 1;
			}
		}

		assertEquals(76, Arrays.stream(numberCounts).sum());
		assertArrayEquals(expectedNumberCounts, numberCounts);
		assertArrayEquals(expectedColorCounts, colorCounts);
	}

	// When initialized, Card deck should have 8 Reverse cards
	@Test
	public void UnoSkipCardsTest() {
		var cards = cardDeck.getImmutableCards();
		var colorCounts = new int[4];

		for (var card : cards) {
			if (card.getType() == CardType.SKIP) {
				var skipCard = (SkipCard) card;

				colorCounts[skipCard.getColor().ordinal()] += 1;
			}
		}

		assertEquals(8, Arrays.stream(colorCounts).sum());

		assertTrue(Arrays.stream(colorCounts).allMatch((i) -> i == 2));
	}

	// When initialized, Card deck should have 8 Reverse cards
	@Test
	public void UnoReverseCardsTest() {
		var cards = cardDeck.getImmutableCards();
		var colorCounts = new int[4];

		var expectedColorCounts = new int[4];

		// to fill complete array with a particular value
		// 2 Reverse cards for each colors
		Arrays.fill(expectedColorCounts, 2);

		for (var card : cards) {
			if (card.getType() == CardType.REVERSE) {
				var reverseCard = (ReverseCard) card;

				colorCounts[reverseCard.getColor().ordinal()] += 1;
			}
		}

		// test 4 colors have 2 cards
		assertEquals(8, Arrays.stream(colorCounts).sum());
		assertArrayEquals(expectedColorCounts, colorCounts);
	}

	// When initialized, Card deck should have 8 Draw Two cards
	@Test
	public void UnoDrawTwoCardsTest() {
		var cards = cardDeck.getImmutableCards();
		var colorCounts = new int[4];

		var expectedColorCounts = new int[4];

		// 2 Draw Two cards for each colors
		Arrays.fill(expectedColorCounts, 2);

		for (var card : cards) {
			if (card.getType() == CardType.DRAW_TWO) {
				var drawTwoCard = (DrawTwoCard) card;

				colorCounts[drawTwoCard.getColor().ordinal()] += 1;
			}
		}

		// test 4 colors have 2 cards
		assertEquals(8, Arrays.stream(colorCounts).sum());
		assertArrayEquals(expectedColorCounts, colorCounts);
	}

	// When initialized, Card deck should have 8 Wild cards
	@Test
	public void UnoWildCardsTest() {
		var cards = cardDeck.getImmutableCards();
		
		var wildColorCardCount = 0;
		var wildDrawCardCount = 0;
		
		for (var card : cards) {
			if (card.getType() == CardType.WILD_COLOR) {
				wildColorCardCount++;
			} else if (card.getType() == CardType.WILD_DRAW_FOUR) {
				wildDrawCardCount++;
			}
		}
		
		// There are 4 of each kind of Wild Cards. 
		assertEquals(4, wildColorCardCount);
		assertEquals(4, wildDrawCardCount);
	}
}
