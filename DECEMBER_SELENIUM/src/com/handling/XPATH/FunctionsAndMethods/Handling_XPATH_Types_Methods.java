package com.handling.XPATH.FunctionsAndMethods;

public class Handling_XPATH_Types_Methods 
{
	/*
	
	 There are Two Types of xpaths like Absolute xpath and Relative xpath
	 
	 Absolute xpath :- Complete xml path like 
	 
      Ex:- html/body/a/a[0]
      
     Relative xpath :- Rest of the part 
     
     Syn: //tagname[@element='value']
     
     There are Different Types of Xpath Functions 
     ===========================================
     1. contains
     
        URL : https://acegrades.com/login.html
     
       Syn:- //tagname[contains(@name,'value')] 
       
                       (or)
                       
             //tagname[@name='value']
             
                         (or)
                         
            If you are not shore about the tagname you can specify '*'
              
              Ex:-  .//*[@name='value']
           
       
       Ex:- //button[contains(@id,'loginId')]
     
	        //button[@id='loginId']
	         
	  2. text()
	  
	  Syn:- //tagname[contains(text(),'value')]
	  
	  Ex:- //a[contains(text(),'Forgot your password?')]
	  
	  3. Using OR Operator
	  
	  Syn:- //tagname[@name='value' or @id='value']
	  
	  Ex:- //input[@id='email' or @type='text']
	  
	  4. Using AND Operator
	  
	  Syn:-  //tagname[@name='value' or @id='value']
	  
	  Ex:-  //input[@id='email' and @type='text']
	  
	  5. Startswith()
	  
	  URL:- https://testautomationpractice.blogspot.com/
	  
	  Syn:- //tagname[starts-with(text(),'Message')]
	  
	  Ex:- //span[starts-with(text(),'Message')]
	  
	  ==========================================
	  
	 The following Xpath Functions are used to find complex or dynamic web elements
	 
	     -Ancestor
	     -Child
	     -Parent
	     -Preceding
	     -Following
	     -Self
	     -Descendant
	  
	  First we have to understand the above Functions carefully, then only we can easily identify web elements
	  
	  -Ancestor :- Means Parent or Grand Parent
	   
	     Syn:- //ancestor::name or id or type 
	     Ex:-  //ancestor::name
	  
	  -Child
	  
	     Ex:-  //child::employee
	    
	 -Parent
	 
	     Ex:- //email/parent::employee
	     
	 -Preceding    
	 
	     Ex:- //employee[3]/preceding::employee
	    
	   
	 -Following
	 
	    Ex:- //employee[@id='1']/following::employee
	    
	    Ex:- //input[@name='firstname']/following::input[5]
	    
	    
	 -Self
	 
	    Ex:- //input/self::*
	 
	 -Descendant
	    
	    Ex:- //descendant::employee
	 */
}
