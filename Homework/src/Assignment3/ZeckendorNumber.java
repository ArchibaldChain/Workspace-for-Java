package Assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ZeckendorNumber {
	@SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer> ns = new ArrayList<Integer>();
		if (t>=1&&t<=150) {
			for (int i = 0; i < t; i++) {
				int n = sc.nextInt();
				ns.add(n);
			}
			for (int i = 0; i < t; i++) {
				Object[] cards = new Object[10];
				for (int j = 0; j < cards.length; j++) {
					cards[j] = new ArrayList<Integer>();
				}
				if (ns.get(i)>=1&&ns.get(i)<=100) {
					for (int j = 1; j <= ns.get(i); j++) {
						ArrayList<Integer> result = new ArrayList<Integer>();
						fib(j, result);
						Collections.reverse(result);
						sortCards(j, result, cards);
					}
					for (int j = 1;j<=10; j++) {
						if (isNull((ArrayList<Integer>)cards[j-1])) {
							break;
						}
						System.out.println("Card #"+j+": "+ show((ArrayList<Integer>)cards[j-1]));
					}
				} else {
					System.out.println("Invalid Number");
				}
			}
		}
	}

	private static boolean isNull(ArrayList<Integer> arrayList) {
		if (arrayList.isEmpty()) {
			return true;
		}
		return false;
	}

	@SuppressWarnings({ "unchecked"})
	public static void sortCards(int j, ArrayList<Integer> result, Object[] cards) {
		for (int re : result) {
			switch (re) {
			case 1:
				((ArrayList<Integer>) cards[0]).add(j);
				break;
			case 2:
				((ArrayList<Integer>) cards[1]).add(j);
				break;
			case 3:
				((ArrayList<Integer>) cards[2]).add(j);
				break;
			case 5:
				((ArrayList<Integer>) cards[3]).add(j);
				break;
			case 8:
				((ArrayList<Integer>) cards[4]).add(j);
				break;
			case 13:
				((ArrayList<Integer>) cards[5]).add(j);
				break;
			case 21:
				((ArrayList<Integer>) cards[6]).add(j);
				break;
			case 34:
				((ArrayList<Integer>) cards[7]).add(j);
				break;
			case 55:
				((ArrayList<Integer>) cards[8]).add(j);
				break;
			case 89:
				((ArrayList<Integer>) cards[9]).add(j);
				break;
			}
		}
	}

	private static void fib(int n,ArrayList<Integer> result) {
		int lo = 0;
		int hi = 1;
		while (true) {
			hi = lo + hi;
			lo = hi - lo;
			if (hi>n) {
				result.add(lo);
				if (n-lo != 0) {
					fib(n-lo,result);
				}
				break;
			}
		}
	}
	
	public static String show(ArrayList<Integer> cards) {
		StringBuilder sbd = new StringBuilder();
		for (int num : cards) {
			sbd.append(num+" ");
		}
        return sbd.toString();
    }
}
