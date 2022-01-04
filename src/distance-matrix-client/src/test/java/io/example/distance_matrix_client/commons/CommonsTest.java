package io.example.distance_matrix_client.commons;

import static org.junit.jupiter.api.Assertions.*;

class CommonsTest {

    @org.junit.jupiter.api.Test
    void getVersionDate() {
        assertNotNull(Commons.getVersionDate());
    }

}