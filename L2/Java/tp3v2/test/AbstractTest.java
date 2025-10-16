package tp3v2.test;

public abstract class AbstractTest {
	protected int testCount;
	protected int testFailed;
	protected int testSucceeded;
	protected int testExpected;
	protected String testName;

	public AbstractTest() {
		this.testName = this.getClass().getName();
		init();
		runTests();
		printSummary();
	}

	protected void init() {
		this.testCount = 0;
		this.testFailed = 0;
		this.testSucceeded = 0;
		this.testExpected = 0;
	}

	public int getTestCount() {
		return this.testCount;
	}

	public int getTestFailedCount() {
		return this.testFailed;
	}

	public int getTestSucceededCount() {
		return this.testSucceeded;
	}

	public int getTestExpectedCount() {
		return this.testExpected;
	}

	protected void printSummary() {
		System.out.println("------------------------------------");
		System.out.println("-- " + this.testName);
		System.out.println("Test run: " + this.testCount + "\tTest failed: " + this.testFailed
			+ "\tTest succeeded: " + this.testSucceeded + "\t[x:" + this.testExpected + "]");
	}

	protected void assertTrue(boolean condition, String msg) {
		this.testCount++;

		try {
			if (!condition) {
				this.testFailed++;
				Exception e = new Exception();
				StackTraceElement methodName = e.getStackTrace()[1];
				System.err.println("Test Failed: [" + msg + "] in " + methodName);
			} else {
				this.testSucceeded++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.testFailed++;
		}
	}

	protected void assertEquals(Object expected, Object other) {
		this.testCount++;

		try {
			if (!expected.equals(other)) {
				this.testFailed++;
				Exception e = new Exception();
				StackTraceElement methodName = e.getStackTrace()[1];
				System.err.println("Test Failed: Expected [" + expected + "] got [" + other
					+ "] in " + methodName);
			} else {
				this.testSucceeded++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.testFailed++;
		}
	}

	protected void assertEquals(int expected, int other) {
		this.testCount++;
		try {
			if (expected != other) {
				this.testFailed++;
				Exception e = new Exception();
				StackTraceElement methodName = e.getStackTrace()[1];
				System.err.println("Test Failed: Expected [" + expected + "] got [" + other
					+ "] in " + methodName);
			} else {
				this.testSucceeded++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.testFailed++;
		}
	}

	protected void assertEquals(long expected, long other) {
		this.testCount++;
		try {
			if (expected != other) {
				this.testFailed++;
				Exception e = new Exception();
				StackTraceElement methodName = e.getStackTrace()[1];
				System.err.println("Test Failed: Expected [" + expected + "] got [" + other
					+ "] in " + methodName);
			} else {
				this.testSucceeded++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.testFailed++;
		}
	}

	protected void assertEquals(double expected, double other) {
		this.testCount++;
		if (Double.isNaN(other) || Math.abs(expected - other) > 0.00001) {
			this.testFailed++;
			Exception e = new Exception();
			StackTraceElement methodName = e.getStackTrace()[1];
			System.err.println(
				"Test Failed: Expected [" + expected + "] got [" + other + "] in " + methodName);
		} else {
			this.testSucceeded++;
		}
	}

	@SuppressWarnings("unchecked")
	protected void assertInstanceOf(Object obj, Class expectedClass) {
		this.testCount++;

		try {
			expectedClass.cast(obj);
			this.testSucceeded++;
		} catch (ClassCastException ex) {
			this.testFailed++;
			Exception e = new Exception();
			StackTraceElement methodName = e.getStackTrace()[1];
			System.err.println("Test Failed: Expected [" + expectedClass + "] in " + methodName);
		} catch (Exception e) {
			e.printStackTrace();
			this.testFailed++;
		}
	}

	protected void assertNull(Object obj) {
		this.testCount++;
		if (obj != null) {
			this.testFailed++;
			Exception e = new Exception();
			StackTraceElement methodName = e.getStackTrace()[1];
			System.err.println(
				"Test Failed: Expected [" + null + "] got [" + obj + "] in " + methodName);
		} else {
			this.testSucceeded++;
		}
	}

	protected void assertDeclaredMethod(
		Class testedClass, String methodName, Class[] parameterTypes, String msg) {
		this.testCount++;
		try {
			testedClass.getMethod(methodName, parameterTypes);
			this.testSucceeded++;
		} catch (NoSuchMethodException ex) {
			this.testFailed++;
			Exception e = new Exception();
			StackTraceElement callerMethodName = e.getStackTrace()[1];
			System.err.println("Test Failed: [ " + msg + " ] in " + callerMethodName);
		}
	}

	protected void assertDeclaredConstructor(
		Class testedClass, Class[] parameterTypes, String msg) {
		this.testCount++;
		try {
			testedClass.getConstructor(parameterTypes);
			this.testSucceeded++;
		} catch (NoSuchMethodException ex) {
			this.testFailed++;
			Exception e = new Exception();
			StackTraceElement callerMethodName = e.getStackTrace()[1];
			System.err.println("Test Failed: [ " + msg + " ] in " + callerMethodName);
		}
	}

	protected abstract void runTests();
}
