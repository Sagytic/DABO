package com.ecommerce.domain.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = -1632201066L;

    public static final QReservation reservation = new QReservation("reservation");

    public final StringPath address = createString("address");

    public final StringPath bloodDate = createString("bloodDate");

    public final StringPath bloodTime = createString("bloodTime");

    public final StringPath bloodType = createString("bloodType");

    public final StringPath housename = createString("housename");

    public final NumberPath<Long> reservationId = createNumber("reservationId", Long.class);

    public final StringPath telephone = createString("telephone");

    public QReservation(String variable) {
        super(Reservation.class, forVariable(variable));
    }

    public QReservation(Path<? extends Reservation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservation(PathMetadata metadata) {
        super(Reservation.class, metadata);
    }

}
