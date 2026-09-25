package DungeonWorld;

public class Move extends Listable{
    String description;

    public Move(String description)
    {
        this.description = description;
        this.name = "";
    }
    public Move(String name, String description)
    {
        this.description = description;
        this.name = name;
    }
    public Move()
    {
        this.description = "default";
        this.name = "";
    }
    @Override
    public String toString(){
        if(name.isEmpty()||name.isBlank()){
            return description;
        }
        else{
            return name + ": " + description;
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
