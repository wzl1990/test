package com.opc.admin;

import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * Description :
 * Author: zhenglong
 * since 17 八月 2017
 */
@Configuration
@EnableScheduling
public class NotifierConfiguration {
    @Autowired
    private Notifier notifier;

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier remindingNotifier = new RemindingNotifier(notifier);
        remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(5));
        return remindingNotifier;
    }

    @Scheduled(fixedRate = 60000L)
    public void remind() {
        remindingNotifier().sendReminders();
    }
}