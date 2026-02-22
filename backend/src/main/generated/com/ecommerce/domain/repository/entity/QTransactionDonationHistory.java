package com.ecommerce.domain.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTransactionDonationHistory is a Querydsl query type for TransactionDonationHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransactionDonationHistory extends EntityPathBase<TransactionDonationHistory> {

    private static final long serialVersionUID = 1371421146L;

    public static final QTransactionDonationHistory transactionDonationHistory = new QTransactionDonationHistory("transactionDonationHistory");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final NumberPath<Long> campaignId = createNumber("campaignId", Long.class);

    public final StringPath contractAddress = createString("contractAddress");

    public final DatePath<java.time.LocalDate> created_at = createDate("created_at", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath state = createString("state");

    public final StringPath transactionDonationFromAddress = createString("transactionDonationFromAddress");

    public final StringPath transactionDonationToAddress = createString("transactionDonationToAddress");

    public QTransactionDonationHistory(String variable) {
        super(TransactionDonationHistory.class, forVariable(variable));
    }

    public QTransactionDonationHistory(Path<? extends TransactionDonationHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransactionDonationHistory(PathMetadata metadata) {
        super(TransactionDonationHistory.class, metadata);
    }

}
