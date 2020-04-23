// making a flood fill in the 4 directions

import java.util.*;
import java.io.*;
public class Main {
   static boolean [][]visited;
   static char [][] grid;
   static int[] dr= {-1,1,0,0};
   static int []dc= {0,0,1,-1};
   static int size;
   static boolean check(int i,int j) {
	   return i>=0 && j>=0 && i<size && j<size && !visited[i][j] && (grid[i][j]=='x' || grid[i][j]=='@');
   }
   static void flodfill(int i,int j) {
	   if(!check(i, j)) return;
	   visited[i][j]=true;
	   for(int k=0;k<4;k++)
		   flodfill(i+dr[k], j+dc[k]);
   }
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int t=sc.nextInt();
		for(int k=1;k<=t;k++) {
			size=sc.nextInt();
			grid=new char[size][];
			visited=new boolean[size][size];
			for(int i=0;i<size;i++) grid[i]=sc.next().toCharArray();
			int ans=0;
			for(int i=0;i<size;i++)
				for(int j=0;j<size;j++) {
					if(check(i, j) && grid[i][j]=='x') {
						ans++;
						flodfill(i, j);
					}
				}
			pw.println("Case "+k+": "+ans);
		}
		pw.flush();
		pw.close();
	}
      static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

}
