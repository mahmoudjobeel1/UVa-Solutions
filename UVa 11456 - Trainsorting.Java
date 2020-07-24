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
	/*
	 * 19 
	 * 12 18 0 4 10 2 17 7 1 3 8 15 9 13 5 14 11 16 6
	 */
	
	/* 
	 * 15 
	 * 10 3 13 1 4 9 8 12 6 14 5 7 2 0 11
	 */

	public static void main(String[] args) throws IOException {
		int t=sc.nextInt();
		while(t-->0) {
			int x=sc.nextInt();
			int [] arr=sc.nextIntArray(x);
			// Longest Increasing subsequance
			int [] LIS=new int[x];
			// Longest Decreasing subsequance
			int [] LDS=new int [x];
			
			for(int i=x-1;i>=0;i--) {
				LDS[i]=LIS[i]=1;
				for(int j=i+1;j<x;j++) {
					if(arr[i]>arr[j])
						LDS[i]=Math.max(LDS[i], LDS[j]+1);
					if(arr[i]<arr[j])
						   LIS[i]=Math.max(LIS[i], LIS[j]+1);
				}
			}
			//pw.println(Arrays.toString(LIS)+"\n"+Arrays.toString(LDS));
			int max=0;
			for(int i=0;i<x;i++)
				max=Math.max(max, LIS[i]+LDS[i]-1);
			pw.println(max);
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
