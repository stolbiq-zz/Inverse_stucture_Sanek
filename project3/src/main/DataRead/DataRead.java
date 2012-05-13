//пока это элементарная основа того класса который будет первично обрабатывать массив данных, для коррекции вывода и ввода мне нужно знать как я получаю данные и куда и как их отдавать

package pack;

import java.io.*;

public class DataRead{
	  	String sElemName=""; // Строка для имени элемента
	    	
	    public void findAndPrint(){
	  	String stroka="\n";
	    try
		{
	    System.out.println("\nELEMENT SEARCH\n");
	    
		OutputStreamWriter OSW = new OutputStreamWriter(System.out);
		PrintWriter         PW = new PrintWriter(OSW, true); 
	    PW.println("\nВведите название присутствующего элемента:");
	    InputStreamReader ISR = new InputStreamReader(System.in, "Cp866");
	    BufferedReader     BR = new BufferedReader(ISR);     
	    
	    //Ввод названия элемента
	    sElemName = BR.readLine(); // читаем строку (имя элемента) 
	    PW.println("\nПрисутствующий элемент: "+sElemName);
	    try
	    { 
	       
	       // Построчно читаем файл и печатаем его содержимое если такой элемент встречается  
	       FileReader FR = new FileReader("base.txt");
	       BufferedReader BRf = new BufferedReader(FR);
	       do
	        {
	        stroka=BRf.readLine();
	        
	        if(stroka!=null) {
	        if(stroka.indexOf(sElemName)>0)
	        	{
	        	PW.println(stroka);
	        	}
	        }
	        
	        }
	        while(stroka!=null);

	        
	   
	       PW.println("\n\nФАЙЛ ПРОЧИТАН.\n\n\n");
	    
	    }//try
	     catch (FileNotFoundException e) 
	    { 
	     PW.println("Файл не найден."); 
	    }//catch (FileNotFoundException e) //catch
	    }//try
	    catch(Exception e)
	    {
	  	System.out.println("Something is wrong....");
	    }//catch(Exception e)
	   //main
	//testFile1
}
}
