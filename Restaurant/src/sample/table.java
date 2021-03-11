/*package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {
    PreparedStatement pst;
    Connection co;
    Statement st;
    ResultSet rs;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label lb = new Label("Food Id");
        lb.setId("lb");
        TextField txf = new TextField();
        txf.setPrefSize(300, 30);

        Label lb2 = new Label("Food Name");
        lb2.setId("lb");
        TextField txf2 = new TextField();
        txf2.setPrefSize(300, 30);

        Label lb3 = new Label("Quantity");
        lb2.setId("lb");
        TextField txf3 = new TextField();
        txf2.setPrefSize(300, 30);

        Button btn2 = new Button("Save");
        btn2.setOnAction(e -> {

                    try {
                        //  Class.forName("com.mysql.jdbc.Driver");
                        co = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "0924073830");
                        String query= "insert into food(food_id,food_name,quantity) values(?,?,?)";
                        pst = co.prepareStatement(query);
                        pst.setString(1,txf.getText());
                        pst.setString(2,txf2.getText());
                        pst.setString(3,txf3.getText());
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
        table.getColumns().addAll(Id,food_name, quantity);

        ObservableList<user> data= FXCollections.observableArrayList();
        Button view = new Button("View Data");
        view.setOnAction(e->{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                co = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "0924073830");
                String query2= "select * from food";
                pst=co.prepareStatement(query2);
                rs=pst.executeQuery();
                while(rs.next()) {
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

            }catch (Exception y){
            }
        });

        StackPane st = new StackPane();
        st.getChildren().add(table);
        SubScene sn2 = new SubScene(st, 500, 400);
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(5);
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

        SubScene sn = new SubScene(gp, 500, 300);
        HBox hb = new HBox();
        hb.getChildren().addAll(sn, sn2);
        Scene main = new Scene(hb, 900, 400);
        primaryStage.setTitle("Restaurant Finance Management System");
        primaryStage.setScene(main);
        primaryStage.show();
    }

}

*/