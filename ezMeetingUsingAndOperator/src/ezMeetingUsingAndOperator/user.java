package ezMeetingUsingAndOperator;

public class user {
	String name;
	boolean[][] schedule;

	//constructor for initialize
	public user (String tempName){
		this.name = tempName;
		this.schedule = new boolean[][] {{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}};
	}

	//return name
	public String getName(){
		return this.name;
	}

	
	//Input : days of the week, splited line
	public void setUp(int day,String[] tempLine2) {
		//loop this til the line's end
		for(int i = 1 ; i<tempLine2.length ; i=i+2) {
			//start : start of user's idle time
			int start = Integer.parseInt(tempLine2[i]);
			//end : end of user's idle time
			int end = Integer.parseInt(tempLine2[i+1]);
			//from start to end, user's idle time display by boolean value
			//true : idle
			//false : busy
			for(int j = start ; j<end ; j++) {
				this.schedule[day][j] = true;
			}
		}
	}
	
	//Input : some line
	//Function : split the line and go to setUp method with days of the week and line
	public void setSchedule(String tempLine) {
		String[] tempLine2 = tempLine.split(" ");
		if(tempLine2[0].equals("Mon")) {
			setUp(0,tempLine2);
		}
		else if(tempLine2[0].equals("Tue")) {
			setUp(1,tempLine2);
		}
		else if(tempLine2[0].equals("Wed")) {
			setUp(2,tempLine2);
		}
		else if(tempLine2[0].equals("Thu")) {
			setUp(3,tempLine2);
		}
		else if(tempLine2[0].equals("Fri")) {
			setUp(4,tempLine2);
		}
	}
}
