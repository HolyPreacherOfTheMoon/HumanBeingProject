package Common.Exceptions;

public class RecurrentException extends Exception{

  public RecurrentException(){

  }

  public RecurrentException(String message) {
    super(message);
  }

  public RecurrentException(String message, Throwable cause) {
    super(message, cause);
  }

  public RecurrentException(Throwable cause) {
    super(cause);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }

  @Override
  public synchronized Throwable getCause() {
    return super.getCause();
  }
}
