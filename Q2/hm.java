import java.util.*;
import java.io.*;
class hm {
  public static void main(String[] args) {
		String temp1="";
		int temp2=0,count=0;
		HashMap hashMap = new HashMap();
		Scanner enter = new Scanner(System.in);
		while(true)
		{
			System.out.print("��"+(count+1)+"��\n�ǥͩm�W(-1:out) : ");
			temp1=enter.nextLine();
			if(temp1.compareTo("-1")==0)
			{
				break;
			}
			else
			{
				System.out.print("�ǥͦ��Z : ");
				temp2=Integer.parseInt(enter.nextLine());
				System.out.print("====================\n");
				hashMap.put(temp1,temp2);
				count++;
			}
		}
		System.out.print("====================\n�d�߾ǥͦ��Z\n");
		while(true)
		{
			System.out.print("�ǥͩm�W(-1:out) : ");
			temp1=enter.nextLine();
			if(temp1.compareTo("-1")==0)
			{
				break;
			}
			else
			{
				if(hashMap.get(temp1)==null)
				{
					System.out.println("���d�ߨ즹�ǥ�!!");
				}
				else
				{
					System.out.println("���Z : "+hashMap.get(temp1));
				}
				System.out.println("\n====================");
			}
		}
		
		//System.out.println(hashMap.get("aa"));
        //for (Object key : hashMap.keySet()) {
        //    System.out.println(key + " : " + hashMap.get(key));
        //}
  }
}
