package com.eduardomelo.EXPENSE_TRACKER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardomelo.EXPENSE_TRACKER.models.User;

public interface UserRepositorie extends JpaRepository<User, Long> {
    
}
