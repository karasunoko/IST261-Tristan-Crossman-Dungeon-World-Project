package DungeonWorld;

import java.util.ArrayList;

public class Item extends Listable{
    private int cost;
    private int weight;
    private ArrayList<DWTag> tags;
    private int n;

    public Item(String name){
        this.name = name;
        this.description = "";
        this.cost = 0;
        this.weight = 0;
        this.n = 0;
        this.tags = new ArrayList<DWTag>();
    }
    public Item(String name, String description){
        this.name = name;
        this.description = description;
        this.cost = 0;
        this.weight = 0;
        this.n = 0;
        this.tags = new ArrayList<DWTag>();
    }

    public Item(String name, String description, int weight){
        this.name = name;
        this.description = description;
        this.cost = 0;
        this.weight = weight;
        this.n = 0;
        this.tags = new ArrayList<DWTag>();
    }

    public Item(String name, String description, int cost, int weight){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.weight = weight;
        this.n = 0;
        this.tags = new ArrayList<DWTag>();
    }

    public Item(String name, String description, int cost, int weight, int n){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.weight = weight;
        this.n = n;
        this.tags = new ArrayList<DWTag>();
    }

    public Item(){
        this.name = "default";
        this.description = "";
        this.cost = 0;
        this.weight = 0;
        this.n = 0;
        this.tags = new ArrayList<DWTag>();
    }

    @Override
    public String toString(){
        return name;
    }



    public String toFullString(){
        String out = "";

        if(!tags.isEmpty()){
            out = name + "(";
            for(DWTag dwTag : tags){
                out += dwTag.getName()+", ";
            }
            out += "Cost: "+cost+", Weight: "+weight+")";
        }
        else
        {
            out = name + "(Cost: "+cost+", Weight: "+weight+")";
        }


        return out;
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

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
