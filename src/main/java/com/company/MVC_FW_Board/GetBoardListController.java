package com.company.MVC_FW_Board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class GetBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("전체 게시글 검색 처리됨");
		
		String searchField = ""; // 검색 대상(제목 또는 작성자)
		String searchText = ""; // 검색 텍스트 객체 레퍼런스 변수

		if (request.getParameter("searchCondition") != "" 
				&& request.getParameter("searchKeyword") != "") { // &&(and)

			searchField = request.getParameter("searchCondition");
			searchText = request.getParameter("searchKeyword");
		}
		// BoardDAO 클래스 객체 생성
	
		BoardDAO boardDAO = new BoardDAO();

		List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
		
	}
	

	
}
