package GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class StartMenu extends Application {

    public void start(Stage primaryStage) {
        VBox vBox = new VBox();
        vBox.setPrefSize(1280,720);
        //vBox.getStylesheets().add("GUI/startMenu.css");

        Text title = new Text("Mota 魔塔");
        title.setId("title");
        Button start = new Button("Start");
        Button load = new Button("Load");
        Button exit = new Button("Exit ");

        vBox.getChildren().add(title);
        vBox.getChildren().add(start);
        vBox.getChildren().add(load);
        vBox.getChildren().add(exit);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("GUI/startMenu.css");

        primaryStage.setResizable(false);//窗口不能伸缩
        primaryStage.setTitle("Java魔塔");//设定窗口名称
        primaryStage.setScene(scene);
        primaryStage.show();

        //按钮事件绑定
        start.setOnAction(event -> {
            try { Game game = new Game(); game.showWindow(); primaryStage.close();} catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        exit.setOnAction(event -> primaryStage.close());
    }
}