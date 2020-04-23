// using bfs to get the minimum number of steps

import java.util.*;
import java.io.*;


public class Main {
		static HashSet<Integer> set;
		static int target;
		static int [] arr;
		
		static int solve(int x) {
			Queue<Integer> queue=new LinkedList<Integer>();
			Queue<Integer> times=new LinkedList<Integer>();
			queue.add(x);
			times.add(0);
			set.add(x);
			while(!queue.isEmpty()) {
				int y=queue.poll();
				int ans=times.poll();
				if(y==target) return ans;
				for(int i:arr) {
				   int temp =(y+i)%10000;
					if(!set.contains(temp)) {
						set.add(temp);
						queue.add(temp);
						times.add(ans+1);
					}
				}
			}
			
			return -1;
		}
    	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int L=sc.nextInt();  target=sc.nextInt();  int x=sc.nextInt();
		int k=1;
	//	Thread.sleep(3000);
		//System.out.println(1);
		while(L!=0 || target!=0 || x!=0) {
		//	System.out.println(1);
			arr=new int[x];
			set=new HashSet<>();
			for(int i=0;i<x;i++) arr[i]=sc.nextInt();
			int ans=solve(L);
			System.out.print("Case "+k+": ");
			System.out.println(ans==-1 ? "Permanently Locked":ans);
			 L=sc.nextInt();  target=sc.nextInt();   x=sc.nextInt();
			k++;
		}
		pw.flush();
		pw.close();
	}
      static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
