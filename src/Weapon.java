
/*Represents weapons player can equip with*/
public class Weapon{
    protected String name;//represents name of weapon
   protected int attackBonus;//represents bonus attack power provided by weapon

    Weapon(String name, int attackBonus){
        this.name = name;
        this.attackBonus = attackBonus;
    }

    public String getName(){
        return this.name;
    }
    public int getAttackBonus(){
        return this.attackBonus;
    }

    @Override
    public String toString(){
        return String.format(getName() + " has attackBonus of " + getAttackBonus());
    }
}
