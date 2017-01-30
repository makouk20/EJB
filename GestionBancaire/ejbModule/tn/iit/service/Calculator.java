package tn.iit.service;

import javax.ejb.Stateless;

@Stateless
public class Calculator implements CalulatorRemote {

	@Override
	public Double Som(double a, double b) {
		return a+b;
	}

	@Override
	public Double sous(double a, double b) {
		return a-b;
	}

	@Override
	public Double multi(double a, double b) {
		return a*b;
	}


}
