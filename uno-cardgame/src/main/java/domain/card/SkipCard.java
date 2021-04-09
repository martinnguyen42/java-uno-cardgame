package domain.card;

import java.util.Objects;

public class SkipCard implements Card {
	private final CardColor color;

	public SkipCard(CardColor color) {
		CardUtil.validateColor(color);
		
		this.color = color;
	}

	public CardColor getColor() {
		return color;
	}

	@Override
	public CardType getType() {
		return CardType.SKIP;
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
		
		SkipCard other = (SkipCard) obj;
		
		return (color == other.color);
	}
	
	
	
}
