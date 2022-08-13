module fr.nymeria.servor {
    requires javafx.controls;
    requires javafx.fxml;
	requires fontawesomefx;
	requires javafx.graphics;
	requires javafx.base;

    opens fr.nymeria.servor to javafx.fxml;
    exports fr.nymeria.servor;
}
