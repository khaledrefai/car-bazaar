package com.syriabazaar.cars.domain;

import static com.syriabazaar.cars.domain.SellerTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.syriabazaar.cars.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SellerTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Seller.class);
        Seller seller1 = getSellerSample1();
        Seller seller2 = new Seller();
        assertThat(seller1).isNotEqualTo(seller2);

        seller2.setId(seller1.getId());
        assertThat(seller1).isEqualTo(seller2);

        seller2 = getSellerSample2();
        assertThat(seller1).isNotEqualTo(seller2);
    }
}
