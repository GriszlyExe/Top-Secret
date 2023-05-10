package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

//You might need to do something to the following line
public class ControlPane extends VBox{
	
	private Text drawnNumberText;
	private Text drawCountText;
	private Text bingoText;
	private Button drawButton;
	private Button newRoundButton;
	private NumberGrid numberGrid;

	
	public ControlPane(NumberGrid numberGrid) {
		// TODO
		this.numberGrid = numberGrid;
		setAlignment(Pos.CENTER);
		setPrefWidth(300);
		setSpacing(20);
		setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		drawnNumberText = new Text();
		drawnNumberText.setFont(Font.font(20));
		drawCountText = new Text();
		initializeBingoText();
		initializeDrawButton();
		initializeNewRoundButton();
		getChildren().addAll(drawnNumberText,drawButton,newRoundButton,bingoText,drawCountText);
//		BingoUtil.setTextsBeginning(drawnNumberText, drawCountText);
	}
	
	private void initializeBingoText() {
		// TODO
		bingoText = new Text("Bingo!!");
		bingoText.setFont(Font.font(40));
		bingoText.setVisible(false);	
		

	}

	private void initializeDrawButton() {
		// TODO
		drawButton = new Button("Draw a number");
		drawButton.setPrefWidth(100);
		drawButton.setOnAction(e->{
			drawButtonHandler();
		});

	}

	private void initializeNewRoundButton() {
		// TODO
		newRoundButton = new Button("New Round");
		newRoundButton.setPrefWidth(100);
		newRoundButton.setDisable(true);
		newRoundButton.setOnAction(e->{
			newRoundButtonHandler();
		});

	}
	
	private void drawButtonHandler() {
		// TODO
		int number = BingoUtil.drawNumber();
		
		numberGrid.highlightNumber(number);
		if (BingoUtil.isBingo(getNumberGrid())) {
			bingoText.setVisible(true);
			drawButton.setDisable(true);
			newRoundButton.setDisable(false);
		}
		BingoUtil.updateTextsAfterDrawn(number, drawnNumberText, drawCountText);
	}
	
	private void newRoundButtonHandler() {
		// TODO
		BingoUtil.assignRandomNumbers(numberGrid.getNumberSquares());
		bingoText.setVisible(false);
		drawButton.setDisable(false);
		newRoundButton.setDisable(true);
		BingoUtil.setTextsBeginning(drawnNumberText, drawCountText);
	}

	public Text getDrawnNumberText() {
		return drawnNumberText;
	}

	public Text getDrawCountText() {
		return drawCountText;
	}

	public Text getBingoText() {
		return bingoText;
	}

	public Button getDrawButton() {
		return drawButton;
	}

	public Button getNewRoundButton() {
		return newRoundButton;
	}

	public NumberGrid getNumberGrid() {
		return numberGrid;
	}

}
