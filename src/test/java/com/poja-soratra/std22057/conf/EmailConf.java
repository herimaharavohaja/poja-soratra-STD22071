package com.poja-soratra.std22057.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import com.poja-soratra.std22057.PojaGenerated;

@PojaGenerated
public class EmailConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.ses.source", () -> "dummy-ses-source");
  }
}
