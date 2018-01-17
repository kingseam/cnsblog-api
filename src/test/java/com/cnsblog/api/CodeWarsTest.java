package com.cnsblog.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;

public class CodeWarsTest {

	@Test
	public void add() {
		System.out.println("aaa=="+LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMDDHHMMSS")));
		long a = Long.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMDDHHMMSS")).toString());
		Date test = new Date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMDDHHMMSS")).toString());


		System.out.println("bbb=="+test);
	}

	private static void testing(int actual, int expected) {
		assertEquals(expected, actual);
	}


	@Test
	public void asd() {
		  Map<String, Object> registParam = null;
	        String menuTestYn = registParam.get("menuTestYn") == null ? "" : (String)registParam.get("menuTestYn");
	}

	@Test
	public void codeMather() {
		//assertEquals(Tests.codeMather(null),false);
		assertEquals(Tests.codeMather("9901"),true);
		assertEquals(Tests.codeMather("99"),true);
		assertEquals(Tests.codeMather("999"),false);
		assertEquals(Tests.codeMather("990"),false);
		assertEquals(Tests.codeMather("9950"),false);
		assertEquals(Tests.codeMather("9955"),false);
		assertEquals(Tests.codeMather("9961"),false);

		assertEquals(Tests.codeMather2("9999"),true);
		assertEquals(Tests.codeMather2("9901"),true);
		assertEquals(Tests.codeMather2("99"),true);
		assertEquals(Tests.codeMather2("999"),false);
		assertEquals(Tests.codeMather2("990"),false);
		assertEquals(Tests.codeMather2("9950"),true);
		assertEquals(Tests.codeMather2("9955"),true);
		assertEquals(Tests.codeMather2("9961"),true);
	}

	@Test
	public void test11() {
		testing(Tests.nbYear(1500, 5, 100, 5000), 15);
		testing(Tests.nbYear(1500000, 2.5, 10000, 2000000), 10);
		testing(Tests.nbYear(1500000, 0.25, 1000, 2000000), 94);
	}

	@Test
	public void exampleTests() {
		assertEquals('e', Tests.findMissingLetter(new char[] { 'a', 'b', 'c', 'd', 'f' }));
		assertEquals('P', Tests.findMissingLetter(new char[] { 'O', 'Q', 'R', 'S' }));
	}

	@Test
	public void testSolution() {
		assertEquals(Tests.maskify("4556364607935616"), "############5616");
		assertEquals(Tests.maskify("64607935616"), "#######5616");
		assertEquals(Tests.maskify("1"), "1");
		assertEquals(Tests.maskify(""), "");

		// "What was the name of your first pet?"
		assertEquals(Tests.maskify("Skippy"), "##ippy");
		assertEquals(Tests.maskify("Nananananananananananananananana Batman!"),
				"####################################man!");
	}

	@Test
	public void test1() {
		assertThat(Tests.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
	}

	@Test
	public void test2() {
		assertThat(Tests.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
	}

	@Test
	public void test3() {
		assertThat("Empty input should return empty string", Tests.order(""), equalTo(""));
	}

	@Test
	public void Test1() {
		assertEquals("ABC", Tests.SongDecoder("WUBWUBABCWUB"));
	}

	@Test
	public void Test2() {
		assertEquals("R L", Tests.SongDecoder("RWUBWUBWUBLWUB"));
	}

	@Test
	public void testWhoIsNext1() {
		String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		int n = 1;
		assertEquals("Sheldon", Tests.WhoIsNext(names, n));
	}

	@Test
	public void testWhoIsNext2() {
		String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		int n = 6;
		assertEquals("Sheldon", Tests.WhoIsNext(names, n));
	}

	@Test
	public void 정규식() {
		String regex1 = "^[;|:]{1}[-|~]{1}[D|)]";
		String regex2 = "^[;|:]{1}[D|)]";
		// assertThat(true, is(matched(regex1, ";)")));
		assertThat(true, is(matched(regex2, ";)")));
	}

	private boolean matched(String regex, String inputTxt) {
		return Pattern.matches(regex, inputTxt);
	}

	@Test
	public void countSmileys2() {
		List<String> a = new ArrayList<String>();
		a.add(":)");
		a.add(":D");
		a.add(":-}");
		a.add(":-()");
		assertEquals(2, Tests.countSmileys(a));
	}

	@Test
	public void countSmileys3() {
		List<String> a = new ArrayList<String>();
		a.add(":)");
		a.add("XD");
		a.add(":0}");
		a.add("x:-");
		a.add("):-");
		a.add("D:");
		assertEquals(1, Tests.countSmileys(a));
	}

	@Test
	public void countSmileys4() {
		List<String> a = new ArrayList<String>();
		a.add(":)");
		a.add(":D");
		a.add("X-}");
		a.add("xo)");
		a.add(":X");
		a.add(":-3");
		a.add(":3");
		assertEquals(2, Tests.countSmileys(a));
	}

	@Test
	public void countSmileys5() {
		List<String> a = new ArrayList<String>();
		a.add(":)");
		a.add(":)");
		a.add("x-]");
		a.add(":ox");
		a.add(";-(");
		a.add(";-)");
		a.add(";~(");
		a.add(":~D");
		assertEquals(4, Tests.countSmileys(a));
	}

	@Test
	public void tests() {
		assertEquals("(123) 456-7890", Tests.createPhoneNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
	}

	@Test
	public void check1() {
		String pangram1 = "The quick brown fox jumps over the lazy dog.";
		assertEquals(true, Tests.check(pangram1));
	}

	@Test
	public void check2() {
		String pangram2 = "You shall not pass!";
		assertEquals(false, Tests.check(pangram2));
	}

	@Test
	public void testSomething() {
		assertEquals(Tests.reverseWords("I like eating"), "eating like I");
		assertEquals(Tests.reverseWords("I like flying"), "flying like I");
		assertEquals(Tests.reverseWords("The world is nice"), "nice is world The");
	}

	@Test
	public void test12() {
		List<long[]> res = new ArrayList<long[]>();
		res.add(new long[] { 15, 21 });
		res.add(new long[] { 21, 15 });
		List<long[]> a = Tests.removNb(26);
		assertArrayEquals(res.get(0), a.get(0));
		assertArrayEquals(res.get(1), a.get(1));
	}

	@Test
	public void test14() {
		List<long[]> res = new ArrayList<long[]>();
		List<long[]> a = Tests.removNb(1000003);
		System.out.println(res.size());
		assertTrue(res.size() == a.size());
	}

	@Test
	public void test15() {
		List<long[]> res = new ArrayList<long[]>();
		List<long[]> a = Tests.removNb(1000008);
		System.out.println(res.size());
		assertTrue(res.size() == a.size());
	}
}

class Tests {

	public static List<long[]> removNb(long n) {
		System.out.println(LongStream.of(n).skip(0).sum());

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
			if (sum <= 0)
				return new ArrayList<long[]>();
		}

		if (sum < 0)
			new ArrayList<long[]>();
		int i = 0;
		int j = 0;

		for (i = 1; i <= n; i++) {
			for (j = i + 1; j <= n; j++) {
				if (i * j == (sum - i - j)) {
					List<long[]> res = new ArrayList<long[]>();
					res.add(new long[] { i, j });
					res.add(new long[] { j, i });
					return res;
				}
			}
		}
		return new ArrayList<long[]>();
	}

	public static String reverseWords(String str) {
		return Stream.of(str.split(" ")).collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
			Collections.reverse(lst);
			return lst.stream();
		})).collect(Collectors.joining(" "));
		// return Arrays.stream(str.split(" ")).reduce((x, y) -> y+" "+x).get();
	}

	public static boolean codeMather(String str){
		String regex = "^99|99[0-4]{1}[0-9]{1}";
		return Pattern.matches(regex, str);
	}

	public static boolean codeMather2(String str){
		String regex = "^99|99[0-9]{1}[0-9]{1}";
		return Pattern.matches(regex, str);
	}

	public static boolean check(String sentence) {
		return 2847 == sentence.toLowerCase().chars().filter(s -> (s >= 97 && s <= 122)).distinct().sorted().sum()
				? true : false;
	}

	public static String createPhoneNumber(int[] numbers) {
		// Your code here!
		String num = IntStream.of(numbers).collect(StringBuilder::new, (sb, i) -> sb.append(i), StringBuilder::append)
				.toString();
		String phoneRegex = "(\\d{3})(\\d{3})(\\d{4})";
		Pattern.matches(phoneRegex, num);
		return num.replaceAll(phoneRegex, "($1) $2-$3");
		// return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
		// java.util.stream.IntStream.of(numbers).boxed().toArray());a
	}

	public static int countSmileys(List<String> arr) {
		int cnt = 0;

		String regex1 = "^[;|:]{1}[-|~]{1}[D|)]";
		String regex2 = "^[;|:]{1}[D|)]";

		for (String str : arr) {
			if (str.length() > 2) {
				if (Pattern.matches(regex1, str))
					cnt++;
			} else {
				if (Pattern.matches(regex2, str))
					cnt++;
			}
		}
		return cnt;
		// return (int)arr.stream().filter( x ->
		// x.matches("[:;][-~]?[)D]")).count();
	}

	public static String factors(int n) {
		// your code
		return "";
	}

	public static String WhoIsNext(String[] names, int n) {
		Map<String, Long> map = Stream.of(names)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<Entry<String, Long>> list = map.entrySet().stream().filter(m -> m.getValue() > 1)
				.sorted((a, b) -> Long.compare(b.getValue(), a.getValue())).collect(Collectors.toList());

		List<String> result = new ArrayList<String>(map.size());

		for (Entry<String, Long> entry : list) {
			result.add(entry.getKey());
		}

		for (String str : names) {
			if (!result.contains(str))
				result.add(str);
		}

		return result.get((n % result.size()) - 1);
	}

	public static String SongDecoder(String song) {
		return song.replaceAll("WUB", " ").replaceAll(" +", " ").trim();
		//
		// return Arrays.stream(song.split("WUB"))
		// .filter(i -> !"".equals(i))
		// .collect(Collectors.joining(" "));
	}

	public static String order(String words) {
		String[] arr = words.split(" ");
		String[] result = new String[arr.length];
		try {

			for (String temp : arr) {
				int idx = temp.chars().filter(ch -> (ch > 47 && ch < 58)).findFirst().getAsInt() - 49;
				result[idx] = temp;
			}
		} catch (Exception e) {
			return "";
		}

		return Stream.of(result).collect(Collectors.joining(" "));
	}

	public static String maskify(String str) {
		if (str.length() < 5)
			return str;
		String result = "";
		for (int i = 0; i < str.length() - 4; i++) {
			result += "#";
		}
		result += str.substring(str.length() - 4, str.length());
		return result;
	}

	public static int nbYear(int p0, double percent, int aug, int p) {
		int year = 1;
		while (p0 < p) {
			p0 = (int) (p0 * (percent / 100)) + p0 + aug;
			year++;
		}

		return year - 1;
	}

	public static char findMissingLetter(char[] array) {
		char idx = array[0];
		for (char ch : array) {
			if (idx != ch)
				return idx;
			idx++;
		}

		return idx;
//		int index = IntStream.range(0, array.length - 1).filter(i -> array[i] != array[i + 1] - 1).findFirst()
//				.getAsInt();
//		return Arrays.stream(words.split(" "))
//				.sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
//				.reduce((a, b) -> a + " " + b).get();
	}
}
