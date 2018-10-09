package ex022;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class FileCopier {
	
	private String _source;
	private String _destination;
	private BufferedInputStream _bin = null;
	private BufferedOutputStream _bout = null;
	
	FileCopier(String sourceFilePath, String destinationFilePath) {
		_source = sourceFilePath;
		_destination = destinationFilePath;
	}
	
	boolean startCopy() throws IOException {
		try {			
			_bin = new BufferedInputStream(new FileInputStream(_source));
		    _bout = new BufferedOutputStream(new FileOutputStream(_destination));
		    
		    byte[] buffer = new byte[32 * 1024];
	        int numBytes;
	        while ((numBytes = _bin.read(buffer))!= -1)
	            _bout.write(buffer, 0, numBytes);
		    
	        System.out.println(_source + " is successfully copied to "+ _destination);
	        return true;
		} catch(FileNotFoundException ex) {
			System.out.println("File not found : " + ex.getMessage());
			return false;
		} catch(IOException ex) {
			System.out.println("Exception : " + ex.getMessage());
			return false;
		} finally {
		    if (_bin != null) _bin.close();
		    if (_bout != null) _bout.close();
		}
	}
	
}

public class FileCopyExample {
	
	public static void main(String[] args) throws IOException {
		
		// get file from resources
		ClassLoader classLoader = FileCopyExample.class.getClassLoader();
		File sourceFile = new File(classLoader.getResource("SampleFileCopy.txt").getFile());
		
		// get the desktop path
		String desktopPath = System.getProperty("user.home") + "\\Desktop";
		
		FileCopier fc = new FileCopier(sourceFile.getAbsolutePath().replace("%20", " "), desktopPath + "\\" + "OutputFile.txt");
		fc.startCopy();
		
	}

}
