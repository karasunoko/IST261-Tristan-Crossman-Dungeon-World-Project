import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void testToString() {
        Character character = new Character();
        assertEquals("","");
    }

    @Test
    void getName() {
        Character character = new Character();
        assertEquals("",character.getName());
    }

    @Test
    void setName() {
        Character character = new Character();
        character.setName("Test");
        assertEquals("Test",character.getName());
    }

    @Test
    void getHP() {
        Character character = new Character();
        assertEquals(0,character.getHP());
    }

    @Test
    void setHP() {
        Character character = new Character();
        character.setHP(5);
        assertEquals(5,character.getHP());
    }

    @Test
    void getArmor() {
        Character character = new Character();
        assertEquals(0,character.getArmor());
    }

    @Test
    void setArmor() {
        Character character = new Character();
        character.setArmor(2);
        assertEquals(2,character.getArmor());
    }

    @Test
    void getDescription() {
        Character character = new Character();
        assertEquals("",character.getDescription());
    }

    @Test
    void setDescription() {
        Character character = new Character();
        character.setDescription("Test description.");
        assertEquals("Test description.",character.getDescription());
    }

    @Test
    void getTags() {
        Character character = new Character();
        assertEquals(new ArrayList<DWTag>(),character.getTags());
    }

    @Test
    void setTags() {
        Character character = new Character();
        DWTag tag = new DWTag("Test");
        character.setTags(new ArrayList<DWTag>(List.of(tag)));
        assertEquals(new ArrayList<DWTag>(List.of(tag)),character.getTags());
    }

    @Test
    void addTag() {
        Character character = new Character();
        DWTag tag = new DWTag("Test");
        character.addTag(tag);
        assertEquals(new ArrayList<DWTag>(List.of(tag)),character.getTags());
    }

    @Test
    void removeTag() {
        Character character = new Character();
        DWTag tag = new DWTag("Test");
        character.setTags(new ArrayList<DWTag>(List.of(tag)));
        character.removeTag(tag);
        assertEquals(new ArrayList<DWTag>(),character.getTags());
    }

    @Test
    void removeTagAt() {
        Character character = new Character();
        DWTag tag1 = new DWTag("Test 1");
        DWTag tag2 = new DWTag("Test 2");
        character.setTags(new ArrayList<DWTag>(List.of(tag1,tag2)));
        character.removeTagAt(0);
        assertEquals(new ArrayList<DWTag>(List.of(tag2)),character.getTags());
    }

    @Test
    void getMoves() {
        Character character = new Character();
        assertEquals(new ArrayList<Move>(),character.getMoves());
    }

    @Test
    void setMoves() {
        Character character = new Character();
        Move move = new Move("Test");
        character.setMoves(new ArrayList<>(List.of(move)));
        assertEquals(new ArrayList<Move>(List.of(move)),character.getMoves());
    }

    @Test
    void addMove() {
        Character character = new Character();
        Move move = new Move("Test");
        character.addMove(move);
        assertEquals(new ArrayList<Move>(List.of(move)),character.getMoves());
    }

    @Test
    void removeMove() {
        Character character = new Character();
        Move move = new Move("Test");
        character.setMoves(new ArrayList<Move>(List.of(move)));
        character.removeMove(move);
        assertEquals(new ArrayList<Move>(),character.getMoves());
    }

    @Test
    void removeMoveAt() {
        Character character = new Character();
        Move move1 = new Move("Test 1");
        Move move2 = new Move("Test 2");
        character.setMoves(new ArrayList<Move>(List.of(move1,move2)));
        character.removeMoveAt(0);
        assertEquals(new ArrayList<Move>(List.of(move2)),character.getMoves());
    }

    @Test
    void getItems() {
        Character character = new Character();
        assertEquals(new ArrayList<Item>(),character.getItems());
    }

    @Test
    void setItems() {
        Character character = new Character();
        Item item = new Item("Test");
        character.setItems(new ArrayList<Item>(List.of(item)));
        assertEquals(new ArrayList<Item>(List.of(item)),character.getItems());
    }

    @Test
    void addItem() {
        Character character = new Character();
        Item item = new Item("Test");
        character.addItem(item);
        assertEquals(new ArrayList<Item>(List.of(item)),character.getItems());
    }

    @Test
    void removeItem() {
        Character character = new Character();
        Item item1 = new Item("Test 1");
        Item item2 = new Item("Test 2");
        character.setItems(new ArrayList<Item>(List.of(item1,item2)));
        character.removeItem(item1);
        assertEquals(new ArrayList<Item>(List.of(item2)),character.getItems());
    }

    @Test
    void removeItemAt() {
        Character character = new Character();
        Item item1 = new Item("Test 1");
        Item item2 = new Item("Test 2");
        character.setItems(new ArrayList<Item>(List.of(item1,item2)));
        character.removeItemAt(0);
        assertEquals(new ArrayList<Item>(List.of(item2)),character.getItems());
    }

    @Test
    void getTagList() {
        Character character = new Character();
        DWTag tag1 = new DWTag("Test 1");
        DWTag tag2 = new DWTag("Test 2");
        character.setTags(new ArrayList<DWTag>(List.of(tag1,tag2)));
        assertEquals("Test 1, Test 2",character.getTagList());
    }
}