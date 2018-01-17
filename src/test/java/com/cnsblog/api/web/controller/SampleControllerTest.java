package com.cnsblog.api.web.controller;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class SampleControllerTest {

    public void Test1()
    {
      int a = 9119;
      String num = Integer.toString(a);
      String result = "";

      System.out.println( num.length());
      for(int i=0; i < num.length(); i++){
    	  int temp = Integer.parseInt(num.substring(i,i+1));
    	  System.out.println(temp);
    	  result += ""+(int)Math.pow(temp,2);
      }

      System.out.println(result);
    }


    public void test2(){
    	int n = 9119;
        Integer.parseInt(String.valueOf(n)
               .chars()
               .map(i -> Integer.parseInt(String.valueOf((char) i)))
               .map(i -> i * i)
               .mapToObj(String::valueOf)
               .collect(Collectors.joining("")));
    }

    @Test
    public void test() {
      assertEquals("emocleW", spinWords("Welcome"));
      assertEquals("Hey wollef sroirraw",spinWords("Hey fellow warriors"));
    }


    public String spinWords(String word)
    {
    	return Stream.of(word.split(" ")).map(str ->str.length() > 4 ? new StringBuilder(str).reverse().toString() : str).collect(Collectors.joining(" "));
    }

   public int GetSum(int a, int b)
   {
      if(a == b) return a;
      if(a < 0){
        if(b < 0) return a+b;
        if(b == 0) return a;
        return b;
      }

      return a+b;
   }
}