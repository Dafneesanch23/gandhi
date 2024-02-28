package com.bookstore.gandhi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.gandhi.models.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
