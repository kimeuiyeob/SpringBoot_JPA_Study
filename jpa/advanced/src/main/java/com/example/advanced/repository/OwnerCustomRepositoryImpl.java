package com.example.advanced.repository;

import com.example.advanced.entity.Owner;
import com.example.advanced.entity.OwnerDTO;
import com.example.advanced.entity.QOwnerDTO;
import com.example.advanced.entity.Search;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.advanced.entity.QOwner.owner;

@Repository
@RequiredArgsConstructor
public class OwnerCustomRepositoryImpl implements OwnerCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Owner> findAllByOwnerName(Pageable pageable) {

        List<Owner> owners = queryFactory.selectFrom(owner)
                .where(owner.ownerName.eq("홍길동"))
                .orderBy(owner.ownerId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.selectFrom(owner)
                .where(owner.ownerName.eq("홍길동"))
                .fetch().size();

        return new PageImpl<>(owners, pageable, total);
    }

    @Override
    public List<OwnerDTO> findAllByOwnerName(String ownerName) {
//        return queryFactory.select(Projections.constructor(OwnerDTO.class,
//                owner.ownerId,
//                owner.ownerName,
//                owner.ownerPhone
//        )).from(owner)
//                .where(owner.ownerName.eq("홍길동"))
//                .fetch();
        return queryFactory.select(new QOwnerDTO(
                owner.ownerId,
                owner.ownerName,
                owner.ownerPhone,
                owner.ownerAge
        )).from(owner)
                .where(owner.ownerName.eq("홍길동"))
                .fetch();
    }

    @Override
    public List<OwnerDTO> findAllSearch(Search search) {
        return queryFactory.select(new QOwnerDTO(owner.ownerId, owner.ownerName, owner.ownerPhone, owner.ownerAge))
                .from(owner)
                .where(
                        nameEqOrAgeLoe(search.getName(), search.getAge()))
                .fetch();
    }

    private BooleanExpression nameEq(String name){
        return StringUtils.hasText(name) ? owner.ownerName.eq(name) : null;
    }

    private BooleanExpression ageLoe(Integer age){
        return age != null ? owner.ownerAge.loe(age) : null;
    }

    private BooleanExpression nameEqOrAgeLoe(String name, Integer age){
        return nameEq(name).or(ageLoe(age));
    }

    private BooleanExpression nameEqAndAgeLoe(String name, Integer age){
        return nameEq(name).and(ageLoe(age));
    }
}
















