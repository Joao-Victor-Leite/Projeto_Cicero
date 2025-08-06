package com.duende.cicero_app.repository;

import com.duende.cicero_app.model.origin.OriginModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OriginRepository extends JpaRepository <OriginModel, Long>{}
