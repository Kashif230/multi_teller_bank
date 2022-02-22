/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi_teller_bank;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Kashif
 */
public class Multi_teller_bank {
    //static table table_obj = new table();
    static int clock = 20;          // 10 minute
    //static int[] server = {1,2,3};
    static int number_of_server=3;  //=2 it means we have two server 0 and 1
    static ArrayList<table> a = new ArrayList<table>();
    static ArrayList<getting_teller_information> getting_teller_information = new ArrayList<getting_teller_information>();
    
    static ArrayList<getting_teller_information> p = new ArrayList<getting_teller_information>();
    static ArrayList<table> t = new ArrayList<table>();
    //static int clock_sum = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Random rand_for_arrival = new Random();
        // for inter arriaval time with mean =1 minute
        for(int i=0; i<clock; ){
            
            int rand_no = rand_for_arrival.nextInt(3);
            i=rand_no + i;
            if(i>clock) break;
            a.add(new table(rand_no));
            //a.add(new table().setInter_arrival_time(rand_no));
//            a.add(table_obj.setInter_arrival_time(rand_no, table_obj));
            
        }
        
        
        // for servive time with mean= 4.5 minute
        Random rand_for_service = new Random();
        for(int i=0; i<a.size();i++){
            int rand_no = rand_for_service.nextInt(10);
            //table element= new table(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);
            //a.set(i, new table(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)  );
            //a.set(i, new table( rand_no, "service_time"));
            //a.set(i, a.get(i));
            a.get(i).setService_time(rand_no);
        }
        
        // making server chosen = -1 intially
        for(int i=0; i<a.size();i++){
            
            //table element= new table(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);
            //a.set(i, new table(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)  );
            //a.set(i, new table( rand_no, "service_time"));
            //a.set(i, a.get(i));
            a.get(i).setServer_name(-1);
        }
        
        
        
        // for arrival time
        int sum=0;
        for(int i=0; i<a.size();i++){
            sum = sum +a.get(i).inter_arrival_time;
            a.get(i).setArrival_time( sum );
        }
        
        
        
        
        //printing
//        System.out.println(  "arrival time" + "    " + "service time"+ "    " + "server chosen"+ "    " + "time serv begin"+ "    " + "time serv end"+  "    " + "numb_in_queue");
//        for(int i=0; i<a.size();i++){
//            
//            System.out.println(   a.get(i).arrival_time + "                " + a.get(i).service_time+ "              " + a.get(i).server_name+ "                  " + a.get(i).time_service_begins+ "                 " + a.get(i).time_service_ends+ "                      " + a.get(i).number_in_queue);
//        }
        
        
        
//        for(int i=0; i<a.size();i++){
//            getting_information_about_teller();
//            p = getting_teller_information;
//            if(p.size()==0){
//                dollar();
//                table unique = process_t_gives_unique();
//                a.get(i).server_name=unique.server_name;
//                a.get(i).time_service_begins=a.get(i).arrival_time;
//                a.get(i).time_service_ends=a.get(i).arrival_time+a.get(i).service_time;
//                a.get(i).number_in_queue=update_queue(a.get(i),i);
//                a.get(i).waiting_time_in_queue=a.get(i).time_service_begins-a.get(i).arrival_time;
//            }
//            if(p.size()!=0){
//                hash();
//                table unique = process_t_gives_unique();
//                a.get(i).server_name=unique.server_name;
//                if(unique.time_service_ends>a.get(i).arrival_time){
//                    a.get(i).time_service_begins=unique.time_service_ends;
//                }
//                if(unique.time_service_ends<a.get(i).arrival_time){
//                    a.get(i).time_service_begins=a.get(i).arrival_time;
//                }
//                if(unique.time_service_ends==a.get(i).arrival_time){
//                    a.get(i).time_service_begins=a.get(i).arrival_time;
//                }
//                a.get(i).time_service_ends=a.get(i).time_service_begins+a.get(i).service_time;
//                a.get(i).number_in_queue=update_queue(a.get(i),i);
//                a.get(i).waiting_time_in_queue=a.get(i).time_service_begins-a.get(i).arrival_time;
//            }
//            t.clear();
//            getting_teller_information.clear();
//        }
        
        for(number_of_server = number_of_server; number_of_server<8; number_of_server++){
            
            for(int i=0; i<a.size();i++){
            getting_information_about_teller();
            p = getting_teller_information;
            if(p.size()==0){
                dollar();
                table unique = process_t_gives_unique();
                a.get(i).server_name=unique.server_name;
                a.get(i).time_service_begins=a.get(i).arrival_time;
                a.get(i).time_service_ends=a.get(i).arrival_time+a.get(i).service_time;
                a.get(i).number_in_queue=update_queue(a.get(i),i);
                a.get(i).waiting_time_in_queue=a.get(i).time_service_begins-a.get(i).arrival_time;
            }
            if(p.size()!=0){
                hash();
                table unique = process_t_gives_unique();
                a.get(i).server_name=unique.server_name;
                if(unique.time_service_ends>a.get(i).arrival_time){
                    a.get(i).time_service_begins=unique.time_service_ends;
                }
                if(unique.time_service_ends<a.get(i).arrival_time){
                    a.get(i).time_service_begins=a.get(i).arrival_time;
                }
                if(unique.time_service_ends==a.get(i).arrival_time){
                    a.get(i).time_service_begins=a.get(i).arrival_time;
                }
                a.get(i).time_service_ends=a.get(i).time_service_begins+a.get(i).service_time;
                a.get(i).number_in_queue=update_queue(a.get(i),i);
                a.get(i).waiting_time_in_queue=a.get(i).time_service_begins-a.get(i).arrival_time;
            }
            t.clear();
            getting_teller_information.clear();
        }
            
            System.out.println(  "arrival time" + "    " + "service time"+ "    " + "server chosen"+ "    " + "time serv begin"+ "    " + "time serv end"+  "    " + "numb_in_queue" + "       "+"waiting_time_in_queue/delay_time_in_queue");
        for(int i=0; i<a.size();i++){
            
            System.out.println(   a.get(i).arrival_time + "                " + a.get(i).service_time+ "              " + a.get(i).server_name+ "                  " + a.get(i).time_service_begins+ "                 " + a.get(i).time_service_ends+ "                      " + a.get(i).number_in_queue+ "                      " + a.get(i).waiting_time_in_queue);
        }
        
        
        System.out.println();
        System.out.println("Number of teller : "+ number_of_server);
        System.out.println("Mean interarrival time : "+ 1 + " minute");
        System.out.println("Mean service time : "+ 4.5  + " minute");
        
        sum=0;
        for(int i=0; i<a.size(); i++){
            sum = sum + a.get(i).number_in_queue;
        }
        float sum_float =(float) sum / a.size();
        System.out.println("With "+ number_of_server+ " ,average number in queue = " + sum_float);
        
        
        
//        System.out.println("expected time-average total number of customers in queue");
        
        //System.out.println("expected average delay in queue");
        sum=0;
        for(int i=0; i<a.size(); i++){
            sum = sum + a.get(i).waiting_time_in_queue;
        }
        float sum_float1 =(float) sum / a.size();
        System.out.println("expected average delay in queue : " + sum_float1);
        
        
        // printing maximum delay in queue
        int y=0;
        int max_delay = a.get(y).waiting_time_in_queue;
        for(y=1; y<a.size(); y++){
            if(a.get(y).waiting_time_in_queue>max_delay){
                max_delay = a.get(y).waiting_time_in_queue;
            }
        }
        System.out.println("maximum delay in queue : " + max_delay);
         
        for(int i=0; i<a.size();i++){
                a.get(i).server_name = -1;
                a.get(i).time_service_begins=0;
                a.get(i).time_service_ends=0;
                a.get(i).number_in_queue=0;
                a.get(i).waiting_time_in_queue=0;
                //a.get(i).server_name+ "                  " + a.get(i).time_service_begins+ "                 " + a.get(i).time_service_ends+ "                      " + a.get(i).number_in_queue a.get(i).waiting_time_in_queue
        }    
            
            
        }
        
        
        
        
        
        
        
//        //printing
//        System.out.println("inter-arri" + "    " + "service time" + "    " + "arrival time"+ "    " + "server chosen"+ "    " + "time serv begin"+ "    " + "time serv end"+ "    " + "waiting_time_in_queue"+ "    " + "time_customer_spend_in_system"+ "    " + "service_idle_time"+ "    " + "numb_in_queue");
//        for(int i=0; i<a.size();i++){
//            
//            System.out.println(a.get(i).inter_arrival_time + "             " + a.get(i).service_time + "                " + a.get(i).arrival_time+ "              " + a.get(i).server_name+ "                  " + a.get(i).time_service_begins+ "                 " + a.get(i).time_service_ends+ "                 " + a.get(i).waiting_time_in_queue+ "                           " + a.get(i).time_customer_spend_in_system+ "                            " + a.get(i).service_idle_time+ "                      " + a.get(i).number_in_queue);
//        }


           //printing
//        System.out.println("---------------------------------------------------");
//        System.out.println("---------------------------------------------------");   
//        System.out.println(  "arrival time" + "    " + "service time"+ "    " + "server chosen"+ "    " + "time serv begin"+ "    " + "time serv end"+  "    " + "numb_in_queue" + "       "+"waiting_time_in_queue/delay_time_in_queue");
//        for(int i=0; i<a.size();i++){
//            
//            System.out.println(   a.get(i).arrival_time + "                " + a.get(i).service_time+ "              " + a.get(i).server_name+ "                  " + a.get(i).time_service_begins+ "                 " + a.get(i).time_service_ends+ "                      " + a.get(i).number_in_queue+ "                      " + a.get(i).waiting_time_in_queue);
//        }
//        
//        
//        System.out.println();
//        System.out.println("Number of teller : "+ number_of_server);
//        System.out.println("Mean interarrival time : "+ 1 + " minute");
//        System.out.println("Mean service time : "+ 4.5  + " minute");
//        
//        sum=0;
//        for(int i=0; i<a.size(); i++){
//            sum = sum + a.get(i).number_in_queue;
//        }
//        float sum_float =(float) sum / a.size();
//        System.out.println("With "+ number_of_server+ " ,average number in queue = " + sum_float);
//        
//        
//        
////        System.out.println("expected time-average total number of customers in queue");
//        
//        //System.out.println("expected average delay in queue");
//        sum=0;
//        for(int i=0; i<a.size(); i++){
//            sum = sum + a.get(i).waiting_time_in_queue;
//        }
//        float sum_float1 =(float) sum / a.size();
//        System.out.println("expected average delay in queue : " + sum_float1);
//        
//        
//        // printing maximum delay in queue
//        int y=0;
//        int max_delay = a.get(y).waiting_time_in_queue;
//        for(y=1; y<a.size(); y++){
//            if(a.get(y).waiting_time_in_queue>max_delay){
//                max_delay = a.get(y).waiting_time_in_queue;
//            }
//        }
//        System.out.println("maximum delay in queue : " + max_delay);
//        
        
    }
    
    public static void getting_information_about_teller(){
        for(int i=0; i<number_of_server;i++){
            
            for(int j=0; j<a.size();j++){
                if(i==a.get(a.size()-1-j).server_name) {
                    getting_teller_information.add( new  getting_teller_information(a.get(a.size()-1-j)));
                    break;
                }
            }
            
        }
        
    }
    
    
    public static void dollar(){
        for(int i=0; i<number_of_server; i++){
            t.add(new table(0,0,0,i,0,0,0,0,0,0));
        }
    }
    
    
    
    public static table process_t_gives_unique (){
        
        int i=0;
        int min_queue=t.get(i).number_in_queue;
        table min_row=t.get(i);
        for(i=1; i<t.size(); i++){
            if(min_queue>t.get(i).number_in_queue){
                min_row=t.get(i);
                min_queue=t.get(i).number_in_queue;
            }
            if(min_queue==t.get(i).number_in_queue){
                if(min_row.time_service_ends>t.get(i).time_service_ends){
                    min_row=t.get(i);
                    min_queue=t.get(i).number_in_queue;
                    
                }
            }
        }
        return min_row;
    }
    
    
    
    
    
    
    public static int update_queue(table b,int h){
        int queue=0,check=0;
        int i ;
        for (i = 0; i<h;i++){
            if(b.server_name==a.get(i).server_name){
                check++;
                if(b.arrival_time<a.get(i).time_service_ends){
                    queue++;
                    //if(i==h-1) queue--;
                }
            }
        }
        if(check!=0)return queue;
        
        if(check==0)return 0;
        //unreachable_statement
        return 0;
    }
    
    
    
    
    public static void hash(){
        int kk=0;
        int i=0;
        int jj=0;
        for(i=0; i<number_of_server;i++){
            for (jj=i; jj<p.size(); jj++){
                if(p.get(jj).t.server_name==i){
                    //jj=jj+1;
                    kk=kk+1;
                    t.add(p.get(i).t);
                    break;
                }
//                if(p.get(jj).t.server_name!=i){
//                    t.add(new table2(0,0,0,i,0,0,0,0,0,0));
//                    //jj=jj+1;
//                    break;
//                }
            }
        }
        
        for(kk=kk;kk<number_of_server;kk++){
            t.add(new table(0,0,0,kk,0,0,0,0,0,0));
        }
    }
    
    
    
}



class table{
        int inter_arrival_time;
        int arrival_time;
        int service_time;
        int server_name;
        int time_service_begins;
        int time_service_ends;
        int waiting_time_in_queue;
        int time_customer_spend_in_system;
        int service_idle_time;
        int number_in_queue;
        
        //act as table2
        public table(int inter_arrival_time, int arrival_time, int service_time, int server_name, int time_service_begins, int time_service_ends, int waiting_time_in_queue, int time_customer_spend_in_system, int service_idle_time, int number_in_queue) {
        this.inter_arrival_time = inter_arrival_time;
        this.arrival_time = arrival_time;
        this.service_time = service_time;
        this.server_name = server_name;
        this.time_service_begins = time_service_begins;
        this.time_service_ends = time_service_ends;
        this.waiting_time_in_queue = waiting_time_in_queue;
        this.time_customer_spend_in_system = time_customer_spend_in_system;
        this.service_idle_time = service_idle_time;
        this.number_in_queue = number_in_queue;
    }

    public table(int inter_arrival_time) {
         this.inter_arrival_time = inter_arrival_time;
        
    }

//    public void setInter_arrival_time(int inter_arrival_time) {
//        this.inter_arrival_time = inter_arrival_time;
//        
//    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setService_time(int service_time) {
        this.service_time = service_time;
    }

    public void setServer_name(int server_name) {
        this.server_name = server_name;
    }

    public void setTime_service_begins(int time_service_begins) {
        this.time_service_begins = time_service_begins;
    }

    public void setTime_service_ends(int time_service_ends) {
        this.time_service_ends = time_service_ends;
    }

    public void setWaiting_time_in_queue(int waiting_time_in_queue) {
        this.waiting_time_in_queue = waiting_time_in_queue;
    }

    public void setTime_customer_spend_in_system(int time_customer_spend_in_system) {
        this.time_customer_spend_in_system = time_customer_spend_in_system;
    }

    public void setService_idle_time(int service_idle_time) {
        this.service_idle_time = service_idle_time;
    }

    public void setNumber_in_queue(int number_in_queue) {
        this.number_in_queue = number_in_queue;
    }
        


}



class getting_teller_information{
    table t;

    public getting_teller_information(table t) {
        this.t = t;
    }
    
}



//class table2{
//        int inter_arrival_time;
//        int arrival_time;
//        int service_time;
//        int server_name;
//        int time_service_begins;
//        int time_service_ends;
//        int waiting_time_in_queue;
//        int time_customer_spend_in_system;
//        int service_idle_time;
//        int number_in_queue;
//
//    public table2(int inter_arrival_time, int arrival_time, int service_time, int server_name, int time_service_begins, int time_service_ends, int waiting_time_in_queue, int time_customer_spend_in_system, int service_idle_time, int number_in_queue) {
//        this.inter_arrival_time = inter_arrival_time;
//        this.arrival_time = arrival_time;
//        this.service_time = service_time;
//        this.server_name = server_name;
//        this.time_service_begins = time_service_begins;
//        this.time_service_ends = time_service_ends;
//        this.waiting_time_in_queue = waiting_time_in_queue;
//        this.time_customer_spend_in_system = time_customer_spend_in_system;
//        this.service_idle_time = service_idle_time;
//        this.number_in_queue = number_in_queue;
//    }
//
////    public table2(int inter_arrival_time) {
////         this.inter_arrival_time = inter_arrival_time;
////        
////    }
//
////    public void setInter_arrival_time(int inter_arrival_time) {
////        this.inter_arrival_time = inter_arrival_time;
////        
////    }
//
//    public void setArrival_time(int arrival_time) {
//        this.arrival_time = arrival_time;
//    }
//
//    public void setService_time(int service_time) {
//        this.service_time = service_time;
//    }
//
//    public void setServer_name(int server_name) {
//        this.server_name = server_name;
//    }
//
//    public void setTime_service_begins(int time_service_begins) {
//        this.time_service_begins = time_service_begins;
//    }
//
//    public void setTime_service_ends(int time_service_ends) {
//        this.time_service_ends = time_service_ends;
//    }
//
//    public void setWaiting_time_in_queue(int waiting_time_in_queue) {
//        this.waiting_time_in_queue = waiting_time_in_queue;
//    }
//
//    public void setTime_customer_spend_in_system(int time_customer_spend_in_system) {
//        this.time_customer_spend_in_system = time_customer_spend_in_system;
//    }
//
//    public void setService_idle_time(int service_idle_time) {
//        this.service_idle_time = service_idle_time;
//    }
//
//    public void setNumber_in_queue(int number_in_queue) {
//        this.number_in_queue = number_in_queue;
//    }
//        
//
//
//}