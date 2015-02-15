import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

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
			
			output.writeObject(config.constantsB);
			output.writeObject(config.variablesB);
			
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
	
	private static void transferConfig() 
	{
		JSch jsch = new JSch();
		Session session = null;
		
		 String host = "roborio-3316.local";
	     String user = "admin";
	     String pass = "";
	     int port = 22;
	     String filePath = "C:/config/configFile.ser";
	     String uploadPath = "/home/lvuser/config/configFile.ser";
		
		try 
		{
			session = jsch.getSession(user, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(pass);
            session.connect();
            
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            
			try 
			{
				byte[] buffer = new byte[4096];
				
				BufferedInputStream bis = new BufferedInputStream (new FileInputStream (filePath));
				
				BufferedOutputStream bos = new BufferedOutputStream(sftpChannel.put(uploadPath));
				
				int readCount;
				while( (readCount = bis.read(buffer)) > 0) 
				{
					bos.write(buffer, 0, readCount);
				}
				bis.close();
				bos.close();
	            System.out.println("File uploaded");
			} 
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
            
		}
		catch (JSchException e) 
		{
			e.printStackTrace();
		}
	}
}


