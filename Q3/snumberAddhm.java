import java.io.*;
import java.util.*;
class snumberAddhm{
	public static void main(String[] args)throws IOException{
		
		String mustSplitString = "";
		HashMap hashMap = new HashMap();
		Scanner enter = new Scanner(System.in);
		Object temp=0;
		int num=0,choose=0,count=0,i=0;
		String hold="";
		FileReader fr = new FileReader("test.txt");//Ū��
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
			if(i==0)//ŪKEY
			{
				hold=br.readLine();
				i=1;
			}
			else if(i==1)//Ūvalue
			{
				i=0;
				hashMap.put(hold,br.readLine());//�s KEY,value
			}
        }
        fr.close();
		while(true)
		{
			System.out.print("1)�s�W�r�� 2)��X��r�q -1)end:");
			choose = Integer.parseInt(enter.nextLine());
			if(choose==1)
			{
				FileWriter fw = new FileWriter("test.txt");
				System.out.println("�п�J�r��:");
				mustSplitString = (enter.nextLine()).toLowerCase();
				String[] gettoken = mustSplitString.split("[,;\\.\\\\ ////\\*+-]+");
				// ����(,)=>,  ����(;)=>;  ����(.)=>\\.  ����(\)=>\\\\  ����( )=>   ����(/)=>////
				// ����(*)=>\\*  ����(+)=>+  ����(-)=>-  ����(=)=>=  ����())=>)  ����(()=>(	..............
				System.out.println("================================================================");
				for(i=0;i<gettoken.length;i++)// ���X �r���r�� �Ʀr�r��
				{
					//System.out.println(gettoken[i]);
					if(hashMap.get(gettoken[i])==null) // �s����r
					{
						//System.out.println("null");
						hashMap.put(gettoken[i],"1");
					}
					else   // *NOTE*  Object ���ઽ���� int�A�� Object -> String -> int
					{
						temp=hashMap.get(gettoken[i]);  // �ª���r
						num=Integer.valueOf((String)temp)+1;
						hold=Integer.toString(num);
						hashMap.put(gettoken[i],hold);
						//System.out.println("ok");
					}
				}
				for (Object key : hashMap.keySet())	// �s��
				{
					fw.write(key+"\n"+hashMap.get(key)+"\n");
				}
				fw.flush();
				fw.close();
			}
			else if(choose==2)
			{
				for (Object key : hashMap.keySet())
				{
					System.out.println(key + " : " + hashMap.get(key));
				}
				System.out.println("================================================================");
			}
			else if(choose==-1)
			{
				break;
			}
		}
	}
}