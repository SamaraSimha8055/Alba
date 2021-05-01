package self;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

public class metaJava {
public  String getCreationDetails(File file)
    {       
       try{         
        Path p = Paths.get(file.getAbsolutePath());
        BasicFileAttributes view
           = Files.getFileAttributeView(p, BasicFileAttributeView.class)
                  .readAttributes();
        FileTime fileTime=view.creationTime();
        return ("JDBC:mysql:\\C:\\Users\\Deadly'''Beast\\Desktop\\Nemesys\\python_-_login_and_registration_form\\Python - Login And Registration Form\\db_member"+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format((fileTime.toMillis())));
       }
       catch(IOException e){ 
        e.printStackTrace(); 
       }
       return ""; 
   }

   public static void main(String...str){
       System.out.println
           (new metaJava().getCreationDetails(new File("")));
   }
}