public class Exercise4_3 {

	public static void main(String[] args) {
		int total=0;
		int tmp=0;
		
		for(int i=1;i<=10;i++) {
			tmp+=i;
			total+=tmp;
		}
		
		System.out.println(total);
	}

}