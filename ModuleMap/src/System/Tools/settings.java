package System.Tools;

import java.util.Stack;
public class settings {
	public static int MAX_POINT = 3000;
	public final static boolean DEBUG_MODE=false;
	/***************************************************************/
	/*	函数：getJSON(String s)
	 *  参数：String s
	 *  功能：在包含JSON的字符串中寻找并返回JSON，本程序中用它来从get请
	 *     	   返回的内容中提取JSON
	 *  返回：满足要求的字符串(String)
	 *  实例：
	 *  	String JSON = "header, {JSON}";
	 *  	System.out.println(getJSON(JSON));
	 *  输出：{JSON}
	 */
	/***************************************************************/
	public static String getJSON(String s) {
		String JSON = s.substring(s.indexOf('{'),s.length());
		return JSON;
	}
	
	/***************************************************************/
	/*	函数：getJSONLen(String JSON)
	 *  参数：int
	 *  功能：获取JSON数组长度
	 *  返回：满足要求的字符串(String)
	 *  实例：
	 *  	String JSON = "[{1},{2},3,"4"]";
	 *  	System.out.println(getJSONLen(JSON,1));
	 *  输出：
	 *  	4
	 */
	/***************************************************************/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int getJSONLen(String json) {
		if(json.charAt(0)!='['||json.charAt(json.length()-1)!=']') {
			System.out.println("json form is incorrect");
			return -1;
		}
		String JSON = json.substring(1,json.length()-1);
		int index_tmp=1;
		Stack s = new Stack();
		int beg=0;
		int end=beg+1;
		for(int i=0;i<JSON.length();i++) {
			char c = JSON.charAt(i);
			if(s.isEmpty()&&c==',') {
				index_tmp++;
			}
			if(c=='{'||c=='[') {
				s.push(i);
			}
			if(c=='}'||c==']') {
				s.pop();
			}
		}
		return index_tmp;
	}
	
	/***************************************************************/
	/*	函数：getByIndex(String JSON,int index)
	 *  参数：String JSON,int index
	 *  功能：获取JSON数组中对应index位置的内容
	 *  返回：满足要求的字符串(String)
	 *  实例：
	 *  	String JSON = "[{1},{2},3,"4"]";
	 *  	System.out.println(getByIndex(JSON,1));
	 *  	System.out.println(getByIndex(JSON,2));
	 *  	System.out.println(getByIndex(JSON,3));
	 *  	System.out.println(getByIndex(JSON,4));
	 *  输出：
	 *  	{1}
	 *  	{2}
	 *  	3
	 *  	"4"
	 */
	/***************************************************************/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getByIndex(String json,int index) {
		int beg=0;
		int end=beg+1;
		if(json.charAt(0)!='['||json.charAt(json.length()-1)!=']') {
			System.out.println("json form is incorrect");
			return null;
		}
		String JSON = json.substring(1,json.length()-1);
		int index_tmp=1;
		Stack s = new Stack();
		boolean flg_beg = true;
		boolean flg_end = true;
		
		for(int i=0;i<JSON.length();i++) {
			char c = JSON.charAt(i);
			if(c=='{'||c=='[') {
				s.push(i);
			}
			if(c=='}'||c==']') {
				s.pop();
			}
			if(s.isEmpty() && c==',') {
				index_tmp++;
				if(index==index_tmp) {
					flg_beg=false;
					beg = i+1;
				}
				if(index+1==index_tmp) {
					flg_end=false;
					end = i;
					break;
				}
			}
		}
		if(flg_beg) {
			beg=0;
		}
		if(flg_end) {
			end=JSON.length();
		}
		return JSON.substring(beg,end);
			
	}
	/***************************************************************/
	/*	函数：findAttribute
	 *  参数：String JSON,String Attribute
	 *  功能：在JSON中寻找某个属性对应的值，支持返回"{}"和"[]"包裹的内容
	 *  返回：满足要求的字符串
	 *  实例：
	 *  	String JSON ="{"attr":"12345","attr1":{"a":1,"b":2},attr2:["1":1]}";
	 *  	System.out.println(findAttribute(JSON,"attr"));
	 *  	System.out.println(findAttribute(JSON,"attr1"));
	 *  	System.out.println(findAttribute(JSON,"attr2"));
	 *  输出：
	 *  	12345
	 *  	{"a":1,"b":2}
	 *  	["1":1]
	 */
	/***************************************************************/
	public static String findAttribute(String JSON,String Attribute) {
		int pos = JSON.indexOf(Attribute);
		int d = 0;
		while(JSON.charAt(d+pos)!=':') {
			d++;
		}
		while(JSON.charAt(d+pos)==' ' || JSON.charAt(d+pos)=='\"') {
			d++;
		}
		d++;
		pos = d+pos;
		if(JSON.charAt(pos)=='{') {
			Stack s = new Stack();
			int end = 0;
			for(int i = pos; i<JSON.length();i++) {
				char c = JSON.charAt(i);
				if(c=='{') {
					s.push(i);
				}
				else if(c=='}') {
					int k = (int) s.pop();
					if(k==pos) {
						end = i+1;
						break;
					}
				}
			}
			String ret = JSON.substring(pos,end);
			return ret;
		}
		else if(JSON.charAt(pos)=='['){
			Stack s = new Stack();
			int end = 0;
			for(int i = pos; i<JSON.length();i++) {
				char c = JSON.charAt(i);
				if(c=='[') {
					s.push(i);
				}
				else if(c==']') {
					int k = (int) s.pop();
					if(k==pos) {
						end = i+1;
						break;
					}
				}
			}
			String ret = JSON.substring(pos,end);
			return ret;
		}
		else {
			int beg = pos;
			int end = pos+1;
			if(JSON.charAt(beg)=='\"') {
				beg ++ ;
				while(JSON.charAt(end)!='\"') {
					end++;
				}
				String ret = JSON.substring(beg,end);
				return ret;
			}
			else {
				while(JSON.charAt(end)!=','&&JSON.charAt(end)!='}') {
					end++;
				}
				String ret = JSON.substring(beg,end);
				return ret;
			}
		}
	}
	public static point[] Link(point []a,point []b) {
		int index=1;
		point[]ret = new point[a.length+b.length-1];
		for(int i=1;i<a.length;i++) {
			ret[index++]=a[i];
		}
		for(int i=1;i<b.length;i++) {
			ret[index++]=b[i];
		}
		return ret;
	}
}
