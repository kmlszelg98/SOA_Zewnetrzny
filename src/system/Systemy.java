package system;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;

/**
 * Created by Kamil on 12.06.2017.
 */

@WebService
public class Systemy {



    @WebMethod(operationName = "monitoring")
    @WebResult(name = "list")
    public String monitoruj() {
        String string="";
        ArrayList<Place> places = Monitoring.database.main();
        int[] licznik = new int[3];
        for(Place place:places){
            licznik[place.getStrefa()-1]++;
        }
        for (int i=0;i<3;i++){
            string+="W strefie "+(i+1)+" jest zajetych "+licznik[i]+" miejsc \n";
        }
        return string;
    }

}
