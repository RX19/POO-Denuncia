package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		//Abre la ventana MENU PRINCIPAL.
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("menuPrincipal.fxml"));
			Pane ventana = (Pane) loader.load();
			Scene scene = new Scene(ventana);
			primaryStage.setTitle("MENU PRINCIPAL");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.printf("--Inicio del programa--%n%n");
		launch(args);
	}
}