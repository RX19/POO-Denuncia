module Trabajo {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.logging;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
