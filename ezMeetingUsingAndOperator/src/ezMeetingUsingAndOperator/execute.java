package ezMeetingUsingAndOperator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class execute {

	static boolean available=false;
	
	public static void readAndStored() {
		// TODO Auto-generated method stub
		//location of input file
		String fileName ="C:/Users/180904/eclipse-workspace/ezMeetingUsingAndOperator/src/Goodinput.txt"; //알고리즘 팀원으로 예를 들어보자
		//initialize inputStream
		Scanner inputStream = null;

		//preprocessing for read data
		try {
			inputStream = new Scanner(new File(fileName));
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName); //혹시나 없을수 있지
			System.exit(0); // 그럼 나가고
		}

		//loop this until file have line
		while(inputStream.hasNextLine()) {
			//first line is the number of members
			int numberOfMembers = Integer.parseInt(inputStream.nextLine());
			System.out.println("numberOfMembers : " + numberOfMembers);
			//make instance with the number of members
			user[] users = new user[numberOfMembers];

			//loop the number of members time
			for(int i = 0; i < numberOfMembers; i++) {
				//read line for set name
				String tempName = new String(inputStream.nextLine()); //read name
				//set name by constructor
				users[i] = new user(tempName);
				//loop this for set schedule with days of the week
				for(int j = 0; j < 5; j++)
				{
					String tempLine =new String(inputStream.nextLine()); //read schedule 0-4 map to mon-fri
					users[i].setSchedule(tempLine);
				}
			}
			//디버그 하실때 46번째 줄에 중단점(더블클릭)걸어 놓으시고 Variable창을 띄우거나 users[i]에 커서 올리면 잘 저장됬는지 확인가능
			System.out.println("all data have been stored");

			//from here to calc
			int target = howMany(numberOfMembers);
			if(target == -1) {
				System.exit(0);
			}
			else {
				System.out.println(target + " people wanna meet together");
				user result = new user("RESULT");
				result = users[0];
				//from 0 to target users
				//if target is 5, then 윤승일 ~ 노웅기
				//if target is 4, then 윤승일 ~ 양지민
				for(int i=0 ; i<target ; i++) {
					for(int day=0 ; day < 5 ; day++) {
						for(int time=0 ; time<24 ; time++) {
							result.schedule[day][time] = result.schedule[day][time] & users[i].schedule[day][time];
						}
					}
				}

				System.out.println("RESULT : ");
				System.out.println("00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 ");
				for(int day=0 ; day < 5 ; day++) {
					System.out.println();
					for(int time=0 ; time<24 ; time++) {
						if(result.schedule[day][time] == true) {
							System.out.print("T- ");
							//if somewhere have true(means this time can meet together)
							if(available != true)
								available=true;
						}
						else if(result.schedule[day][time] == false) {
							System.out.print("F- ");
						}
					}
				}
				if(available == false) {
					System.out.println("\noops! "+target +" people cant meet this week");
				}
				System.out.println("\nEND");
			}
		}
	}

	@SuppressWarnings("resource")
	public static int howMany(int threshold) {
		Scanner inputFromKeyboard = new Scanner(System.in);
		System.out.println("How many people wanna meet together?");
		int people = inputFromKeyboard.nextInt();
		if((people > threshold) || (people < 1)) {
			System.out.println("Can't handle with " + people + "\nMax : "+threshold + "\nMin : 1");
			return -1;
		}
		else {
			return people;
		}
	}



	public static void main(String[] args) {
		readAndStored();
	}

}
