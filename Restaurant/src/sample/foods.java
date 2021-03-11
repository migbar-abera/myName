/*package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class foods {
    Scene scene2;
    public void food(Stage primaryStage){

        Button food2=new Button("Breakfast");
        Button drink2=new Button("Lunch");
        Button dessert2=new Button("Dinner");

        food2.setFont(Font.font("Serif", FontWeight.BOLD,30));
        drink2.setFont(Font.font("Serif", FontWeight.BOLD,30));
        dessert2.setFont(Font.font("Serif", FontWeight.BOLD,30));

        food2.setMinSize(250,50);
        drink2.setMinSize(250,50);
        dessert2.setMinSize(250,50);

        Label title2 = new Label("Foods");
        title2.setAlignment(Pos.CENTER);
        title2.setFont(Font.font("Serif", FontWeight.BOLD,50));

        // title2.setPadding(new Insets(50,50,0,150));
        Button back= new Button("Back");
        back.setStyle("-fx-background-color: #90127190");

        HBox hbox = new HBox();
        hbox.setSpacing(200);
        hbox.setPadding(new Insets(20,50,0,50));
        hbox.getChildren().addAll(back,title2);
        hbox.getChildren().addAll(back,title2);


        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(100,100,50,50));
        vBox2.setSpacing(50);
        vBox2.getChildren().addAll(food2,drink2,dessert2);

        BorderPane root= new BorderPane();
        root.getStylesheets().add("sample/style.css");
        root.setId("pane");
        //root.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%,gold, black)");

        BorderPane root2= new BorderPane();
        root2.setStyle("-fx-background-color:gold");
        root2.setTop(hbox);
        root2.setLeft(vBox2);

        Scene scene = new Scene(root);
        scene2= new Scene(root2);
        //changing scenes
        back.setOnAction(e->primaryStage.setScene(scene));

    }
    public Scene foodScene(Scene scene){
        return scene;
    }
}
*/