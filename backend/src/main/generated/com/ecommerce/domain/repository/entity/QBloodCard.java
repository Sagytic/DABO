package com.ecommerce.domain.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBloodCard is a Querydsl query type for BloodCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBloodCard extends EntityPathBase<BloodCard> {

    private static final long serialVersionUID = 1222354292L;

    public static final QBloodCard bloodCard = new QBloodCard("bloodCard");

    public final NumberPath<Long> bloodCardId = createNumber("bloodCardId", Long.class);

    public final StringPath bloodCardNumber = createString("bloodCardNumber");

    public final StringPath bloodHouse = createString("bloodHouse");

    public final DatePath<java.time.LocalDate> donationDate = createDate("donationDate", java.time.LocalDate.class);

    public final StringPath donationType = createString("donationType");

    public final DatePath<java.time.LocalDate> userBirth = createDate("userBirth", java.time.LocalDate.class);

    public final StringPath userGender = createString("userGender");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userName = createString("userName");

    public QBloodCard(String variable) {
        super(BloodCard.class, forVariable(variable));
    }

    public QBloodCard(Path<? extends BloodCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBloodCard(PathMetadata metadata) {
        super(BloodCard.class, metadata);
    }

}
