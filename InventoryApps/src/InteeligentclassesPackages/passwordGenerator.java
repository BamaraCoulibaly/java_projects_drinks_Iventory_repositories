/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InteeligentclassesPackages;

import java.util.Calendar;

/**
 *
 * @author bamaragcoulibaly
 */
 public class passwordGenerator {
     String Name ;
     String Password;
     String today;
    public passwordGenerator(String Name, String Password){
        this.Password = Password;
        this.Name = Name;
    }
    private String GeneratePassord(){
        today =  java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        System.out.println(today);
        return today;
    }
   // check if a string str is null or empty
        public String IsStringEmptyorNull(String str)
        {
            if (str.isEmpty())
                    { return "the password or the string is null please enter password or "; }
            return str;
        }

      
    
}
