package model;
public class MonsterCreator{
  public Monster create(String monsterID){
    Monster monster;  
    switch(monsterID){
      case "A1":
        monster = new Water("A1", 8, 8, 8);
        break;
      case "A2":
        monster = new Water("A2", 2, 0, 1);
        break;
      case "B1":
        monster = new Flame("B1", 7, 7, 7);
        break;
      case "B2":
        monster = new Flame("B2", 4, 6, 5);
        break;
      case "C1":
        monster = new Wind("C1", 7, 5, 6);
        break;
      case "C2":
        monster = new Wind("C2", 1, 6, 4);
        break;
      case "D1":
        monster = new Thunder("D1", 8, 10, 9);
        break;
      case "D2":
        monster = new Thunder("D2", 4, 3, 3);
        break;
      case "E1":
        monster = new Dirt("E1", 4, 0, 2);
        break;
    }
    return monster;
  }
}
