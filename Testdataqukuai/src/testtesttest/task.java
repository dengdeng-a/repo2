package testtesttest;

import java.text.ParseException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class task {
	public static void main(String[] args) {
	    Runnable runnable = new Runnable() {
	    	public void run() {
	    	  try {
				data_inn.main(null);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Hello !!");
	      }
	    };
	    ScheduledExecutorService service = Executors
	                    .newSingleThreadScheduledExecutor();
	    /*
		command：执行线程
		initialDelay：初始化延时
		period：前一次执行结束到下一次执行开始的间隔时间（间隔执行延迟时间）
		unit：计时单位*/
	    service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);   
	  }
}
