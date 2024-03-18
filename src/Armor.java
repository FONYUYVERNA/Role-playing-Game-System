public class Armor {
    protected String name;//represents name of armor
    protected int defenseBonus;//represents bonus defence provided by armor


    Armor(String name, int defenseBonus){
        this.name = name;
        this.defenseBonus = defenseBonus;
    }

    public String getName(){
        return this.name;
    }
    public int getDefenseBonus(){
        return this.defenseBonus;
    }

    @Override
    public String toString(){
        return String.format(getName() + " has defence Bonus of " + getDefenseBonus());
    }
}
