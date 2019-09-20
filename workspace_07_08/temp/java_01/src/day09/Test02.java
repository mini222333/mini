package day09;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Test02 {
	public static void main(String[] args) {
		String msg="Java programming/23000";
		System.out.println(msg.indexOf("/"));
		
		String d1 = msg.substring(0,msg.indexOf("/"));
		String d2 = msg.substring(msg.indexOf("/")+1);
		
		System.out.println(d1);
		System.out.println(d2);
		
		String url = "http://127.0.0.1:8080/web1/list.do";
		System.out.println(url.indexOf('/'));
		System.out.println(url.lastIndexOf('/'));
		System.out.println(url.substring(url.indexOf('/')));
		
		System.out.println(url.contains("web1"));
		
		String data = "2019001_홍길동/ 90_ 70/100";
	    System.out.println(data);
	    data = data.replace('_', '/');
	    System.out.println(data);
		//System.out.println(data.replace('_', '/'));//스트링 불변.안바뀜
		String[] sdata = data.split("/");
        System.out.println(Arrays.toString(sdata));	
        System.out.println("==================");
        data = "2019001_홍길동/ 90_70/100";
        StringTokenizer st = new StringTokenizer(data,"/_");
        System.out.println(st.countTokens());
        while(st.hasMoreElements()) {
        	System.out.println(st.nextToken()+" , ");
        }
	}

}
