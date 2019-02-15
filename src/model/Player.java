package model;
public class Player{
  private String name;
  private int hp;
  private int maxCrystal;
  private int crystal;
  private Monster[] handCards;
  private int maxHandCardNumber;
  private int handCardNumber;
  
  public Player(int hp, int crystal, int maxCrystal, int maxHandCardNumber){
    this.hp = hp;
    this.crystal = crystal;
    this.maxCrystal = maxCrystal;
    this.maxHandCardNumber = maxHandCardNumber;
    this.handCards = new Monster[this.maxHandCardNumber];
    this.handCardNumber = 0;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public int getHp(){
    return hp;
  }

  public void setHp(int hp){
    this.hp = hp;
    if(this.hp < 0){
      this.hp = 0;
    }
  }

  public void setCrystal(int crystal){
    this.crystal = crystal;
  }

  public int getCrystal(){
    return crystal;
  }

  public void setMaxCrystal(int maxCrystal){
    this.maxCrystal = maxCrystal;
  }
 
  public int getMaxCrystal(){
    return maxCrystal;
  }

  public void fillCrystal(){
    crystal = maxCrystal;
  }

  public Monster[] getHandCards(){
    Monster[] cards = new Monster[handCardNumber];
    for(int i=0; i< handCardNumber; i++){
      cards[i] = handCards[i];
    }
    return cards;
  }

  public void addHandCards(Monster[] cards){
    int end = ((maxHandCardNumber - handCardNumber) > cards.length) ? (handCardNumber+cards.length) : maxHandCardNumber;
    int start = handCardNumber;
    for(int i=start; i < end; i++){
      handCards[i] = cards[i-start];
      handCardNumber+=1;
    } 
  }

  public Monster selectCard(String monsterID){
    Monster result = null;
    for(int i=0; i<handCardNumber; i++){
      if(handCards[i].getID().equals(monsterID)){
        result = handCards[i];
        handCardNumber -= 1;
        arrangeHandCards(i);
        break;
      }
    }
    return result; 
  }

  private void arrangeHandCards(int index){
    for(int i = index; i<handCardNumber; i++){
      handCards[i] = handCards[i+1];
    }
    handCards[handCardNumber] = null;
  }
}
