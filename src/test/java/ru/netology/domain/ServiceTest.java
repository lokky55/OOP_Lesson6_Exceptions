package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    CartRepository repo = new CartRepository();
    PurchaseItem first = new PurchaseItem(101, 1, "first", 100, 2);
    PurchaseItem second = new PurchaseItem(222, 2, "second", 10, 1);
    PurchaseItem third = new PurchaseItem(30, 3, "third", 1, 2);

    @Test
    public void shouldRemoveById() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(222);
        PurchaseItem[] actual = repo.findAll();
        PurchaseItem[] expected = {first, third};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveMessageIfRemoveIncorrectId() {
        repo.save(first);
        repo.save(second);
        repo.save(third);


        Assertions.assertThrows(NegativeIdException.class, () -> {
            repo.removeById(-222);
        } );

    }
}
