package tp3v2.test;

public class TestVideo1 extends AbstractTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestVideo1();
	}

	protected void runTests() {
		this.testExpected = 5;
		try {
			testDeclaredMethods();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testDeclaredConstructors();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testSuperTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeclaredMethods() {
		assertDeclaredMethod(tp3v2.blog.Video.class, "getURL", new Class[] {},
			"missing method getURL() in class Video");
		// TODO: check return type is 'String'
	}

	public void testDeclaredConstructors() {
		assertDeclaredConstructor(tp3v2.blog.Video.class,
			new Class[] {long.class, String.class, String.class},
			"missing constructor Video(long, String, String) in class Video");
	}

	public void testSuperTypes() {
		tp3v2.blog.Video v = new tp3v2.blog.Video(
			1259838000, "Jean-Luc Picard", "http://www.startrek.com/vids/trailer.mpg");
		assertInstanceOf(v, tp3v2.blog.AbstractItem.class);
		assertInstanceOf(v, tp3v2.blog.Taggable.class);
		assertInstanceOf(v, tp3v2.blog.Publishable.class);
	}
}
