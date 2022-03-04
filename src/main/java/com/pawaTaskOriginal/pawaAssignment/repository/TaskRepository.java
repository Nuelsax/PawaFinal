package com.pawaTaskOriginal.pawaAssignment.repository;

import com.pawaTaskOriginal.pawaAssignment.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Long> {

}