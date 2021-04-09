package domain.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Test when given same and different number(color) UNO cards
 * include Number Cards, Action Cards and Wild Cards
 */
public class CardTests {
	
	/*
	 * Number Cards
	 */
	@Test
	public void GivenSameNumberCardValues_ShouldBeEqual() {
		var numberCard = new NumberCard(1, CardColor.GREEN);
		var anotherNumberCard = new NumberCard(1, CardColor.GREEN);
		
		// These arguments look the same
		assertNotSame(numberCard, anotherNumberCard);
		assertEquals(numberCard, anotherNumberCard);
	}
	
	@Test
	public void GivenDifferentNumberCardValues_ShouldNotBeEqual() {
		var numberCard = new NumberCard(1, CardColor.YELLOW);
		var anotherNumberCard = new NumberCard(1, CardColor.GREEN);
		
		assertNotSame(numberCard, anotherNumberCard);
		assertNotEquals(numberCard, anotherNumberCard);
	}
	
	/*
	 * Action Cards: Skip, Reverse, Draw Two
	 */
	@Test
	public void GivenSameSkipCard_ShouldBeEqual() {
		var skipCard = new SkipCard(CardColor.BLUE);
		var anotherSkipCard = new SkipCard(CardColor.BLUE);
		
		assertEquals(skipCard, anotherSkipCard);
	}
	
	@Test
	public void GivenDifferentSkipCard_ShouldNotBeEqual() {
		var skipCard = new SkipCard(CardColor.RED);
		var anotherSkipCard = new SkipCard(CardColor.GREEN);
		
		assertNotEquals(skipCard, anotherSkipCard);
	}
	
	@Test
    public void GivenDifferentActionCard_ShouldNotBeEqual(){
        var drawTwoCard_RED = new DrawTwoCard(CardColor.RED);
        var drawTwoCard_BLUE = new DrawTwoCard(CardColor.BLUE);
        
        var reverseCard = new ReverseCard(CardColor.RED);

        // Test with 2 diff colors
        assertNotEquals(drawTwoCard_RED, reverseCard);
        assertNotEquals(drawTwoCard_BLUE, reverseCard);
    }
	
	@Test 
	public void GivenSameWildColorCard_ShuoldBeEqual() {
		var card = new WildColorCard();
        var anotherCard = new WildColorCard();

        assertEquals(card, anotherCard);
	}
	
	@Test
    public void GivenSameWildDrawFourCard_ShouldBeEqual(){
        var card = new WildDrawFourCard();
        var anotherCard = new WildDrawFourCard();

        assertEquals(card, anotherCard);
    }
	
}
