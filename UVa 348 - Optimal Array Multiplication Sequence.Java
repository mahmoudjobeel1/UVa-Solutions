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


public class Main{
	static int n;
	static int [] row,col;
	static long [][] memo;
	static StringBuilder ans;
	
	static long dp(int i,int j) {
		if(i==j) return 0;
		if(memo[i][j]!=-1) return memo[i][j];
		long min=(long)1e9;
		for(int k=i;k<j;k++)
			min=Math.min(min, dp(i, k)+dp(k+1, j)+row[i]*col[j]*col[k]);
		return memo[i][j]=min;
	}
	static void trace(int i,int j) {
		if(i==j) { ans.append("A"+(i+1)); return;}
		for(int k=i;k<j;k++)
			if(dp(i, j)==dp(i, k)+dp(k+1, j)+row[i]*col[j]*col[k]) {
				ans.append("(");
				trace(i, k);
				ans.append(" x ");
				trace(k+1, j);
				ans.append(")");
				break;
			}
	}
	public static void main(String[] args) throws IOException {
		n=sc.nextInt();
		int t=1;
		while(n!=0) {
			row=new int [n];
			col=new int [n];
			for(int i=0;i<n;i++) {row[i]=sc.nextInt(); col[i]=sc.nextInt();}
			memo=new long [n+1][n+1];
			for(long [] a:memo) Arrays.fill(a,-1);
			ans=new StringBuilder();
			//pw.println(dp(0, n-1));
			trace(0, n-1);
			pw.print("Case "+(t++)+": ");
			pw.println(ans);
			n=sc.nextInt();
		}
		pw.flush();
		pw.close();
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
