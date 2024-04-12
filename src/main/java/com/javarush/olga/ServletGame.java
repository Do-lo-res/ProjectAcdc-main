package com.javarush.olga;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/game")
public class ServletGame extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "Добро пожаловать на страницу start.jsp");
        request.getRequestDispatcher("start.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String answer1 = request.getParameter("answer1");
        switch (answer1) {
            case "Отклонить":
                session.setAttribute("result", "Ты отклонил вызов. Поражение");
                break;
            case "Принять":
                String answer2 = request.getParameter("answer2");

                switch (answer2) {
                    case "Отказаться":
                        session.setAttribute("result", "Ты отказался от переговоров. Поражение");
                        break;
                    case "Подняться":
                        String answer3 = request.getParameter("answer3");
                        switch (answer3) {
                            case "Согласиться":
                                session.setAttribute("result", "Твою ложь разоблачили. Поражение");
                                break;
                            case "Рассказать правду":
                                session.setAttribute("result", "Тебя вернули домой. Победа");
                                break;
                            default:
                                session.setAttribute("result", "Случилась фигня. Попробуй снова");
                                break;
                        }
                        break;
                    default:
                        session.setAttribute("result", "Случилась фигня. Попробуй снова");
                        break;
                }
                break;
            default:
                session.setAttribute("result", "Случилась фигня. Попробуй снова");
                break;
        }

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
