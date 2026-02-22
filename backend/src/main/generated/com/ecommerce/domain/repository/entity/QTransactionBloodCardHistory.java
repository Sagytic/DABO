package com.ecommerce.domain.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTransactionBloodCardHistory is a Querydsl query type for TransactionBloodCardHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransactionBloodCardHistory extends EntityPathBase<TransactionBloodCardHistory> {

    private static final long serialVersionUID = -600651054L;

    public static final QTransactionBloodCardHistory transactionBloodCardHistory = new QTransactionBloodCardHistory("transactionBloodCardHistory");

    public final NumberPath<Long> bloodCardId = createNumber("bloodCardId", Long.class);

    public final NumberPath<Long> campaignId = createNumber("campaignId", Long.class);

    public final DatePath<java.time.LocalDate> transactionCardDate = createDate("transactionCardDate", java.time.LocalDate.class);

    public final NumberPath<Long> transactionCardFromId = createNumber("transactionCardFromId", Long.class);

    public final NumberPath<Long> transactionCardHistoryId = createNumber("transactionCardHistoryId", Long.class);

    public final StringPath transactionCardMessage = createString("transactionCardMessage");

    public final NumberPath<Long> transactionCardToId = createNumber("transactionCardToId", Long.class);

    public final StringPath userName = createString("userName");

    public QTransactionBloodCardHistory(String variable) {
        super(TransactionBloodCardHistory.class, forVariable(variable));
    }

    public QTransactionBloodCardHistory(Path<? extends TransactionBloodCardHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransactionBloodCardHistory(PathMetadata metadata) {
        super(TransactionBloodCardHistory.class, metadata);
    }

}
