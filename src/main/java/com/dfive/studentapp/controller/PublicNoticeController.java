package com.dfive.studentapp.controller;


import com.dfive.studentapp.entity.PublicNotice;
import com.dfive.studentapp.service.Impl.PublicNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/public_notices")
public class PublicNoticeController {


    @Autowired
    private PublicNoticeService publicNoticeService;


    @GetMapping("/{noticeId}")
    public ResponseEntity<PublicNotice> getNoticeById(@PathVariable("noticeId") Long noticeId) {
        Optional<PublicNotice> noticeOptional = this.publicNoticeService.getNoticeById(noticeId);
        if (noticeOptional.isPresent()) {
            return ResponseEntity.ok(noticeOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<PublicNotice> addNotice(@RequestBody PublicNotice notice) {
        PublicNotice notice1 = this.publicNoticeService.addNotice(notice);
        return ResponseEntity.ok(notice1);
    }


    @GetMapping("/")
    public ResponseEntity<?> getNotices() {
        return ResponseEntity.ok(this.publicNoticeService.getNotices());
    }

    @DeleteMapping("/{noticeId}")
    public void deleteNotice(@PathVariable("noticeId") Long noticeId) {
        this.publicNoticeService.deleteNotice(noticeId);

    }

    @PatchMapping("/{noticeId}")
    public ResponseEntity<PublicNotice> patchStudent(@PathVariable("noticeId") Long noticeId, @RequestBody PublicNotice updatedNotice) {
        Optional<PublicNotice> existingNoticeOptional = this.publicNoticeService.getNoticeById(noticeId);
        if (existingNoticeOptional.isPresent()) {
            PublicNotice existingNotice = existingNoticeOptional.get();
            existingNotice.setId(updatedNotice.getId());
            existingNotice.setMessage(updatedNotice.getMessage());
            existingNotice.setTitle(updatedNotice.getTitle());

            PublicNotice savedNotice = this.publicNoticeService.addNotice(existingNotice);
            return ResponseEntity.ok(savedNotice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{noticeId}")
    public PublicNotice updateNotice(@PathVariable Long noticeId, @RequestBody PublicNotice notice) {
        notice.setId(noticeId);
        return this.publicNoticeService.updateNotice(notice);
    }
}