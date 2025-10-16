package tp3v2.test;

public class TestAbstractItem2 extends AbstractTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestAbstractItem2();
	}

	protected void runTests() {
		this.testExpected = 23;
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
		try {
			testAddAndGetTag();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testRemoveAndGetTag();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class MyItem extends tp3v2.blog.AbstractItem {
		public MyItem(long publicationDate, String author) {
			super(publicationDate, author);
		}
	}

	public void testSuperTypes() {
		MyItem p = new MyItem(1259838000, "Jean-Luc Picard");
		assertInstanceOf(p, tp3v2.blog.AbstractPublishableItem.class);
		assertInstanceOf(p, tp3v2.blog.Publishable.class);
		assertInstanceOf(p, tp3v2.blog.Taggable.class);
	}

	public void testGetPublicationDate() {
		MyItem p = new MyItem(1259838000, "Jean-Luc Picard");

		long expected = 1259838000;
		long value = p.getPublicationDate();
		assertEquals(expected, value);

		p = new MyItem(1261655940, "Benjamin Sisko");

		expected = 1261655940;
		value = p.getPublicationDate();
		assertEquals(expected, value);
	}

	public void testGetAuthor() {
		MyItem p = new MyItem(1259838000, "Jean-Luc Picard");

		String expectedS = "Jean-Luc Picard";
		String valueS = p.getAuthor();
		assertEquals(expectedS, valueS);

		p = new MyItem(1261655940, "Benjamin Sisko");

		expectedS = "Benjamin Sisko";
		valueS = p.getAuthor();
		assertEquals(expectedS, valueS);
	}

	public void testAddAndGetTag() {
		MyItem p = new MyItem(1259838000, "Jean-Luc Picard");

		assertEquals(0, p.tagCount());
		p.addTag("trekkies");
		assertEquals(1, p.tagCount());
		assertTrue(
			p.getTags().contains("trekkies"), "tag 'trekkies' is missing on the tagged item");

		p.addTag("trekkies");
		assertEquals(1, p.tagCount()); // "an item might not be tagged twice with the same tag"
		p.addTag("starship");
		assertEquals(2, p.tagCount());
		assertTrue(
			p.getTags().contains("trekkies"), "tag 'trekkies' is missing on the tagged item");
		assertTrue(
			p.getTags().contains("starship"), "tag 'starship' is missing on the tagged item");

		p.addTag(null);
		assertEquals(2, p.tagCount());
	}

	public void testRemoveAndGetTag() {
		MyItem p = new MyItem(1259838000, "Jean-Luc Picard");

		p.removeTag(null);
		assertEquals(0, p.tagCount());

		p.addTag("trekkies");
		p.removeTag("trekkies");
		assertEquals(0, p.tagCount());
		assertTrue(p.getTags().contains("trekkies") == false,
			"tag 'trekkies' should have been removed on the tagged item");

		p.addTag("enterprise");
		p.addTag("trekkies");
		p.addTag("starship");
		p.removeTag(null);
		assertEquals(3, p.tagCount());

		p.removeTag("trekkies");
		assertEquals(2, p.tagCount());
		assertTrue(p.getTags().contains("trekkies") == false,
			"tag 'trekkies' should have been removed on the tagged item");
		assertTrue(
			p.getTags().contains("starship"), "tag 'starship' is missing on the tagged item");
		assertTrue(
			p.getTags().contains("enterprise"), "tag 'enterprise' is missing on the tagged item");
	}
}
