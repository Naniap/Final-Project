import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileWriter {
	private static FileWriter fileWriter;
	
	private FileWriter() {
	}

	public static FileWriter getInstance(){
		if (fileWriter == null){
			fileWriter = new FileWriter();
		}
		return fileWriter;
	}
	
	public static void writeError(String message, String fileName, boolean isAppended){
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileOutputStream(new File(fileName),isAppended)); 
			writer.write(message + "\n");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
