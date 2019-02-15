package model;
import java.io.File;
import java.util.Scanner;

public class Deck{
  private Monster[] cards;
  private int allCardNumber;
  private int top;

  public Deck(int allCardNumber){
    this.allCardNumber = allCardNumber;
    cards = new Monster[allCardNumber];
    top = 0;
  }
  
  public ErrorMessage readFile(String fileName){
    ErrorMessage errorMessage = new ErrorMessage(); 
    File file = new File(fileName);
    if(!file.exist()){
      errorMessage.setMessage(fileName + "doesn't exist!");
      return errorMessage;
    }
    
    Scanner scanner = new Scanner(file);
    MonsterCreator monsterCreator = new MonsterCreator();
    int index = 0;
    while(scanner.hasNextLine()){
      String card = scanner.nextLine();
      Monster monster = monsterCreator.create(card);
      if(monster == null){
        errorMessage.setMessage("The name of card is ilegal in " + filename + "!");
        return errorMessage;
      } 
      cards[index] = monster;
      index += 1; 
    }
    return errorMessage; 
  }
  


  public Monster[] getCard(int cardNumber){
    Monster[] resultCard;
    
    int nextTop = top + cardNumber;
    if(nextTop > allCardNumber){
      nextTop = allCardNumber;
    }
  
    cardNumber = nextTop - top;
    resultCard = new Monster[cardNumber];
    for(int i=0; i<cardNumber; i++){
      deckIndex = top + i;
      resultCard[i] = cards[deckIndex];
    }
    top = nextTop; 
    
    return resultCard;
  }
}
