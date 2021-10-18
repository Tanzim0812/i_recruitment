package com.example.i_recruitment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HR_IR_VCNCY")
public class vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String jobType;
    private LocalDate createDate;
    private int vcncyTot;
    private String spec;
    private boolean vcncMale;
    private boolean vcncFemale;
    private String addtnlReqrmnt;
    private LocalDate requiredWithin;
    private Long salMax;
    private Long salMin;
    private String jobNature;
    private String jobResponsibility;
    private String area;
    private boolean negotiable;
    private int noExperience;
    private boolean isActive;
    private String operatingUnit;
    private LocalDate crclrDate;
    private String relevantEducation;
    private String jobLocation;
    private String refNo;
    private boolean isOt;
    private int otHour;
    private String remarks;
    private int experienceMax;
    private int experienceMin;
    private String othersBenefit;
    private String status;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDate createAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDateTime;

    private Long entryBy;
    private Long updateBy;
    private Long appliedJobs;
    private Long shortListed;

}
