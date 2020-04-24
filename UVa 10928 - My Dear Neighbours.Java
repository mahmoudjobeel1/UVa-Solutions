//Graph representation

import java.util.*;
import java.io.*;


  
public class Main{
	public static void main(String[] args) throws Exception {
		int t=sc.nextInt();
		while(t-->0) {
			int x=sc.nextInt();
			int [] neighbours =new int [1002];
			int min=Integer.MAX_VALUE;
			for(int i=1;i<=x;i++) {
				int y;
				neighbours[i]=y=sc.nextLine().split(" ").length;
				min=Math.min(min, y);
			}
			
			StringBuilder sb=new StringBuilder();
			for(int i =1;i<=x;i++)
				if(neighbours[i]==min)sb.append(i+" ");
			pw.println(sb.deleteCharAt(sb.length()-1));
		}
		pw.flush();
		pw.close();
	}

	static class pair{
		int u,v;
		public pair(int u,int v) {this.u=u; this.v=v;}
		public String toString() {return u+" "+v;}
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

    public String nextLine() throws IOException {return br.readLine();}

    public boolean ready() throws IOException {return br.ready();}


}
	static PrintWriter pw=new PrintWriter(System.out);
	static Scanner sc=new Scanner(System.in);
 
}
