import java.util.Scanner;

public class Tiling {
	public static int tile(int len, int wid){
		int result = 0;
		int tileSz = 1;
		int size = 0;
		int size2 = 0;
		int total = 0;
		//Checks base case 1 if the rooms dimensions are 0
		if(wid ==0 || len==0){
			
		}
		//Checks base case 2 if the rooms length or width are 1
		else if (wid == 1|| len ==1){
			result += wid*len;
		} else {
			//Finds if either the length or width as a smaller size
			if (wid > len){

				size= len;
				
				size2 = wid;
			}else{
				
				size = wid;
				size2 = len;
			}
			//Finds the biggest tile size that can fit in the current room
			while(tileSz <= size){
				tileSz = tileSz*2;
			}
			tileSz =tileSz /2;
			//Increments number of tiles by 1 for the 1 tile used
			result +=1;
			//Passes the two smaller sub rooms created after the biggest tile has been taken out of the rooms total space
			result += tile((size - tileSz), size2);
			result += tile((size - (size - tileSz)), size2 - tileSz);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Gets room size from user
		System.out.println("Enter room size");
		int len =sc.nextInt();
		int wid =sc.nextInt();
		//Outputs minimum number of tiles to tile the room.
		System.out.println(tile(len, wid));
	}

}
