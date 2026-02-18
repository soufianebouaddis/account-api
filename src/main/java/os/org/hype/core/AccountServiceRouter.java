package os.org.hype.core;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static org.springframework.aop.support.AopUtils.getTargetClass;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

@Component
public class AccountServiceRouter {
    private final Map<String, AccountServiceMarker> services = new HashMap<>();

    // locate all beans implementing AccountServiceMarker & annotated with AppServiceName and register them
    public AccountServiceRouter(List<AccountServiceMarker> serviceList) {
        for (AccountServiceMarker service : serviceList) {
            Class<?> targetClass = getTargetClass(service);
            AppServiceName annotation = findAnnotation(targetClass, AppServiceName.class);
            if (isNull(annotation)) {
                throw new IllegalStateException(
                        "Missing @AppServiceName on " + targetClass.getName()
                );
            }
            String key = annotation.value().getCode();
            if (services.containsKey(key)) {
                throw new IllegalStateException(
                        "Duplicate Service key detected: " + key
                );
            }
            services.put(key, service);
        }
    }



    public <T extends AccountServiceMarker> T get(String key, Class<T> type) {
        AccountServiceMarker service = services.get(key);
        if (isNull(service)) {
            throw new IllegalArgumentException(
                    "No Service registered for key: " + key
            );
        }
        return type.cast(service);
    }
}
