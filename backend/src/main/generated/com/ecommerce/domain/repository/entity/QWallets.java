package com.ecommerce.domain.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWallets is a Querydsl query type for Wallets
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWallets extends EntityPathBase<Wallets> {

    private static final long serialVersionUID = 435057508L;

    public static final QWallets wallets = new QWallets("wallets");

    public final StringPath address = createString("address");

    public final NumberPath<Long> balance = createNumber("balance", Long.class);

    public final NumberPath<Long> cash = createNumber("cash", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> ownerId = createNumber("ownerId", Long.class);

    public final NumberPath<Long> payBalance = createNumber("payBalance", Long.class);

    public final NumberPath<Integer> receivingCount = createNumber("receivingCount", Integer.class);

    public QWallets(String variable) {
        super(Wallets.class, forVariable(variable));
    }

    public QWallets(Path<? extends Wallets> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWallets(PathMetadata metadata) {
        super(Wallets.class, metadata);
    }

}
