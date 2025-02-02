package com.nhom29.Model.ERD;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ThongTin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "varchar(255)")
    private String Email;
    @Column(columnDefinition = "nvarchar(100)")
    private String Ho;
    @Column(columnDefinition = "nvarchar(100)", nullable = false)
    private String Ten;
    @Column(columnDefinition = "nvarchar(255)")
    private String Truong;
    @Column(columnDefinition = "varchar(10)")
    private String Sdt;
    @Column(name = "AnhDaiDien", columnDefinition = "TEXT")
    private String anhDaiDien;
    @Column(columnDefinition = "nvarchar(500)", nullable = true)
    private String GioiThieu;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TaiKhoan_ThongTin")
    private TaiKhoan_ThongTin taiKhoanThongTin;
    @Column(columnDefinition = "varchar(20)")
    private String providerId;
    @ManyToMany(mappedBy = "luu", cascade = CascadeType.ALL)
    private List<BaiDang> baiDang_Luu = new ArrayList<>();
    @ManyToMany(mappedBy = "like", cascade = CascadeType.ALL)
    private List<BaiDang> baiDang_Like = new ArrayList<>();
    @OneToMany(mappedBy = "thongTin", fetch = FetchType.EAGER)
    private List<BaiDang> baiDangs = new ArrayList<>();
}
