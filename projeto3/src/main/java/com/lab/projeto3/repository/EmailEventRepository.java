package com.lab.projeto3.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lab.projeto3.enums.EmailStatus;
import com.lab.projeto3.model.EmailEvent;


@Repository
public interface EmailEventRepository extends JpaRepository<EmailEvent, Long> {
    @Query("SELECT e FROM EmailEvent e WHERE e.status = :status OR e.status = com.lab.projeto3.enums.EmailStatus.FALHOU AND e.nextRetry <= :now ORDER BY e.nextRetry ASC")
    List<EmailEvent> findPendingEmails(
            @Param("status") EmailStatus status,
            @Param("now") LocalDateTime now,
            Pageable pageable);

    List<EmailEvent> findTop10ByStatusOrNextRetryBeforeOrderByNextRetryAsc(
            EmailStatus status, LocalDateTime date);
}
