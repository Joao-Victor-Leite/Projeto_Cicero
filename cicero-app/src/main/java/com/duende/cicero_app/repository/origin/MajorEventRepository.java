package com.duende.cicero_app.repository.origin;

import com.duende.cicero_app.model.origin.MajorEventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorEventRepository extends JpaRepository <MajorEventModel, Long> {}
