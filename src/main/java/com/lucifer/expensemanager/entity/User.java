package com.lucifer.expensemanager.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/*
User Entity : Will manage user details and have a one to many relation to all the expenses
 */
@Entity
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.PRIVATE)
    private int id;

    @Column(nullable = false)
    @Getter
    private String name;

    @Column(nullable = false)
    @Getter
    private long monthlySalary;

    @OneToMany(mappedBy = "user",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Expense> expenses;

    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }

    public void removeExpense(Expense expense){
        this.expenses.remove(expense);
    }

    public User(){}
    public User(String name, long monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }
}
