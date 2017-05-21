package rocketBase;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;
import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		for(RateDomainModel rdm : rates){
			if(rdm.getiMinCreditScore() <= GivenCreditScore)
				dInterestRate = rdm.getdInterestRate();
			else
				break;
		}
		if (dInterestRate == 0)
			throw new RateException();
		return dInterestRate;
	}
	
	public static double getPVPayment(double r, double n, double y, double f, boolean t) {
		r=r/100;
		r=r/12;
		return FinanceLib.pmt(r,  n,  y,  f,  t);
		
		
	}
}