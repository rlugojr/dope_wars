package cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLine{

	private String input;

	public ReadLine(){
		try{
			BufferedReader br = 
	                      new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();

	 
		}catch(IOException io){
			io.printStackTrace();
		}
	}

	public String read(){
		return input;
	}


}