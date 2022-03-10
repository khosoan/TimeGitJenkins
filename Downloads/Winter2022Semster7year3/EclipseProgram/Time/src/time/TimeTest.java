package time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	
	@Test
	void testGetMilliSecondsExceptional() {
		assertThrows(StringIndexOutOfBoundsException.class,
				()-> {
					Time.getMilliseconds("50:50:50:99");});
	}
	@Test
	void testGetMilliSecondsGood() {
		int milliseconds=Time.getMilliseconds("05:05:05:555");
		assertTrue("The milliseconds  were not calculated properly",milliseconds==555);
	}
	@Test
	void testGetMilliSecondsBad() {
		int milliseconds=Time.getMilliseconds("05:05:05:001");
		assertTrue("The milliseconds  were not calculated properly",milliseconds==1);
	}
	@Test
	void testGetMilliSecondsBoundary() {
		int milliseconds=Time.getMilliseconds("05:05:05:999");
		assertTrue("The milliseconds  were not calculated properly",milliseconds==999);
	}

	@Test
	void testGetTotalSecondsGood() {
		int seconds=Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly",seconds==18305);
		
	}
	@Test
	public void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
		()-> {
			Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetTotalSecondsBoundary() {
		int seconds=Time.getTotalSeconds("05:05:59");
		assertTrue("The seconds were not calculated properly",seconds==18359);
	}

	
	

	@Test
	void testGetTotalMinutesGood() {
		int minutes=Time.getTotalMinutes("05:05:05");
		assertTrue("The minutes were not calculated properly",minutes==5);
		
	}
	@Test
	public void testGetTotalMinutessBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
		()-> {
			Time.getTotalSeconds("00:10");});
	}
	
	@Test
	void testGetTotalMinutesBoundary() {
		int minutes=Time.getTotalMinutes("05:59:59");
		assertTrue("The minutes were not calculated properly",minutes==59);
	}

	@ParameterizedTest
	@ValueSource(strings= {"05:00:00", "05:59:59"})
	void testGetTotalHoursGood() {
		int hours=Time.getTotalHours("05:05:05");
		assertTrue("The Hours were not calculated properly",hours==5);
		
	}
	@Test
	public void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
		()-> {
			Time.getTotalSeconds("10:10");});
	}
	
	@Test
	void testGetTotalHoursBoundary() {
		int hours=Time.getTotalHours("05:59:59");
		assertTrue("The Hours were not calculated properly",hours==5);
	}
}
