package tp3v2.test;

import java.util.List;

import tp3v2.blog.Publishable;

public class TestBlogServiceImpl2 extends AbstractTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestBlogServiceImpl2();
	}

	protected void runTests() {
		this.testExpected = 54;
		try {
			testSuperTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testGetTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testGetPublishableCountAndPost();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testGetTaggableItemsCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testFindItemsByAuthor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testGetLatestItem();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testFindItemsByTags();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testFindItemsByContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testFindItemsByTagsOrContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testSuperTypes() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");
		assertInstanceOf(b, tp3v2.blog.BlogService.class);
	}

	public void testGetTitle() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");
		String expectedS = "Star trek blog";
		String valueS = b.getTitle();
		assertEquals(expectedS, valueS);

		b = new tp3v2.blog.BlogServiceImpl("Another Galaxy blog");
		expectedS = "Another Galaxy blog";
		valueS = b.getTitle();
		assertEquals(expectedS, valueS);
	}

	public void testGetPublishableCountAndPost() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");
		assertEquals(0, b.getPublishableItemsCount());

		tp3v2.blog.Message aMessage =
			new tp3v2.blog.Message(1259838000, "Jean-Luc Picard", "Space the final frontier");
		tp3v2.blog.Message anotherMessage =
			new tp3v2.blog.Message(1259838000, "Quark", "Ferengi rules");

		b.post(aMessage);
		assertEquals(1, b.getPublishableItemsCount());
		assertTrue(b.getItems().contains(aMessage), "blog should contains my posted message");

		b.post(anotherMessage);
		assertEquals(2, b.getPublishableItemsCount());
		assertTrue(
			b.getItems().contains(anotherMessage), "blog should contains my second posted message");
		assertTrue(b.getItems().contains(aMessage), "blog should contains my posted message");
	}

	public void testGetTaggableItemsCount() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");
		assertEquals(0, b.getTaggableItemsCount());

		tp3v2.blog.Picture aPicture = new tp3v2.blog.Picture(
			1259838000, "Jean-Luc Picard", "http://www.startrek.com/img/logo.png");
		tp3v2.blog.Picture anotherPicture = new tp3v2.blog.Picture(
			1359738000, "Jean-Luc Picard", "http://www.startrek.com/img/banner.png");
		tp3v2.blog.Message aMessage =
			new tp3v2.blog.Message(1259838000, "Jean-Luc Picard", "Space the final frontier");
		tp3v2.blog.Message anotherMessage =
			new tp3v2.blog.Message(1259838000, "Quark", "Ferengi rules");
		tp3v2.blog.Video aVideo =
			new tp3v2.blog.Video(1259838000, "Quark", "http://www.startrek.com/vids/trailer.avi");

		b.post(aPicture);
		assertEquals(1, b.getTaggableItemsCount());
		b.post(aMessage);
		assertEquals(1, b.getTaggableItemsCount());
		b.post(anotherPicture);
		b.post(anotherMessage);
		assertEquals(2, b.getTaggableItemsCount());
		b.post(aVideo);
		assertEquals(3, b.getTaggableItemsCount());
	}

	public void testFindItemsByAuthor() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");

		tp3v2.blog.Picture aPicture = new tp3v2.blog.Picture(
			1259838000, "Jean-Luc Picard", "http://www.startrek.com/img/logo.png");
		tp3v2.blog.Picture anotherPicture =
			new tp3v2.blog.Picture(1359738000, "Quark", "http://www.startrek.com/img/banner.png");
		tp3v2.blog.Message aMessage =
			new tp3v2.blog.Message(1259838000, "Jean-Luc Picard", "Space the final frontier");

		List<Publishable> res = b.findItemsByAuthor("Jean-Luc Picard");
		assertTrue(res != null, "findItemsByAuthor() should never return a null reference");
		assertEquals(0, res.size());

		b.post(aPicture);
		b.post(anotherPicture);
		b.post(aMessage);
		res = b.findItemsByAuthor("Jean-Luc Picard");
		assertEquals(2, res.size());
		assertTrue(res.contains(aPicture), "findItemsByAuthor() did not find this picture");
		assertTrue(
			!res.contains(anotherPicture), "findItemsByAuthor() should not find this picture");
		assertTrue(res.contains(aMessage), "findItemsByAuthor() did not find this message");
		res = b.findItemsByAuthor("Quark");
		assertEquals(1, res.size());
		assertTrue(res.contains(anotherPicture), "findItemsByAuthor() did not find this picture");
	}

	public void testGetLatestItem() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");

		tp3v2.blog.Picture aPicture = new tp3v2.blog.Picture(
			1259838000, "Jean-Luc Picard", "http://www.startrek.com/img/logo.png");
		tp3v2.blog.Picture anotherPicture =
			new tp3v2.blog.Picture(1359738000, "Quark", "http://www.startrek.com/img/banner.png");
		tp3v2.blog.Message aMessage =
			new tp3v2.blog.Message(1259837000, "Jean-Luc Picard", "Space the final frontier");

		assertNull(b.getLatestItem());

		b.post(aPicture);
		Publishable expected = aPicture;
		Publishable res = b.getLatestItem();
		assertEquals(expected, res);

		b.post(aMessage);
		expected = aPicture;
		res = b.getLatestItem();
		assertEquals(expected, res);

		b.post(anotherPicture);
		expected = anotherPicture;
		res = b.getLatestItem();
		assertEquals(expected, res);
	}

	public void testFindItemsByTags() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");

		tp3v2.blog.Picture aPicture = new tp3v2.blog.Picture(
			1259838000, "Jean-Luc Picard", "http://www.startrek.com/img/logo.png");
		tp3v2.blog.Picture anotherPicture =
			new tp3v2.blog.Picture(1359738000, "Quark", "http://www.startrek.com/img/banner.png");
		tp3v2.blog.Message aMessage = new tp3v2.blog.Message(
			1259837000, "Jean-Luc Picard", "Is there any starship near this place?");
		tp3v2.blog.Video aVideo =
			new tp3v2.blog.Video(1259838000, "Quark", "http://www.startrek.com/vids/trailer.avi");

		List<Publishable> res = b.findItemsByTags(new String[] {"trekkies"});
		assertTrue(res != null, "findItemsByTags() should never return a null reference");
		assertEquals(0, res.size());

		b.post(aPicture);
		res = b.findItemsByTags(new String[] {"trekkies"});
		assertEquals(0, res.size());
		aPicture.addTag("trekkies");
		res = b.findItemsByTags(new String[] {"trekkies"});
		assertEquals(1, res.size());
		assertTrue(res.contains(aPicture), "findItemsByTags() did not find the tagged picture");

		b.post(anotherPicture);
		b.post(aVideo);
		b.post(aMessage);
		res = b.findItemsByTags(new String[] {"trekkies"});
		assertEquals(1, res.size());
		assertTrue(res.contains(aPicture), "findItemsByTags() did not find the tagged picture");

		anotherPicture.addTag("space");
		anotherPicture.addTag("starship");
		res = b.findItemsByTags(new String[] {"starship"});
		assertEquals(1, res.size());
		assertTrue(
			res.contains(anotherPicture), "findItemsByTags() did not find the tagged picture");

		aVideo.addTag("starship");
		res = b.findItemsByTags(new String[] {"starship"});
		assertEquals(2, res.size());
		assertTrue(
			res.contains(anotherPicture), "findItemsByTags() did not find the tagged picture");
		assertTrue(res.contains(aVideo), "findItemsByTags() did not find the tagged video");

		anotherPicture.removeTag("starship");
		res = b.findItemsByTags(new String[] {"starship"});
		assertEquals(1, res.size());
		assertTrue(res.contains(aVideo), "findItemsByTags() did not find the tagged video");
	}

	public void testFindItemsByContent() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");

		List<Publishable> res = b.findItemsByContent(new String[] {"trekkies"});
		assertTrue(res != null, "findItemsByContent() should never return a null reference");
		assertEquals(0, res.size());

		tp3v2.blog.Picture aPicture = new tp3v2.blog.Picture(
			1259838000, "Jean-Luc Picard", "http://www.startrek.com/img/logo.png");
		tp3v2.blog.Message aMessage = new tp3v2.blog.Message(
			1259837000, "Jean-Luc Picard", "Is there any starship near this place?");
		tp3v2.blog.Message anotherMessage =
			new tp3v2.blog.Message(1259836000, "Jean-Luc Picard", "The final frontier");
		tp3v2.blog.Message anotherMessage2 =
			new tp3v2.blog.Message(1259838000, "Jean-Luc Picard", "There is no place like home");

		b.post(aMessage);
		res = b.findItemsByContent(new String[] {"trekkies"});
		assertEquals(0, res.size());
		res = b.findItemsByContent(new String[] {"starship"});
		assertEquals(1, res.size());
		assertTrue(res.contains(aMessage),
			"findItemsByContent() did not find the message matching the search criteria");
		res = b.findItemsByContent(new String[] {"place"});
		assertEquals(1, res.size());
		assertTrue(res.contains(aMessage),
			"findItemsByContent() did not find the message matching the search criteria");

		aPicture.addTag("place");
		b.post(aPicture);
		res = b.findItemsByContent(new String[] {"place"});
		assertEquals(1, res.size());
		assertTrue(res.contains(aMessage),
			"findItemsByContent() did not find the message matching the search criteria");

		b.post(anotherMessage);
		b.post(anotherMessage2);
		res = b.findItemsByContent(new String[] {"place"});
		assertEquals(2, res.size());
		assertTrue(res.contains(aMessage),
			"findItemsByContent() did not find the message matching the search criteria");
		assertTrue(res.contains(anotherMessage2),
			"findItemsByContent() did not find the message matching the search criteria");
	}

	public void testFindItemsByTagsOrContent() {
		tp3v2.blog.BlogServiceImpl b = new tp3v2.blog.BlogServiceImpl("Star trek blog");

		List<Publishable> res = b.findItemsByTagsOrContent(new String[] {"trekkies"});
		assertTrue(res != null, "findItemsByTagsOrContent() should never return a null reference");
		assertEquals(0, res.size());

		tp3v2.blog.Picture aPicture = new tp3v2.blog.Picture(
			125989000, "Jean-Luc Picard", "http://www.startrek.com/img/logo.png");
		tp3v2.blog.Picture anotherPicture =
			new tp3v2.blog.Picture(1359738000, "Quark", "http://www.startrek.com/img/banner.png");
		tp3v2.blog.Message aMessage = new tp3v2.blog.Message(
			1259837000, "Jean-Luc Picard", "Is there any starship near this place?");
		tp3v2.blog.Video aVideo =
			new tp3v2.blog.Video(1259835000, "Quark", "http://www.startrek.com/vids/trailer.avi");
	}
}
