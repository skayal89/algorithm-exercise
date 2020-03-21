package coding.java8.patterntest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    static Pattern[] patterns;
    public static void main(String[] args) {
        Pattern p1=Pattern.compile("/pickup/[A-Z]{4}[0-9]+/open");
        Matcher m1=p1.matcher("/pickup/FM0938875/open");
        System.out.println(m1.matches());

        buildPatterns();
        String test="/pickup/FMPP0938875/open";
        String test2="/pickup_request/history/FMPP9989";
        String test3="/pickup_request/recon/vendor/status";
        System.out.println(getMatchedIndex(test3));

        String meterName4x="/pickup/[A-Z]{4}[0-9]+/open".replaceAll("[^a-zA-Z0-9]","")+"4xx";
        System.out.println();
    }

    static String[] getPatterns(){
        String[] patterns=new String[]{
                "/pickup/[A-Z]{4}[0-9]+",
                "/pickup/[A-Z]{4}[0-9]+/open",
                "/pickup_request/history/[A-Z]{4}[0-9]+",
                "/pickup_request/history",
                "/pickup_request/recon/[a-z]/[A-Z]{4}[0-9]+",
                "/pickup_request/recon/[a-z]/status"
        };
        return patterns;
    }

    static void buildPatterns(){
        String[] patternList=getPatterns();
        patterns=new Pattern[patternList.length];
        for (int i=0;i<patterns.length;i++){
            if(patternList[i]!=null && !patternList[i].isEmpty()) {
                patterns[i] = Pattern.compile(patternList[i]);
            }
        }
    }

    static int getMatchedIndex(String uri){
        for (int i = 0; i < patterns.length; i++) {
            if(patterns[i].matcher(uri).matches()){
                return i;
            }
        }
        return -1;
    }
}
