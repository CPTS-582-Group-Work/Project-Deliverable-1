import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.ClassLoader;

public class CheckFeatureEnvy {

    public static void main(String[] args) throws IOException {
		
		String filePath = "C:\\Users\\kworede\\Test.java"; // Source code path
		String methodBody = readSourceFileToString(filePath);// Converts the source code file into string
        String[] classNames = extractClasseNames(methodBody); // Extract each class name from the code
        String targetObjectName = null;	//Object created by potential envy classes	
		
        Class[] classes = new Class[]{Resident.class, Address.class}; //User need to add all declared classes       
		
		//Class<?> resident = Resident.class;
        //Class<?> address = Address.class;

		//System.out.println(Resident.getFullAddress());
		//String[] fullAddress = Resident.getFullAddress();
		 //   for (String name : fullAddress) {
				//System.out.println(name);
				//}
	   //System.out.println("");
		//Resident.test();
		
        for (int i = 0; i < classes.length; i++) { //Iterates over each user's input classes 
		    for (Method method : classes[i].getDeclaredMethods()) { // For each class, get declared methods
			//System.out.println("Method name: " + method.getName());
            //System.out.println("Containing class: " + method.getDeclaringClass().getName());			
			String extractedMethodBody = extractMethodBody(methodBody, method.getName()); //Extract method body based on method name from source code
            //System.out.println("Method Body:" + extractedMethodBody);
			
			if (extractedMethodBody !=null) {
				for (int j = 0; j < classNames.length; j++) { // Get each class names to check object creation  
					targetObjectName = extractObjectValue(extractedMethodBody, classNames[j]); // Extracts object name from the method body
						if (targetObjectName !=null) {
							int numberOfobjcetCall = countObjectClassCall(extractedMethodBody, targetObjectName); // How many times is object referenced
								if (numberOfobjcetCall>5) { //If object is used more than 3 times to access a different class, flag for 'Feature Envy"
									
									System.out.println("");
									System.out.println(" *** Potential feature envy detected ***");
									System.out.println ("Class:" + method.getDeclaringClass().getName() + " is accessing Class:" + classNames[j] + " more than " +  (numberOfobjcetCall-1) + " times");
								}
						}	
				}
					
			}
			
		
		}
	}		
            
        }
		
    
	    /* Get source file and convert it to a string*/
	    public static String readSourceFileToString(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }
	   
	   /* Extracts method body based on the method signiture "public static String "*/
	   public static String extractMethodBody(String code, String methodName) {
       //String pattern = "(public static String " + methodName + "\\(\\) \\{)([\\s\\S]*?)(\\})";
       String pattern = "(public[\\w\\s]*" + methodName + "\\(\\) \\{)([\\s\\S]*?)(\\})";
	   String extractedMethodBody;
	   
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(code);

        if (m.find()) {
            //System.out.println(m.group(2));
			return (m.group(2));
        } else {
			//return("No Method not found for:" + methodName);
			return null;
        }
     
	 } 
	 	 
	       /* Get the objects based on the class list of the class names */
	 	   public static String extractObjectValue(String extractedMethodBody, String className) {
            
             String input = extractedMethodBody;
			 Pattern pattern = Pattern.compile(className+"\\s+(\\w+)");
			 Matcher matcher = pattern.matcher(input);
    
				if (matcher.find()) {
					String ad = matcher.group(1);
					//System.out.println(ad);
					return ad;
				}
				return null;
			} 
					
			
			
		/* Accepts source code as an input and get all class names based on the key word "Class" */	
		public static String[] extractClasseNames(String sourceCode) {
            
              ArrayList<String> classNamesList = new ArrayList<>();
              Pattern pattern = Pattern.compile("class\\s+(\\w+)\\s*\\{");
              Matcher matcher = pattern.matcher(sourceCode);
              while (matcher.find()) {
              classNamesList.add(matcher.group(1));
              }
              String[] classNamesArray = new String[classNamesList.size()];
               return classNamesList.toArray(classNamesArray);
			 }
    

			
			
              /*Counts the number of objects occurence taking method body and objct name as a parameter*/
			 public static int countObjectClassCall(String code, String objectName) {
				String input = code;
				
				//Pattern pattern = Pattern.compile("\\baddress.\\b");
				Pattern pattern = Pattern.compile("\\b" + objectName + "\\.\\w+\\b");
				Matcher matcher = pattern.matcher(input);
    
				int count = 0;
				while (matcher.find()) {
				count++;
				}
    
				//System.out.println("The word "+objectName+" occurs " + count + " times in the input string.");
				return count;
				}

	}


