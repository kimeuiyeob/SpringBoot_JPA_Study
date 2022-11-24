package com.example.advanced.entity;

import com.example.advanced.mapper.TimeMapper;
import com.example.advanced.repository.OwnerRepository;
import com.example.advanced.repository.PetRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import static com.example.advanced.entity.QOwner.*;
import static com.example.advanced.entity.QPet.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class HospitalPetTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void saveTest(){
//        Owner owner = new Owner();
//        Pet pet1 = new Pet();
//        Pet pet2 = new Pet();
//
//        owner.setOwnerName("한동석");
//        owner.setOwnerPhone("01012341234");
//
//        ownerRepository.save(owner);
//
//        pet1.setPetName("Tom");
//        pet1.setPetGender("Male");
//        pet1.setPetDisease("Cold");
//        pet1.setOwner(owner);
//
//        pet2.setPetName("Jack");
//        pet2.setPetGender("Male");
//        pet2.setPetDisease("Fracture");
//        pet2.setOwner(owner);
//
//        petRepository.save(pet1);
//        petRepository.save(pet2);

        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        Pet pet3 = new Pet();
        Pet pet4 = new Pet();

        owner1.setOwnerName("한동석");
        owner1.setOwnerPhone("01012341234");
        owner2.setOwnerName("홍길동");
        owner2.setOwnerPhone("01056785678");

        ownerRepository.save(owner1);
        ownerRepository.save(owner2);

        pet1.setPetName("Tom");
        pet1.setPetGender("Male");
        pet1.setPetDisease("Cold");
        pet1.setOwner(owner1);

        pet2.setPetName("Jack");
        pet2.setPetGender("Male");
        pet2.setPetDisease("Fracture");
        pet2.setOwner(owner1);

        petRepository.save(pet1);
        petRepository.save(pet2);

        pet3.setPetName("Bell");
        pet3.setPetGender("Female");
        pet3.setPetDisease("Cold");
        pet3.setOwner(owner2);

        pet4.setPetName("Lora");
        pet4.setPetGender("Female");
        pet4.setPetDisease("Cold");
        pet4.setOwner(owner2);

        petRepository.save(pet3);
        petRepository.save(pet4);
    }

    @Test
    public void findTest(){
        Optional<Pet> findPet = petRepository.findById(2L);
        if(findPet.isPresent()){
            assertThat(findPet.get().getPetName()).isEqualTo("Tom");
//            기존에 연관객체를 필드로 가지고 있는 객체를 조회할 경우
//            지연 로딩으로 설정했다면, 필드에 있는 연관객체에는 Proxy가 주입된다.
//            이 때 최초 Proxy는 원본 객체를 상속받고 필드도 그대로 가지고 있다.
//            하지만, ID값만 들어가고 나머지 필드는 NULL로 되어 있고,
//            ID외에 다른 필드를 조회할 때 새로운 쿼리가 발생된다.

//            entityManager.flush();
//            entityManager.clear();

//            영속성 컨텍스트를 비우면 매핑 정보를 가지고 있던 객체가 없어지므로,
//            더 이상 필드에 있던 연관객체 조회 시 Proxy에 있던 ID를 제외한 다른 필드 조회가 불가능해진다.
//            log.info("owner id: " + findPet.get().getOwner().getOwnerId());
            log.info("owner phone: " + findPet.get().getOwner().getOwnerPhone());
            log.info("owner: " + findPet.get().getOwner().getClass());
        }
    }

    @Test
    public void updateTest(){
        petRepository.findAll().get(0).getOwner().setOwnerName("Lazy Kim");
    }

    @Test
    public void manyToOneBothWaysTest(){
//        반려동물 이름으로 찾은 주인의 전체 반려동물 찾기
//        List<Pet> pets = petRepository.findByPetName("Tom");
//        pets.get(0).getOwner().getPets().stream().map(Pet::getPetName).forEach(log::info);

//        N + 1 문제 발생
//        조회하는 개수만큼 쿼리가 실행
        List<Pet> pets = petRepository.findAll();
        for (Pet pet : pets) {
            log.info("pet name: " + pet.getPetName());
            log.info("owner: " + pet.getOwner().getClass());
            log.info("owner name: " + pet.getOwner().getOwnerName());
        }
    }

    @Test
    public void getTimeTest(){
        log.info("now: " + petRepository.getTime());
    }

    @Test
    public void findByGenderTest(){
        assertThat(petRepository.findByGender("Male")).extracting("petName").containsExactly("Tom", "Jack");
        assertThat(petRepository.findByGender("Male")).extracting("petName").contains("Tom");
        assertThat(petRepository.findByGender("Male")).extracting("petName").contains("Jack");
    }

    @Test
    public void queryDslTest(){
        for (int i=0; i<100; i++){
            Owner owner = new Owner();
            owner.setOwnerName("홍길동");
            owner.setOwnerPhone(i + 1 + "");
            ownerRepository.save(owner);
        }

        //화면에서 파라미터로 받기
        Pageable pageable = PageRequest.of(1, 10);

        List<Owner> owners = jpaQueryFactory.selectFrom(owner)
                .where(owner.ownerName.eq("홍길동"))
                .orderBy(owner.ownerId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = jpaQueryFactory.selectFrom(owner)
                .where(owner.ownerName.eq("홍길동"))
                .fetch().size();

        Page<Owner> ownerPaging = new PageImpl<>(owners, pageable, total);
        ownerPaging.getTotalPages(); // 전체 페이지 개수
        ownerPaging.getNumber(); // 현재 페이지

        ownerPaging.isFirst();
        ownerPaging.isLast();

        ownerPaging.getContent().stream().map(Owner::toString).forEach(log::info);
    }

    @Test
    public void queryDslTest2(){
//        jpaQueryFactory.select(
//                owner.count(),
//                owner.ownerName.max(),
//                owner.ownerId.avg(),
//                owner.ownerId.sum())
//                .from(owner)
//                .fetch();

        List<Pet> fetchJoin = jpaQueryFactory.selectFrom(pet).join(pet.owner).fetchJoin().fetch();
    }

    @Test
    public void 말도안되는동적쿼리(){
        for (int i=0; i<100; i++){
            Owner owner = new Owner();
            owner.setOwnerName(i % 2 == 0 ? "홍길동" : "한동석");
            owner.setOwnerPhone(i + 1 + "");
            owner.setOwnerAge(i + 1);
            ownerRepository.save(owner);
        }
        Search search = new Search();
        search.setName("홍길동");
        assertThat(ownerRepository.findAllSearch(search).size()).isEqualTo(10);
    }

}






















