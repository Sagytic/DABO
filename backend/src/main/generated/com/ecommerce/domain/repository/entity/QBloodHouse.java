package com.ecommerce.domain.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBloodHouse is a Querydsl query type for BloodHouse
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBloodHouse extends EntityPathBase<BloodHouse> {

    private static final long serialVersionUID = -756684484L;

    public static final QBloodHouse bloodHouse = new QBloodHouse("bloodHouse");

    public final StringPath address = createString("address");

    public final NumberPath<Long> bloodHouseId = createNumber("bloodHouseId", Long.class);

    public final StringPath housename = createString("housename");

    public final StringPath net = createString("net");

    public final StringPath telephone = createString("telephone");

    public QBloodHouse(String variable) {
        super(BloodHouse.class, forVariable(variable));
    }

    public QBloodHouse(Path<? extends BloodHouse> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBloodHouse(PathMetadata metadata) {
        super(BloodHouse.class, metadata);
    }

}
