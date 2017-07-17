//Student object that holds the information of the students
public class Student {
private String last;
public String getLast() {
	return last;
}
public void setLast(String last) {
	this.last = last;
}
public String getFirst() {
	return first;
}
public void setFirst(String first) {
	this.first = first;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getCourses() {
	return courses;
}
public void setCourses(String courses) {
	this.courses = courses;
}
private String first;
private String gender;
private String id;
private String dob;
private String courses;
	public Student(String last, String first, String gender, String id, String dob, String courses) {
		this.last = last;
		this.first = first;
		this.gender = gender;
		this.id = id;
		this.dob = dob;
		this.courses = courses;
	}
	public String toString(){
		String result = "";
		result += this.last + " ";
		result +=  this.first + " ";
		result += this.gender + " ";
		result += this.id + " ";
		result += this.dob + " ";
		result += this.courses + " ";
		return result;
		}
		
	public Student() {
		// TODO Auto-generated constructor stub
	}

}
