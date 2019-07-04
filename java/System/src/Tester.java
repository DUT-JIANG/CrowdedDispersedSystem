import org.model.Query;
import org.model.UserDao;
public class Tester {

	public static void main(String[] args) {
		UserDao.match("asfa","GUYGY");
		UserDao.match("asfa","123");
	}
}