package com.dfive.studentapp.repository;

import com.dfive.studentapp.entity.PublicNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicNoticeRepository extends JpaRepository<PublicNotice,Long> {
}
