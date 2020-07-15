import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet("noSSEServlet")
public class noSSEServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
       int i = 0;
       while(i<10){
           out.println("data:"+i+"\n");
           out.flush();
           i++;
           try {
               TimeUnit.SECONDS.sleep(2);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        out.println();
    }
}
