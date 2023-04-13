package br.com.carsoft.servlet;

import br.com.carsoft.model.dao.Car;
import br.com.carsoft.model.dao.CarDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carName = request.getParameter("car-name");
        var car = new Car(carName);

        new CarDAO().createCar(car);

        response.sendRedirect("/find-all-cars");

    }

}