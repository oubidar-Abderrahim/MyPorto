package playing.maybe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClasss {

	public static void main(String[] args) {

		// Scanner scanner = new Scanner(System.in);

		// String str = scanner.next();

		String str = "00:01:00\nahmed,mezyan,00:01:00\nkarim,ajdou,00:00:52\njam"
				+ "al,tiberkani,00:01:01\nAziz,chmari,00:01:10\n----\n00:01:20\nsamira,ato"
				+ "uch,00:01:30\namal,mahir,00:02:02\nloubna,sariaa,00:01:11\njihan,basel,00:01:21\n----";

		System.out.println(str);
		System.out.println();

		String textStr[] = str.split("\\r\\n|\\n|\\r");

		for (String en : textStr) {
			System.out.println("line : " + en);
		}

		System.out.println();
		System.out.println();

		List<String> answer = whoIsQualified(textStr);

		for (String en : answer) {
			System.out.println("answer : " + en);
		}
	}

	public static List<String> whoIsQualified(String[] info) {

		int time = 0;
		List<String> qualifiedList = new ArrayList<>();
		StringBuilder result = new StringBuilder();
		
		for (String line : info) {
			if (line.equals("----")) {
				if (result.length() == 0) {
					qualifiedList.add("NONE");
					time = 0;
				} else {
					result.setLength(result.length() - 1);
					qualifiedList.add(result.toString());
					time = 0;
					result = new StringBuilder();
				}
			} else {
				if (time == 0) {
					String[] timeTable = line.split(":");
					time += (Integer.parseInt(timeTable[0]) * 60 * 60);
					time += (Integer.parseInt(timeTable[1]) * 60);
					time += (Integer.parseInt(timeTable[2]));
					continue;
				} else {
					String[] dataTable = line.split(",");
					int personalTime = 0;
					String[] timeTable = dataTable[dataTable.length - 1].split(":");
					personalTime += (Integer.parseInt(timeTable[0]) * 60 * 60);
					personalTime += (Integer.parseInt(timeTable[1]) * 60);
					personalTime += (Integer.parseInt(timeTable[2]));
					if (personalTime <= time) {
						result.append(dataTable[0] + " " + dataTable[1] + ",");
					}
				}
			}
		}
		return qualifiedList;
	}

}
