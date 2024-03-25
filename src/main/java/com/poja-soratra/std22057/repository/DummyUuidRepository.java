package com.poja-soratra.std22057.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.poja-soratra.std22057.PojaGenerated;
import com.poja-soratra.std22057.repository.model.DummyUuid;

@PojaGenerated
@Repository
public interface DummyUuidRepository extends JpaRepository<DummyUuid, String> {

  @Override
  Optional<DummyUuid> findById(String id);
}
