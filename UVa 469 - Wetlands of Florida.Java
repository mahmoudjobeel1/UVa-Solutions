// just using a simple bfs in the 8 directions

import java.util.*;
import java.io.*;

public class Main {
	static  char [][] land;
	static boolean [][] visited;
	static int [] dx= { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int [] dy= { -1, 1, -1, 0, 1, -1, 0, 1 };
	static int row,col;
	static boolean check(int r,int c) {
		return r>=0 && c>=0 && r<row && c<col && land[r][c]!='L' && !visited[r][c]; 
	}
	static int solve(int r,int c) {
		if(!check(r, c)) return 0;
		int ans=1;
		visited[r][c]=true;
		for(int i=0;i<8;i++) {
			ans+=solve(r+dx[i], c+dy[i]);
		}
		return ans;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		br.readLine();
		StringBuilder ans = new StringBuilder();
		while(t-->0) {
			land = new char[100][100];
			
			row = col = 0;
			String s;
			while (true) {
				s=br.readLine();
				if (s.charAt(0)=='L' || s.charAt(0)=='W') {
					land[row++]=s.toCharArray();
				//	pw.println(s);
					col=s.length();
				} else {
					break;
				}
			}
			while (s!=null && !s.isEmpty()) {
				visited = new boolean[100][100];
				StringTokenizer st=new StringTokenizer(s);
				int x=Integer.parseInt(st.nextToken())-1;
				int y=Integer.parseInt(st.nextToken())-1;
				pw.println(solve(x, y));
				s=br.readLine();
			}
			if(t!=0) pw.println();
		}
		
		pw.flush();
        pw.close();
    }
        static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

 }
