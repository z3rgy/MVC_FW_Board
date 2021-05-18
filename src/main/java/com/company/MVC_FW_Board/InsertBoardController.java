package com.company.MVC_FW_Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class InsertBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("게시글 입력 처리됨");

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		BoardDO boardDO = new BoardDO();

		boardDO.setTitle(title);
		boardDO.setWriter(writer);
		boardDO.setContent(content);

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(boardDO);

	
		return "getBoardList.do";
	}

}
