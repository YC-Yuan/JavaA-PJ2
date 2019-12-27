
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;

public class test extends Application{
    @Override
    public void start(Stage primaryStage) {
        StackPane pane=new StackPane();
        Circle circle=new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        Color mycolor=new Color(0.25,0.14,0.333,0.51);
        circle.setRadius(100);
        circle.setStroke(Color.RED);;
        circle.setFill(mycolor);

        Label label=new Label("显示系统可用字体");
        label.setFont(Font.font("造字工房丁丁（非商用）常规体",FontWeight.BOLD,FontPosture.ITALIC,50));
        pane.getChildren().add(circle);
        pane.getChildren().add(label);
        pane.setStyle("-fx-border-color:red;-fx-background-color:yellow");
        pane.setRotate(60);
        Scene scene=new Scene(pane,200,200);
        primaryStage.setTitle("Circle");
        primaryStage.setScene(scene);
        primaryStage.show();

        Font myfont=new Font(1);

        List<String> mylist=myfont.getFamilies();
        int i;
        for(i=0;i<mylist.size();i++) {
            System.out.println(mylist.get(i));
        }

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}