package com.example.order.task;

import com.example.order.domain.dao.OrderDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderTask {
    private final OrderDAO orderDAO;

    @Scheduled(cron = "0 0 0 * * *")
    public void insertSequence(){
        log.warn("===============================");
        log.warn("Inserted order sequence");
        log.warn("===============================");

        orderDAO.saveOrderSequence();
    }
}










