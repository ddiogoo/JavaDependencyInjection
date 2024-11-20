import log.ILogger;

/**
 * The Service class provides a service that uses a logger to log messages.
 * It is constructed with an ILogger instance and provides a method to perform
 * the service and log a message.
 */
public class Service {
  private ILogger logger;

  /**
   * Constructs a new Service with the specified logger.
   * 
   * @param logger the logger to use.
   */
  public Service(ILogger logger) {
    this.logger = logger;
  }

  /**
   * Serves the specified message by logging it.
   * 
   * @param message the message to serve.
   */
  public void serve(String message) {
    logger.log(message);
  }
}
