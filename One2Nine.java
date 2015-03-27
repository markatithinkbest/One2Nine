import java.util.Arrays;
import java.util.Random;

public class One2Nine {
	static int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static Random rnd;
	static int s1 = 0;
	static int s2 = 0;
	static int s3 = 0;
	static int s4 = 0;
	static int s5 = 0;

	public static boolean meet1() {
		s1 = num[0] * 10 + num[1];
		s2 = num[2];
		s3 = num[3] * 10 + num[4];
		s4 = num[5] * 10 + num[6];
		s5 = num[7] * 10 + num[8];
		if (s1 * s2 != s3) {
			return false;
		}
		if (s3 + s4 != s5) {
			return false;
		}

		return true;
	}

	public static boolean meet2() {
		s1 = num[0] - num[1];
		s2 = num[3] / num[4];
		s3 = num[6] + num[7];

		if (s1 != num[2]) {
			return false;
		}
		if (s2 != num[5]) {
			return false;
		}
		if (s3 != num[8]) {
			return false;
		}
		if (s3 != s1 * s2) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		rnd = new Random();
		find(1);
		find(2);
	}

	static void find(int question) {
		int pos1 = 0;
		int pos2 = 0;
		int temp = 0;
		boolean result = false;
		for (long i = 0; i < 1000000; i++) {
			pos1 = rnd.nextInt(9);
			pos2 = rnd.nextInt(9);
			temp = num[pos1];
			num[pos1] = num[pos2];
			num[pos2] = temp;
			switch (question) {
			case 1:
				result = meet1();
				break;
			case 2:
				result = meet2();
				break;
			}

			if (result) {
				System.out.println(i + " sol " + question + ":"
						+ Arrays.toString(num));
				return;
			}
		}
	}
}
