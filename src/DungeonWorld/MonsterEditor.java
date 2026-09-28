package DungeonWorld;

import javax.swing.*;
import java.awt.*;

public class MonsterEditor extends JFrame {
    private JPanel cPane;
    private JLabel titleText;
    private JTextField nameText;
    private JTextField weaponText;
    private JTextField rangeText;
    private JTextArea descriptionText;
    private JLabel rangeLabel;
    private JLabel armorLabel;
    private JLabel hpLabel;
    private JLabel weaponLabel;
    private JList moveList;
    private JButton resetButton;
    private JButton saveButton;
    private JButton clearButton;
    private JButton deleteButton;
    private JButton editMovesButton;
    private JTextField instinctText;
    private JTextField specialText;
    private JSpinner hpSpinner;
    private JSpinner armorSpinner;
    private JList itemList;
    private JList tagList;
    private JLabel movesLabel;
    private JButton editItemsButton;
    private JButton editTagsButton;

    private MonsterUICtrl monsterUICtrl;

    public MonsterEditor(MonsterUICtrl monsterUICtrl) {
        this.monsterUICtrl = monsterUICtrl;
    }

    //getter and setters

    public JPanel getcPane() {
        return cPane;
    }

    public void setContentPane(JPanel cPane) {
        this.cPane = cPane;
    }

    public JLabel getTitleText() {
        return titleText;
    }

    public void setTitleText(JLabel titleText) {
        this.titleText = titleText;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    public JTextField getWeaponText() {
        return weaponText;
    }

    public void setWeaponText(JTextField weaponText) {
        this.weaponText = weaponText;
    }

    public JTextField getRangeText() {
        return rangeText;
    }

    public void setRangeText(JTextField rangeText) {
        this.rangeText = rangeText;
    }

    public JTextArea getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(JTextArea descriptionText) {
        this.descriptionText = descriptionText;
    }

    public JLabel getRangeLabel() {
        return rangeLabel;
    }

    public void setRangeLabel(JLabel rangeLabel) {
        this.rangeLabel = rangeLabel;
    }

    public JLabel getArmorLabel() {
        return armorLabel;
    }

    public void setArmorLabel(JLabel armorLabel) {
        this.armorLabel = armorLabel;
    }

    public JLabel getHpLabel() {
        return hpLabel;
    }

    public void setHpLabel(JLabel hpLabel) {
        this.hpLabel = hpLabel;
    }

    public JLabel getWeaponLabel() {
        return weaponLabel;
    }

    public void setWeaponLabel(JLabel weaponLabel) {
        this.weaponLabel = weaponLabel;
    }

    public JList getMoveList() {
        return moveList;
    }

    public void setMoveList(JList moveList) {
        this.moveList = moveList;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getEditMovesButton() {
        return editMovesButton;
    }

    public void setEditMovesButton(JButton editMovesButton) {
        this.editMovesButton = editMovesButton;
    }

    public JTextField getInstinctText() {
        return instinctText;
    }

    public void setInstinctText(JTextField instinctText) {
        this.instinctText = instinctText;
    }

    public JTextField getSpecialText() {
        return specialText;
    }

    public void setSpecialText(JTextField specialText) {
        this.specialText = specialText;
    }

    public MonsterUICtrl getCharacterCtrl() {
        return monsterUICtrl;
    }

    public void setCharacterCtrl(MonsterUICtrl monsterUICtrl) {
        this.monsterUICtrl = monsterUICtrl;
    }

    public JSpinner getArmorSpinner() {
        return armorSpinner;
    }

    public void setArmorSpinner(JSpinner armorSpinner) {
        this.armorSpinner = armorSpinner;
    }

    public JSpinner getHpSpinner() {
        return hpSpinner;
    }

    public void setHpSpinner(JSpinner hpSpinner) {
        this.hpSpinner = hpSpinner;
    }

    public JList getItemList() {
        return itemList;
    }

    public void setItemList(JList itemList) {
        this.itemList = itemList;
    }

    public JList getTagList() {
        return tagList;
    }

    public void setTagList(JList tagList) {
        this.tagList = tagList;
    }

    public JLabel getMovesLabel() {
        return movesLabel;
    }

    public void setMovesLabel(JLabel movesLabel) {
        this.movesLabel = movesLabel;
    }

    public JButton getEditItemsButton() {
        return editItemsButton;
    }

    public void setEditItemsButton(JButton editItemsButton) {
        this.editItemsButton = editItemsButton;
    }

    public JButton getEditTagsButton() {
        return editTagsButton;
    }

    public void setEditTagsButton(JButton editTagsButton) {
        this.editTagsButton = editTagsButton;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        cPane = new JPanel();
        cPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(14, 5, new Insets(5, 10, 5, 10), -1, -1));
        cPane.setEnabled(true);
        nameText = new JTextField();
        cPane.add(nameText, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), new Dimension(1000, 1000), 0, false));
        rangeText = new JTextField();
        cPane.add(rangeText, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), new Dimension(1000, 1000), 0, false));
        titleText = new JLabel();
        titleText.setText("Monster Editor");
        cPane.add(titleText, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(1000, 1000), 0, false));
        weaponLabel = new JLabel();
        weaponLabel.setText("Weapon");
        cPane.add(weaponLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(1000, 1000), 0, false));
        hpLabel = new JLabel();
        hpLabel.setText("HP");
        cPane.add(hpLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(1000, 1000), 0, false));
        armorLabel = new JLabel();
        armorLabel.setText("Armor");
        cPane.add(armorLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(1000, 1000), 0, false));
        rangeLabel = new JLabel();
        rangeLabel.setText("Range");
        cPane.add(rangeLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(1000, 1000), 0, false));
        moveList = new JList();
        cPane.add(moveList, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 50), new Dimension(300, 100), new Dimension(1000, 1000), 0, false));
        resetButton = new JButton();
        resetButton.setText("Reset");
        cPane.add(resetButton, new com.intellij.uiDesigner.core.GridConstraints(13, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), new Dimension(1000, 1000), 0, false));
        saveButton = new JButton();
        saveButton.setText("Save");
        cPane.add(saveButton, new com.intellij.uiDesigner.core.GridConstraints(13, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), new Dimension(1000, 1000), 0, false));
        clearButton = new JButton();
        clearButton.setText("Clear");
        cPane.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(13, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), new Dimension(1000, 1000), 0, false));
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        cPane.add(deleteButton, new com.intellij.uiDesigner.core.GridConstraints(13, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), new Dimension(1000, 1000), 0, false));
        editMovesButton = new JButton();
        editMovesButton.setText("Edit Moves");
        cPane.add(editMovesButton, new com.intellij.uiDesigner.core.GridConstraints(8, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), new Dimension(1000, 1000), 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Instinct");
        cPane.add(label1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(1000, 1000), 0, false));
        instinctText = new JTextField();
        cPane.add(instinctText, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), new Dimension(1000, 1000), 0, false));
        specialText = new JTextField();
        cPane.add(specialText, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), new Dimension(1000, 1000), 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Special");
        cPane.add(label2, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(1000, 1000), 0, false));
        hpSpinner = new JSpinner();
        cPane.add(hpSpinner, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), new Dimension(1000, 1000), 0, false));
        armorSpinner = new JSpinner();
        cPane.add(armorSpinner, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), new Dimension(1000, 1000), 0, false));
        descriptionText = new JTextArea();
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        cPane.add(descriptionText, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(50, 50), new Dimension(300, 150), new Dimension(1000, 1000), 0, false));
        movesLabel = new JLabel();
        movesLabel.setText("Moves");
        cPane.add(movesLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(-1, 20), new Dimension(1000, 1000), 0, false));
        itemList = new JList();
        itemList.setLayoutOrientation(0);
        cPane.add(itemList, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 50), new Dimension(300, 50), new Dimension(1000, 1000), 0, false));
        tagList = new JList();
        tagList.setLayoutOrientation(2);
        cPane.add(tagList, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 50), new Dimension(300, 50), new Dimension(1000, 1000), 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Items");
        cPane.add(label3, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, null, new Dimension(1000, 1000), 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Tags");
        cPane.add(label4, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, null, new Dimension(1000, 1000), 0, false));
        editItemsButton = new JButton();
        editItemsButton.setText("Edit Items");
        cPane.add(editItemsButton, new com.intellij.uiDesigner.core.GridConstraints(10, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), new Dimension(1000, 1000), 0, false));
        editTagsButton = new JButton();
        editTagsButton.setText("Edit Tags");
        cPane.add(editTagsButton, new com.intellij.uiDesigner.core.GridConstraints(12, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 20), new Dimension(1000, 1000), 0, false));
        weaponText = new JTextField();
        cPane.add(weaponText, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, new Dimension(1000, 1000), 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Name");
        cPane.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, null, new Dimension(1000, 1000), 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return cPane;
    }

}
