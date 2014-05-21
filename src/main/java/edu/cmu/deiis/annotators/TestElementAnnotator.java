package edu.cmu.deiis.annotators;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.*;

import java.util.regex.*;

public class TestElementAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		
		//System.out.println(arg0);
		//System.out.println(arg0.getDocumentText());
		
		String doc = arg0.getDocumentText();
		Pattern exp= Pattern.compile("[QA]");
		Pattern exp2=Pattern.compile("Q [\\w ?]+");
		Pattern exp1=Pattern.compile("A \\d [\\w,' .]+");
				
		Matcher m1 = exp1.matcher(doc);
		Matcher m2 = exp2.matcher(doc);
		
		while (m1.find()){
			m1.start();
			m1.end();
			System.out.println(m1.start());
			System.out.println(m1.end());
			String cadena = doc.substring(m1.start(),m1.end());
			Answer ans= new Answer(arg0);
			ans.setBegin(m1.start()+4);
			ans.setEnd(m1.end());
			ans.addToIndexes();	
		}
		while (m2.find()){
			m2.start();
			m2.end();
			System.out.println(m2.start());
			System.out.println(m2.end());
			String cadena = doc.substring(m2.start(),m2.end());
			Question ans= new Question(arg0);
			ans.setBegin(m2.start()+2);
			ans.setEnd(m2.end());
			ans.addToIndexes();	
		}
		
	}

}
