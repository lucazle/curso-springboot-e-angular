package com.barber.shop.api.activity;

import com.barber.shop.api.exception.NotFoundException;
import com.barber.shop.api.exception.ScheduleInUseException;
import com.barber.shop.api.model.Schedule;
import com.barber.shop.api.repository.ScheduleRepository;
import com.barber.shop.api.service.ScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class ScheduleQueryActivity implements ScheduleQueryService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public Schedule findById(long id) {
        return repository.findById(id).orElseThrow( () -> new NotFoundException("O agendamento não foi encontrado"));
    }

    @Override
    public List<Schedule> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyIfScheduleExists(OffsetDateTime startAt, OffsetDateTime endAt) {

//        if(repository.existsStartAtAndEndAt(startAt, endAt)) {
//
//            var message = "Já existe um agendamento no horário solicitado";
//            new ScheduleInUseException(message);
//        }

    }
}
