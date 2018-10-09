package ex023;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.StringTokenizer;

class WordCounter {
	
	private String _source;
	private String _log;
	private FileWriter _fw = null;
	private BufferedReader _br = null;
	
	WordCounter(String sourceFilePath, String logFilePath) {
		_source = sourceFilePath;
		_log = logFilePath;
	}
	
	boolean start() throws IOException {
		try {
			_br = new BufferedReader(new FileReader(_source));
			String line = "", str = "";
			int words = 0;
			while ((line = _br.readLine()) != null) {
				str += line + " ";
			}
			 
			StringTokenizer st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				st.nextToken();
				words++;
			}
						
			_fw = new FileWriter(_log);
			_fw.write(_source + " has " + words + " words");
			 System.out.println("Log file created at : " + _log);
			return true;
		} catch(FileNotFoundException ex) {
			System.out.println("File not found : " + ex.getMessage());
			return false;
		} catch(IOException ex) {
			System.out.println("Exception : " + ex.getMessage());
			return false;
		} finally {
		    if (_br != null) _br.close();
		    if (_fw != null) _fw.close();
		}
	}
}

public class WordCounterExample {

	public static void main(String[] args) throws IOException {
		
		// get file from resources
		ClassLoader classLoader = WordCounterExample.class.getClassLoader();
		File sourceFile = new File(classLoader.getResource("iso_8859-1.txt").getFile());
		
		// get the desktop path
		String desktopPath = System.getProperty("user.home") + "\\Desktop";
		
		WordCounter wc = new WordCounter(sourceFile.getAbsolutePath().replace("%20", " "), desktopPath + "\\" + "WordCount.log");
		wc.start();

	}

}
