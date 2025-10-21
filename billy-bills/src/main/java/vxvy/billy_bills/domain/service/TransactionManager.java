package vxvy.billy_bills.domain.service;

public interface TransactionManager {
    <T> T executeInTransaction(TransactionCallback<T> callback);
    void executeInTransaction(Runnable action);

    @FunctionalInterface
    interface TransactionCallback<T> {
        T doInTransaction();
    }
}