package fr.nymeria.servor.helpers;

import javafx.scene.control.Slider;

public class CustomSliderSkin extends javafx.scene.control.skin.SliderSkin {

    public CustomSliderSkin(Slider slider) {
        super(slider);

        slider.valueProperty().addListener((observable, oldValue, newValue) -> updateTrackBackground());
    }

    private void updateTrackBackground() {
        Slider slider = getSkinnable();
        double percent = (int) (100 *  (slider.getValue() - slider.getMin()) / (slider.getMax() - slider.getMin()));
        double trackWidth = percent * slider.getWidth();
        getSkinnable().lookup(".track").setStyle("-fx-background-color: linear-gradient(to right, #0066FF " + percent + "%, #363636 " + percent + "%);");
    }
}
