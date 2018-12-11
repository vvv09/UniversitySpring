package com.valunskii.university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valunskii.university.domain.Group;
import com.valunskii.university.domain.Schedule;
import com.valunskii.university.domain.Teacher;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    public List<Schedule> findAllByOrderByIdAsc();
    public List<Schedule> findByGroupOrderById(Group group);
    public List<Schedule> findByTeacherOrderById(Teacher teacher);
}
