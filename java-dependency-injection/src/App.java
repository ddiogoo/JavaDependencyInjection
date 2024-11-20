import log.ConsoleLogger;
import log.FileLogger;
import log.ILogger;

/**
 * The App class contains the main method.
 */
public class App {
    /**
     * The main method.
     * 
     * @param args the command-line arguments.
     * @throws Exception if an error occurs.
     */
    public static void main(String[] args) throws Exception {
        Injector injectorConsole = new Injector();

        injectorConsole.register(ILogger.class, ConsoleLogger.class);
        injectorConsole.register(Service.class, Service.class);

        Service consoleService = injectorConsole.resolve(Service.class);
        consoleService.serve("Hello, Console!");

        Injector injectorFile = new Injector();

        injectorFile.register(ILogger.class, FileLogger.class);
        injectorFile.register(Service.class, Service.class);

        Service fileService = injectorFile.resolve(Service.class);
        fileService.serve("Hello, File!");
    }
}
