package mooc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class task {
	public static void main(String[] args) {
	    Runnable runnable = new Runnable() {
	      public void run() {
	    	  test.main(null);
	        System.out.println("Hello !!");
	      }
	    };
	    ScheduledExecutorService service = Executors
	                    .newSingleThreadScheduledExecutor();
	    /*
		command��ִ���߳�
		initialDelay����ʼ����ʱ
		period��ǰһ��ִ�н�������һ��ִ�п�ʼ�ļ��ʱ�䣨���ִ���ӳ�ʱ�䣩
		unit����ʱ��λ*/
	    service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);   
	  }
}
