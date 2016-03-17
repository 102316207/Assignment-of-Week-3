import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class snumber{
	public static void main(String[] args){
		
		String mustSplitString = "";
		int key=0,ncount=0,wcount=0,count=0;
		String[] number=new String[100];
		String[] word=new String[100];
		
		System.out.println("½Ð¿é¤J¦r¦ê:");
		Scanner op = new Scanner(System.in);
		mustSplitString = (op.nextLine()).toLowerCase();
		String[] gettoken = mustSplitString.split("[,;\\.\\\\ ////\\*+-]+");
		// ¤Á³Î(,)=>,  ¤Á³Î(;)=>;  ¤Á³Î(.)=>\\.  ¤Á³Î(\)=>\\\\  ¤Á³Î( )=>   ¤Á³Î(/)=>////
		// ¤Á³Î(*)=>\\*  ¤Á³Î(+)=>+  ¤Á³Î(-)=>-  ¤Á³Î(=)=>=  ¤Á³Î())=>)  ¤Á³Î(()=>(	..............
		
		for(int i=0;i<gettoken.length;i++) // ¤À¥X ¦r¤¸¦r¦ê ¼Æ¦r¦r¦ê
		{
			key=0;
			char[] str = gettoken[i].toCharArray();
			for(int j=0;j<str.length;j++)
			{
				if(!Character.isDigit(str[j]))
				{
					key=1;
					break;
				}
			}
			if(key!=1)
			{
				//System.out.println("1");
				number[ncount]=gettoken[i];
				//System.out.println(number[ncount]+"\t"+ncount+"number");
				ncount++;
			}
			else
			{
				//System.out.println("2");
				word[wcount]=gettoken[i];
				//System.out.println(word[wcount]+"\t"+wcount+"word");
				wcount++;
			}
		}
		System.out.println("====================\n\t¦r¦ê");
		for(int i=0;i<wcount;i++)
		{
			System.out.println("\t"+word[i]);
		}
		System.out.println("====================\n\t¼Æ¦r");
		for(int i=0;i<ncount;i++)
		{
			if((ncount-1)==i)
			{
				System.out.println("      + "+number[i]);
			}
			else
			{
				System.out.println("\t"+number[i]);
			}
			count=count+Integer.parseInt(number[i]);
		}
		System.out.println("    ---------\n        "+count);
		
	}
}