import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;

public class Main 
{
	static Config config;
	
	static Scanner reader = new Scanner (System.in);
	
	public static void main (String [] args)
	{
		config = new Config();
		
		writeConfig();
		transferConfig();
	}
	
	private static void writeConfig ()
	{
		FileOutputStream out;
		ObjectOutputStream output;
		
		try 
		{
			out = new FileOutputStream("C:/config/configFile.ser");
			output = new ObjectOutputStream(out);
			
			output.writeObject(config.constants);
			output.writeObject(config.variables);
			
			output.close();
			out.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void transferConfig ()
	{
		int BUFFER_SIZE = 4096;
		
		String ftpUrl = "ftp://%s:%s@%s/%s;type=i";
        String host = "roborio-3316.local";
        String user = "admin";
        String pass = "";
        String filePath = "C:/config/configFile.ser";
        String uploadPath = "/home/lvuser/config/configFile.ser";
 
        ftpUrl = String.format(ftpUrl, user, pass, host, uploadPath);
        
        try 
        {
            URL url = new URL(ftpUrl);
            URLConnection conn = url.openConnection();
            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(filePath);
 
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            inputStream.close();
            outputStream.close();
 
            System.out.println("File uploaded");
        }
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
	}
}


