package domain.card;

import java.util.Objects;

public class WildDrawFourCard implements Card {
	private final CardType type = CardType.WILD_DRAW_FOUR;
	
	public WildDrawFourCard() {	}

	@Override
	public CardType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		WildDrawFourCard other = (WildDrawFourCard) obj;
		
		return (type == other.type);
	}
	
}
