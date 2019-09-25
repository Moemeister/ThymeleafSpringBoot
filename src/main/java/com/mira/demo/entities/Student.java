package com.mira.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "student_id_student_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "student_id_student_seq", sequenceName = "public.student_id_student_seq", allocationSize = 1)
    private int id_student;

    private String s_name;

    private String s_lname;

    private boolean b_active;

    private int s_age;
}
