// Knapsack

import java.util.*;
import java.util.Map.Entry;
import java.io.*;
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
	static int t,w,n;
	static long [] value;
	static long [][]memo;
	static int [] down,up;
	static ArrayList<String> list;
	static long dp(int time,int index) {
		if(time<0) return -(long) 1e9;
		if(index==n || time==0) return 0;
		if(memo[time][index]!=-1) return memo[time][index];
		long take=value[index]+dp(time-(up[index]+down[index]), index+1);
		long leave=dp(time, index+1);
		return memo[time][index]=Math.max(take, leave);
	}
	static void trace(int time,int index) {
		if(time<0 || index==n) return;
		if(dp(time, index)==dp(time, index+1)) trace(time, index+1);
		else {
			list.add(up[index]/w+" "+value[index]);
			trace(time-(up[index]+down[index]), index+1);
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int k=0;
		while(sc.hasNext()) {
			
			t=sc.nextInt(); w=sc.nextInt();
			n=sc.nextInt();
			count=0;
			memo=new long [1001][n];
			value=new long [n];
			down=new int[n];
			up=new int [n];
			list=new ArrayList<>();
			for(long [] a:memo) Arrays.fill(a,-1);
			for(int i=0;i<n;i++) {
				int d=sc.nextInt(); value[i]=sc.nextInt();
				up[i]=d*w;
				down[i]=2*d*w;
			}
			trace(t, 0);
			if(k!=0) pw.println();
			pw.println(memo[t][0]);
			pw.println(list.size());
			for(String st:list) pw.println(st);
			k++;
			pw.flush();
		}
		pw.flush();
		pw.close();
	}
	static PrintWriter pw = new PrintWriter(System.out);
}
