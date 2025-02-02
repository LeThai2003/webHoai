package com.nhom29.Repository;

import com.nhom29.Model.ERD.BinhLuan;
import com.nhom29.Model.ERD.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("select t from Tag t where t.TenTag = :name")
    Optional<Tag> findTagByName(String name);

    @Query("select t from Tag t order by t.thoigiantao desc")
    List<Tag> layTagTheoNgayTaoMoiNhat();
}
