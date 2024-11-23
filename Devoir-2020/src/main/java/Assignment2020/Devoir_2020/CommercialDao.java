package Assignment2020.Devoir_2020;

import java.util.Set;

public interface CommercialDao {
	Set<Commercial> selectAll();
	public void delete(String matricule);
	public Commercial getCommercialById(String commercialId);
}
