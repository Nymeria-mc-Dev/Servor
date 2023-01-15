module fr.nymeria.servor {
    requires javafx.controls;
    requires javafx.fxml;
	requires fontawesomefx;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	requires java.discord.rpc;
	requires json.simple;

	opens fr.nymeria.servor to javafx.fxml;
    exports fr.nymeria.servor;
}
