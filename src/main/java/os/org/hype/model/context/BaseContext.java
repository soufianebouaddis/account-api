package os.org.hype.model.context;

public interface BaseContext {
    boolean isSuccess();

    void setSuccess(boolean success);

    String getErrorMessage();

    void setErrorMessage(String message);
}
