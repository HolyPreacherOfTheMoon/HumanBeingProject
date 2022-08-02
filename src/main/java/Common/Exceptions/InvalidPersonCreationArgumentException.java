package Common.Exceptions;

public class InvalidPersonCreationArgumentException extends Exception {

  String message;
  Throwable cause = null;

  public InvalidPersonCreationArgumentException(Throwable cause) {
    this.cause = cause;
  }

  public InvalidPersonCreationArgumentException() {

  }

  public InvalidPersonCreationArgumentException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public synchronized Throwable getCause() {
    if (cause != null) {
      return cause;
    } else {
      return new NullPointerException(
          "There were no cause in Common.Exceptions.InvalidPersonCreationArgumentException");
    }
  }
}
