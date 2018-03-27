package quartz.chapter01;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import quartz.chapter01.HelloJob;

/**
 * @author: weizhenglong
 * @since 2018-03-27
 */
public class HelloScheduler {

    public static void main(String[] args) throws  Exception{
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("mujob", "hellojob").build();

        System.out.println(jobDetail.getJobClass().getName());
        System.out.println(jobDetail.getKey().getGroup());
        System.out.println(jobDetail.getKey().getName());

        // 创建一个 Trigger 实例，定义该 job 立即执行，并且每隔两秒重复执行一次，直到永远
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("my", "group").startNow().withSchedule(SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever())// 定义执行频度
                .build();

        SchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler =
                factory.getScheduler();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();



    }
}
