import org.model.Map;
import org.model.SchemeMake.Units.point;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		float x1 = (float)39.084105;
		float y1 = (float)121.817608;
		float x2 = (float)39.057184;
		float y2 = (float)121.781387;
		
		point src=new point(x1,y1);
		point dst=new point(x2,y2);
		Map.getAllJunction(src, dst);
	};

}
