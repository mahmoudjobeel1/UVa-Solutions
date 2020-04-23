// using the color full graph technique 
// no two adjecant nodes have the same color 
// making that by using bfs or dfs 


import java.util.*;
import java.io.*;

public class Main {
	static int [] color;
	static ArrayList<Integer>[]lists;
	
	static boolean isbipartite(int s) {
		color[s]=1;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(s);
		while(!queue.isEmpty()) {
			int u=queue.poll();
			for(int v:lists[u]) {
				if(color[v]==0) queue.add(v);
				if(color[v]==color[u]) return false;
				color[v]=3-color[u];
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		while(true) {
			int x=sc.nextInt();
			if(x==0) break;
			lists=new ArrayList[x+1];
			color =new int [x+1];
			for(int i=1;i<=x;i++) lists[i]=new ArrayList<>();
			int u=sc.nextInt(); int v=sc.nextInt();
			while(u!=0 && v!=0) {
				lists[u].add(v); lists[v].add(u);
				u=sc.nextInt(); v=sc.nextInt();
			}
			boolean f=true;
			for(int i=1;i<=x;i++) {
				if(color[i]==0) {
					f=f && isbipartite(i);
				}
			}
			pw.println(f?"YES":"NO");
		}
		pw.flush();
		pw.close();
	}
      static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
