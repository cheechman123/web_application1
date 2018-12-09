package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    static Connection connection;
    static String userName = "root";
    static String password = "root";
    static String connectionURL = "jdbc:mysql://localhost:3306/users" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";


    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("a");

    }



}







/*



@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet implements SingleThreadModel{
    /*

    @Override
    public void init() throws ServletException {
        System.out.println("initialization");
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost");
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println(Thread.currentThread().getName());
        String s = "<html><head><title>PENIS</title></head>" +
                "<body>" +
                "HELLO WORLD, BITCH" +
                "</body></html>";
        response.getWriter().write(s);
}
    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    static int i = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        synchronized (this) {
            for (int j = 0; j < 1000000; j++) {
                i++;
            }
            System.out.println(i);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j<2; j++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        URLConnection urlConnection = new URL("http://localhost:8080/MyServlet").openConnection();
                        urlConnection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
        }
    }
}

///////////////////////////////////////////////////////////////////////////////////////////

doGet

String one = request.getParameter("one");
        String two = request.getParameter("two");
        String abc = request.getParameter("abc");
        System.out.println(one + " " + two + " " + abc);
        String[] ones = request.getParameterValues("one");
        for(String s:ones)
            System.out.println(s);
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String elementName = parameterNames.nextElement();
            System.out.println(elementName + " " + request.getParameter(elementName));
        }

        Map<String, String[]> map = request.getParameterMap();
        for(String s:map.get("one"))
            System.out.println(s);

        System.out.println("URL " + request.getRequestURL());
        System.out.println("URI " + request.getRequestURI());
        System.out.println("Servlet Path " + request.getServletPath());
        System.out.println("Remote host  " + request.getRemoteHost());
        System.out.println("Local Port  " + request.getLocalPort());
        System.out.println("Query string " + request.getQueryString());


/////////////////////////////////////////////////////////////////////////////////////////////////////////

protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s + " = " + request.getHeader(s));
        }
        System.out.println("getAuthType " + request.getAuthType());
        System.out.println("getContentLength " + request.getContentLength());
        System.out.println("getContentType " + request.getContentType());
        System.out.println("getMethod " + request.getMethod());
        System.out.println("getRequestURL " + request.getRequestURL());
        System.out.println("getQueryString " + request.getQueryString());
        System.out.println("getProtocol " + request.getProtocol());

        response.setHeader("/////////", "/////////");

    }



    //////////////////////////////////////////////////////////////////////////////////////////////

Сжатие веб-страниц

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(request.getHeader("accept-encoding").contains("gzip")){
            PrintWriter printWriter = new PrintWriter(new GZIPOutputStream(response.getOutputStream()));
            printWriter.write("hello world");
        }


    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("hello");
        //        response.setStatus(HttpServletResponse.SC_OK);
//        response.sendRedirect("/hello");

//        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "helloworld");
//        response.setHeader("Refresh", "5;URL=https://google.com");
        response.setHeader("Refresh", "2");

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    COOKIES

    Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
            System.out.println(cookie.getMaxAge());
        }


        Cookie cookie = new Cookie("name", "abc");
        cookie.setMaxAge(5);
        cookie.setPath("/MyServlet");//устанавливает страницу, на которой будут отображаться эти кукис (только на ней)
//        cookie.setDomain("/////////");//устанавливает домены, которые могут получить доступ к кукис
        response.addCookie(cookie);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

SESSIONS

HttpSession httpSession = request.getSession();
        Enumeration<String> attributeNames = httpSession.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String attribute = attributeNames.nextElement();
            System.out.println(attribute + " = " + httpSession.getAttribute(attribute));
        }
//        httpSession.setAttribute("one", "two");
//        httpSession.removeAttribute("one");//удаляет аттрибут
        httpSession.invalidate();//очищает сессию
        System.out.println(httpSession.isNew());//проверяет, есть ли уже такая сессия
        System.out.println(httpSession.getMaxInactiveInterval());//выводит время активности сессии


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

ASYNCCONTEXT

package servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/ASyncServlet", asyncSupported = true)
public class ASyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext asyncContext = req.getAsyncContext();
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                //some action
            }
        });//это нужно чтоб тут выполнялось какое-то действие, например, ожидание ответа, в отдельном потоке, чтоб это не мешало выполнению остальной части программы

        asyncContext.complete();
    }
}











///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////





ЭТО ЧАСТЬ КОДА, КОТОРУЮ НАДО ДОРАБОТАТЬ







try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try{
                connection = DriverManager.getConnection(connectionURL, userName, password);
                Statement statement = connection.createStatement();
                String name = request.getParameter("name");
                String secondname = request.getParameter("secondname");
                String sex = request.getParameter("sex");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                PreparedStatement preparedStatement = connection.prepareStatement("insert into clients (name, secondname, sex, email, country) values (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, secondname);
                preparedStatement.setString(3, sex);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, country);
                preparedStatement.execute();
                ResultSet resultSet = statement.executeQuery("select * from clients");
                while(resultSet.next()){
                    System.out.print(resultSet.getInt("id") + " ");
                    System.out.print(resultSet.getString("name") + " ");
                    System.out.print(resultSet.getString("secondname") + " ");
                    System.out.print(resultSet.getString("sex") + " ");
                    System.out.print(resultSet.getString("email") + " ");
                    System.out.println(resultSet.getString("country"));
                }



            } catch (SQLException e) {

                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


//        String two = request.getParameter("two");
//        one = one == null ? "" : one.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        response.getWriter().write("<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                "<div class='form-wrap'>" +
                "  <div class='profile'><img src='https://html5book.ru/wp-content/uploads/2016/10/profile-image.png'>" +

                "  </div>" +
                "  <form method='post' action='MyServlet'>" +
                "    <div>" +
                "      <label for='name'>Имя</label>" +
                "      <input type='text' name='name' required>" +
                "    </div>" +
                "<div>" +
                "      <label for='secondname'>Фамилия</label>" +
                "      <input type='text' name='secondname' required>" +
                "    </div>" +

                "    <div class='radio'>" +
                "      <span>Пол</span>" +
                "      <label>" +
                "        <input type='radio' name='sex' value='мужской'>мужской" +
                "      </label>" +
                "      <label>" +
                "        <input type='radio' name='sex' value='женский'>женский" +
                "      </label>" +
                "    </div>" +
                "    <div>" +
                "      <label for='email'>E-mail</label>" +
                "      <input type='email' name='email' required>" +
                "    </div>" +
                "    <div>" +
                "      <label for='country'>Страна</label>" +
                "      <select name='country'>" +
                "        <option>Выберите страну проживания</option>" +
                "        <option value='Россия'>Россия</option> " +
                "        <option value='Украина'>Украина</option> " +
                "        <option value='Беларусь'>Беларусь</option> " +
                "      </select> " +
                "      <div class='select-arrow'></div> " +
                "    </div> " +
                "    <button type='submit'>Отправить</button> '" +
                "  </form> '" +
                "</div>" +
                "</body>" +
                "</html>");


















 */