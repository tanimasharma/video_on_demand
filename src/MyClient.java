import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.io.*;
import java.net.URI;

public class MyClient 
{
    public static String fetchIndex()
    {
        try
        {
          String url = "http://localhost:9000/";
          HttpResponse<String> response = Unirest.get(url).asString();
         
          String ans = response.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    public static String checkLoginFromServer(String user, String pass)
    {
        try
        {
          String url = "http://localhost:9000/check?user="+user+"&pass="+pass;
          
          HttpResponse<String> response = Unirest.get(url).asString();
         
          String ans = response.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    public static String signupUsingServer(String user, String pass, 
                                           String mobile, String email, File ph)
    {
        try
        {
          String url = "http://localhost:9000/signup";
          
          System.out.println("selected file "+ph);
          
          
          // SEND TEXT DATA AS QUERY STRING
          // SEND FILE AS FIELD
          HttpResponse<String> response = Unirest.post(url)
                                                 
                                                 .queryString("user", user)
                                                 .queryString("pass", pass)
                                                 .queryString("mobile", mobile)
                                                 .queryString("email", email)
                                                 
                                                 .field("f1",ph)
                  
                                                 .asString();
         
          String ans = response.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    public static String getUserDetailFromServer(String u)
    {
        try
        {
          String url = "http://localhost:9000/getUserDetail?user="+u;
          HttpResponse<String> res = 
                  Unirest.get(url).asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
 
    public static String getCategoriesFromServer()
    {
        try
        {
          String url = "http://localhost:9000/getcategory";
          HttpResponse<String> response = Unirest.get(url).asString();
         
          String ans = response.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
 
    
    public static String addCategory(String catname, File ph)
    {
        try
        {
          String url = "http://localhost:9000/addcategory";
          
          HttpResponse<String> response = Unirest.post(url)
                                                 .queryString("catname", catname)
                                                 .field("f1", ph)
                                                 .asString();
         
          String ans = response.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
 
    
    public static String addVideo(String videoname, String description, File poster, File video,
                                  String trailerlink,String catname, int runningtime )
    {
        try
        {
          String url = "http://localhost:9000/addvideo";
          
          HttpResponse<String> response = Unirest.post(url)
                                                 .queryString("videoname", videoname)
                                                 .queryString("description",description)
                                                 .queryString("trailerlink", trailerlink)
                                                 .queryString("catname", catname)
                                                 .queryString("runningtime", runningtime+"")
                  
                                                 .field("poster", poster)
                                                 .field("video", video)
                                                 .asString();
         
          String ans = response.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    public static String getVideoFromServer(String catname)
    {
        try
        {
          String url = "http://localhost:9000/getvideo?catname="+catname;
          HttpResponse<String> response = Unirest.get(url).asString();
         
          String ans = response.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    public static String getSingleVideoDetailsFromServer(int vid)
    {
        try
        {
          String url = "http://localhost:9000/getvideodetails?vid="+vid;
          HttpResponse<String> response = Unirest.get(url).asString();
         
          String ans = response.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    public static void playMovie(String movie_path)
    {
        try
        {
            Desktop.getDesktop().browse(URI.create("http://localhost:9000/playmovie?movie_path="+movie_path));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static String checkAdminLoginFromServer(String u, String p)
    {
        try
        {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/checkadminlogin?user="+u+"&pass="+p)
                                       .asString();
            
            String ans = res.getBody();
            
            return ans;
        }
        catch(Exception ex)
        {
            return ex.toString();
        }
    }
}

