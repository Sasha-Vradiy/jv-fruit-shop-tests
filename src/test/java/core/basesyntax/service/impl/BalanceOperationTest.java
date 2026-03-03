package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class BalanceOperationTest {
    private final OperationHandler balanceOperation = new BalanceOperation();

    @Test
    void handle_validTransaction_Ok() {
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "banana", 100);
        balanceOperation.handle(transaction);
        int actualQuantity = Storage.getFruitQuantity("banana");
        assertEquals(100, actualQuantity);
    }

    @AfterEach
    void tearDown() {
        Storage.clear();
    }
}
