package domain.game;

import java.util.List;
import java.util.Stack;

import domain.card.Card;

public class DrawPile {
	private final Stack<Card> drawPile = new Stack<>();
	
	public DrawPile(List<Card> shuffledCards) {
		drawPile.addAll(shuffledCards);
	}
}
