package JUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import calculation.Calculate;
import calculation.Calculation;

public class test3 
{
	@Test
	public void test() 
	{
		Calculation<Double> calcu_mounth1 = new Calculate(1001, 1, 5).execute();
		Calculation<Double> calcu_mounth2 = new Calculate(1001,  1, 5).execute();
		Calculation<Double> calcu_mounth3 = new Calculate(1001,  0.01, 3).execute();
		Calculation<Double> calcu_mounth4 = new Calculate(1001,  0.01, 3).execute();
		
		assertEquals(calcu_mounth1.getResult(),calcu_mounth2.getResult(), 0.01);
		assertEquals(calcu_mounth3.getResult(),calcu_mounth4.getResult(), 0.01);
	}

}
