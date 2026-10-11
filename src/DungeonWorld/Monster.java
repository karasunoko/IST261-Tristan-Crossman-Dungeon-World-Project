package DungeonWorld;

import java.util.ArrayList;

public class Monster extends Character {
    private int hp;
    private int armor;
    private String weapon;
    private String range;



    public Monster(String name, int hp, int armor, String description, String instinct, String weapon, String range){
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.description = description;
        this.instinct = instinct;
        this.weapon = weapon;
        this.range = range;
        this.special = "None";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }
    public Monster(String name, int hp, int armor, String description, String instinct, String weapon, String range, DWTag location)
    {
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.description = description;
        this.instinct = instinct;
        this.weapon = weapon;
        this.range = range;
        this.special = "None";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        this.addTag(location);

    }
    public Monster(String name, int hp, int armor, String description, String instinct, String weapon, String range, String special){
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.description = description;
        this.instinct = instinct;
        this.weapon = weapon;
        this.range = range;
        this.special = special;
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }
    public Monster(String name, int hp){
        this.name = name;
        this.hp = hp;
        armor = 0;
        description = "";
        this.instinct = "";
        this.weapon = "";
        this.range = "";
        this.special = "None";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }

    public Monster(String name, int hp, int armor){
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.description = "";
        this.instinct = "";
        this.weapon = "";
        this.range = "";
        this.special = "None";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }

    public Monster(String name, int hp, int armor, String description){
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.description = description;
        this.instinct = "";
        this.weapon = "";
        this.range = "";
        this.special = "None";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }

    @Override
    public String toString(){
        return name;
    }


    public String toFullString(){
        return name + ":\n" + "HP: "+hp+"\nArmor: "+armor+"\nWeapon: "+weapon+" "+range+"\n["+this.getTagList()+"]\nSpecial Qualities: "+special+"\nDescription: "+description+"\nMoves:\n"+moves.toString()+"\nItems: "+items.toString()+"\nInstinct: "+instinct;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }



    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void printSetup(){
        banner = "**************************Monster**************************";
    }
}
