package com.daliborstakic.rzk.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daliborstakic.rzk.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	@Query("select e from Expense e inner join e.user u where u.username = ?1")
	List<Expense> findByUsername(String username);

	@Query("select e from Expense e inner join e.user u where u.username = ?2 and e.idExpense = ?1")
	Optional<Expense> findByUsernameAndIdExpense(Integer idExpense, String username);

	@Query("SELECT e FROM Expense e inner join e.user u WHERE u.username = ?1 and MONTH(e.date) = ?2")
	List<Expense> getExpenseByMonth(String username, Integer month);

	@Query("SELECT e FROM Expense e " + "INNER JOIN e.user u " + "INNER JOIN e.category c "
			+ "WHERE u.username = ?2 AND c.idCategory = ?1")
	List<Expense> getExpensesByCategory(Integer idCategory, String username);
}
