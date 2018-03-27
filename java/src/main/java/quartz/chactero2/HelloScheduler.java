package quartz.chactero2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import quartz.chapter01.HelloJob;

/**
 * @author: weizhenglong
 * @since 2018-03-27
 */
public class HelloScheduler {

    public static void main(String[] args) throws  Exception{
        // 创建一个 JobDetail 实例，将该实例与 HelloJob 实例绑定
        JobDetail jobDeatil = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob", "jobgroup1")// 定义标识符
                .usingJobData("message", "hello myjob1")// 传入自定义参数
                .usingJobData("floatJobValue", 3.14F)// 传入自定义参数
                .build();

        System.out.println("jobDetail's name : " + jobDeatil.getKey().getName());
        System.out.println("jobDetail's group : " + jobDeatil.getKey().getGroup());
        System.out.println("jobDetail's jobClass : " + jobDeatil.getJobClass().getName());

        // 创建一个 Trigger 实例，定义该 job 立即执行，并且每隔两秒重复执行一次，直到永远
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","trigroup1")// 定义标识符
                .usingJobData("message", "hello mytrigger1")// 传入自定义参数
                .usingJobData("doubleTriggerValue", 2.0D)// 传入自定义参数
                .startNow()// 定义立即执行
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())// 定义执行频度
                .build();

        // 创建 Scheduler 实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();

        // 绑定 JobDetail 和 trigger
        scheduler.scheduleJob(jobDeatil, trigger);

        // 执行任务
        scheduler.start();



    }
}
