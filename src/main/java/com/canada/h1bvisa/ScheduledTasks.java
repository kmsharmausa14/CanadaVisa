package com.canada.h1bvisa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduledTasks {

    @Autowired
    TelegramClient telegramClient;

    @Autowired
    AppointmentParser appointmentParser;

    @Scheduled(initialDelay = 10000, fixedDelay = 1200000) // Run every 20 minutes
    public void performTask() throws Exception {
        //System.out.println("Task performed at: " + System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Task performed at: " + formatter.format(date));
        Boolean february = appointmentParser.parseCanada();
        System.out.println("February or March Availability "+ february);

        if (february) {
            // Your task logic goes here
            List<String> chatIdList = new ArrayList();
            chatIdList.add("-4166843179");
            for(String chatId: chatIdList){
                telegramClient.sendMessage("February", chatId);
            }
        }
    }
}

