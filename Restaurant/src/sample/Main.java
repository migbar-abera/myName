package sample;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.*;
import javafx.stage.*;
import java.io.IOException;
import javafx.scene.image.*;
import java.sql.*;
import javafx.event.*;


public class Main extends Application {

    homepage h = new homepage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        h.home(primaryStage);
    }

}

//==================================
        /*TableView PTable = new TableView();
        PTable.setEditable(false);
        PTable.setPrefSize(800,400);
        PTable.setLayoutY(50);;
        Label lblTableName = new Label("List Of Prisoners");
        lblTableName.setLayoutX (20);
        lblTableName.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR,30));
        Button btnAdd = new Button("Add Prisoner");
        btnAdd.setLayoutX(30);
        btnAdd.setLayoutY(500);
        btnAdd.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,14));

        Group tblGroup = new Group();
        tblGroup.getChildren().addAll(lblTableName,btnAdd);

        TableColumn colPrisonerID = new TableColumn<PrisonerTD,Integer>("Prisoner ID");
        colPrisonerID.setPrefWidth(80);
        colPrisonerID.setResizable(false);
        TableColumn colFirstName = new TableColumn<PrisonerTD,String>("FirstName");

        colFirstName.setPrefWidth(150);
        colFirstName.setResizable(false);
        TableColumn colLastName = new TableColumn<PrisonerTD,String>("LastName");
        colLastName.setPrefWidth(150);
        colLastName.setResizable(false);
        TableColumn colCellNo = new TableColumn<PrisonerTD,Integer>("Cell Number");
        colCellNo.setPrefWidth(80);
        colCellNo.setResizable(false);
        PTable.getColumns().addAll(colPrisonerID,colFirstName,colLastName,colCellNo);
        Initialize();
        Scene TableScene = new Scene(tblGroup, 800,600);

        ((Group)TableScene.getRoot()).getChildren().add(PTable);
*/
//================================


