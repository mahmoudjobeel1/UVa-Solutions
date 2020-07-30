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
	static  int n;
	static char [][] grid;
	static int max;
	static int mod=20437;
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,1,-1};
	static boolean valid (int i,int j,int k) {
		return i>=0 && i<n && j<n && j>=0 && (grid[i][j]=='.' || grid[i][j]==(char)(k+'A'));
	}
	public static void main(String[] args) throws IOException {
		
		int t=1;
		out: while(true) {
			n=sc.nextInt();
			if(n==0) break;
			grid=new char[n][n];
			max=0;
			int x=-1,y=-1;
			for(int i=0;i<n;i++) {
				grid[i]=sc.next().toCharArray();
				for(int j=0;j<n;j++) {
					if(grid[i][j]>='A' && grid[i][j]<='Z') {
						if(grid[i][j]=='A') {
							x=i; y=j;
						}
						max=Math.max(max,grid[i][j]-'A');
					}
				}
			}
			int mindist=0,ways=1;
			for(int k=1;k<=max;k++) {
				int [][] distance=new int [n][n];
				int [][] path=new int [n][n];
				Queue<pair> queue=new LinkedList<pair>();
				distance[x][y]=0; path[x][y]=1;
				queue.add(new pair(x,y));
				grid[x][y]='.';
				x=-1; y=-1;
				while(!queue.isEmpty()) {
					pair temp=queue.poll();
					//pw.println(temp);
					int i=temp.i; int j=temp.j;
					if(grid[i][j]==(char)('A'+k)) {
						x=i; y=j;
					}
					for(int w=0;w<4;w++) {
						int i2=i+dx[w]; int j2=j+dy[w];
						if(valid(i2, j2,k)) {
							
							if(distance[i2][j2]==0) {
								distance[i2][j2]=distance[i][j]+1;
								path[i2][j2]=path[i][j];
								queue.add(new pair(i2, j2));
							}else if(distance[i2][j2]==distance[i][j]+1) {
								path[i2][j2]=(path[i2][j2]+path[i][j])%mod;
							}
						}
					}
				}
				if(x==-1) {
					pw.println("Case "+(t++)+": Impossible");
					continue out;
				}
				mindist+=distance[x][y];
				ways=(ways*path[x][y])%mod;
			}
			pw.println("Case "+(t++)+": "+mindist+" "+ways);
		}
		pw.flush();
		pw.close();
	}
	
	static class pair{
		int i,j;
		public pair(int i,int j) {
			this.i=i; this.j=j;
		}
		public String toString() {return i+" "+j;}
	}
	
	
    static class Scanner {
    	 
        private InputStream in;
        private byte[] buffer = new byte[1024];
        private int curbuf;
        private int lenbuf;
 
        public Scanner(InputStream in) {
            this.in = in;
            this.curbuf = this.lenbuf = 0;
        }
 
        public boolean hasNextByte() {
            if (curbuf >= lenbuf) {
                curbuf = 0;
                try {
                    lenbuf = in.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0)
                    return false;
            }
            return true;
        }
 
        private int readByte() {
            if (hasNextByte())
                return buffer[curbuf++];
            else
                return -1;
        }
 
        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
 
        private void skip() {
            while (hasNextByte() && isSpaceChar(buffer[curbuf]))
                curbuf++;
        }
 
        public boolean hasNext() {
            skip();
            return hasNextByte();
        }
 
        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
 
        public int nextInt() {
            if (!hasNext())
                throw new NoSuchElementException();
            int c = readByte();
            while (isSpaceChar(c))
                c = readByte();
            boolean minus = false;
            if (c == '-') {
                minus = true;
                c = readByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = readByte();
            } while (!isSpaceChar(c));
            return (minus) ? -res : res;
        }
 
        public long nextLong() {
            if (!hasNext())
                throw new NoSuchElementException();
            int c = readByte();
            while (isSpaceChar(c))
                c = readByte();
            boolean minus = false;
            if (c == '-') {
                minus = true;
                c = readByte();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = readByte();
            } while (!isSpaceChar(c));
            return (minus) ? -res : res;
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        public Integer [] sortedIntArray(int n) {
        	Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            Arrays.sort(a);
            return a;
        }
        public Long [] sortedLongArray(int n) {
        	Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            Arrays.sort(a);
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
 
    }
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
}
