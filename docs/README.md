# Project Title:  'Dungeon World GM Assistant'

* Student:  Tristan Crossman
* Instructor:  Ken Smith
* Class:  IST261 - App Development Studio I
* Semester:  Spring '26

Project Description:  A simple but useful program for managing notes, items, NPCs, hirelings, and monsters for the tabletop role playing game Dungeon World.

## Current Assignment Name:   'M04-A01: Implementing Inheritance and Interfaces'


## Assignment Accomplishments - (Description)

Provide what you did for this assignment and any classes you created.  Or describe directly to tell the grader what was created specifically by you and what to look for in your code to show that you met the assignment (rubric) requirements for it.  Mention classes, methods, specific files, etc.  Aka... make it easy for the grader to find and give you credit ... where credit is due!

### M04-A01: Implementing Inheritance and Interfaces
I already knew about inheritance from previous work, so I planned for it in my existing class architecture. My Character class serves as the parent for the Monster and Hireling class. 
I moved the old Main code into a new Main runnable test class called TestPrint. 
I worked on both the UI for Monster Editor and the Confirmation UI. Then made a basic UICtrl class to control the different UIs in the project. 
MonsterUICtrl is a child class of UICtrl and controls the UI for editing monsters.

### M03-A01: Writing Model Unit Tests
I manually wrote the tests for the Item class and the DWTag class. I then used JUnit to write the automatic test cases for the Move and Character Classes. I was unsure of how to get the TestHarness code to still run in Main if I moved it to the test folder, so I left it in the main directory for now.

### M02-A01: Identifying and Creating SW Model Classes
I created basic constructors, getters, setters, and toString for my classes I outlined in the NounVerbAnalysis.
I then created the first monster in the book ankheg and a dummy hireling with a spear item.
I made all the moves and tags required to represent these dummy characters.
I printed to the console the toStrings of all the various objects created for the demo.

## Running the Project

These are instructions on how to run the project once loaded into IntelliJ.


### Steps

Step-by-step instructions on how to run your application.

1.  Main class to run for this assignment:
   
    Main.java

2.  Any other specifics (if needed):
    
    Then run the Character Test and Move Test classes in the test folder.



