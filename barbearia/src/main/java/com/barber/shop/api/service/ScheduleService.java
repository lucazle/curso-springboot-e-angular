package com.barber.shop.api.service;
import com.barber.shop.api.model.Schedule;

import java.time.OffsetDateTime;
import java.util.List;

public interface ScheduleService {

    Schedule save(final Schedule schedule);

    void delete(final long id);

    List<Schedule> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);
    
}
