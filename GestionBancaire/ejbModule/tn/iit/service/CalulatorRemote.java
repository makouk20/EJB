package tn.iit.service;

import javax.ejb.Remote;

@Remote
public interface CalulatorRemote {
	Double Som(double a,double b);
	Double sous(double a,double b);
	Double multi(double a,double b);

}
