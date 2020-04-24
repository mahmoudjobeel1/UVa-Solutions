// Graph representation by using adjLists 

import java.util.*;
import java.io.*;

  
public class Test {
		public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(br.ready()) {
		StringTokenizer st=new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st.nextToken()); int m=Integer.parseInt(st.nextToken());
		ArrayList<Integer> [] lists=new ArrayList[1000005];
		for(int i=0;i<lists.length;i++)lists[i]=new ArrayList<>();
		    int j=1;
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
			lists[Integer.parseInt(st.nextToken())].add(j++);
		
		while(m-->0) {
			st=new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken()); int v=Integer.parseInt(st.nextToken());
			if(lists[v].size()<k) pw.println(0);
			else pw.println(lists[v].get(k-1));
			pw.flush();
		}
		}
		
		pw.close();
	}
	static PrintWriter pw=new PrintWriter(System.out);
}
