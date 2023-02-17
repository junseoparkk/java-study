public class Exercise4_4 {

	public static void main(String[] args) {
		int total=0;
		int flag=1;
		int num = 0;
		
		for(int i=1; total<100; i++,flag=-flag) {
			num=i*flag;
			total+=num;
		}
		
		System.out.println("total: "+total);
		System.out.println("number: "+num);
	}

}
