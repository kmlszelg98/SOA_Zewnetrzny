package system;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Kamil on 11.06.2017.
 */
@WebServlet(urlPatterns = "/monitoring")
public class Monitoring extends HttpServlet {

    public static Database database = new Database();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setIntHeader("Refresh", 15);
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        ArrayList<Place> places = database.main();
        int[] licznik = new int[3];
        for(Place place:places){
           licznik[place.getStrefa()-1]++;
        }
        for (int i=0;i<3;i++){
            writer.print("W strefie "+(i+1)+" jest zajetych "+licznik[i]+" miejsc</br>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
