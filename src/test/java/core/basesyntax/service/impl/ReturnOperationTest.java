package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReturnOperationTest {
    private final OperationHandler returnOperation = new ReturnOperation();

    @BeforeEach
    void setUp() {
        Storage.putFruit("apple", 30);
    }

    @Test
    void handle_validReturn_Ok() {
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.RETURN, "apple", 15);
        returnOperation.handle(transaction);
        assertEquals(45, Storage.getFruitQuantity("apple"));
    }

    @AfterEach
    void tearDown() {
        Storage.clear();
    }
}
