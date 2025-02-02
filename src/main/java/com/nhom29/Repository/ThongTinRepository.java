package com.nhom29.Repository;

import com.nhom29.Model.ERD.ThongTin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThongTinRepository extends JpaRepository<ThongTin, Long> {
    @Query("select t from ThongTin t where t.Email = :email")
    Optional<ThongTin> findByEmail(String email);
    @Query("select t from ThongTin t where t.taiKhoanThongTin.taiKhoan.username = :username")
    Optional<ThongTin> findByUsername(String username);
}


