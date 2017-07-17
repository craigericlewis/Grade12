import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentDatabase {
	private Student[] students;
	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getStudent() {
		return student;
	}

	public void setStudent(int student) {
		this.student = student;
	}

	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}
	private String info = "";
	private int student = -1;
	private boolean sorted = false;
	public StudentDatabase(){
		
	}
	//Implementation of bubble sort
	public void fliperino(){
		Student temp;
		boolean sorted = true;
		
		//Keeps sorting while the database is unsorted
		while (sorted){
			
			sorted = false;
			// Bubbles over students that are out of place 
			for (int i = 0; i < this.students.length-1;i++){
								if (this.students[i].getLast().compareToIgnoreCase(this.students[i+1].getLast()) > 0){
					temp = this.students[i];
					this.students[i] = this.students[i+1];
					this.students[i+1] = temp;
					//Keeps sorting as a bubble has occured
					sorted = true;
				}
			}
		}
		
	}
	//Calculates number of females 
	public int numFemales(){
		int females = 0;
		
		for (int i = 0 ; i < this.students.length; i++){
			if (this.students[i].getGender().equals("F")){
				females++;
			}
		}
		return females;
	}
	//Implementation of a select sort
	public void selecterino(){
		boolean sorted = true;
		int times = 0;
		while(sorted){
			sorted = false;
			String maximum = this.students[times].getLast();
			int max = 0;
			//Finds the smallest element in the remaining unsorted list
			for (int i = times; i < this.students.length-1; i++){
				if(this.students[i].getLast().compareToIgnoreCase(maximum) < 0){
					max = i;
					maximum = this.students[i].getLast();
					
				}
			}
			//Inserts the element to the beginning of the list
			Student temp = this.students[times];
			this.students[times] = this.students[max];
			this.students[max] = temp;
			System.out.println(students[times].getLast());
			times++;
			//If the number of inserts is greater than the size of the database the sorting is finished
			if (times < this.students.length-1){
				sorted = true;
			}
		}
		this.sorted = true;
	}
	//Outputs a specific student from the list
	public String[] output(){
		String result = "";
		String[] result2 = new String[student];
		for (int i = 0; i <this.student -1; i++){
		result = "";
		result += this.students[i].getLast() + " ";
		result +=  this.students[i].getFirst() + " ";
		result += this.students[i].getGender() + " ";
		result += this.students[i].getId() + " ";
		result += this.students[i].getDob() + " ";
		result += this.students[i].getCourses() + " ";
		result2[i] = result;
		}
		return result2;
		
	}
	
	
	public void readStudentDataBase(String filename) throws FileNotFoundException{
		FileReader file = new FileReader(filename);
		
		Scanner sc2 = new Scanner(file);
		while(sc2.hasNextLine()){
			sc2.nextLine();
			this.student += 1;
		}
		
	}
	//Saves the students into a student array
	public void saveStudentDatabase(String filename) throws FileNotFoundException{
		FileReader file = new FileReader(filename);
		
		
		Scanner sc2 = new Scanner(file);
		Student[] kids = new Student[student+1];
		Student temp;
		String[] info2 = info.split(",");
		int i = 0;
		while(sc2.hasNextLine()){
			
			String[] temp2 = sc2.nextLine().split(",");
			temp = new Student(temp2[0], temp2[1], temp2[2], temp2[3], temp2[4], temp2[5]);
			kids[i] = temp;
			i++;
		}
		this.students = kids;
		
	}
	public int numCourse(String course){
		int result =0;
		for (int i = 0; i < this.students.length; i++){
			String[] courses = this.students[i].getCourses().split(" ");
			
			for (int j = 0; j < courses.length; j++){
				if(courses[j].equals(course)){
					result+=1;
				}
			}
		}
		return result;
		
	}
	//Implementation of a binary search
	public Student binary(String search){
		Student result = new Student();
		int low = 0;
		int high = students.length-1;
		boolean searching = true;
		while (searching){
			int location = ((high+low)/2);
			if ((this.students[location].getLast().compareToIgnoreCase(search) == 0)){
				result = students[location];
				searching = false;
			}
			else if ((this.students[location].getLast().compareToIgnoreCase(search) < 0)){
				low = location;
			}
			else if ((this.students[location].getLast().compareToIgnoreCase(search) > 0)){
				high = location;
			}
			else if (high == students.length -1 && low == students.length -2){
				low = high;
			}
			else if(low == high-1 && this.students[location].getLast().compareToIgnoreCase(search) != 0 ){
				searching = false;
				result = null;
			}
		}
		return result;
	}
	//Implementation of a linear search
	public Student linear(String search){
		
		Student result = new Student(); 
		for (int i= 0; i < this.students.length-1;i++ ){
			String[] courses = this.students[i].getCourses().split(" ");
			if(this.students[i].getLast().equals(search)){
				result = students[i];
			}
			else if(this.students[i].getFirst().equals(search)){
				result = students[i];
			}
			else if(this.students[i].getGender().equals(search)){
				result = students[i];
			}
			else if(this.students[i].getId().equals(search)){
				result = students[i];
			}
			else if(this.students[i].getDob().equals(search)){
				result = students[i];
			}
			else{
				for(int j = 0; j < courses.length; j++){
					if (search == courses[j]){
						result = students[i];
					}
				}
			}
		}
		return result;
		
	}
}
