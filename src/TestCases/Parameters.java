package TestCases;

import java.util.Random;

import org.checkerframework.checker.units.qual.radians;

public class Parameters {
	
	private static final int MIN_AMOUNT = 10;
	private static final int MAX_AMOUNT = 1000;
	String[] CustomersName = {"Harry Potter","Hermoine Granger","Ron Weasly","Albus Dumbledore","Neville Longbottom"};
    Random rand = new Random();
    int CustomerID = rand.nextInt(CustomersName.length);
    int RandomAmount = MIN_AMOUNT + rand.nextInt(MAX_AMOUNT - MIN_AMOUNT + 1);
	
}
