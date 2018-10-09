package ex02;

import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaUtilZipExample {
	private static ZipFile zipFile = null;

	public static void main(String [] args) throws IOException {
		try {
			ClassLoader classLoader = JavaUtilZipExample.class.getClassLoader();
			File file = new File(classLoader.getResource("SampleZipFile.zip").getFile());
					
			// ZipFile has problems parsing file path with spaces (%20)
			zipFile  = new ZipFile(file.getAbsolutePath().replace("%20", " "));
			
			Enumeration<? extends ZipEntry> entries = zipFile .entries();

			while(entries.hasMoreElements()){
			    ZipEntry entry = entries.nextElement();
			    if(entry.isDirectory()){
			        System.out.println("Dir Name : " + entry.getName());
			    } else {
			    	Date date = new Date(entry.getTime());
			    	
			        System.out.println("File Name : " + entry.getName() + 
			        				   "\t| Date : " + date.getDate()+ 
			        				   "\t| Hour : " + date.getHours() +
			        				   "\t| Size : " + entry.getSize() +
			        				   "\t| Packed Size : " + entry.getCompressedSize());
			    }
			}
		} catch(FileNotFoundException ex) {
			System.out.println("File not found : " + ex.getMessage());
		} catch(IOException ex) {
			System.out.println("Exception : " + ex.getMessage());
		} finally {
			if (zipFile != null) zipFile.close();
		}
	}
}
