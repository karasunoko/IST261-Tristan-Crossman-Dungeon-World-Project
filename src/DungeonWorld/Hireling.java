package DungeonWorld;

import java.util.ArrayList;

public class Hireling extends Character {
    private String controllingPlayer = "";
    private int level = 0;
    private String cost = "";
    private int adeptLevel = 0;
    private int burglarLevel = 0;
    private int minstrelLevel = 0;
    private int priestLevel = 0;
    private int protectorLevel = 0;
    private int trackerLevel = 0;
    private int warriorLevel = 0;

    public Hireling(String name, String description, String cost){
        this.name = name;
        this.description = description;
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        this.controllingPlayer = "";
        this.cost = cost;
        this.level = 0;
        this.adeptLevel = 0;
        this.burglarLevel = 0;
        this.minstrelLevel = 0;
        this.priestLevel = 0;
        this.protectorLevel = 0;
        this.trackerLevel = 0;
        this.warriorLevel = 0;
    }

    public Hireling(String name, String description, String cost, String controller){
        this.name = name;
        this.description = description;
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        this.controllingPlayer = controller;
        this.cost = cost;
        this.level = 0;
        this.adeptLevel = 0;
        this.burglarLevel = 0;
        this.minstrelLevel = 0;
        this.priestLevel = 0;
        this.protectorLevel = 0;
        this.trackerLevel = 0;
        this.warriorLevel = 0;
    }

    public Hireling(String name){
        this.name = name;
        this.description = "";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        this.controllingPlayer = "";
        this.cost = "";
        this.level = 0;
        this.adeptLevel = 0;
        this.burglarLevel = 0;
        this.minstrelLevel = 0;
        this.priestLevel = 0;
        this.protectorLevel = 0;
        this.trackerLevel = 0;
        this.warriorLevel = 0;
    }

    public Hireling(String name, String description){
        this.name = name;
        this.description = description;
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        this.controllingPlayer = "";
        this.cost = "";
        this.level = 0;
        this.adeptLevel = 0;
        this.burglarLevel = 0;
        this.minstrelLevel = 0;
        this.priestLevel = 0;
        this.protectorLevel = 0;
        this.trackerLevel = 0;
        this.warriorLevel = 0;
    }
    @Override
    public String toString(){
        return name;
    }


    public String toFullString() {
        return name + ":\nCost: "+ cost +"\nControlling Player: "+ controllingPlayer+"\nLevel: "+ level + "\n["+this.getTagList()+"]" +"\nDescription: "+description+"\nMoves:\n"+moves.toString()+"\nItems: "+items.toString()+"\nSkills: (Adept Level: "+adeptLevel+", Burglar Level: "+burglarLevel+", Minstrel Level: "+minstrelLevel+", Priest Level: "+priestLevel+", Protector Level: "+protectorLevel+", Warrior Level: "+warriorLevel+")";
    }

    public String getControllingPlayer() {
        return controllingPlayer;
    }

    public void setControllingPlayer(String controllingPlayer) {
        this.controllingPlayer = controllingPlayer;
    }

    public int getLevel() {
        return level;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getAdeptLevel() {
        return adeptLevel;
    }

    public void setAdeptLevel(int adeptLevel) {
        this.adeptLevel = adeptLevel;
        this.level = this.adeptLevel+this.burglarLevel+this.minstrelLevel+this.priestLevel+this.protectorLevel+this.trackerLevel+this.warriorLevel;
    }

    public int getBurglarLevel() {
        return burglarLevel;
    }

    public void setBurglarLevel(int burglarLevel) {
        this.burglarLevel = burglarLevel;
        this.level = this.adeptLevel+this.burglarLevel+this.minstrelLevel+this.priestLevel+this.protectorLevel+this.trackerLevel+this.warriorLevel;
    }

    public int getMinstrelLevel() {
        return minstrelLevel;
    }

    public void setMinstrelLevel(int minstrelLevel) {
        this.minstrelLevel = minstrelLevel;
        this.level = this.adeptLevel+this.burglarLevel+this.minstrelLevel+this.priestLevel+this.protectorLevel+this.trackerLevel+this.warriorLevel;
    }

    public int getPriestLevel() {
        return priestLevel;
    }

    public void setPriestLevel(int priestLevel) {
        this.priestLevel = priestLevel;
        this.level = this.adeptLevel+this.burglarLevel+this.minstrelLevel+this.priestLevel+this.protectorLevel+this.trackerLevel+this.warriorLevel;
    }

    public int getProtectorLevel() {
        return protectorLevel;
    }

    public void setProtectorLevel(int protectorLevel) {
        this.protectorLevel = protectorLevel;
        this.level = this.adeptLevel+this.burglarLevel+this.minstrelLevel+this.priestLevel+this.protectorLevel+this.trackerLevel+this.warriorLevel;
    }

    public int getTrackerLevel() {
        return trackerLevel;
    }

    public void setTrackerLevel(int trackerLevel) {
        this.trackerLevel = trackerLevel;
        this.level = this.adeptLevel+this.burglarLevel+this.minstrelLevel+this.priestLevel+this.protectorLevel+this.trackerLevel+this.warriorLevel;
    }

    public int getWarriorLevel() {
        return warriorLevel;
    }

    public void setWarriorLevel(int warriorLevel) {
        this.warriorLevel = warriorLevel;
        this.level = this.adeptLevel+this.burglarLevel+this.minstrelLevel+this.priestLevel+this.protectorLevel+this.trackerLevel+this.warriorLevel;
    }

    @Override
    public void printSetup(){
        banner = "**************************Hireling**************************";
    }
}
