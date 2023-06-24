package mul.cam.a.util;

import java.util.Random;

public class RandomCode {
	public static void main(String[] args) {
		eduCode();
		subCode();
	}
	
	public static String eduCode() {
        
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        
        int num  = 0;
        while(sb.length() < 3) {
        	num = ran.nextInt(75)+48;
        	 if (num >= 65 && num <= 90) {
                 sb.append((char) num);
             } else {
                 continue;
             }
		}
        while(sb.length() < 6) {
			num = ran.nextInt(75)+48;
			 if (num >= 48 && num <= 57) {
			        sb.append((char) num);
			    } else {
			        continue;
			    }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
	
public static String subCode() {
        
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        
        int num  = 0;
        while(sb.length() < 1) {
        	num = ran.nextInt(75)+48;
        	 if (num >= 97 && num <= 122) {
                 sb.append((char) num);
             } else {
                 continue;
             }
		}
        while(sb.length() < 4) {
			num = ran.nextInt(75)+48;
			 if (num >= 48 && num <= 57) {
			        sb.append((char) num);
			    } else {
			        continue;
			    }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
