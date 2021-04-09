package domain.card;

import java.util.Objects;

public class NumberCard implements Card {
	private final int value;
	private final CardColor color;
	
	public NumberCard(int value, CardColor color) {
		CardUtil.validateNumber(value);
		CardUtil.validateColor(color);
		
		this.value = value;
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public CardColor getColor() {
		return color;
	}

	@Override
	public CardType getType() {
		return CardType.NUMBER;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, color);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		NumberCard other = (NumberCard) obj;
		
		return (value == other.value && color == other.color);
	}
	
	
	
}
