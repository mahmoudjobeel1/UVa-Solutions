import java.util.*;
import java.io.*;

public class Main {
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		while(sc.hasNext()) {
			int x=sc.nextInt();
			ArrayList<Integer>[]lists=new ArrayList[x];
			
			for(int i=0;i<x;i++) {
				lists[i]=new ArrayList<>();
				int t=sc.nextInt();
				while(t-->0) lists[i].add(sc.nextInt());
			}
			int t=sc.nextInt();
			while(t-->0) {
				int k=sc.nextInt();
				boolean [] visited=new boolean[x];
				int day=1,max=0,c=1;
				ArrayList<Integer> occ=new ArrayList<>();
				occ.add(k);
				visited[k]=true;
			//	System.out.println(occ);
				while(true) {
					
					ArrayList<Integer> temp=new ArrayList<>();
					for(int i:occ)
						for(int u:lists[i])
						if(!visited[u]) {
							temp.add(u); visited[u]=true;
						}
					if(temp.size()==0) break;
					else {
						if(temp.size()>max) {
							max=temp.size();
							day=c;
						}
					}
					c++;
					occ=temp;
				}
				if(max==0) System.out.println(0);
				else System.out.println(max+" "+day);
			}
		}
		pw.flush();
		pw.close();
	}
      static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
