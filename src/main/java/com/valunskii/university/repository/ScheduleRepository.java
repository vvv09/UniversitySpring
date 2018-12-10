package com.valunskii.university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valunskii.university.domain.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    public List<Schedule> findAllByOrderByIdAsc();
}
