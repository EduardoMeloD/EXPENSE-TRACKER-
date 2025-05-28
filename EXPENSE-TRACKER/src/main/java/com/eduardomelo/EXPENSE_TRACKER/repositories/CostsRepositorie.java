package com.eduardomelo.EXPENSE_TRACKER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardomelo.EXPENSE_TRACKER.models.Costs;
import java.util.List;


public interface CostsRepositorie extends JpaRepository<Costs, Long> {
    
    List<Costs>  findByUser_Id(Long id);
}
