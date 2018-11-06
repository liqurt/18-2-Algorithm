package ezMeeting;

import java.util.*;
import java.io.*;

public class YoonSeungIlCase {

	static String teamSchedule[];
	static String data [][][];
	static int Count=-1;
	static int nowMem=-1;

	private static void readAndStore(){
		//�Է�
		String fileName ="C:/Users/180904/eclipse-workspace/ezMeeting/src/input.txt"; //�˰��� �������� ���� ����
		Scanner inputStream = null;
		System.out.println("The file " + fileName + "\ncontains the following lines : \n");

		try {
			inputStream = new Scanner(new File(fileName));
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName); //Ȥ�ó� ������ ����
			System.exit(0); // �׷� ������
		}

		while(inputStream.hasNextLine()) { // 1�پ� ����
			String line = inputStream.nextLine();
			if(Count == -1) { // 1��°���� �����
				int numberOfMembers = Integer.parseInt(line); //������ȯ
				System.out.println("There are "+numberOfMembers+ " members");
				data = new String[numberOfMembers][5][]; //�����,��~��,�������� �������� ��������
			}
			else { //������ �а� �ش��ϴ� ���Ͽ� ���� ä�� �־����. ���ϵ� ä���� �ǳ� �𸣰ڳ�
				String day = line.substring(0,3); //�̸��� Mon,Tue,Wed,Thu,Fri�� �����ϴ� ����� ���� ġ��
				if(day.equals("Mon")) { // �������� �������̸� ���� ������ �ɰ��� ��̿� ����
					data[nowMem][0] = line.split(" ");
				}
				else if(day.equals("Tue")) { //ȭ
					data[nowMem][1] = line.split(" ");
				}
				else if(day.equals("Wed")) { //��
					data[nowMem][2] = line.split(" ");
				}
				else if(day.equals("Thu")) { //��
					data[nowMem][3] = line.split(" ");
				}
				else if(day.equals("Fri")) { //��
					data[nowMem][4] = line.split(" ");
				}
				else { //��~���� �ƴ϶�� ���� ����̸��̶�� ����
					nowMem++;
				}
			}
			System.out.println("#"+(Count+2)+" : " + line); //�׳�
			Count++;
		}
		inputStream.close(); //���� ��Ʈ�� �ʿ����
	}//�Է� �ٵư�

	public static void main(String[] args) throws IOException {
		readAndStore();
	}
}