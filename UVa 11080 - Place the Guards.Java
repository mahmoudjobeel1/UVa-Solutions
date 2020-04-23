// using the color full graph technique 
// no two adjecant nodes have the same color 
// making that by using bfs or dfs 

import java.util.*;
import java.io.*;

public class Main {
    static int [] color;
    static ArrayList<Integer>[] lists;
    static int c=1,constant;
    static boolean isbipartite(int s) {
    	Queue<Integer> queue=new LinkedList<Integer>();
    	queue.add(s);
    	color[s]=c;
    	while(!queue.isEmpty()) {
    		int u=queue.poll();
    		for(int v:lists[u]) {
    		if(color[v]==0) queue.add(v);
    		if(color[u]==color[v]) return false;
    		color[v]=constant-color[u];
    		}
    	}
    	return true;
    }
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int t=sc.nextInt();
		while(t-->0) {
			int x=sc.nextInt();
		    lists=new ArrayList[x];
			
			for(int i=0;i<x;i++) lists[i]=new ArrayList<>();
			int y=sc.nextInt();
			while(y-->0) {
				int u=sc.nextInt(); int v=sc.nextInt();
				lists[u].add(v);
				lists[v].add(u);
			}
			
			c=1;
			constant=3;
			boolean f=true;
			int ans=0;
			color=new int [x];
			for(int i=0;i<x;i++) {
				if(color[i]==0) {
				if(!isbipartite(i)) {ans=-1; break;}
				else {
					int c1=0,c2=0;
					for(int u:color) {
						if(u==c) c1++;
						else if(u==c+1) c2++;
					}
					if(c2==0 || c1==0) ans+=c1+c2;
					else {
					int temp=Math.min(c1, c2);
					ans+=temp;
					}
					
				}
				c+=2;
				constant=(c*2)+1;
				}
			}
			
			pw.println(ans);
		}
		pw.flush();
		pw.close();
	}
}
