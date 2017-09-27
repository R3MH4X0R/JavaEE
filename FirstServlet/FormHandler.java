package com.gmail.ditritusa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class FormHandler extends HttpServlet {
    private AtomicInteger count = new AtomicInteger(0);
    static final int questionOne_Yes = 0;
    static final int questionOne_Gaben = 1;
    static final int questionTwo_Java = 2;
    static final int questionTwo_1C = 3;


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final int[] results = new int[4];
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");

        String qOne = req.getParameter("question1");
        String qTwo = req.getParameter("question2");

        final int idx1 = "Yes".equals(qOne) ? questionOne_Yes : questionOne_Gaben;
        final int idx2 = "Java".equals(qTwo) ? questionTwo_Java : questionTwo_1C;

        count.getAndIncrement();

        results[idx1]++;
        results[idx2]++;

        PrintWriter pw = resp.getWriter();

        pw.println("<html><body></body></html>");
        pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        pw.println("<p><b>" + "Total respondents " + count + "</b></p>");
        pw.println(name + " " + surname + " " + age);
        pw.println("<p>Question 1: Yes = " + results[questionOne_Yes] + ", No = " + results[questionOne_Gaben] + "</p>");
        pw.println("<p>Question 2: Java = " + results[questionTwo_Java] + ", 1C = " + results[questionTwo_1C] + "</p>");


    }

}
