import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ScoreBoard extends Application {
    // 定义一个名为ScoreBoard的类，它继承自JavaFX的Application类，表示这是一个JavaFX应用程序。

    @Override
    public void start(Stage primaryStage) {
        // 重写Application类的start方法，这是JavaFX应用程序的入口点。
        // primaryStage参数代表应用程序的主窗口。


        Button btn = new Button();
        btn.setText("NEXT LEVEL");
        btn.setBackground(new Background(new BackgroundFill(Color.web("#4CAF50"), null, null))); // 背景色
        btn.setTextFill(Color.WHITE); // 文字颜色
        btn.setPadding(new Insets(10, 20, 10, 20)); // 内边距
        btn.setFont(Font.font("Agency FB", FontWeight.BOLD,30)); // 字体和大小

        // 设置按钮点击时的动作
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // 这里是按钮点击时要执行的代码
                System.out.println("Button clicked! Moving to the next level.");
                // 在这里你可以添加其他的逻辑，比如跳转场景、改变界面状态等
            }
        });

        Text text = new Text();
        text.setText("SCORE BOARD");
        text.setFont(Font.font("Agency FB", FontWeight.BOLD,65));
        text.setFill(Color.DARKGREEN);

        Text text2 = new Text();
        text2.setText("Forests absorb over 2 billion tons of carbon dioxide yearly, playing a vital role in combating climate change.");
        text2.setFont(Font.font("Agency FB",30));
        text2.setFill(Color.DARKGREEN);
        text2.setWrappingWidth(400); // 设置文本的自动换行宽度

        VBox vbox = new VBox(10); // 10是VBox中子元素之间的间距
        vbox.setAlignment(Pos.TOP_CENTER); // 设置内容为顶部居中
        vbox.setPadding(new Insets(10)); // 设置内边距
        vbox.getChildren().add(text2);

        Text text_gem = new Text();
        text_gem.setText("GEM NUMBER - 12");
        text_gem.setFont(Font.font("Courier New", FontWeight.BOLD,40));
        text_gem.setFill(Color.DARKGREEN);

        Text text_carbon = new Text();
        text_carbon.setText("C-EMISSION - 78");
        text_carbon.setFont(Font.font("Courier New", FontWeight.BOLD,40));
        text_carbon.setFill(Color.DARKGREEN);

        Text text_time = new Text();
        text_time.setText("TIME  -  4'46\" ");
        text_time.setFont(Font.font("Courier New", FontWeight.BOLD,40));
        text_time.setFill(Color.DARKGREEN);

        Text text_totalscore = new Text();
        text_totalscore.setText("FINAL SCORE  -  82 ");
        text_totalscore.setFont(Font.font("Agency FB", FontWeight.BOLD,45));
        text_totalscore.setFill(Color.DARKGOLDENROD);
//        text_totalscore.setStroke(Color.DARKGOLDENROD);
//        text_totalscore.setStrokeWidth(1);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(600);
        rectangle.setHeight(200);
        rectangle.setFill(Color.WHITE);
        rectangle.setStrokeWidth(3);
        rectangle.setStroke(Color.DARKGREEN);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setWidth(600);
        rectangle2.setHeight(330);
        rectangle2.setFill(Color.WHITE);
        rectangle2.setStrokeWidth(3);
        rectangle2.setStroke(Color.DARKGREEN);

        Line line = new Line();
        line.setStartX(50);
        line.setStartY(0);
        line.setEndX(650);
        line.setEndY(0);
        line.setStroke(Color.DARKGREEN);
        line.setStrokeWidth(3);
        line.getStrokeDashArray();

        Image image = new Image("src/tree.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(image.getWidth() / 4);
        imageView.setFitHeight(image.getHeight() / 4);

        Image image_gem = new Image("src/gem.png");
        ImageView imageView_gem = new ImageView(image_gem);
        imageView_gem.setFitWidth(image.getWidth() / 15);
        imageView_gem.setFitHeight(image.getHeight() / 18);

        Image image_carbon = new Image("src/carbon3.png");
        ImageView imageView_carbon = new ImageView(image_carbon);
        imageView_carbon.setFitWidth(image.getWidth() / 14);
        imageView_carbon.setFitHeight(image.getHeight() / 17);

        Image image_time = new Image("src/time2.png");
        ImageView imageView_time = new ImageView(image_time);
        imageView_time.setFitWidth(image.getWidth() / 17);
        imageView_time.setFitHeight(image.getHeight() / 17);

        StackPane root = new StackPane();
        // 创建一个新的堆叠面板对象，并赋值给变量root，作为布局的根节点。

        root.setStyle("-fx-background-color:rgb(243,243,243);");

        root.getChildren().addAll(btn,text,rectangle,imageView,rectangle2,vbox,line,
                imageView_gem,imageView_carbon,imageView_time,
                text_gem,text_carbon,text_time,text_totalscore);

        StackPane.setMargin(text, new Insets(-700, 0, 0, 0));
        StackPane.setMargin(btn, new Insets(0, 0, -700, 0));
        StackPane.setMargin(rectangle, new Insets(350, 0, 0, 0));
        StackPane.setMargin(imageView, new Insets(360, 400, 20, 0));
        StackPane.setMargin(vbox, new Insets(530, 100, 0, 290));
        StackPane.setMargin(rectangle2, new Insets(-220, 0, 20, 0));

        StackPane.setMargin(imageView_gem, new Insets(-450, 400, 20, 0));
        StackPane.setMargin(text_gem, new Insets(-450, -100, 20, 0));
        StackPane.setMargin(imageView_carbon, new Insets(-300, 400, 20, 0));
        StackPane.setMargin(text_carbon, new Insets(-300, -100, 20, 0));
        StackPane.setMargin(imageView_time, new Insets(-150, 400, 20, 0));
        StackPane.setMargin(text_time, new Insets(-150, -100, 20, 0));

        StackPane.setMargin(text_totalscore, new Insets(10, 0, 0, 0));
        StackPane.setMargin(line, new Insets(-70, 0, 0, 0));

        Scene scene = new Scene(root, 1000, 850);

        primaryStage.setTitle("LAND OF LUSTROUS");
        primaryStage.setScene(scene);
        // 将创建的场景scene设置为主窗口的内容。
        primaryStage.setResizable(false);

        primaryStage.show();
        // 显示主窗口，即显示整个JavaFX应用程序的图形界面。
    }

    public static void main(String[] args) {
        // 定义JavaFX应用程序的入口点，当运行程序时，会首先执行这个方法。
        // args参数包含命令行参数，但在本例中并未使用。

        launch(args);
        // 调用JavaFX的静态方法launch，该方法负责创建应用程序实例，设置图形界面环境，
        // 并调用start方法开始应用程序的执行。
    }

}
