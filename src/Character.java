import java.util.ArrayList;

public class Character {

    protected String name = "";
    protected int hp = 0;
    protected int armor = 0;
    protected String description = "";
    protected ArrayList<DWTag> tags = new ArrayList<DWTag>();
    protected ArrayList<Move> moves = new ArrayList<Move>();
    protected ArrayList<Item> items = new ArrayList<Item>();

    public Character(String name, int hp){
        this.name = name;
        this.hp = hp;
        this.armor = 0;
        this.description = "";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }

    public Character(String name, int hp, int armor){
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.description = "";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }

    public Character(String name, int hp, int armor, String description){
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.description = description;
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }
    public Character(){
        this.name = "";
        this.hp = 0;
        this.armor = 0;
        this.description = "";
        this.tags = new ArrayList<DWTag>();
        this.moves = new ArrayList<Move>();
        this.items = new ArrayList<Item>();
    }

    @Override
    public String toString(){
        return name + ":\n" + "HP: "+hp+"\nArmor: "+armor+"\n["+this.getTagList()+"]\n" +"\nDescription: "+description+"\nMoves:\n"+moves.toString()+"\nItems: "+items.toString();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}

