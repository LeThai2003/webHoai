package com.nhom29.Model.ERD;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String TenTag;

    @ManyToMany(mappedBy = "tag")
    private List<BaiDang> baiDang = new ArrayList<>();
    @Column( columnDefinition = "NTEXT")
    private String noidung;
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime thoigiantao;
}
