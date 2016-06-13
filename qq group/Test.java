package qq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class Test {

	public static void main(String[] args)throws IOException  {

		 print2();
	}

	public static  void print1() throws IOException
	{
		String fileName = "C:\\Users\\wangxiaofei\\qq.txt";
		File file = new File(fileName);
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = "";
		int i = 0;
		StringBuilder sb =new StringBuilder();
		while ((lineTxt = bufferedReader.readLine()) != null) {
			if (StringUtils.isBlank(lineTxt)) {
				break;
			}
			lineTxt = StringUtils.trimToEmpty(lineTxt);
			sb.append(lineTxt);
			sb.append(" ");
			if (++i % 4 == 0) {
				System.out.println(sb.toString());
				sb =new StringBuilder();
			}
			
		}
		read.close();
		bufferedReader.close();
	}
	
	public static  void print2() throws IOException
	{
		String fileName = "C:\\Users\\wangxiaofei\\qq2.txt";
		File file = new File(fileName);
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = "";
		int i = 0;
		StringBuilder sb =new StringBuilder();
		while ((lineTxt = bufferedReader.readLine()) != null) {
			if (StringUtils.isBlank(lineTxt)) {
				break;
			}
			++i;
			if(i==40)
			{
				System.out.println();
			}
			lineTxt = StringUtils.trimToEmpty(lineTxt);
			String [] temp =lineTxt.split(" ");
	
			String [] temp2 = temp[3].split("\\t");
			String qq=temp2[0].substring(0, 3)+"****"+temp2[0].substring(6);
			System.out.println(temp[2]+"	"+qq+"	"+temp2[3].replace('/', '-'));
			
		}
		read.close();
		bufferedReader.close();
	}
}
