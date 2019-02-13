public class Board{
  private Monster[] monsterBoard;
  private char name;
  private int boardNumber; 
  
  public Board(char name, int boardNumber){
    this.boardNumber = boardNumber;
    monsterBoard = new Monster[boardNumber];
    this.name = name;
  } 
  
  public ErrorMessage setMonster(String location, Monster monster){
    ErrorMessage errorMessage = new ErrorMessage();
    int number = splitPosition(location);
    if(number != -1 && monsterBoard[number-1] == null){
      monsterBoard[number-1] = monster;
    }
    else{
      errorMessage.setMessage("The position is error");
    }
    return errorMessage; 
  }

  private int splitPosition(String position){
    int number = -1;
    if(position.length() == 2){
      char positionName = position.charAt(0);
      char positionNumber = position.charAt(1);
      if(positionName == name){
        number = Character.getNumbericValue(positionNumber);
        if(number < 1 || number > 6){
          number = -1;
        }
      }
    }
    return number;
  }

  public void showBoard(){
  
  }


  public void getMonster(String position){
    Monster monster = null;
    int number = splitPosition(position);
    if(number != -1)
      monster = monsterBoard[number-1];
    }
    return monster
  }


  public void clearBoard(){
    for(int i=0; i<boardNumber; i++){
      if(monsterBoard[i].getHp() == 0){
        monsterBoard[i] = null; 
      }
    }
  }

  public ErrorMessage changeMonsterState(String position){
    ErrorMessage errorMessage = new ErrorMessage();
    int number = splitPosition(position);
    if(number != -1){
      monsterBoard[number-1].changeState(); 
    }else{
      errorMessage.setMessage("The position is error");
    }
  }
  
}
