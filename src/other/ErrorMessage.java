public class ErrorMessage{
  private boolean isError;
  private String message;



  public boolean getIsError(){
    return isError;
  }

  public void setMessage(String message){
    isError = true;
    this.message = message;
  }

  public String getMessage(){
    return message;
  }
}
