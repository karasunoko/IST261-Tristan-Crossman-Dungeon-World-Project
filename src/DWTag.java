public class DWTag {
    private String name;
    private String description;
    private int n;

    public DWTag(String name){
        this.name = name;
        this.description = "";
        this.n = 0;
    }

    public DWTag(String name, String description){
        this.name = name;
        this.description = description;
        this.n = 0;
    }

    public DWTag(String name, String description, int variable){
        this.name = name;
        this.description = description;
        this.n = variable;
    }

    public DWTag(){
        this.name = "default";
        this.description = "";
        this.n = 0;
    }

    @Override
    public String toString() {

        if(n == 0) {
            return name;
        }
        else {
            return name + " " + n;
        }


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
}
