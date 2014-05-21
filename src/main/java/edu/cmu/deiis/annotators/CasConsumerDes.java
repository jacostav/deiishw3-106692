package edu.cmu.deiis.annotators;

import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.resource.ResourceProcessException;

public class CasConsumerDes extends CasConsumer_ImplBase {

	@Override
	public void processCas(CAS arg0) throws ResourceProcessException {
		// TODO Auto-generated method stub
		System.out.println("Hello world from cas consumer");

	}

}
