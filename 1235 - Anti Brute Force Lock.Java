// Minimum Spanning Tree -> Kruscal Algorithm (DSU)
// find the number of steps from every password to the other sorting them
// get the minimum spanning tree 
// get the minimum value from every passward to "0000"

import java.util.*;
import java.io.*;
public class Main{
	static double distance(double x1,double y1,double x2,double y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	static int steps(char [] x,char [] y) {
		int min=0;
		int a=x[0]-'0',b=y[0]-'0';
		if(a>b) {int temp=a; a=b; b=temp;}
		min+=Math.min(b-a, (9-b)+(a)+1);
		a=x[1]-'0'; b=y[1]-'0';
		if(a>b) {int temp=a; a=b; b=temp;}
		min+=Math.min(b-a, (9-b)+(a)+1);
		a=x[2]-'0';b=y[2]-'0';
		if(a>b) {int temp=a; a=b; b=temp;}
		min+=Math.min(b-a, (9-b)+(a)+1);
		a=x[3]-'0';b=y[3]-'0';
		if(a>b) {int temp=a; a=b; b=temp;}
		min+=Math.min(b-a, (9-b)+(a)+1);
		return min;
	}
	public static void main(String[] args) throws Exception {
		int t=sc.nextInt();
		while(t-->0) {
			int x=sc.nextInt();
			String [] arr=new String[x];
			//arr[0]="0000";
			for(int i=0;i<x;i++) arr[i]=sc.next();
			ArrayList<tuble> list=new ArrayList<>();

			for(int i=0;i<x;i++)
				for(int j=i+1;j<x;j++)
					list.add(new tuble(i, j, steps(arr[i].toCharArray(), arr[j].toCharArray())));
			DSU d=new DSU(x);
			Collections.sort(list);
			//pw.println(list);
			int ans=0;
			for(tuble temp:list)
				if(!d.same(temp.x, temp.y)) {
					d.union(temp.x, temp.y);
					ans+=temp.z;
				}
			int min=Integer.MAX_VALUE;
			for(String w:arr) {min=Math.min(min, steps("0000".toCharArray(),w.toCharArray()));}
			pw.println(ans+min);
		}
		pw.flush();
		pw.close();
	}
	static class pair1{
		double x,y; 
		public pair1(double x,double y) {this.x=x; this.y=y;}
	}
	static class DSU{
		int [] links,size;
		public DSU(int n) {
			links=new int [n];
			size=new int [n];
			for(int i=0;i<n;i++) {links[i]=i; size[i]=1;}
		}
		public int find(int x) {
			while(x!=links[x]) x=links[x];
			return x;
		}
		public boolean same(int a,int b) {
			return find(a)==find(b);
		}
		public void union(int a,int b) {
			a=find(a);
			b=find(b);
			if(size[b]>size[a]) {int temp=a; a=b; b=temp;}
			size[a]+=size[b];
			links[b]=a;
		}
		public String toString() {return Arrays.toString(links)+"\n"+Arrays.toString(size);}
	}
	static class tuble implements Comparable<tuble>{
		int x,y, z;
		public tuble(int x,int y,int z) {
			this.x=x; this.y=y; this.z=z;
		}
		public int compareTo(tuble o) {return Integer.compare(z,o.z);}
		public String toString() {
			return x+" "+y+" "+z;
		}
	}
  	static PrintWriter pw=new PrintWriter(System.out);
	static Scanner sc=new Scanner(System.in);

}
