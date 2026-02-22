package com.ecommerce.domain.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDABOUser is a Querydsl query type for DABOUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDABOUser extends EntityPathBase<DABOUser> {

    private static final long serialVersionUID = -2011775541L;

    public static final QDABOUser dABOUser = new QDABOUser("dABOUser");

    public final StringPath bloodType = createString("bloodType");

    public final StringPath email = createString("email");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QDABOUser(String variable) {
        super(DABOUser.class, forVariable(variable));
    }

    public QDABOUser(Path<? extends DABOUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDABOUser(PathMetadata metadata) {
        super(DABOUser.class, metadata);
    }

}
