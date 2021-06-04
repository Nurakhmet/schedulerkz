package kz.matanov.schedulerkz.repositories;

import kz.matanov.schedulerkz.entities.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Tasks, Long> {

    List<Tasks> findAllByToDateExp(Date date);
    List<Tasks> findAllByToDateExpAndUsers_Id(Date date, Long id);
    List<Tasks> findAllByUsers_Id(Long id);

}
