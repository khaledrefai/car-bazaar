package com.syriabazaar.cars.domain;

import static com.syriabazaar.cars.domain.BrandTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.syriabazaar.cars.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BrandTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Brand.class);
        Brand brand1 = getBrandSample1();
        Brand brand2 = new Brand();
        assertThat(brand1).isNotEqualTo(brand2);

        brand2.setId(brand1.getId());
        assertThat(brand1).isEqualTo(brand2);

        brand2 = getBrandSample2();
        assertThat(brand1).isNotEqualTo(brand2);
    }
}
