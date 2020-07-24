import java.util.*;

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
public class Main{
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		
		while(sc.hasNext()) {
			int x=sc.nextInt();
			int [] arr=new int [x];
			for(int i=0;i<x;i++) arr[i]=sc.nextInt();
			// Longest Increasing subsequance
			int [] LIS=new int[x];
			// Longest Decreasing subsequance
			int [] LDS=new int [x];
			
			ArrayList<Integer> list=new ArrayList<Integer>();
			list.add(arr[0]);
			LIS[0]=1;
			for(int i=1;i<x;i++) {
				if(list.get(0)>arr[i]) {
					list.set(0,arr[i]);
					LIS[i]=1;
				} else if(list.get(list.size()-1)<arr[i]) {
					list.add(arr[i]);
					LIS[i]=list.size();
				}else {
					int idx=Collections.binarySearch(list,arr[i]);
				//	pw.println(list+" "+idx+" "+arr[i]);

					if(idx<0) {
						list.set((-idx)-1, arr[i]);
						LIS[i]=-idx;
					}else {
						LIS[i]=idx+1;
					}
				}
			}
			//pw.println(list);
			list=new ArrayList<Integer>();
			list.add(arr[x-1]);
			LDS[x-1]=1;
			for(int i=x-2;i>=0;i--) {
				if(list.get(0)>arr[i]) {
					list.set(0,arr[i]);
					LDS[i]=1;
				} else if(list.get(list.size()-1)<arr[i]) {
					list.add(arr[i]);
					LDS[i]=list.size();
				}else {
					int idx=Collections.binarySearch(list,arr[i]);
					if(idx<0) {
						list.set((-idx)-1, arr[i]);
						LDS[i]=-idx;
					}else {
						LDS[i]=idx+1;
					}
				}
			}
			//pw.println(Arrays.toString(LIS)+"\n"+Arrays.toString(LDS));
			int max=0;
			for(int i=0;i<x;i++) {
				int min=Math.min(LIS[i],LDS[i])-1;
				max=Math.max(max, 2*min+1);
			}
			
			pw.println(max);
			pw.flush();
		}
		pw.flush();
		pw.close();
	}

	static PrintWriter pw = new PrintWriter(System.out);
}
