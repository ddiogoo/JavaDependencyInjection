package log;

/**
 * Represents a console logger.
 */
public class ConsoleLogger implements ILogger {
  @Override
  public void log(String message) {
    System.out.println(message);
  }
}
