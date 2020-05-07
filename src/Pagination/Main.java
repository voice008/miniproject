package Pagination;

import javafx.application.Application;
import javafx.scene.control.Pagination;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.VBox;




public class Main {
	
	

	public static void main(String[] args) {
	
		
		Pagination pagination ;

		pagination = new Pagination(10);
		pagination.setStyle("-fx-border-color:blue");
		pagination.setPageFactory((Integer pageIndex) ->;
		
		
	}
	public VBox createPage(int pageIndex) 
	{
}
