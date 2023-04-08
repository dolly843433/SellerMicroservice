package com.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seller.entity.Model;



public interface Repository extends JpaRepository <Model, String>  {

}
