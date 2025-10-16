package tp3v2.test;

public class TestAbstractPublishableItem1 extends AbstractTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestAbstractPublishableItem1();
	}

	protected void runTests() {
		this.testExpected = 3;
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
	}

	public void testDeclaredMethods() {
		assertDeclaredMethod(tp3v2.blog.AbstractPublishableItem.class, "getAuthor", new Class[] {},
			"missing method getAuthor() in class AbstractPublishableItem");
		// TODO: check return type is 'void'

		assertDeclaredMethod(tp3v2.blog.AbstractPublishableItem.class, "getPublicationDate",
			new Class[] {}, "missing method getPublicationDate() in class AbstractPublishableItem");
		// TODO: check return type is 'long'
	}

	public void testDeclaredConstructors() {
		assertDeclaredConstructor(tp3v2.blog.AbstractPublishableItem.class,
			new Class[] {long.class, String.class},
			"missing constructor AbstractPublishableItem(long, String) in class "
				+ "AbstractPublishableItem");
	}
}
