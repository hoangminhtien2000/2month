package com.uuhnaut69.inventory.infrastructure.message.log;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {

  @Query(value = """
      SELECT EXISTS (SELECT 1 FROM message_log WHERE id = :messageId)
      """, nativeQuery = true)
  boolean isMessageProcessed(Long messageId);
}
