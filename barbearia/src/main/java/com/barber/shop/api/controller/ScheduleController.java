package com.barber.shop.api.controller;


import com.barber.shop.api.activity.ScheduleActivity;
import com.barber.shop.api.model.Schedule;
import com.barber.shop.api.service.ScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("schedule")
@AllArgsConstructor
public class ScheduleController {

    @Autowired
    private  ScheduleActivity activity;

    @Autowired
    private ScheduleQueryService scheduleQueryService;

    @PostMapping("/save")
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
        return ResponseEntity.ok( activity.save(schedule) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        activity.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{year}/{month}")
    public List<Schedule> listMonth(@PathVariable final int year, @PathVariable final int month){
        var yearMonth = YearMonth.of(year, month);
        var startAt = yearMonth.atDay(1)
                .atTime(0, 0, 0, 0)
                .atOffset(ZoneOffset.UTC);
        var endAt = yearMonth.atEndOfMonth()
                .atTime(23, 59, 59, 999_999_999)
                .atOffset(ZoneOffset.UTC);
        return activity.findInMonth(startAt, endAt);
    }

}
