import java.util.Scanner;
import java.math.*;
public class dp_062916
{
	//These 2 booleans are used to determine if . and - appear twice. If so, one of them is set and the looping stops
	static boolean un, deux;

	//Returns true as long as we are still in the numerical section of string
	static boolean isnum (char ch)		
	{
		if ((ch >= '0' && ch <= '9') || ((ch == '.') && !(un)) || ((ch=='-') && !(deux)))
		{
			if (ch == '.')
				un = true;
			if (ch == '-')
				deux = true;
			return true;
		}
		return false;
	}
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String ip;
		StringBuilder sb = new StringBuilder("");
		boolean flag=false;
		double from, to;
		char c1, c2;
		int i=0;
		un = false;
		deux = false;		
		ip = sc.next();
		try
		{
			for (i=0;isnum(ip.charAt(i));i++)
				sb.append(ip.charAt(i));
		}
		catch (StringIndexOutOfBoundsException e)
		{
			System.out.println ("Wrong input");
			return;
		}
		c1 = ip.charAt(i);
		c2 = ip.charAt(i+1);
		switch (c1)
		{
			case 'd': if (c2=='r')
					  flag=true;
				  break;
			case 'r': if (c2=='d')
					  flag=true;
				  break;
			case 'f': if (c2=='c'||c2=='k')
					  flag=true;
				  break;
			case 'c': if (c2=='f'||c2=='k')
					  flag=true;
				  break;
			case 'k': if (c2=='c'||c2=='f')
					  flag=true;
				  break;
		}
		if (!flag)
			System.out.println ("Wrong input");
		else
		{
			ip = sb.toString();
			from = Double.parseDouble(ip);
			if (c1 == 'd')
				to = from*Math.PI/180;	
			else if (c1 == 'r')
				to = from*180/Math.PI;
			else if (c1 == 'f')
			{
				to = (from - 32)*5/9;
				if (c2 == 'k')
					to += 273.15;
			}
			else if (c1 == 'c')
			{
				if (c2=='k')
					to = from+273.15;
				else
					to = 9*from/5 + 32;
			}
			else
			{
				to = from-273.15;
				if (c2=='f')
					to = 9*from/5+32;
			}
			System.out.println (from+ "" + c1);
			System.out.println (to + "" + c2);
		}
	}
}
	
