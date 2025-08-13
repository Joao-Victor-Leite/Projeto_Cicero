package com.duende.cicero_app.repository.purpose;

import com.duende.cicero_app.model.purpose.PersonalPurposeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalPurposeRepository extends JpaRepository<PersonalPurposeModel, Long> {}
