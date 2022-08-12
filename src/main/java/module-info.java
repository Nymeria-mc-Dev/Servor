module fr.nymeria.servor {
    requires javafx.controls;
    requires javafx.fxml;
	requires fontawesomefx;

    opens fr.nymeria.servor to javafx.fxml;
    exports fr.nymeria.servor;
}
