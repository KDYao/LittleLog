package littlelog;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The Logger class serves as a simple logging mechanism. Rather than typing
 * customized logs, the Logger class is able to aid in creating and writing
 * simple logs to multiple streams.
 */
public final class Logger {

	/**
	 * Some constants for quick referencing on commonly used
	 * tag values
	 */
	public static String VERBOSE = "VERBOSE";
	public static String INFO = "INFO";
	public static String ERROR = "ERROR";
	public static String WARN = "WARN";
	public static String DEBUG = "DEBUG";

	/**
	 * Every object will hold a PrintStream object
	 * to write logs to. This PrintStream object cannot
	 * be null by contract to ensure proper writing.
	 */
	private PrintStream printStream;

	/**
	 * Constructs the object with a custom PrintStream.
	 *
	 * @param ps PrintStream object to be written to
	 */
	@NotNull
	public Logger(PrintStream ps) {
		this.printStream = ps;
	}

	/**
	 * Constructs the object with the system default PrintStream.
	 */
	public Logger() {
		this.printStream = System.out;
	}

	/**
	 * Gets the PrintStream object that is currently stored.
	 *
	 * @return A PrintStream object
	 */
	@Contract(pure = true)
	PrintStream getPrintStream() {
		return printStream;
	}

	/**
	 * Sets a new PrintStream to write to.
	 *
	 * @param printStream The PrintStream to set to
	 */
	public void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}

	/**
	 * Writes a log entry to the print stream with a tag value.
	 *
	 * @param args Strings of the form "value" where value is a
	 * 			   desired value in the log
	 */
	public void log(String... args) {
		this.printStream.println(formatMessage(args));
	}

	/**
	 * Formats a message to "nicely" display the log message with some
	 * other information (like date and time).
	 *
	 * @param msg Message that will be logged
	 * @param tag Tag value to indicate a type of log. Can be used with
	 *            the above constants to can be a custom tag
	 * @return formattedMsg The "nicely" formatted message
	 */
	@NotNull
	private String formatMessage(String... args) {
		StringBuilder sb = new StringBuilder();
		sb.append("[" + LocalDate.now() + "] ");
		sb.append("[" + LocalTime.now() + "] ");
		for (String arg : args){
			sb.append("[" + arg + "] ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * Formats a message to "nicely" display the log message with some
	 * other information (like date and time).
	 *
	 * @param msg Message that will be logged
	 *
	 * @return formattedMsg The "nicely" formatted message
	 */
	@NotNull
	private String formatMessage(String msg) {
		return "[" + LocalDate.now() + "] [" + LocalTime.now() + "] " + msg;
	}
}
