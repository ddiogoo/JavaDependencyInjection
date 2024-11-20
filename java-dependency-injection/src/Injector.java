import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Injector {
  private final Map<Class<?>, Class<?>> mappings = new HashMap<>();

  /**
   * Registers a mapping between an interface and its implementation.
   *
   * @param <T>                the type of the interface.
   * @param interfaceType      the class object of the interface.
   * @param implementationType the class object of the implementation that
   *                           implements the interface.
   */
  public <T> void register(Class<T> interfaceType, Class<? extends T> implementationType) {
    mappings.put(interfaceType, implementationType);
  }

  /**
   * Creates an instance of the specified interface.
   * 
   * @param <T>           the type of the interface.
   * @param interfaceType the class object of the interface.
   * @return an instance of the implementation that implements the interface.
   * @throws Exception if the interface has not been registered or if the
   *                   implementation cannot be instantiated.
   */
  public <T> T resolve(Class<T> interfaceType) throws Exception {
    Class<?> implementationType = mappings.get(interfaceType);
    if (implementationType == null) {
      throw new InjectorException("No mapping found for " + interfaceType.getName());
    }
    Constructor<?>[] constructors = implementationType.getConstructors();
    Constructor<?> constructor = constructors[0];

    Object implementatioInstance;
    if (constructor.getParameterCount() == 0) {
      implementatioInstance = constructor.newInstance();
    } else {
      Object[] params = new Object[constructor.getParameterCount()];
      for (int i = 0; i < params.length; i++) {
        params[i] = resolve(constructor.getParameterTypes()[i]);
      }
      implementatioInstance = constructor.newInstance(params);
    }

    for (var field : implementationType.getDeclaredFields()) {
      if (field.getType().isInterface()) {
        field.setAccessible(true);
        field.set(implementatioInstance, resolve((Class<?>) field.getType()));
      }
    }
    return interfaceType.cast(implementatioInstance);
  }
}
