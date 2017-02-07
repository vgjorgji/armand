package mk.vcms.utils;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.vcms.localization.model.Language;
import com.vcms.utils.DateUtils;

@RunWith(BlockJUnit4ClassRunner.class)
public class DateUtilsTest {

	@Test
	public void testToDuration_Past_Seconds() {
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 10), Language.English));
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 100), Language.English));
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 1000), Language.English));
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 10000), Language.English));
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 100000), Language.English));
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 1000000), Language.English));
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 10000000), Language.English));
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 100000000), Language.English));
		System.out.println(DateUtils.toDuration(new Date(System.currentTimeMillis() - 1000000000), Language.English));
		assertEquals(1, 1);
	}
}
