package coding.algo.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class JobScheduling {

    static class Job{
        int startTime, endTime, value;

        public Job(int startTime, int endTime, int value) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.value = value;
        }
    }

    static int getMaxProfit(Job[] job){
        int n=job.length;
        int dp[]=new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=job[i].value;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if(job[j].startTime>=job[i].endTime){
                    dp[j]=Math.max(dp[j],dp[i]+job[j].value);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Job j[]=new Job[6];
        j[0]=new Job(1,3,5);
        j[1]=new Job(2,5,6);
        j[2]=new Job(4,6,5);
        j[3]=new Job(6,7,4);
        j[4]=new Job(5,8,11);
        j[5]=new Job(7,9,2);
        System.out.println(getMaxProfit(j));


    }
}
