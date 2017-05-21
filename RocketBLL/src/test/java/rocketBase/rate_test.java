package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	
@Test
public void rate_test() throws Exception{
	double rate = RateBLL.getRate(630);
	assertTrue(rate == 7);
}

@Test (expected = RateException.class)
public void excep() throws RateException{
 RateBLL.getRate(200);
}
	
	
}