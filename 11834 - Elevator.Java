public class Main {
	
	public static void main(String[] args) throws Exception {
		int length=sc.nextInt(); int width=sc.nextInt(); int R1=sc.nextInt(); int R2=sc.nextInt();
		while(width!=0 || length!=0 && R1!=0 && R2!=0) {
			int min = Math.min(width, length);
			if(2*R1>min || 2*R2>min) pw.println("N");
			else {
		    int x = length - R1 - R2;
		    int y = width - R1 - R2;
		    int r = R1 + R2;
		    if (x * x + y * y >= r * r)
		      pw.println("S");
		    else pw.println("N");
			}
			 width=sc.nextInt();  length=sc.nextInt();  R1=sc.nextInt();  R2=sc.nextInt();
		}
		pw.flush();
		pw.close();
	}
  static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
}
