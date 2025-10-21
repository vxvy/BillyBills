package vxvy.billy_bills.infraestructure.adapters.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import vxvy.billy_bills.domain.service.TransactionManager;

@Component
public class SpringTransactionManagerAdapter implements TransactionManager {

    private final PlatformTransactionManager platformTransactionManager;

    public SpringTransactionManagerAdapter(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    @Override
    public <T> T executeInTransaction(TransactionCallback<T> callback) {
        TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            T result = callback.doInTransaction();
            platformTransactionManager.commit(status);
            return result;
        } catch (Exception e) {
            platformTransactionManager.rollback(status);
            throw new RuntimeException("Transaction failed", e);
        }
    }

    @Override
    public void executeInTransaction(Runnable action) {
        executeInTransaction(() -> {
            action.run();
            return null;
        });
    }
}