package ma.Ensa.firstproject;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentConverterTest {

    @Test
    public void testStudentToGson() {
        Student student = new Student("123456", "Doe", "John", "john.doe@example.com", "1234567890"); 
        String json = StudentConverter.stringToGson(student);
        
        assertNotNull(json);
        
    }

    @Test
    public void testStudentFromGson() {
        String json = "{\"cne\":\"123456\",\"nom\":\"Doe\",\"prenom\":\"John\",\"email\":\"john.doe@example.com\",\"phone\":\"1234567890\"}";
        
        Student student = StudentConverter.studentFromGson(json);
        
        assertEquals("Doe", student.getNom());
        assertEquals("john.doe@example.com", student.getEmail());
    }
}
