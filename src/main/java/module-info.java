module fr.nymeria.servor {
    requires javafx.controls;
    requires javafx.fxml;
	requires fontawesomefx;
	requires javafx.graphics;
	requires javafx.base;
	requires java.discord.rpc;

    opens fr.nymeria.servor to javafx.fxml;
    exports fr.nymeria.servor;
}
