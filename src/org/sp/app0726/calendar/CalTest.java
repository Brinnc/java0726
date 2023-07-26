package org.sp.app0726.calendar;

import java.util.Calendar;

public class CalTest {

	public static void main(String[] args) {
		//날짜 객체 얻어오기(현재 날짜가 디폴트로 지정되어 있음)
		Calendar cal=Calendar.getInstance();
		
		//년도, 월, 일 구하기
		int yy=cal.get(Calendar.YEAR);
		int mm=cal.get(Calendar.MONTH);
		int dd=cal.get(Calendar.DATE);
		//요일 구하기
		int day=cal.get(Calendar.DAY_OF_WEEK);
		
		//System.out.println(yy);
		//System.out.println(mm+1); //js와 동일하게 월은 0부터 시작하기 때문에, 출력 시 +1해줘야함
		//System.out.println(dd);
		//System.out.println(day); //js와 다르게 요일은 1부터 시작함..
		
		//6.25 발생일은?
		//1950.06.25
		//1)
		cal.set(1950, 5, 25);
		//2)
		cal.set(Calendar.YEAR, 1950);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DATE, 25);
		
		System.out.println("6.25 발생 요일은 "+cal.get(Calendar.DAY_OF_WEEK));
		//!JAVA는 1이 일요일임!
		
		
		
		
	}
}
