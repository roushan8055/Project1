package prime_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PrimeNumberServlet")
public class prime_number extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("number");

        // First filter: Check if input is a number
        try {
            int number = Integer.parseInt(input);

            // Second filter: Check if the number is greater than 0
            if (number <= 0) {
                out.println("<h3>Number must be greater than 0.</h3>");
            } else {
                out.println("<h3>Prime numbers up to " + number + ":</h3>");
                for (int i = 2; i <= number; i++) {
                    if (isPrime(i)) {
                        out.println(i + "<br>");
                    }
                }
            }
        } catch (NumberFormatException e) {
            out.println("<h3>Invalid input! Please enter a valid number.</h3>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}