package ma.Ensa.firstproject;

public class App
{
    public static void main( String[] args )
    {
        Student student = new Student("123456", "Doe", "John", "john.doe@example.com", "1234567890"); 
        String json = StudentConverter.stringToGson(student);
        System.out.println("This is json : "+json);
        Student convertedJson = StudentConverter.studentFromGson(json);
        System.out.println("student name : "+ convertedJson.getNom());
    }
}
