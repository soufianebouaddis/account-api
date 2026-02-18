package os.org.hype.model.base;

import java.io.Serial;
import java.io.Serializable;

// this class will be extended by DTOs
public abstract class BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}