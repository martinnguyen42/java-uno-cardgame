package domain.card;

import java.util.Objects;

public class WildColorCard implements Card {
	private final CardType type = CardType.WILD_COLOR;
	
	public WildColorCard() { }

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
		
		WildColorCard other = (WildColorCard) obj;
		
		return (type == other.type);
	}
	
	
}
