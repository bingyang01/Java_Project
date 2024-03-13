package src.main.java;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;
//application是抽象类，需要重写start 方法
public class Main extends Application{
    public static void main(String[] args){
//    启动javafx的标准方式，
//    launch - Application类的静态方法，会自动调用init->start方法
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Main 页面
        Label label = new Label("Lust of Lustrous");
        Button buttonNewGame = new Button("Play");
        Button buttonExit = new Button("Exit");
//        label style
        label.setLayoutX(200);
        label.setLayoutY(100);
        label.setStyle("-fx-border-color: black");
        label.setPrefWidth(100);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
//        button style
        buttonNewGame.setLayoutX(225);
        buttonNewGame.setLayoutY(200);
        buttonExit.setLayoutX(225);
        buttonExit.setLayoutY(250);
//设置scene，将button全部加入home page
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(label,buttonNewGame,buttonExit);
        Scene HomePage = new Scene(root,500,500);

        // level page
        Button buttonBackHome = new Button("Home");
        AnchorPane levelRoot = new AnchorPane();
        levelRoot.getChildren().addAll(buttonBackHome);
        Scene levelPage = new Scene(levelRoot,500,500);

        //绑定各种事件
//        homepage
        buttonNewGame.setOnAction(e -> {
            primaryStage.setScene(levelPage);
        });

        buttonExit.setOnAction(e -> {
            Platform.exit();
        });
//        level page
        buttonBackHome.setOnAction(event -> {
            primaryStage.setScene(HomePage);
        });

//      处理退出状态
        Platform.setImplicitExit(false);//关闭OS默认退出的动作
        primaryStage.setOnCloseRequest(event->{
            event.consume();//这行代码让点关闭按钮无反应
            Alert alert  = new Alert(Alert.AlertType.CONFIRMATION);//建立一个提醒
            alert.setTitle("Exit the Game");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to exit the Game？");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                Platform.exit();//关闭程序，调用
                //primartStage.close()->关闭窗口，但是程序没关
            }

        });
        primaryStage.setScene(HomePage);
        primaryStage.setTitle("Game Demo");
        primaryStage.getIcons().add(new Image("src/main/resources/gem.png"));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}