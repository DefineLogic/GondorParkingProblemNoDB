import java.util.HashMap;


public class TestMat {

	public static void main(String args[]){
		int count=1;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++){
				System.out.print(count);
				count++;
			}
			System.out.println();
		}
		
		HashMap<String,Integer> ab= new HashMap<String ,Integer>();
		System.out.println(ab.get("abc"));
		
	}
}
