import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class ReadCsvFile {

	public static void main(String[] args) {
		Set<Person> personList = new HashSet<Person>();
		String line = null;
		String personInfo[];
		try {
		FileReader fr = new FileReader("C:/Users/hp/eclipse-workspace/ReadCSVFile/src/file.csv");
		BufferedReader bf = new BufferedReader(fr);
		
			while((line= bf.readLine())!= null) {
				Person person = new Person();
				String cleanLine = line.replace("\"", "");
				personInfo = cleanLine.split(",");
				person.setNom(personInfo[0]);
				person.setPrenom(personInfo[1]);
				person.setEmail(personInfo[2]);
				person.setPhone(personInfo[3]);
				personList.add(person);
			  }
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		for(Person p : personList) {
			System.out.println("name : "+p.getNom());
			System.out.println("Prenom : "+p.getPrenom());
			System.out.println("Email : "+p.getEmail());
			System.out.println("Phone : "+p.getPhone());
			System.out.println("---------------");
		}
		
	}

}
