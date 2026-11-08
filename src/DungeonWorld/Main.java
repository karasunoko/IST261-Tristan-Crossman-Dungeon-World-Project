package DungeonWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Character> characterList;

    public static void main(String[] args) {


        //Fill test objects with values for a Monster, Hireling and their Moves, Items, and Tags
        DWTag cavern = new DWTag("Cavern Dweller", "At the edges of civilization in the caves and tunnels below the old mountains of the world dwell all sorts of scheming, dangerous monsters. Some are wily and old, like the race of goblins scheming to burn villages and make off with livestock. Others are strange aberrations of nature like the stinking, trash-eating Otyugh. A word of caution, then, to those brave adventurers whose first foray into danger leads them into these dank and shadowy places; bad things live in the dark. Bad things with sharp teeth.");
        Monster testMonster = new Monster("Ankheg",10, 3, "A hide like plate armor and great crushing mandibles are problematic. A stomach full of acid that can burn a hole through a stone wall makes them all the worse. They’d be bad enough if they were proper insect-sized, but these things have the gall to be as long as any given horse. It’s just not natural! Good thing they tend to stick to one place? Easy for you to say—you don’t have an ankheg living under your corn field.", "To undermine","Bite (d8+1)", "Close", "Burrowing");
        Move move1 = new Move("Undermine the ground");
        Move move2 = new Move("Burst from the earth");
        Move move3 = new Move("Spray forth acid, eating away at metal and flesh");
        Move move4 = new Move("4");
        Move move5 = new Move("5");
        Move move6 = new Move("6");
        Item shinyRock = new Item("Shiny Rock", "A rock the sparkles in the light.", 10, 2);
        Hireling jimmy = new Hireling("Jimmy","A retired soldier who is eager to help those who will pay him.", "Reasonable coin.", "Tristan");
        Move sentry = new Move("Sentry", "When a protector stands between you and an attack you increase your armor against that attack by the defender’s skill, then reduce their skill by 1 until they receive healing or have time to mend.");
        Move intervene = new Move("Intervene", "When a protector helps you defy danger you may opt to take +1 from their aid. If you do you cannot get a 10+ result, a 10+ instead counts as a 7–9.");
        Move manAtArms = new Move("Man-At-Arms", "When you deal damage while a warrior aids you add their skill to the damage done. If your attack results in consequences (like a counter attack) the man-at-arms takes the brunt of it.");
        DWTag reach = new DWTag("Reach", "It’s useful for attacking something that’s several feet away—maybe as far as ten.");
        DWTag near = new DWTag("Near", "It’s useful for attacking if you can see the whites of their eyes.");
        DWTag thrown = new DWTag("Thrown", "Throw it at someone to hurt them. If you volley with this weapon, you can’t choose to mark off ammo on a 7–9; once you throw it, it’s gone until you can recover it.");
        Item spear = new Item("Spear", "A pointy stick. What a classic!", 5, 1);
        DWTag uses = new DWTag("uses", "It can only be used n times.", 0);
        DWTag slow = new DWTag("Slow", "It takes minutes or more to use.");
        DWTag ration = new DWTag("Ration", "It's edible, more or less.");
        Item bandages = new Item("Bandages","When you have a few minutes to bandage someone else’s wounds, heal them of 4 damage and expend a use.",5,0,3);
        Item adventuringGear = new Item("Adventuring Gear","Adventuring gear is a collection of useful mundane items such as chalk, poles, spikes, ropes, etc. When you rummage through your adventuring gear for some useful mundane item, you find what you need and mark off a use.", 20, 1, 5);
        Item dungeonRations = new Item("Dungeon Rations", "Not tasty, but not bad either.", 3, 1, 5);
        bandages.addTag(slow);
        uses.setN(3);
        DWTag bandageUses = new DWTag(uses);
        bandages.addTag(bandageUses);
        uses.setN(5);
        DWTag adventuringGearUses = new DWTag(uses);
        DWTag dungeonRationUses = new DWTag(uses);
        adventuringGear.addTag(adventuringGearUses);
        dungeonRations.addTag(dungeonRationUses);
        spear.addTag(reach);
        spear.addTag(thrown);
        spear.addTag(near);
        jimmy.addItem(spear);
        jimmy.addMove(sentry);
        jimmy.addMove(intervene);
        jimmy.addMove(manAtArms);
        jimmy.setProtectorLevel(1);
        jimmy.setWarriorLevel(1);
        testMonster.addTag(cavern);
        testMonster.addMove(move1);
        testMonster.addMove(move2);
        testMonster.addMove(move3);
        testMonster.addMove(move4);
        testMonster.addMove(move5);
        testMonster.addMove(move6);
        testMonster.addItem(shinyRock);
        DWTag folks = new DWTag("Folks of the Realm");
        Move move7 = new Move("Report the truth");
        Move move8 = new Move("Double cross");
        Character spy = new Character("Spy","Beloved of kings but never truly trusted. Mysterious, secretive and alluring, the life of a spy is, if you ask a commoner, full of romance and intrigue. They’re a knife in the dark and a pair of watchful eyes. A spy can be your best friend, your lover or that old man you see in the market every day. One never knows. Hells, maybe you’re a spy—they say there’s magic that can turn folks’ minds without them ever knowing it. How can we trust you?","To infiltrate");
        spy.addMove(move7);
        spy.addMove(move8);
        spy.addTag(folks);
        characterList = new ArrayList<Character>();
        characterList.add(testMonster);
        characterList.add(jimmy);
        characterList.add(spy);
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(shinyRock);
        items.add(spear);
        items.add(bandages);
        items.add(adventuringGear);
        items.add(dungeonRations);
        // ---- Additional SRD monsters ----
        DWTag solitary = new DWTag("Solitary", "Lives and fights alone rather than as part of a group.");
        DWTag large = new DWTag("Large", "Noticeably bigger than a human, about horse-sized or more.");
        DWTag construct = new DWTag("Construct", "Built or magically assembled rather than born naturally.");
        DWTag intelligent = new DWTag("Intelligent", "Can reason, scheme, and bargain.");
        DWTag organized = new DWTag("Organized", "Part of a structured group with leaders and plans.");
        DWTag twistedExperiments = new DWTag("Twisted Experiments", "Created by reckless magic or unnatural meddling.");
        DWTag ravenousHordes = new DWTag("Ravenous Hordes", "Comes from the swarming, warlike tribes.");
        Monster otyugh = new Monster("Otyugh", 20, 1, "A bloated brute that lurks half-sunk in foul water and gorges on the garbage left by orcs and goblins. Its barbed tentacles drag victims toward a mouth full of teeth, and survivors may carry filth fever home with them.", "To befoul", "Tentacles (d10+3)", "Close, Reach, Forceful", "Filth Fever");
        otyugh.addTag(new DWTag(cavern));
        otyugh.addTag(new DWTag(solitary));
        otyugh.addTag(new DWTag(large));
        otyugh.addMove(new Move("Infect someone with filth fever"));
        otyugh.addMove(new Move("Fling someone or something"));
        Monster owlbear = new Monster("Owlbear", 12, 2, "A bear's body wearing an owl's feathers, beak, and sharp night vision. It is built to ambush from the dark.", "To hunt", "Claws (d10)", "Close", "None");
        owlbear.addTag(new DWTag(twistedExperiments));
        owlbear.addTag(new DWTag(solitary));
        owlbear.addTag(new DWTag(construct));
        owlbear.addMove(new Move("Strike from darkness"));
        Monster warchief = new Monster("Orc Warchief", 16, 0, "The single supreme leader of the orc horde, blessed by both the one-eyes and the shamans. He carries an ancient sword and an old grudge against the civilized races, and he expects to be obeyed.", "To lead", "Iron Sword of Ages (2d10, take highest, +2)", "Close, Reach", "One-Eye blessings, Shaman blessings, Divine protection from mortal harm");
        warchief.addTag(new DWTag(ravenousHordes));
        warchief.addTag(new DWTag(solitary));
        warchief.addTag(new DWTag(intelligent));
        warchief.addTag(new DWTag(organized));
        warchief.addMove(new Move("Start a war"));
        warchief.addMove(new Move("Make a show of power"));
        warchief.addMove(new Move("Enrage the tribes"));
        characterList.add(otyugh);
        characterList.add(owlbear);
        characterList.add(warchief);

        ArrayList<Item> saved = StorageManager.loadItems();
        if (saved != null) {
            items = saved;   // use the saved list instead of the test data
        }
        new ItemListUICtrl(items);

        ArrayList<Character> savedCharacters = StorageManager.loadCharacters();
        if (savedCharacters != null) {
            characterList = savedCharacters;
        }

        //CharacterUICtrl characterUICtrl = new CharacterUICtrl(spy);

        CharacterListUICtrl characterListUICtrl = new CharacterListUICtrl(characterList);

    }

    public static ArrayList<Item> EditItems(ArrayList<Item> items){
        ArrayList<Item> returned;
        ArrayList<Item> newItems = new ArrayList<Item>();
        ListUICtrl itemUICtrl = ListUICtrl.forItems(items);
        itemUICtrl.setFrame(new JFrame());
        itemUICtrl.getFrame().setTitle("Item Editor");
        itemUICtrl.getFrame().setContentPane(itemUICtrl.getItemEditor().getcPane());
        itemUICtrl.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        itemUICtrl.getFrame().setSize(600,500);
        itemUICtrl.getFrame().pack();
        itemUICtrl.getFrame().setLocationRelativeTo(null);
        itemUICtrl.getFrame().setVisible(true);
        itemUICtrl.ResetValues(true);
        itemUICtrl.getItemEditor().getPreviousButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {itemUICtrl.PreviousValues();}});
        itemUICtrl.getItemEditor().getNextButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {itemUICtrl.NextValues();}});
        itemUICtrl.getItemEditor().getResetButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {itemUICtrl.ResetValues(false);}});
        itemUICtrl.getItemEditor().getSaveButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {itemUICtrl.SaveValues();}});
        itemUICtrl.getItemEditor().getClearButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {itemUICtrl.ClearValues();}});
        itemUICtrl.getItemEditor().getDeleteButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {itemUICtrl.DeleteValues();}});
        itemUICtrl.getItemEditor().getNewButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {itemUICtrl.New();}});
        itemUICtrl.getItemEditor().getEditTagsButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {itemUICtrl.EditTags();}});
        itemUICtrl.getItemEditor().getSaveAndCloseButton().addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {
            ArrayList<Listable> newList = itemUICtrl.SaveClose();
            for(Listable l : newList){
                newItems.add((Item) l);
            }
        }});

        return newItems;
    }
}