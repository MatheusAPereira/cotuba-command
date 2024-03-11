package cotuba.application;

import java.util.HashMap;
import java.util.Map;

import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUBCommand;
import cotuba.pdf.GeradorPDFCommand;

public class Invoker {
	
	public static Map<String, Command> comandos = new HashMap<>();
	
	
	static {
		comandos.put("pdf", new GeradorPDFCommand());
		comandos.put("epub", new GeradorEPUBCommand());
	}
	
	public static void Invoke(Ebook ebook) {
		
		if(comandos.containsKey(ebook.getFormato())) {
			comandos.get(ebook.getFormato()).execute(ebook);
		} else {
			throw new IllegalArgumentException("Formato do ebook inválido: " + ebook.getFormato());
		}
		
	}
}
