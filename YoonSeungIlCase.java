package ezMeeting;

import java.util.*;
import java.io.*;

public class YoonSeungIlCase {

	static String teamSchedule[];
	static String data [][][];
	static int Count=-1;
	static int nowMem=-1;

	private static void readAndStore(){
		//입력
		String fileName ="C:/Users/180904/eclipse-workspace/ezMeeting/src/input.txt"; //알고리즘 팀원으로 예를 들어보자
		Scanner inputStream = null;
		System.out.println("The file " + fileName + "\ncontains the following lines : \n");

		try {
			inputStream = new Scanner(new File(fileName));
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName); //혹시나 없을수 있지
			System.exit(0); // 그럼 나가고
		}

		while(inputStream.hasNextLine()) { // 1줄씩 읽자
			String line = inputStream.nextLine();
			if(Count == -1) { // 1번째줄은 사람수
				int numberOfMembers = Integer.parseInt(line); //정수변환
				System.out.println("There are "+numberOfMembers+ " members");
				data = new String[numberOfMembers][5][]; //사람수,월~금,스케줄은 많을수도 적을수도
			}
			else { //요일을 읽고 해당하는 요일에 값을 채워 넣어야지. 요일도 채워야 되나 모르겠네
				String day = line.substring(0,3); //이름이 Mon,Tue,Wed,Thu,Fri로 시작하는 사람은 없다 치고
				if(day.equals("Mon")) { // 읽은줄이 월요일이면 띄어쓰기 단위로 쪼개서 어레이에 넣자
					data[nowMem][0] = line.split(" ");
				}
				else if(day.equals("Tue")) { //화
					data[nowMem][1] = line.split(" ");
				}
				else if(day.equals("Wed")) { //수
					data[nowMem][2] = line.split(" ");
				}
				else if(day.equals("Thu")) { //목
					data[nowMem][3] = line.split(" ");
				}
				else if(day.equals("Fri")) { //금
					data[nowMem][4] = line.split(" ");
				}
				else { //월~금이 아니라는 것은 사람이름이라는 거지
					nowMem++;
				}
			}
			System.out.println("#"+(Count+2)+" : " + line); //그냥
			Count++;
		}
		inputStream.close(); //이제 스트림 필요없음
	}//입력 다됐고

	public static void main(String[] args) throws IOException {
		readAndStore();
	}
}