// to count the number of trees we use the fact that a gragh is atree if the number of edges=num of nudes -1
// counting the number of edges by using bfs or dfs

import java.util.*;
import java.io.*;

  
public class Main {
	static ArrayList<Integer>[]lists;
	static int count_edges;
	static HashSet<Integer>set;
	static boolean [] visited;
	static void dfs(int s) {
		visited[s]=true;
		set.add(s);
		for(int u:lists[s])
			if(!visited[u]) {
				dfs(u);
				count_edges++;
			}
	}
	public static void main(String[] args) throws Exception {
		int t=sc.nextInt();
		while(t-->0) {
			lists=new ArrayList[27];
			visited=new boolean[27];
			for(int i=0;i<27;i++) lists[i]=new ArrayList<>();
			String x=sc.next();
			while(x.charAt(0)!='*') {
				int u=x.charAt(1)-'A'; int v=x.charAt(3)-'A';
				lists[u].add(v);
				lists[v].add(u);
				x=sc.next();
			}
			x=sc.next();
			int tree=0,acorn=0;
			for(int i=0;i<x.length();i+=2) {
				int s=x.charAt(i)-'A';
				set=new HashSet<>();
				count_edges=0;
				if(!visited[s]) dfs(s);
				if(set.size()==1) acorn++;
				else if(set.size()==count_edges+1) tree++;
			}
			pw.println("There are "+tree+" tree(s) and "+acorn+" acorn(s).");
			
		}
		pw.flush();
		pw.close();
	}

static class Scanner
{
    StringTokenizer st;
    BufferedReader br;

    public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

    public String next() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws IOException {return Integer.parseInt(next());}
    public boolean ready() throws IOException {return br.ready();}

}
	static PrintWriter pw=new PrintWriter(System.out);
	static Scanner sc=new Scanner(System.in);
 
}
