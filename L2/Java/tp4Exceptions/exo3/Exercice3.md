#### Question 1

(a) No. When `instruction2` throws an exception, execution of the `try` block stops. Execution continues in the `catch` block.

(b) No. If the exception is not caught, the exception propagates to the calling method; therefore, `instruction4` is not reached.

(c) Yes. If the exception is caught, execution continues; therefore, `instruction4` is executed.

(d) No. Same case as (b).

#### Question 2

(a) No. When `instruction2` throws an exception, execution of the `try` block stops. Execution continues in the `finally` block. As no `catch` block handles the exception, it propagates to the calling method; therefore, `instruction5` is not reached.

(b) Yes. The `finally` block is always executed after the `try` and `catch` blocks, whether the exception is caught, not caught, or a new exception is thrown in a `catch` block.
	No. The `catch` block catches the exception and executes the `throw ex3`. Execution continues in the `finally` block. As the `catch` block throws a new exception, the exception propagates to the calling method; therefore, `instruction5` is not reached.