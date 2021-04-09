package domain.card;

import java.util.Objects;

public class ReverseCard implements Card {
	private final CardColor color;
	
	public ReverseCard(CardColor color) {
		CardUtil.validateColor(color);
		
		this.color = color;
	}

	public CardColor getColor() {
		return color;
	}

	@Override
	public CardType getType() {
		return CardType.REVERSE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ReverseCard other = (ReverseCard) obj;
		
		return (color == other.color);
	}
	
}
