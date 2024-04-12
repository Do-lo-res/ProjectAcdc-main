package Test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito;


    public class TestServletGame {

        @Test
        public void testAnswer1Reject() {
            TestServletGame servlet = new TestServletGame();
            MockHttpServletRequest request = new MockHttpServletRequest();
            MockHttpServletResponse response = new MockHttpServletResponse();

            request.setParameter("answer1", "Отклонить");
            servlet.doPost(request, response);

            assertEquals("Ты отклонил вызов. Поражение", request.getSession().getAttribute("result"));
        }

        @Test
        public void testAnswer2Decline() {
            TestServletGame servlet = new TestServletGame();
            MockHttpServletRequest request = new MockHttpServletRequest();
            MockHttpServletResponse response = new MockHttpServletResponse();

            request.setParameter("answer1", "Принять");
            request.setParameter("answer2", "Отказаться");
            servlet.doPost(request, response);

            assertEquals("Ты отказался от переговоров. Поражение", request.getSession().getAttribute("result"));
        }

        @Test
        public void testAnswer3Agree() {
            TestServletGame servlet = new TestServletGame();
            MockHttpServletRequest request = new MockHttpServletRequest();
            MockHttpServletResponse response = new MockHttpServletResponse();

            request.setParameter("answer1", "Принять");
            request.setParameter("answer2", "Подняться");
            request.setParameter("answer3", "Согласиться");
            servlet.doPost(request, response);

            assertEquals("Твою ложь разоблачили. Поражение", request.getSession().getAttribute("result"));
        }

        @Test
        public void testAnswer3TellTruth() {
            TestServletGame servlet = new TestServletGame();
            MockHttpServletRequest request = new MockHttpServletRequest();
            MockHttpServletResponse response = new MockHttpServletResponse();

            request.setParameter("answer1", "Принять");
            request.setParameter("answer2", "Подняться");
            request.setParameter("answer3", "Рассказать правду");
            servlet.doPost(request, response);

            assertEquals("Тебя вернули домой. Победа", request.getSession().getAttribute("result"));
        }
    }