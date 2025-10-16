package tp3v2.test;

public class TestAll extends AbstractTest {
	public static void main(String[] args) {
		TestAll t = new TestAll();
	}

	private AbstractTest[] testSuite;

	public TestAll() {
		this.testName = this.getClass().getName();
	}

	protected void init() {
		super.init();
		this.testSuite =
			new AbstractTest[] {new TestPublishable(), new TestAbstractPublishableItem1(),
				new TestAbstractPublishableItem2(), new TestTaggable(), new TestAbstractItem1(),
				new TestAbstractItem2(), new TestMessage1(), new TestMessage2(), new TestPicture1(),
				new TestPicture2(), new TestVideo1(), new TestVideo2(), new TestBlogService(),
				new TestBlogServiceImpl1(), new TestBlogServiceImpl2()};
	}

	public void runTests() {
		for (AbstractTest test : this.testSuite) {
			this.testCount += test.getTestCount();
			this.testFailed += test.getTestFailedCount();
			this.testSucceeded += test.getTestSucceededCount();
			this.testExpected += test.getTestExpectedCount();
		}
	}
}
