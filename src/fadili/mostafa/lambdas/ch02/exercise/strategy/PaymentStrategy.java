package fadili.mostafa.lambdas.ch02.exercise.strategy;

import java.math.BigDecimal;

import fadili.mostafa.lambdas.ch02.exercise.PaymentStatus;

public interface PaymentStrategy {
	
	public PaymentStatus pay(BigDecimal money);

}
