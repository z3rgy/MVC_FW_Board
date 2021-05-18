package com.company.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.company.MVC_FW_Board.DeleteBoardController;
import com.company.MVC_FW_Board.GetBoardController;
import com.company.MVC_FW_Board.GetBoardListController;
import com.company.MVC_FW_Board.InsertBoardController;
import com.company.MVC_FW_Board.UpdateBoardController;
import com.company.view.user.LoginController;
import com.company.view.user.LogoutController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	 
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
