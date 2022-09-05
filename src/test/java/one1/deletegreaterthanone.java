package one1;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class deletegreaterthanone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String s="bharath kumar";
		String S4[]=s.split(" ");
		String K="  ";
		for(int j=0;j<S4.length;j++){
			
			K=S4[j]+K;
		}
		System.out.println(K);
		
		
		
		char s2[]=s.toCharArray();
		String S3 = "";
		
		for (int i=0;i<s2.length;i++) {
			S3=s2[i]+S3;
		}
		System.out.println(S3);
	}
}
		
	
