package rocket.app.view;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	@FXML
	private MainApp mainApp;
	private TextField txtIncome;
	private TextField txtExpenses;
	private TextField txtCreditScore;
	private TextField txtHouseCost;
	private ComboBox cmbterm;
	private Label Income;
	private Label Expenses;
	private Label CreditScore;
	private Label HouseCost;
	private Button Calculate;
	private Label MortgagePayment;
	private TextField txtNew;
	
	
	ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "30 years",
		        "15 years");
		final ComboBox box = new ComboBox(options);
		
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setExpenses(Integer.parseInt(txtExpenses.getText()));
		lq.setIncome(Integer.parseInt(txtIncome.getText()));
		lq.setiTerm(Integer.parseInt(cmbTerm.getAccessibleText()));
		lq.setdAmount(Integer.parseInt(txtHouseCost.getText())-Integer.parseInt(txtDownPayment.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		
		

		a.setLoanRequest(lq);		
		mainApp.messageSend(lq);
	}
	
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		MortgagePayment.setVisible(true);
		MortgagePayment.setText(Double.toString(Math.round(lRequest.getdPayment()*100)/100));
		
		
	}
}
