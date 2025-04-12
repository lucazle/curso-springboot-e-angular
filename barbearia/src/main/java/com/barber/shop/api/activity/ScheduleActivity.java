package com.barber.shop.api.activity;

import com.barber.shop.api.model.Client;
import com.barber.shop.api.model.Schedule;
import com.barber.shop.api.repository.ClientRepository;
import com.barber.shop.api.repository.ScheduleRepository;
import com.barber.shop.api.service.ClientQueryService;
import com.barber.shop.api.service.ClientService;
import com.barber.shop.api.service.ScheduleQueryService;
import com.barber.shop.api.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleActivity implements ScheduleService {

    @Autowired
    private  ScheduleRepository scheduleRepository;

    @Autowired
    private  ScheduleQueryService scheduleQueryService;
    @Override
    public Schedule save(Schedule schedule) {

        //scheduleQueryService.verifyIfScheduleExists(schedule.getStartAt(), schedule.getEndAt());
        return scheduleRepository.save(schedule);
    }

    @Override
    public void delete(long id) {

        scheduleQueryService.findById(id);
        scheduleRepository.deleteById(id);

    }

    @Override
    public List<Schedule> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return scheduleRepository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }
}
