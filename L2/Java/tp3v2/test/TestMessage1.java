package tp3v2.test;

public class TestMessage1 extends AbstractTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestMessage1();
	}

	protected void runTests() {
		this.testExpected = 4;
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
		assertDeclaredMethod(tp3v2.blog.Message.class, "getContent", new Class[] {},
			"missing method getContent() in class Message");
		// TODO: check return type is 'String'
	}

	public void testDeclaredConstructors() {
		assertDeclaredConstructor(tp3v2.blog.Message.class,
			new Class[] {long.class, String.class, String.class},
			"missing constructor Message(long, String, String) in class Message");
	}

	public void testSuperTypes() {
		tp3v2.blog.Message m =
			new tp3v2.blog.Message(1259838000, "Jean-Luc Picard", "Space the final frontier");
		assertInstanceOf(m, tp3v2.blog.AbstractPublishableItem.class);
		assertInstanceOf(m, tp3v2.blog.Publishable.class);
	}
}
