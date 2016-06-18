
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Test {

	private static List<String> list = new ArrayList<String>();

	private static List<String> list2 = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		String path = "C:\\Users\\wangxiaofei\\webCopyCoreData.txt";
		list = print3(path);
		String path2 = "C:\\Users\\wangxiaofei\\swiftCopy.txt";
		list2 = print3(path2);
		for (String str1 : list) 
		{
			for (String str2 : list2) 
			{
				String[] temp = str2.split(" ");
				if (str1.startsWith(temp[0])) 
				{
					if(temp.length==3)
					{
						str1=str1+temp[2];
					}
				}
			}
			//System.out.println(str1);
			String[] temp = str1.split(" ");
			if(temp.length==3)
			{
				
				String str = String.format("%-15s %-15s %-15s", temp[0],temp[1],temp[2]);	
				System.out.println(str);
			
			}else
			{
				String str = String.format("%-15s %-15s %-15s %-15s", temp[0],temp[1],temp[2],temp[3]);
				System.out.println(str);
			
			}
		}
		
		
	}

	public static void print1() throws IOException {
		String fileName = "C:\\Users\\wangxiaofei\\webCopy.txt";
		File file = new File(fileName);
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = "";
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while ((lineTxt = bufferedReader.readLine()) != null) {
			if (StringUtils.isBlank(lineTxt)) {
				break;
			}
			lineTxt = StringUtils.trimToEmpty(lineTxt);
			sb.append(lineTxt);
			sb.append(" ");
			if (++i % 4 == 0) {
				String temp =sb.toString();
				temp =StringUtils.trimToEmpty(temp);
				System.out.println(temp);
				sb = new StringBuilder();
			}

		}
		read.close();
		bufferedReader.close();
	}

	public static void print2() throws IOException {
		String fileName = "C:\\Users\\wangxiaofei\\webCopyFormat.txt";
		File file = new File(fileName);
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = "";
		int i = 0;
		while ((lineTxt = bufferedReader.readLine()) != null) {
			if (StringUtils.isBlank(lineTxt)) {
				break;
			}
			++i;
			if (i == 40) {
				System.out.println();
			}
			lineTxt = StringUtils.trimToEmpty(lineTxt);
			String[] temp = lineTxt.split(" ");

			String[] temp2 = temp[3].split("\\t");
			String qq = temp2[0].substring(0, 3) + "****" + temp2[0].substring(6);
			System.out.println(temp[2] + " " + qq + " " + temp2[3].replace('/', '-'));

		}
		read.close();
		bufferedReader.close();
	}

	public static List print3(String path) throws IOException {
		List<String> list = new ArrayList<String>();
		String fileName = path;
		File file = new File(fileName);
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = "";
		while ((lineTxt = bufferedReader.readLine()) != null) {
			if (StringUtils.isBlank(lineTxt)) {
				break;
			}
			StringBuilder sb = new StringBuilder();
			lineTxt = StringUtils.trimToEmpty(lineTxt);
			String[] temp = lineTxt.split(" ");
			for (String str : temp) {
				if (StringUtils.isNotBlank(str)) {
					sb.append(str);
					sb.append(" ");
				}
			}
			String line = sb.toString();
			//System.out.println(StringUtils.trimToEmpty(line));
			list.add(line);
		}
		read.close();
		bufferedReader.close();
		return list;
	}
}
