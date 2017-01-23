package personal.YouXianMing.Debug;

public class DebugMessage {

	public static final StackTraceElement[] stack() {

		return (new Throwable()).getStackTrace();
	}

	public static final void output(StackTraceElement[] stack, String message) {

		StackTraceElement ste = stack[1];

		System.err.println("[" + ste.getFileName() + ":" + ste.getLineNumber() + "] " + message
				+ "\n-------------------------------\n" + "Class  : " + ste.getClassName() + "\nMethod : "
				+ ste.getMethodName() + "\n-------------------------------");
	}
}
