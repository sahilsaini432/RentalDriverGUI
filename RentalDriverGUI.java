import javafx.application.Application ;
import javafx.stage.Stage ;
import javafx.scene.Scene ;
import javafx.scene.control.Label ;
import javafx.scene.control.TextField ;
import javafx.scene.control.Button ;
import javafx.scene.text.Text ;
import javafx.scene.layout.FlowPane ;
import javafx.geometry.Pos ;
import javafx.event.ActionEvent ;
import java.text.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class RentalDriverGUI extends Application {
  private TextField capacity ;
  private Button economyRentalContarct ;
  private Button businessRenatlContarct ;
  private Text textone ;
  private Text texttwo ;
  private Text textthree ;
  NumberFormat formater = NumberFormat.getCurrencyInstance() ;
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Vehicle Renatl Contarct Generator") ;
    Label fieldLable = new Label("Enter the capacity of the vehicle required :") ;
    capacity = new TextField() ;
    capacity.setPrefWidth(50) ;
    capacity.setOnAction(this::processButtonPress) ;
    economyRentalContarct  = new Button("Economy Rental") ;
    economyRentalContarct.setOnAction(this::processButtonPress) ;
    businessRenatlContarct = new Button("Business Rental") ;
    businessRenatlContarct.setOnAction(this::processButtonPress) ;
    textone = new Text("");
    texttwo = new Text("");
    textthree = new Text("");
    HBox horizontalbox1 = new HBox(fieldLable,capacity);
    horizontalbox1.setPadding(new Insets(10)) ;
    horizontalbox1.setSpacing(10) ;
    HBox horizontalbox2 = new HBox(economyRentalContarct,businessRenatlContarct) ;
    horizontalbox2.setSpacing(10) ;
    horizontalbox2.setPadding(new Insets(10)) ;
    horizontalbox2.setAlignment(Pos.CENTER) ;
    VBox verticalbox1 = new VBox(horizontalbox1,horizontalbox2);
    VBox verticalbox2 = new VBox(textone,texttwo,textthree);
    verticalbox2.setPadding(new Insets(10));
    verticalbox2.setAlignment(Pos.CENTER);
    VBox verticalbox3 = new VBox(verticalbox1,verticalbox2);
    FlowPane pane = new FlowPane(verticalbox3) ;
    pane.setAlignment(Pos.CENTER) ;
    pane.setHgap(10) ;
    pane.setVgap(10) ;
    Scene scene = new Scene(pane,600,450) ;
    primaryStage.setScene(scene) ;
    primaryStage.show() ;
  }
  public void processButtonPress(ActionEvent event) {
    int capacityIn = Integer.parseInt(capacity.getText());
    if(capacityIn<=0){
      textone.setText("Invalid input . Please enter a capacity above 0") ;
      texttwo.setText("");
      textthree.setText("");
    }
    if(event.getSource()==economyRentalContarct){
      if(capacityIn>0) {
        double baseCost = 50 ;
        double insBaseCost = 6 ;
        double rentalCost = 0;
        if(capacityIn>7) {
          rentalCost = baseCost + 5*capacityIn ;
        }
        else if((capacityIn>=5)&&(capacityIn<=7)) {
          rentalCost = baseCost + 3.50*capacityIn ;
        }
        else if(capacityIn<4) {
          rentalCost = baseCost + 2*capacityIn ;
        }
        textone.setText("Economy Rate: " + formater.format(rentalCost)) ;
        double insuranceCost = insBaseCost + 3.50*capacityIn ;
        texttwo.setText("Insurance Cost: " + formater.format(insuranceCost)) ;
        textthree.setText("Toatal Cost: " + formater.format(rentalCost+insuranceCost)) ;
      }
      else {
        textone.setText("Invalid input . Please enter a capacity above 0") ;
        texttwo.setText("");
        textthree.setText("");
      }
    }
   if(event.getSource()==businessRenatlContarct) {
     double baseCost = 47 ;
     if(capacityIn>7) {
       baseCost = baseCost + capacityIn*5.50 ;
     }
     if(capacityIn>0) {
       textone.setText("Business Rate: " + formater.format(baseCost)) ;
       texttwo.setText("Reward Points: " + ((int)(150*baseCost)))  ;
       textthree.setText("") ;
     }
     else if(capacityIn<0) {
       textone.setText("Invalid input . Please enter a capacity above 0") ;
       texttwo.setText("");
       textthree.setText("");
     }
   }
  }
}
