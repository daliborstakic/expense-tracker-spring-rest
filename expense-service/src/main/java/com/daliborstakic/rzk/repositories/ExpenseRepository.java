package com.daliborstakic.rzk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daliborstakic.rzk.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
