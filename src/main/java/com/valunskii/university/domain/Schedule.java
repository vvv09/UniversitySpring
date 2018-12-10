package com.valunskii.university.domain;

import java.io.Serializable;
import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="schedule")
@Getter
@Setter
public class Schedule implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    @Enumerated(EnumType.STRING)
    private Parity parity;
    @Enumerated(EnumType.STRING)
    private Lesson lesson;
    
    public Schedule() {

    }
    
    public Schedule(Subject subject, Group group, Teacher teacher, Classroom classroom, DayOfWeek dayOfWeek,
            Parity parity, Lesson lesson) {
        this.subject = subject;
        this.group = group;
        this.teacher = teacher;
        this.classroom = classroom;
        this.dayOfWeek = dayOfWeek;
        this.parity = parity;
        this.lesson = lesson;
    }
}
