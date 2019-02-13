public class Monster{
  private int hp;
  private String ID;
  private String name;
  private int attackPower;
  private MonsterState state;
  private int crystal;

  public Monster(String ID, int hp, int attackPower, int crystal){
    this.ID = ID;
    this.hp = hp;
    this.attackPower = attackPower;
    this.crystal = crystal;
  }

  public String getID(){
    return ID;
  }

  public int getHp(){
    return hp;
  }

  public int setHp(int hp){
    this.hp = hp;
    if(this.hp < 0){
      this.hp = 0;
    }
  }

  public int getAttackPower(){
    return attackPower;:
  }

  public void attack(Player enemy){
    int hp = enemy.getHp();
    hp -= attackPower;
    enemy.setHp(hp);
  }

  public void attack(Monster monster){
    int hp = monster.getHp();
    hp -= attackPower;
    monster.setHp(hp);
  }

  public void changeState(){
    pass
  }
}
