package one1;

import java.util.ArrayList;
import java.util.List;

public class commonarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1[]= {"Anupama", "IT", "Nagpur", "Ashu"};
		String s2[]= {"Anupama", "bangalore","Ashu","IT"};
		
		List<String> co=new ArrayList<String>();
		
		for(int i=0;i<s1.length;i++)
		{
			for(int j=0;j<s2.length;j++)
			{
				if(s1[i].equalsIgnoreCase(s2[j]))
				{
					co.add(s1[i]);
				}
			}
			
		}
		
		System.out.println(co);
	}

}
