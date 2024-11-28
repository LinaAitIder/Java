package ma.Ensa.firstproject;

import com.google.gson.Gson;

public class StudentConverter {
	
	public static String stringToGson(Student student) {
	    Gson gson = new Gson();
	    return gson.toJson(student);  
	}
	
	public static Student studentFromGson(String json) {
	    Gson gson = new Gson();
	    return gson.fromJson(json, Student.class);  
	}
}
