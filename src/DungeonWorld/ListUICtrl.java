package DungeonWorld;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class ListUICtrl extends UICtrl{
    private ConfirmationUI confirmationUI;
    private JDialog confirmationDialog;
    private MoveEditor moveEditor;
    private ArrayList<Move> moves;
    private ItemEditor itemEditor;
    private ArrayList<Item> items;
    private TagEditor tagEditor;
    private ArrayList<DWTag> tags;
    private String type;
    private int position;
    private ListUICtrl(){

    }



    public static ListUICtrl forMoves(ArrayList<Move> moves){
        ListUICtrl ctrl = new ListUICtrl();
        ctrl.moveEditor = new MoveEditor(ctrl);
        ctrl.setMoves(moves);
        ctrl.type = "Moves";
        ctrl.setPosition(0);
        ctrl.getMoveEditor().getPreviousButton().setEnabled(false);
        return ctrl;
    }

    public static ListUICtrl forItems(ArrayList<Item> items){
        ListUICtrl ctrl = new ListUICtrl();
        ctrl.itemEditor = new ItemEditor(ctrl);
        ctrl.setItems(items);
        ctrl.type = "Items";
        ctrl.setPosition(0);
        //ctrl.getItemEditor().getPreviousButton().setEnabled(false);
        return ctrl;
    }

    public static ListUICtrl forTags(ArrayList<DWTag> tags){
        ListUICtrl ctrl = new ListUICtrl();
        ctrl.tagEditor = new TagEditor(ctrl);
        ctrl.setTags(tags);
        ctrl.type = "Tags";
        ctrl.setPosition(0);
        //ctrl.getTagEditor().getPreviousButton().setEnabled(false);
        return ctrl;
    }
    //Reset the shown values to the saved values
    public void ResetValues(boolean skipConfirmation){
        if(skipConfirmation){
            switch (type){
                case "Moves":
                    if(moves.isEmpty()){
                        moveEditor.getNameText().setText("");
                        moveEditor.getDescriptionText().setText("");
                    }else {
                        Move move = moves.get(position);
                        moveEditor.getNameText().setText(move.getName());
                        moveEditor.getDescriptionText().setText(move.getDescription());
                    }
                break;
                case "Items":
                    //TODO: add item functionality
                    break;
                case "Tags":
                    //TODO: add tag functionality
                    break;
                default:
                    System.out.println("Error: list type not valid");
                    break;
            }
        }else{
            confirmationDialog = new JDialog();
            confirmationDialog.setModal(true);
            confirmationUI = new ConfirmationUI(this, "Are you sure you want to reset the current data to the saved values?");
            confirmationDialog.setContentPane(confirmationUI.getcPanel());
            confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            confirmationDialog.setSize(600, 200);
            confirmationDialog.setLocationRelativeTo(null);

            confirmationUI.getYesButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (type){
                        case "Moves":
                            if(moves.isEmpty()){
                                moveEditor.getNameText().setText("");
                                moveEditor.getDescriptionText().setText("");
                            }else {
                                Move move = moves.get(position);
                                moveEditor.getNameText().setText(move.getName());
                                moveEditor.getDescriptionText().setText(move.getDescription());
                            }
                            break;
                        case "Items":
                            //TODO: add item functionality
                            break;
                        case "Tags":
                            //TODO: add tag functionality
                            break;
                        default:
                            System.out.println("Error: list type not valid");
                            break;
                    }
                    confirmationDialog.dispose();
                }
            });
            confirmationUI.getNoButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    confirmationDialog.dispose();
                }
            });
            confirmationDialog.setVisible(true);
        }
    }
    //Displays the previous move in the lists values
    public void PreviousValues(){
        setPosition(position-1);
        switch (type){
            case "Moves":
                if(position == moves.size()-1){
                    if(moves.size() == 1){
                        moveEditor.getNextButton().setEnabled(false);
                        moveEditor.getPreviousButton().setEnabled(false);
                    }else {
                        moveEditor.getNextButton().setEnabled(false);
                        moveEditor.getPreviousButton().setEnabled(true);
                    }
                }else{
                    if(position == 0){
                        moveEditor.getNextButton().setEnabled(true);
                        moveEditor.getPreviousButton().setEnabled(false);
                    } else {
                        moveEditor.getNextButton().setEnabled(true);
                        moveEditor.getPreviousButton().setEnabled(true);
                    }
            }
                break;
            case "Items":
                //TODO: add item functionality
                break;
            case "Tags":
                //TODO: add tag functionality
                break;
            default:
                System.out.println("Error: list type not valid");
                break;

        }

        ResetValues(true);
    }
    //Displays the next moves in the lists values
    public void NextValues(){
        setPosition(position+1);
        switch (type){
            case "Moves":
                if(position == moves.size()-1){
                    moveEditor.getNextButton().setEnabled(false);
                    moveEditor.getPreviousButton().setEnabled(true);
                }else{
                    if(position == 0){
                        moveEditor.getNextButton().setEnabled(true);
                        moveEditor.getPreviousButton().setEnabled(false);
                    } else {
                        moveEditor.getPreviousButton().setEnabled(true);
                        moveEditor.getNextButton().setEnabled(true);
                    }
                }
                break;
            case "Items":
                //TODO: add item functionality
                break;
            case "Tags":
                //TODO: add tag functionality
                break;
            default:
                System.out.println("Error: list type not valid");
                break;

        }
        ResetValues(true);
    }
    //TODO: Remove current object from the list
    public void DeleteValues(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to permanently delete and remove this from the list?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (type){
                    case "Moves":
                        switch (moves.size()){
                            case 0:
                                moveEditor.getNextButton().setEnabled(false);
                                moveEditor.getPreviousButton().setEnabled(false);
                                break;
                            case 1:
                                moves.remove(getPosition());
                                moveEditor.getNextButton().setEnabled(false);
                                moveEditor.getPreviousButton().setEnabled(false);
                                break;
                            default:
                                moves.remove(getPosition());
                                moveEditor.getNextButton().setEnabled(true);
                                moveEditor.getPreviousButton().setEnabled(false);
                                break;
                        }
                        setPosition(0);
                        ResetValues(true);
                        break;
                    case "Items":
                        //TODO: add item functionality
                        break;
                    case "Tags":
                        //TODO: add tag functionality
                        break;
                    default:
                        System.out.println("Error: list type not valid");
                        break;
                }
                confirmationDialog.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationDialog.dispose();
            }
        });
        confirmationDialog.setVisible(true);
    }
    //Save values of the current object
    public void SaveValues(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to save the current data and overwrite the saved values?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (type){
                    case "Moves":
                        if(moves.isEmpty()) {
                            Move move = new Move();
                            move.setName(moveEditor.getNameText().getText());
                            move.setDescription(moveEditor.getDescriptionText().getText());
                            moves.add(move);
                            setPosition(0);
                            ResetValues(true);
                        }else{
                            Move move = moves.get(position);
                            move.setName(moveEditor.getNameText().getText());
                            move.setDescription(moveEditor.getDescriptionText().getText());
                        }
                        break;
                    case "Items":
                        //TODO: add item functionality
                        break;
                    case "Tags":
                        //TODO: add tag functionality
                        break;
                    default:
                        System.out.println("Error: list type not valid");
                        break;
                }
                confirmationDialog.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationDialog.dispose();
            }
        });
        confirmationDialog.setVisible(true);
    }
    //Clears and empties the fields
    public void ClearValues(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to clear the current data?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (type){
                    case "Moves":
                        moveEditor.getNameText().setText("");
                        moveEditor.getDescriptionText().setText("");
                        break;
                    case "Items":
                        //TODO: add item functionality
                        //itemEditor.getNameText().setText("");
                        //itemEditor.getDescriptionText().setText("");
                        break;
                    case "Tags":
                        //TODO: add tag functionality
                        //tagEditor.getNameText().setText("");
                        //tagEditor.getDescriptionText().setText("");
                        break;
                    default:
                        System.out.println("Error: list type not valid");
                        break;
                }
                confirmationDialog.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationDialog.dispose();
            }
        });
        confirmationDialog.setVisible(true);


    }
    //Add a new empty object to the list
    public void New(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure you want to add a new blank move?");
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);

        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (type){
                    case "Moves":
                        setPosition(moves.size());
                        moves.add(new Move("",""));
                        if(moves.size()<=1){
                            moveEditor.getNextButton().setEnabled(false);
                            moveEditor.getPreviousButton().setEnabled(false);
                        }else {
                            moveEditor.getNextButton().setEnabled(false);
                            moveEditor.getPreviousButton().setEnabled(true);
                        }
                        ResetValues(true);
                        break;
                    case "Items":
                        //TODO: add item functionality
                        //itemEditor.getNameText().setText("");
                        //itemEditor.getDescriptionText().setText("");
                        break;
                    case "Tags":
                        //TODO: add tag functionality
                        //tagEditor.getNameText().setText("");
                        //tagEditor.getDescriptionText().setText("");
                        break;
                    default:
                        System.out.println("Error: list type not valid");
                        break;
                }
                confirmationDialog.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationDialog.dispose();
            }
        });
        confirmationDialog.setVisible(true);
    }
    //Save list to main object and close list editor
    public ArrayList<Listable> SaveClose(){
        confirmationDialog = new JDialog();
        confirmationDialog.setModal(true);
        confirmationUI = new ConfirmationUI(this, "Are you sure?");
        switch (type){
            case "Moves":
                confirmationUI.getConfirmationMsgText().setText("Are you sure you want save the current list of moves and close?");
                break;
            case "Items":
                confirmationUI.getConfirmationMsgText().setText("Are you sure you want save the current list of items and close?");
                break;
            case "Tags":
                confirmationUI.getConfirmationMsgText().setText("Are you sure you want save the current list of tags and close?");
                break;
            default:
                System.out.println("Error: list type not valid");
                break;
        }
        confirmationDialog.setContentPane(confirmationUI.getcPanel());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        confirmationDialog.setSize(600, 200);
        confirmationDialog.setLocationRelativeTo(null);
        ArrayList<Listable> currentList = new ArrayList<Listable>();;
        confirmationUI.getYesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (type){
                    case "Moves":
                        for(Move m : moves){
                            currentList.add(m);
                        }
                        break;
                    case "Items":
                        for(Item i : items){
                            currentList.add(i);
                        }
                        break;
                    case "Tags":
                        for(DWTag t : tags){
                            currentList.add(t);
                        }
                        break;
                    default:
                        System.out.println("Error: list type not valid");
                        break;
                }
                confirmationDialog.dispose();
            }
        });
        confirmationUI.getNoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationDialog.dispose();
            }
        });
        confirmationDialog.setVisible(true);
        frame.dispose();
        return currentList;
    }

    public ConfirmationUI getConfirmationUI() {
        return confirmationUI;
    }

    public void setConfirmationUI(ConfirmationUI confirmationUI) {
        this.confirmationUI = confirmationUI;
    }

    public JDialog getConfirmationDialog() {
        return confirmationDialog;
    }

    public void setConfirmationDialog(JDialog confirmationDialog) {
        this.confirmationDialog = confirmationDialog;
    }

    public MoveEditor getMoveEditor() {
        return moveEditor;
    }

    public void setMoveEditor(MoveEditor moveEditor) {
        this.moveEditor = moveEditor;
    }

    public ItemEditor getItemEditor() {
        return itemEditor;
    }

    public void setItemEditor(ItemEditor itemEditor) {
        this.itemEditor = itemEditor;
    }

    public TagEditor getTagEditor() {
        return tagEditor;
    }

    public void setTagEditor(TagEditor tagEditor) {
        this.tagEditor = tagEditor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<DWTag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<DWTag> tags) {
        this.tags = tags;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
