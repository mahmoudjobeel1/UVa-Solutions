import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.BigInteger;
/*
-> Written by <-
  -----------
 |J_O_B_E_E_L|
 |___________|
 |    ___    |
 |   (^_^)   |
 |  /( | )\  |
 |____|_|____|
*/


public class Main {
	 static pair [] nuts;
	 static int [][] dis;
	 static int [][] memo;
	 static int n;
	 static StringBuilder sb;
	 static boolean checkbit(int mask,int i) { return (mask & 1<<i)==0; }
	 
	 static int setbit(int mask,int i) {return mask | (1<<i);}
	 
	 static int dp(int node ,int mask) {
		 if(mask == (1<<n)-1) return dis[node][0];
		 if(memo[node][mask]!=-1) return memo[node][mask];
		 int min=(int)1e9;
		 for(int i=0;i<n;i++)
			 if(checkbit(mask, i)) {
				 
				 min=Math.min(min, dis[i][node]+dp(i,setbit(mask, i)));
			 }
		 return memo[node][mask]=min;
	 }
	 
//	 static void trace(int node,int mask) {
//		 if(mask==(1<<n)-1) return;
//		 for(int i=0;i<n;i++) {
//			 if(checkbit(mask, i))
//				 if(dp(node, mask)==dis[i][node]+dp(node, setbit(mask, i))) {
//					 sb.append(i+" ");
//					 trace(node, setbit(mask, i));
//					 break;
//				 }
//		 }
//	 }
	 static void minDistance(int a,int b) {
		 int d=Math.abs(nuts[a].r-nuts[b].r)+Math.abs(nuts[a].c-nuts[b].c)-
			   Math.min(Math.abs((nuts[a].r-nuts[b].r)), Math.abs(nuts[a].c-nuts[b].c));
		 dis[a][b]=dis[b][a]=d;
	 }
	 
	    public static void main(String[] args) throws IOException {
	    	Scanner sc=new Scanner(new InputStreamReader(System.in));
	    	while(sc.hasNext()) {
	    		int x=sc.nextInt(); int y=sc.nextInt();
	    		n=1;
	    		nuts=new pair[16];
	    		for(int i=0;i<x;i++) {
	    			char [] ch=sc.next().toCharArray();
	    			for(int j=0;j<y;j++) {
	    				char c=ch[j];
	    				if(c=='L') nuts[0]=new pair(i, j);
	    				else if(c=='#') nuts[n++]=new pair(i, j);
	    			}
	    		}
	    		
	    		dis=new int [n][n];
	    		memo=new int [n][1<<n];
	    		for(int [] a:memo) Arrays.fill(a,-1);
	    		for(int i=0;i<n;i++) 
	    			for(int j=0;j<n;j++) minDistance(i, j);
	    		
	    		System.out.println(dp(0,1));
	    		
	    	}
	    }
	
	static class pair{
		int r,c;
		public pair(int r,int c) {this.r=r; this.c=c;}
		public String toString() {return r+" "+c;}
	}
	static PrintWriter pw = new PrintWriter(System.out);
}
