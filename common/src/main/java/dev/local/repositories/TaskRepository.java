package dev.local.repositories;

import dev.local.taskmgr.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByParticipantIdsContaining(String username);
    Page<Task> findByTaskListId(String taskListId, Pageable pageable);
    List<Task> findByTaskListId(String taskListId);
}
