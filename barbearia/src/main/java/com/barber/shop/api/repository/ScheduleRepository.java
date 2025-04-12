package com.barber.shop.api.repository;

import com.barber.shop.api.model.Client;
import com.barber.shop.api.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt
    );

    boolean existsByStartAtAndEndAt(final OffsetDateTime startAt, final OffsetDateTime endAt);


}
