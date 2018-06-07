import java.io.IOException;
import java.io.PrintWriter;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class TestServlet extends HttpServlet {
	double[] kof={1.0, 0.001, 1000.0, 0.000006, 0.000984207, 0.00110231, 0.157473, 2.20462, 35.274};
	double[] length={1.0, 100, 1000, 0.001, 10, 0.000621371, 1.09361, 3.28084, 39.3701, 0.000539957};
	double[] t={1.0, 1000000000, 1000000, 1000, 0.0166667, 0.0002777783, 0.000011574097222};
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
 
        PrintWriter pw = resp.getWriter();
        
        Integer a = 0, b = 0,  i = 0;
        String c;
        double	d=0;
        Boolean Error = false;
        
        String param_a = req.getParameter("a");
        String param_b = req.getParameter("b");
        String param_d = req.getParameter("d");
        String param_i = req.getParameter("i");
        try {
            a = Integer.parseInt(param_a);
            b = Integer.parseInt(param_b);
            d = Double.parseDouble(param_d);
            i = Integer.parseInt(param_i);
        }
        catch (NumberFormatException e) {
            Error = true;
        }
            
        if (Error) {
			 pw.println("error");
		}
		else {
			if(i==1){
			  c =  String.valueOf((d/kof[a])*kof[b]);
			  pw.println(c);
			}
			if(i==2){
			  c =  String.valueOf((d/length[a])*length[b]);
			  pw.println(c);	
			}
			if(i==3){
				c=String.format( Locale.US, "%.0f", (d/t[a])*t[b]);
			  pw.println(c);	
			}       			
		}
 
    }
}