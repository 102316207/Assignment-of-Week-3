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
		FileReader fr = new FileReader("test.txt");//讀檔
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
			if(i==0)//讀KEY
			{
				hold=br.readLine();
				i=1;
			}
			else if(i==1)//讀value
			{
				i=0;
				hashMap.put(hold,br.readLine());//存 KEY,value
			}
        }
        fr.close();
		while(true)
		{
			System.out.print("1)新增字串 2)輸出單字量 -1)end:");
			choose = Integer.parseInt(enter.nextLine());
			if(choose==1)
			{
				FileWriter fw = new FileWriter("test.txt");
				System.out.println("請輸入字串:");
				mustSplitString = (enter.nextLine()).toLowerCase();
				String[] gettoken = mustSplitString.split("[,;\\.\\\\ ////\\*+-]+");
				// 切割(,)=>,  切割(;)=>;  切割(.)=>\\.  切割(\)=>\\\\  切割( )=>   切割(/)=>////
				// 切割(*)=>\\*  切割(+)=>+  切割(-)=>-  切割(=)=>=  切割())=>)  切割(()=>(	..............
				System.out.println("================================================================");
				for(i=0;i<gettoken.length;i++)// 分出 字元字串 數字字串
				{
					//System.out.println(gettoken[i]);
					if(hashMap.get(gettoken[i])==null) // 新的單字
					{
						//System.out.println("null");
						hashMap.put(gettoken[i],"1");
					}
					else   // *NOTE*  Object 不能直接轉 int，需 Object -> String -> int
					{
						temp=hashMap.get(gettoken[i]);  // 舊的單字
						num=Integer.valueOf((String)temp)+1;
						hold=Integer.toString(num);
						hashMap.put(gettoken[i],hold);
						//System.out.println("ok");
					}
				}
				for (Object key : hashMap.keySet())	// 存檔
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