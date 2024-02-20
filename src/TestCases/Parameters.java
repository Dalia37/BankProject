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
    
    String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack"};
    int firstNameRandome = rand.nextInt(firstNames.length);
    
    String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
    int lastNameRandome = rand.nextInt(lastNames.length);
    
   String[] postCode = {"12345","67890","54321","98765","23456","78901","34567","89012","45678","90123"};
   int postcodeRandom = rand.nextInt(postCode.length);
   
   String[] currency = {"Dollar","Pound","Rupee"} ;
   int carrencyRanom = rand.nextInt(currency.length);
   




    
    
	
}
