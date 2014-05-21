package edu.cmu.deiis.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.deiis.types.*;

public class NGramAnnotator extends JCasAnnotator_ImplBase {

	private boolean mapeaAnnotacion(Annotation uno, Annotation dos){
		
			return uno.getBegin() <= dos.getBegin() && dos.getEnd() <= uno.getEnd();
	}
	
	
	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String documento = arg0.getDocumentText();

		Pattern bigrams = Pattern.compile("[\\w,\\.]+ [\\w,\\.]+");

		Matcher match = bigrams.matcher(documento);

		while (match.find()) {
			System.out.println("NgramAnotator");
			String cadena = documento.substring(match.start(), match.end());
			if (!cadena.startsWith("Q ") && !cadena.startsWith("A 0")
					&& !cadena.startsWith("A 1")) {
				NGram palabra = new NGram(arg0);
				palabra.setBegin(match.start());
				palabra.setEnd(match.end());
			//palabra.setElementType(v);
				
				
				AnnotationIndex<Annotation> a = arg0.getAnnotationIndex(Token.type);
				Annotation a1;
				FSIterator <Annotation> iterador = a.iterator();
				int indice = 0;
				FSArray fs_arr = new FSArray(arg0,2);
				while(iterador.hasNext()){
					a1 = iterador.next();
				    Token token = (Token)a1;				    
				    if(indice<2 && mapeaAnnotacion(palabra,token)){
				    	fs_arr.set(indice,token);
				    	indice++;
				    }
				}
				palabra.setElements(fs_arr);
				palabra.addToIndexes();
			}
		}
	}

}
