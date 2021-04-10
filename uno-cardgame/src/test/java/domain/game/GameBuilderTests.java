package domain.game;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class GameBuilderTests {

	@Test
	public void WhenCreated_RandomNumberReturns() {
		var game = new GameBuilder().build();
		var random = new Random();
		
		for (var i = 0; i < 20; ++i) {
			System.out.println(random.nextInt(10));
		}
		
	}
}
