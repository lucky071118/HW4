import java.util.Scanner;

public class Controller{
  private Model model;
  private View view;
  
  public Controller(model, view){
    this.model = model;
    this.view = view;
    ErrorMessahe errorMessage = this.model.initialModel();
    if(errorMessage.getIsError() == true){
      view.showMessage(errorMessage.getMessage());
    else{
      this.model.startModel(); 
      readInput();
    }
  }


  private void readInput(){
    Scanner scanner = new Scanner(System.in);
    While(true){
      String userInput = scanner.nextLine();
      if(userInput.equal("exit")){
        view.showMessage("Game Over!");
        break;
      }
      handleInput(userInput);
    }
  }

  private void handleUserName(Scanner scanner){
    while(true){
      String usernames = scanner.nextLine();
      String[] nameArray = usernames.split(" ");
      if(nameArray.length == 2){
        model.inputUserName(nameArray[0], nameArray[1]);
      }else{
        view.showMessage("The format of input is error!");
      }
    }
  }

  private void handleInput(String userInput){
    String[] inputArray = userInput.split(" ");
    boolean legal = isLegal(inputArray);
    if(legal == true){
      view.showMessage("The format of input is error!");
    }else{
      chooseModelUpdate(inputArray);
    }
  }

  private boolean isLegal(String[] inputArray){
    boolean legalResult = true;
    if(inputArray.length==4 && inputArray[0].equals("select")){
      legalResult = false;
    }
    else if(inputArray.length==3 && inputArray[1].equals("attack")){
      legalResult = false;
    }
    else if(inputArray.length==2 && inputArray[0].equals("change")){
      legalResult = false;
    }
    else if(inputArray.length==1 && inputArray[0].equals("finish")){
      legalResult = false;
    }
    return legalResult;
  }

  private void chooseModelUpdate(String[] inputArray){
    switch(inputArray[0]){
      case "change":
        model.changeMonsterState(inputArray[1]);
        break;
      case "select":
        model.selectMonster(inputArray[1], inputArray[2], inputArray[3]);
        break;
      case "finish":
        model.finishTurn();
        break;
      default:
        model.monsterAttack(inputArray[0], inputArray[2]);
    }
  }

  private void updateView(){
    view.showPlayer1();
    view.showBoard();
    view.showPlayer2();
  }
}
