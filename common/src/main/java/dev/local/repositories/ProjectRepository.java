package dev.local.repositories;

import dev.local.taskmgr.domain.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wangpeng on 2017/4/19.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    @Query("{'memberIds': ?#{[0]}, 'enabled': ?#{[1]}, 'archived': ?#{[2]}}")
    Page<Project> findRelated(String userId, boolean enabled, boolean archived, Pageable pageable);
//    Page<Project> findByMembersContainingAndEnabledAndArchived(User user, boolean enabled, boolean archived, Pageable pageable);
}
