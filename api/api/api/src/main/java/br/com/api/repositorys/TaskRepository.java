package br.com.api.repositorys;

import br.com.api.entitys.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM tasks where tasks.user_id = :user_id", nativeQuery = true)
    Page<Task> findAll(Pageable pageable, Long user_id);
}
