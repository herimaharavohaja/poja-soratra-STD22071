package com.poja-soratra.std22057.service.event;

import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.poja-soratra.std22057.PojaGenerated;
import com.poja-soratra.std22057.endpoint.event.gen.UuidCreated;
import com.poja-soratra.std22057.repository.DummyUuidRepository;
import com.poja-soratra.std22057.repository.model.DummyUuid;

@PojaGenerated
@Service
@AllArgsConstructor
@Slf4j
public class UuidCreatedService implements Consumer<UuidCreated> {

  private final DummyUuidRepository dummyUuidRepository;

  @Override
  public void accept(UuidCreated uuidCreated) {
    var dummyUuid = new DummyUuid();
    dummyUuid.setId(uuidCreated.getUuid());
    dummyUuidRepository.save(dummyUuid);
  }
}
