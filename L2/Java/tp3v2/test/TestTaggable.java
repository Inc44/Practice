package tp3v2.test;

public class TestTaggable extends AbstractTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		new TestTaggable();
	}

	protected void runTests() {
		this.testExpected = 4;
		try {
			testDeclaredMethods();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeclaredMethods() {
		assertDeclaredMethod(tp3v2.blog.Taggable.class, "addTag", new Class[] {String.class},
			"missing method addTag(String) in interface Taggable");
		// TODO: check return type is 'void'

		assertDeclaredMethod(tp3v2.blog.Taggable.class, "removeTag", new Class[] {String.class},
			"missing method removeTag(String) in interface Taggable");
		// TODO: check return type is 'void'

		assertDeclaredMethod(tp3v2.blog.Taggable.class, "tagCount", new Class[] {},
			"missing method tagCount() in interface Taggable");
		// TODO: check return type is 'int'

		assertDeclaredMethod(tp3v2.blog.Taggable.class, "getTags", new Class[] {},
			"missing method getTags() in interface Taggable");
		// TODO: check return type is 'List<Tag>'
	}
}
