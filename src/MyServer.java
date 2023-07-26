import com.vmm.JHTTPServer;
import java.util.Properties;
import vmm.DBLoader;
import java.sql.*;

public class MyServer extends JHTTPServer
{
    public MyServer(int portno) throws Exception
    {
        super(portno);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) 
    {
         if(uri.equals("/"))
         {
             String ans = "Welcome to My Server";
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else if(uri.equals("/one"))
         {
             String ans = "Random no is "+Math.random();
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else if(uri.equals("/check"))
         {
             // receive incoming parameters sent by myclient
             String u = parms.getProperty("user");
             String p = parms.getProperty("pass");
             
             String ans="";
             
             // now check from DB
             try
             {
                 ResultSet rs = DBLoader.executeSQL("select * from users where username='"+u+"' and password='"+p+"'");
             
                 if(rs.next())
                 {
                     ans = "Login Successfull !!!";
                 }  
                 else
                 {
                     ans = "Login Failed !!!";
                 }
             }
             catch(Exception ex)
             {
                 ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else if(uri.equals("/signup"))
         {
            //1. Receive text
             String u = parms.getProperty("username");
             String p = parms.getProperty("password");
             String m = parms.getProperty("mobile");
             String e = parms.getProperty("email");
             
             // step 2 and 3 , receive files and save on server
             String abspath = "src/myuploads/user";
             String photo_name = saveFileOnServerWithOriginalName(files,parms,"f1",abspath);
            
             String ans = "";
             
             // 4.record in DB
             try
             {
                 ResultSet rs = DBLoader.executeSQL("select * from USERS where username='"+u+"'");
                 
                 if(rs.next())
                 {
                     ans = "This Username is already taken";
                 }
                 else
                 {
                     rs.moveToInsertRow();
                     
                     rs.updateString("username", u);
                     rs.updateString("password", p);
                     rs.updateString("mobile", m);
                     rs.updateString("email", e);
                     rs.updateString("photo", abspath+"/"+photo_name);
                     
                     rs.insertRow();
                     
                     ans = "SignUp Successfull !!!";
                     
                 }
             }
             catch(Exception ex)
             {
                 ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans );
             return res;
         }
         else if(uri.equals("/getUserDetail"))
        {
            String u = parms.getProperty("user");   // rohit
            String ans = "";
            
            // now check from DB
            try
            {
                String sql = "select * from users where username='"+u+"'";
                ResultSet rs = DBLoader.executeSQL(sql);
                String ph = "";
                
                if(rs.next())
                {
                    ph = rs.getString("photo");
                }
                
                ans = ph; 
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
            
            Response res = new Response(HTTP_OK, "text/plain", ans);
            return res;
        }
         else if(uri.equals("/getcategory"))
        {
            String ans = "";
            
            try
            {
                ResultSet rs = DBLoader.executeSQL("select * from category");
                
                String catname, Photo;
                
                while(rs.next())
                {
                    catname = rs.getString("catname");
                    Photo = rs.getString("photo");
                    
                    ans = ans + catname+","+Photo+";";
                }
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
            
            Response res = new Response(HTTP_OK, "text/plain", ans);
            return res;
        }
         else if(uri.equals("/addcategory"))
         {
             //receive text
             String catname = parms.getProperty("catname");
             
             //receive file and save
             String abspath = "src/myuploads/category";
             
             String photo_name = saveFileOnServerWithOriginalName(files, parms, "f1", abspath);
             
             String ans = "";
             
             //now record in DB
             try
             {
                  ResultSet rs = DBLoader.executeSQL("Select * from category where catname='"+catname+"'");
                  
                  if(rs.next())
                  {
                      ans = "This Category Already Exist !!";
                  }
                  else
                  {
                      rs.moveToInsertRow();
                      
                      rs.updateString("catname", catname);
                      rs.updateString("photo", abspath+"/"+photo_name);
                      
                      rs.insertRow();
                      
                      ans = "New Category Added Successfully !!!";
                  }
             }
             catch(Exception ex)
             {
                 ex.printStackTrace();
                 ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else if(uri.equals("/addvideo"))
         {
             String videoname = parms.getProperty("videoname");
             String description = parms.getProperty("description");
             String trailerlink = parms.getProperty("trailerlink");
             String catname = parms.getProperty("catname");
             int runningtime = Integer.parseInt(parms.getProperty("runningtime"));
             
             String abspath1 = "src/myuploads/posters";
             String poster_name = saveFileOnServerWithOriginalName(files, parms, "poster", abspath1);
             
             String abspath2 = "src/myuploads/videos";
             String movie_name = saveFileOnServerWithOriginalName(files, parms, "video", abspath2);
             
             //now record in DB
             String ans = "";
             try
             {
                 ResultSet rs = DBLoader.executeSQL("select * from video where videoname='"+videoname+"'");
                 
                 if(rs.next())
                 {
                     ans = "This Video Name Already Exist !!!";
                 }
                 else
                 {
                     rs.moveToInsertRow();
                     
                     rs.updateString("videoname", videoname);
                     rs.updateString("description", description);
                     rs.updateString("photo", abspath1+"/"+poster_name);
                     rs.updateString("videolink", abspath2+"/"+movie_name);
                     rs.updateString("trailerlink", trailerlink);
                     rs.updateString("catname", catname);
                     rs.updateInt("runningtime", runningtime);
                     
                     rs.insertRow();
                     
                     ans = "New Movie Added Successfully !!!";
                 }
             }
             catch(Exception ex)
             {
                 ex.printStackTrace();
                 ans = ex.toString();
                
             }
             
              Response res = new Response(HTTP_OK, "text/plain", ans);
              return res;
             }
         else if(uri.equals("/getvideo"))
         {
             String catname = parms.getProperty("catname");
             
             String ans = "";
             
             try
             {
                 ResultSet rs = DBLoader.executeSQL("select vid,videoname, photo  from video where catname='"+catname+"'");
                 
                 while(rs.next())
                 {
                     int vid = rs.getInt("vid");
                     String videoname = rs.getString("videoname");
                     String description = rs.getString("photo");
                     
                     ans = ans+vid+","+videoname+","+description+";";
                 }
             }
             catch(Exception ex)
             {
                 ans = ex.toString();
             }
              
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else if(uri.equals("/getvideodetails"))
         {
             int vid = Integer.parseInt(parms.getProperty("vid"));
             
             String ans ="";
             try
             {
                ResultSet rs = DBLoader.executeSQL("select * from video where vid="+vid);
                
                if(rs.next())
                {
                    String videoname = rs.getString("videoname");
                    String description = rs.getString("description");
                    String photo = rs.getString("photo");
                    String videolink = rs.getString("videolink");
                    String trailerlink = rs.getString("trailerlink");
                    String catname = rs.getString("catname");
                    int runningtime = rs.getInt("runningtime");
                    
                    ans = videoname+","+description+","+photo+","+videolink+","+trailerlink+","+catname+","+runningtime;
                }
             }
             catch(Exception ex)
             {
                ans = ex.toString();
             }
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else if(uri.equals("/playmovie"))
         {
             String movie_path = parms.getProperty("movie_path");
             
             Response res = streamFile(movie_path, method, header);
             return res;
         }
         else if(uri.equals("/checkadminlogin"))
         {
             String u = parms.getProperty("user");
             String p = parms.getProperty("pass");
             
             String ans = "";
             
             try
             {
                ResultSet rs = DBLoader.executeSQL("select *from admin where username='"+u+"'and password='"+p+"'");
                
                if(rs.next())
                {
                    ans = "success";
                }
                else
                {
                    ans = "fail";
                }
             }
             catch(Exception ex)
             {
               ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else
         {
             String ans = "Invalid uri";
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
    }
}
