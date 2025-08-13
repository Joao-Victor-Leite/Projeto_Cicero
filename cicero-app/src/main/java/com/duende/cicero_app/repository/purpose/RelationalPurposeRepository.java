package com.duende.cicero_app.repository.purpose;

import com.duende.cicero_app.model.purpose.RelationalPurposeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationalPurposeRepository extends JpaRepository <RelationalPurposeModel, Long> {}
