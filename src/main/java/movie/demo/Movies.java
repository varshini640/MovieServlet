package movie.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Data;
@Entity
@Data
public class Movies {
	@Id
	@GeneratedValue
	int id;
	String mname;
	String description;
	String language;
	String[] genre;
	int rateing;
	@Lob
	byte[] poster;	
}
