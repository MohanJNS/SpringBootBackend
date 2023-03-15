package com.dfive.studentapp.service.Impl;

import com.dfive.studentapp.entity.PublicNotice;
import com.dfive.studentapp.repository.PublicNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicNoticeService {


    @Autowired
    private PublicNoticeService noticeService;
    @Autowired
    private PublicNoticeRepository noticeRepository;


    public PublicNotice addNotice(PublicNotice notice) {
        return noticeRepository.save(notice);
    }

    public Optional<PublicNotice> getNoticeById(Long id) {return noticeRepository.findById(id);
    }

    public List<PublicNotice> getNotices() {return noticeRepository.findAll();
    }

    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    public PublicNotice updateNotice(PublicNotice notice) {
        return noticeRepository.save(notice);
    }
}
