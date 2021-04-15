package me.itzriotz.examplecurldownloadergui;

import java.io.File;

public class Downloader {
	public static int exitVal;
	
	public static void download(String inputURL) {
			try {
				File path = new File(System.getProperty("user.home")+"/Downloads");
				String command = "curl -O "+inputURL;
				Process downloadProcess = Runtime.getRuntime().exec(command,null, path);
				exitVal = downloadProcess.waitFor();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
	}

}
