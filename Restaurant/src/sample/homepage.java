package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import javax.swing.*;
import java.sql.*;

public class homepage {
    PreparedStatement pst;
    Connection co;
    Statement st;
    ResultSet rs;

    public void home(Stage primaryStage){

//Login page
        Label title1 = new Label("Restaurant Finance Management System");
        title1.setId("title");
        title1.setAlignment(Pos.CENTER);
        title1.setFont(Font.font("Serif",FontWeight.BOLD,50));
        title1.setPadding(new Insets(50,50,0,100));
        Label label1 = new Label("Username or email:");
        label1.setId("lb");
        TextField textfield1 = new TextField();
        textfield1.setPrefSize(300,30);
        Label label2 = new Label("Password:");
        label2.setId("lb");
        PasswordField pass = new PasswordField();
        pass.setPrefSize(300,30);

        Alert alert = new Alert(Alert.AlertType.ERROR);
        Button btnlogin = new Button("_Log-in");
        btnlogin.setMnemonicParsing(true);
        btnlogin.getStyleClass().add("button");

        btnlogin.setMaxSize(150,100);
        Hyperlink link = new Hyperlink("Forgot password?");
        link.setId("link");
        link.setOnAction(e ->
                System.out.println("this link is clicked"));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        gridPane.setPadding(new Insets(100, 100, 100, 100));
        gridPane.add(label1, 0, 0);
        gridPane.add(textfield1, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(pass, 1, 1);
        gridPane.add(btnlogin, 2, 2);
        gridPane.add(link, 1, 2);
        gridPane.setAlignment(Pos.CENTER);

        HBox hbox2=new HBox();
        hbox2.getChildren().add(title1);
        hbox2.setAlignment(Pos.CENTER);
        BorderPane vb=new BorderPane();
        vb.setId("vb");
        vb.setCenter(gridPane);
        vb.setTop(hbox2);

        Scene scene3 = new Scene(vb, 1100, 600);
        scene3.getStylesheets().add("sample/style.css");

//TableView and Database
        Button dbBackBtn = new Button("Back");

        Label lb = new Label("Food Id");
        //lb.setId("lb");
        TextField txf = new TextField();
        txf.setPrefSize(300, 30);

        Label lb2 = new Label("Food Name");
        //lb2.setId("lb");
        TextField txf2 = new TextField();
        txf2.setPrefSize(300, 30);

        Label lb3 = new Label("Quantity");
        //lb2.setId("lb");
        TextField txf3 = new TextField();
        txf2.setPrefSize(300, 30);

        Button btn2 = new Button("Save");
        btn2.setOnAction(e -> {

                    try {
                        //  Class.forName("com.mysql.jdbc.Driver");
                        co = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "0924073830");
                        String query = "insert into food(food_id,food_name,quantity) values(?,?,?)";
                        pst = co.prepareStatement(query);
                        pst.setString(1, txf.getText());
                        pst.setString(2, txf2.getText());
                        pst.setString(3, txf3.getText());
                        pst.execute();
                        pst.close();

                    } catch (Exception h) {

                    }
                }
        );

        TableView<user> table = new TableView<>();
        table.setEditable(true);

        TableColumn Id = new TableColumn("ID");
        Id.setCellFactory(new PropertyValueFactory<>("ID"));
        TableColumn food_name = new TableColumn("FOOD NAME");
        food_name.setCellFactory(new PropertyValueFactory<>("FOOD NAME"));
        TableColumn quantity = new TableColumn("QUANTITY");
        quantity.setCellFactory(new PropertyValueFactory<>("QUANTITY"));
        table.getColumns().addAll(Id, food_name, quantity);

        ObservableList<user> data = FXCollections.observableArrayList();
        Button view = new Button("View Data");
        view.setOnAction(e -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                co = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "0923");
                String query2 = "select * from food";
                pst = co.prepareStatement(query2);
                rs = pst.executeQuery();
                while (rs.next()) {
                    data.add(new user(
                            rs.getString("ID"),
                            rs.getString("FOOD NAME"),
                            rs.getString("QUANTITY")
                    ));

                    //data.add(new user(
                    //rs.
                    // ))
                    table.setItems(data);
                }
                pst.close();
                rs.close();

            } catch (Exception y) {
            }
        });


        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(7);
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(5.5, 5.5, 5.5, 5.5));
        gp.add(lb, 0, 0);
        gp.add(txf, 1, 0);
        gp.add(lb2, 0, 1);
        gp.add(txf2, 1, 1);
        gp.add(lb3, 0, 2);
        gp.add(txf3, 1, 2);
        gp.add(btn2, 2, 3);
        gp.add(view, 3, 3);
        gp.add(dbBackBtn,2,4);

        StackPane st = new StackPane();
        st.getChildren().add(table);
        SubScene sn2 = new SubScene(st, 500, 400);
        SubScene sn = new SubScene(gp, 600, 400);

        HBox hb = new HBox();
        hb.getChildren().addAll(sn, sn2);
        Scene tableScene = new Scene(hb, 1100, 400);
        tableScene.getStylesheets().add("sample/style.css");
        primaryStage.setScene(tableScene);

        //========================================================================
        Button food=new Button("Foods");
        Button drink=new Button("Drinks");
        Button dessert=new Button("Desserts");

        food.setId("food");
        drink.setId("drink");
        dessert.setId("dessert");

        food.setFont(Font.font("Serif", FontWeight.BOLD,40));
        drink.setFont(Font.font("Serif", FontWeight.BOLD,40));
        dessert.setFont(Font.font("Serif", FontWeight.BOLD,40));

        food.setMinSize(250,250);
        drink.setMinSize(250,250);
        dessert.setMinSize(250,250);

        Button food2=new Button("Breakfast");
        Button drink2=new Button("Lunch");
        Button dessert2=new Button("Dinner");

        food.setId("food");
        drink.setId("drink");
        dessert.setId("dessert");

        food2.setFont(Font.font("Serif", FontWeight.BOLD,30));
        drink2.setFont(Font.font("Serif", FontWeight.BOLD,30));
        dessert2.setFont(Font.font("Serif", FontWeight.BOLD,30));

        food.setId("food2");
        drink.setId("drink2");
        dessert.setId("dessert2");

        food2.setMinSize(250,250);
        drink2.setMinSize(250,250);
        dessert2.setMinSize(250,250);

       /* Button food3=new Button("Foods");
        Button drink4=new Button("Drinks");
        Button dessert5=new Button("Desserts");

        food.setId("food");
        drink.setId("drink");
        dessert.setId("dessert");

        food.setFont(Font.font("Serif", FontWeight.BOLD,40));
        drink.setFont(Font.font("Serif", FontWeight.BOLD,40));
        dessert.setFont(Font.font("Serif", FontWeight.BOLD,40));

        food.setMinSize(250,250);
        drink.setMinSize(250,250);
        dessert.setMinSize(250,250);
*/
        Label title = new Label("Restaurant Finance Management System");
        title.setId("title");
        title.setAlignment(Pos.CENTER);
        title.setFont(Font.font("Serif",FontWeight.BOLD,50));
        title.setPadding(new Insets(50,50,0,100));


        HBox hbox = new HBox();
        hbox.setSpacing(200);
        hbox.setPadding(new Insets(20,50,0,50));

        Label title2 = new Label("Foods");
        title2.setId("title");
        title2.setAlignment(Pos.CENTER);
        title2.setFont(Font.font("Serif", FontWeight.BOLD,50));
        // title2.setPadding(new Insets(50,50,0,150));

        Button back= new Button("Back");
        back.setStyle("-fx-background-color: #90127190");
        Button dbTbl = new Button("Database");
        hbox.getChildren().addAll(back,title2,dbTbl);

        HBox choices = new HBox();
        choices.setPadding(new Insets(100,100,50,50));
        choices.setSpacing(50);
        choices.getChildren().addAll(food,drink,dessert);

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(100,100,50,50));
        hBox2.setSpacing(50);
        hBox2.getChildren().addAll(food2,drink2,dessert2);

        BorderPane root= new BorderPane();
        root.getStylesheets().add("sample/style.css");
        root.setId("pane");
        root.setTop(title);
        root.setLeft(choices);

        BorderPane root2= new BorderPane();
        root2.setId("pane");
        root2.setTop(hbox);
        root2.setLeft(hBox2);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("sample/style.css");
        Scene scene2= new Scene(root2);
        scene2.getStylesheets().add("sample/style.css");

        food.setOnAction(e->primaryStage.setScene(scene2));
        back.setOnAction(e->primaryStage.setScene(scene));
        dbTbl.setOnAction(e->primaryStage.setScene(tableScene));
        dbBackBtn.setOnAction(e->primaryStage.setScene(scene2));
        btnlogin.setOnAction(e->{
            String name=textfield1.getText();
            String password =String.valueOf(pass.getText());
            if (textfield1.getText().isEmpty()&&pass.getText().isEmpty()) {
                alert.setHeaderText("Input not valid");
                alert.setContentText("Incorrect Email or Password ");
                alert.showAndWait();
            }
            else if(name.equals("admin") && password.equals("123456"))
            { primaryStage.setScene(scene);

            }
            else{
                alert.setHeaderText("Input not valid");
                alert.setContentText("Incorrect Email or Password ");
                alert.showAndWait();
            }
        });

        primaryStage.setTitle("Restaurant Finance Management System");
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(700);
        primaryStage.setMinWidth(800);
        primaryStage.setScene(scene3);
        primaryStage.show();

        }
}