import java.util.ArrayList;

public class TestHarness {
    public TestHarness(){
        TestItem();
        TestDWTag();
    }

    public void TestDWTag(){
        //Test the DWTag class
        System.out.println("Testing the DWTag class:");
        DWTag t1 = new DWTag();
        if(t1 != null){
            System.out.println(t1.getName());
            System.out.println(t1.getDescription());
            System.out.println(t1.getN());
        }else{
            System.out.println("Error creating DWTag class.");
        }
        t1.setName("Test");
        t1.setDescription("Test description.");
        t1.setN(5);
        System.out.println(t1.toString());
        if(t1.toString().equals("Test 5: Test description.")){
            System.out.println("Completed testing the DWTag class.");
        }else{
            System.out.println("Error in DWTag class output.");
        }
    }

    public void TestItem() {
        //Test the Item class
        System.out.println("Testing the Item class:");

        Item i1 = new Item();
        if(i1 != null){
            System.out.println(i1.getName());
            System.out.println(i1.getCost());
            System.out.println(i1.getWeight());
            System.out.println(i1.getTags().toString());

        }else{
            System.out.println("Error creating Item class.");
        }
        i1.setName("Test");
        i1.setCost(5);
        i1.setWeight(1);
        i1.setTags(new ArrayList<DWTag>());
        i1.addTag(new DWTag("tag1"));
        DWTag badTag = new DWTag("badTag");
        i1.addTag(badTag);
        i1.addTag(new DWTag("tag2"));
        i1.addTag(new DWTag("tag3"));
        i1.removeTag(badTag);
        i1.removeTagAt(2);
        System.out.println(i1.toString());
        if(i1.toString().equals("Test(tag1, tag2, Cost: 5, Weight: 1)")){
            System.out.println("Completed testing the Item class.");
        }else{
            System.out.println("Error in Item class output.");
        }


    }
}
