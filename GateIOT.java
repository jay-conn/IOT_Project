import java.util.*;
public class GateIOT{

   /* -attributes*/
   String title = "gate";
   String status = "null";
   String IP_Address = "192.68.103";
   
   /*-constructors*/
   public GateIOT(String title,String status){
      this.title = title;
      this.status = status;
   }
   public GateIOT(){
   
   }
   
   /*-methods*/
   public void open(){
      System.out.println("the door is opened.");
   }
   
   public void close(){
      System.out.println("the door is closed.");
   }
   
   public void powerOn(){
      System.out.println("The gate is on.");
   }
   
   public void powerOff(){
      System.out.println("The gate is off.");
   }
   public void checkStatus(){
      System.out.println("The gate's current status is " + status);
   }
}