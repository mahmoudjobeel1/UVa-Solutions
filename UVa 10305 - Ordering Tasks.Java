// Topological sort by using bfs or dfs but bfs is more easy to debugg

import java.util.*;
import java.io.*;
public class Main{
	static ArrayList<Integer>[]lists;
	static boolean [] visited;
	static int [] freq;
	
	public static void main(String[] args) throws IOException{
		
		while(true) {
			int x=sc.nextInt(); int y=sc.nextInt();
			StringBuilder sb=new StringBuilder();
			if(x==0 && y==0) break;
				lists=new ArrayList[x+1];
				visited=new boolean[x+1];
				freq=new int [x+1];
			
			for(int i=1;i<=x;i++) lists[i]=new ArrayList<>();
			while(y-->0) {
				int u=sc.nextInt(); int v=sc.nextInt();
				lists[u].add(v);
				freq[v]++;
			}	
			for(int i=1;i<=x;i++) {
				if(!visited[i] && freq[i]==0) {
					sb.append(i+" ");
					Queue<Integer> queue=new LinkedList<Integer>();
					queue.add(i);
					while(!queue.isEmpty()) {
						//pw.println(1);
						int u=queue.poll();
						visited[u]=true;
						for(int v:lists[u]) {
							if(--freq[v]==0) {queue.add(v); sb.append(v+" "); }
						}
					}
				}
				//pw.println(Arrays.toString(visited));
			}
			pw.println(sb);
		}
		pw.flush();
        pw.close();
    }	
        static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
