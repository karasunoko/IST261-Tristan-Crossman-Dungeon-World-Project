import java.util.ArrayList;

public class TestPrint {

    public static void main(String[] args){

        DWTag cavern = new DWTag("Cavern Dweller", "At the edges of civilization in the caves and tunnels below the old mountains of the world dwell all sorts of scheming, dangerous monsters. Some are wily and old, like the race of goblins scheming to burn villages and make off with livestock. Others are strange aberrations of nature like the stinking, trash-eating Otyugh. A word of caution, then, to those brave adventurers whose first foray into danger leads them into these dank and shadowy places; bad things live in the dark. Bad things with sharp teeth.");
        Monster testMonster = new Monster("Ankheg",10, 3, "A hide like plate armor and great crushing mandibles are problematic. A stomach full of acid that can burn a hole through a stone wall makes them all the worse. They’d be bad enough if they were proper insect-sized, but these things have the gall to be as long as any given horse. It’s just not natural! Good thing they tend to stick to one place? Easy for you to say—you don’t have an ankheg living under your corn field.", "To undermine","Bite (d8+1)", "Close", "Burrowing");
        Move move1 = new Move("Undermine the ground");
        Move move2 = new Move("Burst from the earth");
        Move move3 = new Move("Spray forth acid, eating away at metal and flesh");
        Move move4 = new Move("4");
        Move move5 = new Move("5");
        Move move6 = new Move("6");
        Item shinyRock = new Item("Shiny Rock", 10, 2);
        Hireling jimmy = new Hireling("Jimmy","A retired soldier who is eager to help those who will pay him.", "Reasonable coin.", "Tristan");
        Move sentry = new Move("Sentry", "When a protector stands between you and an attack you increase your armor against that attack by the defender’s skill, then reduce their skill by 1 until they receive healing or have time to mend.");
        Move intervene = new Move("Intervene", "When a protector helps you defy danger you may opt to take +1 from their aid. If you do you cannot get a 10+ result, a 10+ instead counts as a 7–9.");
        Move manAtArms = new Move("Man-At-Arms", "When you deal damage while a warrior aids you add their skill to the damage done. If your attack results in consequences (like a counter attack) the man-at-arms takes the brunt of it.");
        DWTag reach = new DWTag("Reach", "It’s useful for attacking something that’s several feet away—maybe as far as ten.");
        DWTag near = new DWTag("Near", "It’s useful for attacking if you can see the whites of their eyes.");
        DWTag thrown = new DWTag("Thrown", "Throw it at someone to hurt them. If you volley with this weapon, you can’t choose to mark off ammo on a 7–9; once you throw it, it’s gone until you can recover it.");
        Item spear = new Item("Spear", 5, 1);
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


//        System.out.println(testMonster.toString()+"\n");
//
//        System.out.println(cavern.toString());
//        System.out.println(shinyRock.toString());
//        System.out.println(move1.toString());
//        System.out.println(move2.toString());
//        System.out.println(move3.toString()+"\n.\n.\n.");
//
//        System.out.println(spear.toString()+"\n");
//
//        System.out.println(reach.toString());
//        System.out.println(thrown.toString());
//        System.out.println(near.toString()+"\n.\n.\n.");
//
//        System.out.println(jimmy.toString()+"\n");
//
//        System.out.println(sentry.toString());
//        System.out.println(intervene.toString());
//        System.out.println(manAtArms.toString());

        TestHarness testHarness = new TestHarness();

        ArrayList<Printable> printableObjects = new ArrayList<>();

        printableObjects.add(jimmy);
        printableObjects.add(testMonster);

        for(Printable p : printableObjects){
            p.printSetup();
            p.print();
        }



    }

}
