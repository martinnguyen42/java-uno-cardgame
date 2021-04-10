package domain.game;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domain.card.CardDeck;

public class DealerServiceTests {
	
	@Test
	public void WhenDeckShuffled_ShouldHaveDifferentOrder() {
		// Arrange
		var originalList = new CardDeck().getImmutableCards();
		
		// Process shuffle
		var shuffledList = DealerService.shuffle(originalList);
		
		// Assert
		int totalEquals = 0;
		for (int i = 0; i < originalList.size(); i++) {
			if (originalList.get(i).equals(shuffledList.get(i))) {
				totalEquals++;
			}
		}
	
		// for test
		System.out.println(totalEquals);
		System.out.println(originalList.size());
		
		assertNotEquals(originalList.size(), totalEquals);
		assertTrue(totalEquals < (originalList.size() * 0.2), "Shuffled cards should have less than 20% equal order (heuristically)");
	}
}
