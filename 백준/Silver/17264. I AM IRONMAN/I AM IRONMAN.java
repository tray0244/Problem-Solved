import java.io.*;
import java.util.*;

public class Main { // 17264번 I AM IRONMAN
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String info1 = br.readLine();
		String[] cnt = info1.split(" ");
		int count = Integer.parseInt(cnt[0]);
		int player = Integer.parseInt(cnt[1]);

		String info2 = br.readLine();
		String[] scr = info2.split(" ");
		int wScore = Integer.parseInt(scr[0]);
		int lScore = Integer.parseInt(scr[1]);
		int gScore = Integer.parseInt(scr[2]);

		HashMap<String, String> hsmp = new HashMap<String, String>();

		for (int i = 0; i < player; i++) {
			String name = br.readLine();
			String[] name2 = name.split(" ");
			hsmp.put(name2[0], name2[1]);
		}

		int score = 0;
		boolean flag = false;
		for (int i = 0; i < count; i++) {
			String who = br.readLine();
			if (hsmp.containsKey(who) && hsmp.get(who).equals("W")) {
				score += wScore;
			} else {
				score -= lScore;
			}
			if (score < 0) {
				score = 0;
			}
			if (score >= gScore) {
				System.out.println("I AM NOT IRONMAN!!");
				flag = true;
				break;
			}

		}
		if (flag == false) {
			System.out.println("I AM IRONMAN!!");
		}

	}

}