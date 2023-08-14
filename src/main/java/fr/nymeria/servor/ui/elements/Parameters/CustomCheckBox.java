package fr.nymeria.servor.ui.elements.Parameters;

import javafx.scene.layout.HBox;

public class CustomCheckBox {

    private boolean isSelected = false;
    private double width;
    private double height;
    private String color;

    private HBox checkedBox = new HBox();

    public CustomCheckBox(double width, double height, boolean selected, String color) {
        this.isSelected = selected;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public HBox createCheckBox() {
        HBox root = new HBox();
        root.setMinWidth(this.width);
        root.setMaxWidth(this.width);
        root.setMinHeight(this.height);
        root.setMaxHeight(this.height);
        root.setStyle("-fx-background-color: " + this.color + "; -fx-background-radius: 9px;");

        checkedBox.setTranslateY(5.0d);
        checkedBox.setTranslateX(5.0d);
        checkedBox.setMinWidth(this.width - 10);
        checkedBox.setMaxWidth(this.width - 10);
        checkedBox.setMinHeight(this.height - 10);
        checkedBox.setMaxHeight(this.height - 10);
        checkedBox.setStyle("-fx-background-color: #0066FF; -fx-background-radius: 6px;");
        checkedBox.setVisible(this.isSelected);

        root.getChildren().addAll(checkedBox);

        return root;
    }

    public void setChecked() {
        checkedBox.setVisible(true);
    }

    public void setUnchecked() {
        checkedBox.setVisible(false);
    }

    public void setIsSelected(boolean bool) {
        this.isSelected = bool;
    }
    public boolean isSelected() {
        return this.isSelected;
    }

}
