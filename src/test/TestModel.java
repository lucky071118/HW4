import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestModel{

  @Test
  public void testPlayerBasic(){
    Player player = new Player(20, 2, 5, 10);
    assertEquals(player.getHp(), 20);
    assertEquals(player.getCrystal(), 2);
    assertEquals(player.getMaxCrystal(), 5);
    assertEquals(player.getHandCards().length, 0);
    player.setName("John");
    assertEquals(player.getName(), "John");
    player.setHp(30);
    assertEquals(player.getHp(), 30);
    player.fillCrystal();
    assertEquals(player.getCrystal(),5);
    player.setMaxCrystal(6);
    player.fillCrystal();
    assertEquals(player.getMaxCrystal(), 6);
    assertEquals(player.getCrystal(), 6);
  }

  @Test
  public void testPlayerCard(){
    Player player = new Player(20, 2, 5, 3);
    Monster[] cards = new Monster[2];
    cards[0] = new Monster("A1", 2, 2, 2);
    cards[1] = new Monster("B2", 3, 3, 3);
    player.addHandCards(cards);
    Monster[] card2 = player.getHandCards();
    assertEquals(cards.length, card2.length);
    assertEquals(card2[0].getID(), "A1");
    assertEquals(card2[1].getID(), "B2");

    Monster resultCard = player.selectCard("A1");
    assertEquals(resultCard.getID(), "A1");
    Monster[] card3 = player.getHandCards();
    assertEquals(card3.length, 1);
    assertEquals(card3[0].getID(), "B2");

    Monster[] newCard = new Monster[]{new Monster("C3", 2, 2, 2)};
    player.addHandCards(newCard);
    Monster[] card4 = player.getHandCards();
    assertEquals(card4.length, 2);
    assertEquals(card4[0].getID(), "B2");
    assertEquals(card4[1].getID(), "C3");
    
    Monster[] newTwoCards = new Monster[2];
    newTwoCards[0] = new Monster("D2", 2, 2, 2);
    newTwoCards[1] = new Monster("E1", 2, 2, 2);
    player.addHandCards(newTwoCards);
    Monster[] card5 = player.getHandCards();
    assertEquals(card5.length, 3);
    assertEquals(card5[0].getID(), "B2");
    assertEquals(card5[1].getID(), "C3");
    assertEquals(card5[2].getID(), "D2");

    Monster card = player.selectCard("E1");
    assertEquals(card, null);
    card = player.selectCard("C3");
    assertEquals(card.getID(), "C3");
    Monster[] card6 = player.getHandCards();
    assertEquals(card6.length, 2);
    assertEquals(card6[0].getID(), "B2");
    assertEquals(card6[1].getID(), "D2");
   
    card = player.selectCard("D2");
    assertEquals(card.getID(), "D2");
    Monster[] card7 = player.getHandCards();
    assertEquals(card7.length, 1);
    assertEquals(card7[0].getID(), "B2");
  }

  @Test
  public void testMonsterCreator(){
    MonsterCreator monsterCreator = new MonsterCreator();
    Monster monster = monsterCreator.create("A1");
    assertEquals(monster.getID(), "A1");
    assertEquals(monster.getID(), 
  }
} 
