package tp3v2.test;

public class TestAbstractPublishableItem2 extends AbstractTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestAbstractPublishableItem2();
	}

	protected void runTests() {
		this.testExpected = 6;
		try {
			testSuperTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testGetPublicationDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testGetAuthor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class MyPublishableItem extends tp3v2.blog.AbstractPublishableItem {
		public MyPublishableItem(long publicationDate, String author) {
			super(publicationDate, author);
		}
	}

	public void testSuperTypes() {
		MyPublishableItem p = new MyPublishableItem(1259838000, "Jean-Luc Picard");
		assertInstanceOf(p, tp3v2.blog.AbstractPublishableItem.class);
		assertInstanceOf(p, tp3v2.blog.Publishable.class);
	}

	public void testGetPublicationDate() {
		MyPublishableItem p = new MyPublishableItem(1259838000, "Jean-Luc Picard");

		long expected = 1259838000;
		long value = p.getPublicationDate();
		assertEquals(expected, value);

		p = new MyPublishableItem(1261655940, "Benjamin Sisko");

		expected = 1261655940;
		value = p.getPublicationDate();
		assertEquals(expected, value);
	}

	public void testGetAuthor() {
		MyPublishableItem p = new MyPublishableItem(1259838000, "Jean-Luc Picard");

		String expectedS = "Jean-Luc Picard";
		String valueS = p.getAuthor();
		assertEquals(expectedS, valueS);

		p = new MyPublishableItem(1261655940, "Benjamin Sisko");

		expectedS = "Benjamin Sisko";
		valueS = p.getAuthor();
		assertEquals(expectedS, valueS);
	}
}
