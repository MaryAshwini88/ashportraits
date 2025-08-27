package com.ash.portraits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ash.portraits.model.PortraitDetail;

@Repository
public interface PortraitsRepository extends JpaRepository<PortraitDetail, String> {
	
}