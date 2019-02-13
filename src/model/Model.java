public class Model{
  private Player[] players;
  private Board[] boards;
  private Deck[] decks; 
  private int turn;
  private int round;
  private final int maxHandCardsNumber = 8;
  private final int deckAllCardsNumber = 15;
  private final int initialCardNumber = 5
   
  public Model(){
    Player player1 = new Player(20, 0, 0, maxHandCardsNumber);
    Player player2 = new Player(20, 0, 0, maxHandCardsNumber);
    players = new Player[]{player1, player2};
    boards = new Boards[]{new Board('U',6), new Board('D',6)};
    decks = new Deck[]{new Deck(deckAllCardsNumber), new Deck(deckAllCardsNumber)};
    turn = 0;
    round = 0;
    isError = false;
  }

  public ErrorMessage initialModel(){
    String player1_path = "Card\player1_cards.txt";
    String player2_path = "Card\player2_cards.txt";
    
    //player1 card
    ErrorMessage errorMessage= decks[0].readFile(player1_path);
    if(errorMessage.getIsError() == true){
      return errorMessage;
    }
    
    //player2 card    
    errorMessage = decks[1].readFile(player2_path);
    return errorMessage

  }

  public void startGame(){
    //draw 5 cards to each player
    players[0].addHandCards(deck[0].getCard(initialCardNumber)); 
    players[1].addHandCards(deck[1].getCard(initialCardNumber)); 
    
    turn = 0;
    round = 1;
    int maxCrystal = computeMaxCrystal();
    players[turn].setMaxCrystal(maxCrystal);
    players[turn].fillCrystal();
    
    int drawCardNumber = computeDrawCard();
    players[turn].addHandCards(deck[turn].getCard(drawCardNumber)); 
  }

  public void inputUserName(String player1Name, String player2Name){
    players[0].setName(player1Name);
    players[1].setName(player2Name);

  }

  private int computeMaxCrystl(){
    int result = round;
    if(result > 10){
      result = 10;
    }
    return result;
  }
  
  private int computeDrawCard(){
    int result = 1;
    if(round%3 == 0){
      result = 2;
    }
    return result;
  } 
  
  public ErrorMessage selectMonster(String monsterID, String position, String state){
    ErrorMessage errorMessage = new ErrorMessage();
    Monster monster = players[turn].selectCard(monsterID);
    if(monster == null){
      errorMessage.setMessage(players[turn].getName() + " doesn't have " + monsterID);
    }
    else{
      errorMessage = boards[turn].setMonster(position, monster);
    }
    return errorMessage;
  }

  public ErrorMessage monsterAttack(String attackerPosition, String victimPosition){
    ErrorMessage errorMessage = new ErrorMessage();
    Monster attacker = boards[turn].getMonster(attackerPosition);
    if(attacker == null){
      errorMessage.setMessage("The position of attacker is error");
      return errorMessage;
    }

    if(victimePosition.equals("enemy")){ 
      Player enemy = players[getEnemyTurn()];
      Monster monster = boards[turn].getMonster(attackerPosition);
      monster.attack(enemy);
    }
    else{ 
      Monster victim = boards[getEnemyTurn()].getMonster(victimPosition);
      if(victim == null){
        errorMessage.setMessage("The position of victim is error");
        return errorMessage;
      }
      monster.attack(victim);
    }
    boards[0].clearBoard();
    boards[1].clearBoard();
    return errorMessage;
  }


  public void changeMonsterState(String monsterPosition){
    
  }

  public void finishTurn(){
    
  }

  public ErrorMessage enterPlayerName(String player1Name, String player2Name){
    players[0].setName(player1Name);
    players[1].setName(player2Name);
  }
  
  private int getEnemyTurn(){
    int enemyTurn = turn + 1;
    if(enemyTurn == 2){
      enemyTurn = 0;
    }
    return enemyTurn;
  }
}
