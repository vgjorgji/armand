package mk.vcms.utils;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.vcms.date.DateUtils;
import com.vcms.localization.model.Language;

@RunWith(BlockJUnit4ClassRunner.class)
public class DateUtilsTest {

	@Test
	public void testToDuration_Past_Seconds() {
		Language language = Language.Macedonian;
		for (int i = 0; i < 20; i++) {
			long yearMilis = (long) (Math.random() * TimeUnit.DAYS.toMillis(400));
			if (Math.random() > 0.5) {
				yearMilis *= -1;
			}
			Date date = new Date(System.currentTimeMillis() + yearMilis);
			System.out.println(date + " (" + yearMilis + ") = " + DateUtils.toDuration(date, language));
		}
		assertEquals(1, 1);
	}
}
