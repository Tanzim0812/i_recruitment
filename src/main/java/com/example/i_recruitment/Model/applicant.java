package com.example.i_recruitment.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "HR_IR_APLC")
public class applicant {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String firstNameBng;
    private String middleName;
    private String middleNameBng;
    private String lastname;
    private String lastNameBng;
    private String nickName;
    private String nickNameBng;
    private String fatherName;
    private String fatherNameBng;
    private String motherName;
    private String motherNameBng;
    private String spouseName;
    private String spouseNameBng;
    private String careerSummary;
    private String title;
    private String titleBng;
    private String nationalIdentityNumber;
    private int experienceYear;
    private String objective;
    private String tinNumber;
    private String presentAddress;
    private String permanentAddress;
    private Long salCurr;
    private Long salExpected;
    private LocalDate dob;
    private LocalDate lastLoginDate;
    private String cv;
    private String pic;
    private String cvFileTitle;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDate createDate;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDateTime;


    private Long USER_ID;
    private Long alkpBloodGrp;
    private Long appliedJobs;
    private Long shortListed;
}
