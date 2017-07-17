import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DatabaseMain {

	public static void main(String[] args) throws FileNotFoundException {
		//Creates an instance of the student database
		StudentDatabase database = new StudentDatabase();
		database.readStudentDataBase("StudentData.txt");
		//System.out.println("read");
		//Saves student Database 
		database.saveStudentDatabase("StudentData.txt");
		//Choice between bubble sort or select sort
		//database.fliperino();
		database.selecterino();
		//Outputs the student database
		String[] data = database.output();
		for (int i= 0; i < database.getStudent()-1; i++){
			System.out.println(data[i]);
		}
		//Outputs the number of females
		System.out.println(database.numFemales());
		//Outputs number of students taking a specific course
		System.out.println(database.numCourse("SCH3UH02"));
		//System.out.println(database.linear("19891013"));
		//Outputs student info by name
		System.out.println(database.binary("Abdi"));
		
				
	}
}


	

	
		

