package DungeonWorld;

import java.util.ArrayList;

public class Character implements Printable {

    protected String banner;
    protected String name;
    protected String description;
    protected String instinct;
    protected String special;
    protected ArrayList<DWTag> tags;
    protected ArrayList<Move> moves;
    protected ArrayList<Item> items;

    public Character(String name, String description, String instinct){
        this.name = name;
        this.description = description;
        this.instinct = instinct;
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        banner = "****************************************************";
    }
    public Character(String name, String description, String instinct, String special){
        this.name = name;
        this.description = description;
        this.instinct = instinct;
        this.special = special;
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        banner = "****************************************************";
    }

    public Character(String name){
        this.name = name;
        this.description = "";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        banner = "****************************************************";
    }

    public Character(String name, String description){
        this.name = name;
        this.description = description;
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        banner = "****************************************************";
    }
    public Character(){
        this.name = "";
        this.description = "";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
        banner = "****************************************************";
    }

    @Override
    public String toString(){
        return name + ":" +"\n["+this.getTagList()+"]" +"\nDescription: "+description+"\nMoves:\n"+moves.toString()+"\nItems: "+items.toString()+"\nInstinct: "+instinct;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<DWTag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<DWTag> tags) {
        this.tags = tags;
    }

    public void addTag(DWTag tag){
        this.tags.add(tag);
    }

    public void removeTag(DWTag tag){
        this.tags.remove(tag);
    }

    public void removeTagAt(int position){
        this.tags.remove(position);
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }
    public void addMove(Move move){
        this.moves.add(move);
    }

    public void removeMove(Move move){
        this.moves.remove(move);
    }

    public void removeMoveAt(int position){
        this.moves.remove(position);
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void addItem(Item item){
        this.items.add(item);
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getInstinct() {
        return instinct;
    }

    public void setInstinct(String instinct) {
        this.instinct = instinct;
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void removeItemAt(int position){
        this.items.remove(position);
    }

    public String getTagList(){
        String out = "";
        for(DWTag dwTag : tags){

            if(!out.isEmpty()){
                out = out+", ";
            }
            out =  out+dwTag.getName();
        }
        return out;
    }

    @Override
    public void printSetup(){
        banner = "**************************Character**************************";
    }

    @Override
    public void print() {
        System.out.println(banner);
        System.out.println(this.toString());
    }
}

