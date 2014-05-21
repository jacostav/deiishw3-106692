package edu.cmu.deiis.annotators;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class TokenAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		  String documento = arg0.getDocumentText();
		  
		 Pattern tokenPattern = Pattern.compile("[\\w']+");

		 
		   Matcher match = tokenPattern.matcher(documento);
		   
		   while (match.find()) {
		     String cadena = documento.substring(match.start(),match.end());
		     if(!cadena.equals("Q")&&!cadena.equals("A")&&!cadena.equals("0")&&!cadena.equals("1")){
		    	 Token palabra = new Token(arg0);
		     	 palabra.setBegin(match.start());
		     	 palabra.setEnd(match.end());
		     	 palabra.addToIndexes();
		     	
		     	 }
		   }
	
	}

}
