public class Exercise3_2 {

	public static void main(String[] args) {
		int numOfApples = 123;
		int sizeOfBucket = 10;
		
		int result=numOfApples/sizeOfBucket;
		
		int numOfBucket = (numOfApples%sizeOfBucket==0)?(result):(result+1);
		
		System.out.println("필요한 바구니의 수 : "+numOfBucket);

	}

}
