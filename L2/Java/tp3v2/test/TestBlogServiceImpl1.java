package tp3v2.test;

public class TestBlogServiceImpl1 extends AbstractTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestBlogServiceImpl1();
	}

	protected void runTests() {
		this.testExpected = 1;
		try {
			testDeclaredConstructors();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeclaredConstructors() {
		assertDeclaredConstructor(tp3v2.blog.BlogServiceImpl.class, new Class[] {String.class},
			"missing constructor BlogServiceImpl(String) in class BlogServiceImpl");
	}
}
