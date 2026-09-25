package Testing;

import DungeonWorld.Character;
import DungeonWorld.DWTag;
import DungeonWorld.Item;
import DungeonWorld.Move;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void testToString() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        assertEquals("","");
    }

    @Test
    void getName() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        assertEquals("",character.getName());
    }

    @Test
    void setName() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        character.setName("Test");
        assertEquals("Test",character.getName());
    }


    @Test
    void getDescription() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        assertEquals("",character.getDescription());
    }

    @Test
    void setDescription() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        character.setDescription("Test description.");
        assertEquals("Test description.",character.getDescription());
    }

    @Test
    void getTags() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        assertEquals(new ArrayList<DWTag>(),character.getTags());
    }

    @Test
    void setTags() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        DWTag tag = new DWTag("Test");
        character.setTags(new ArrayList<DWTag>(List.of(tag)));
        assertEquals(new ArrayList<DWTag>(List.of(tag)),character.getTags());
    }

    @Test
    void addTag() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        DWTag tag = new DWTag("Test");
        character.addTag(tag);
        assertEquals(new ArrayList<DWTag>(List.of(tag)),character.getTags());
    }

    @Test
    void removeTag() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        DWTag tag = new DWTag("Test");
        character.setTags(new ArrayList<DWTag>(List.of(tag)));
        character.removeTag(tag);
        assertEquals(new ArrayList<DWTag>(),character.getTags());
    }

    @Test
    void removeTagAt() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        DWTag tag1 = new DWTag("Test 1");
        DWTag tag2 = new DWTag("Test 2");
        character.setTags(new ArrayList<DWTag>(List.of(tag1,tag2)));
        character.removeTagAt(0);
        assertEquals(new ArrayList<DWTag>(List.of(tag2)),character.getTags());
    }

    @Test
    void getMoves() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        assertEquals(new ArrayList<Move>(),character.getMoves());
    }

    @Test
    void setMoves() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        Move move = new Move("Test");
        character.setMoves(new ArrayList<>(List.of(move)));
        assertEquals(new ArrayList<Move>(List.of(move)),character.getMoves());
    }

    @Test
    void addMove() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        Move move = new Move("Test");
        character.addMove(move);
        assertEquals(new ArrayList<Move>(List.of(move)),character.getMoves());
    }

    @Test
    void removeMove() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        Move move = new Move("Test");
        character.setMoves(new ArrayList<Move>(List.of(move)));
        character.removeMove(move);
        assertEquals(new ArrayList<Move>(),character.getMoves());
    }

    @Test
    void removeMoveAt() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        Move move1 = new Move("Test 1");
        Move move2 = new Move("Test 2");
        character.setMoves(new ArrayList<Move>(List.of(move1,move2)));
        character.removeMoveAt(0);
        assertEquals(new ArrayList<Move>(List.of(move2)),character.getMoves());
    }

    @Test
    void getItems() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        assertEquals(new ArrayList<Item>(),character.getItems());
    }

    @Test
    void setItems() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        Item item = new Item("Test");
        character.setItems(new ArrayList<Item>(List.of(item)));
        assertEquals(new ArrayList<Item>(List.of(item)),character.getItems());
    }

    @Test
    void addItem() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        Item item = new Item("Test");
        character.addItem(item);
        assertEquals(new ArrayList<Item>(List.of(item)),character.getItems());
    }

    @Test
    void removeItem() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        Item item1 = new Item("Test 1");
        Item item2 = new Item("Test 2");
        character.setItems(new ArrayList<Item>(List.of(item1,item2)));
        character.removeItem(item1);
        assertEquals(new ArrayList<Item>(List.of(item2)),character.getItems());
    }

    @Test
    void removeItemAt() {
        DungeonWorld.Character character = new DungeonWorld.Character();
        Item item1 = new Item("Test 1");
        Item item2 = new Item("Test 2");
        character.setItems(new ArrayList<Item>(List.of(item1,item2)));
        character.removeItemAt(0);
        assertEquals(new ArrayList<Item>(List.of(item2)),character.getItems());
    }

    @Test
    void getTagList() {
        DungeonWorld.Character character = new Character();
        DWTag tag1 = new DWTag("Test 1");
        DWTag tag2 = new DWTag("Test 2");
        character.setTags(new ArrayList<DWTag>(List.of(tag1,tag2)));
        assertEquals("Test 1, Test 2",character.getTagList());
    }
}