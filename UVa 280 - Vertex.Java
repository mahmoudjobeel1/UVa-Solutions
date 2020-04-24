// Using dfs or bfs , marking the nodes that we can visit
// printing the nodes that we can't reach 

import java.util.*;
import java.io.*;

  
public class Test {
	static ArrayList<Integer>[]edges;
	static boolean [] visited;
	static void dfs(int s) {
		
		for(int v:edges[s])
			if(!visited[v]) {
				visited[v]=true;
				dfs(v);
			}
	}
	public static void main(String[] args) throws Exception {
		int x=sc.nextInt();
		while(x!=0) {
			edges=new ArrayList[x];
			for(int i=0;i<x;i++)edges[i]=new ArrayList<>();
			int u=sc.nextInt();
			while(u!=0) {
				int v=sc.nextInt();
				while(v!=0) {
					edges[u-1].add(v-1);
					v=sc.nextInt();
				}
				u=sc.nextInt();
			}
			
			int t=sc.nextInt();
			while(t-->0) {
				visited=new boolean[x];
				dfs(sc.nextInt()-1);
			    StringBuilder sb=new StringBuilder();
			    int c=0;
			    for(int i=0;i<x;i++) 
			    	if(!visited[i]) {
			    		sb.append((i+1)+" ");
			    		c++;
			    	}
			    pw.println(c==0?0:c+" "+sb.deleteCharAt(sb.length()-1));
			}
			x=sc.nextInt();
		}
		pw.flush();
		pw.close();
	}
	static PrintWriter pw=new PrintWriter(System.out);
	static Scanner sc=new Scanner(System.in);
 
}
