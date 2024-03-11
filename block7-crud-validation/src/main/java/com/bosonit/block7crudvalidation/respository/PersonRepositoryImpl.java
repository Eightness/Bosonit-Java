/**
 * @author Albert Lozano Blasco
 * @version 12.0
 */

package com.bosonit.block7crudvalidation.respository;

import com.bosonit.block7crudvalidation.controller.dto.mappers.PersonMapper;
import com.bosonit.block7crudvalidation.controller.dto.outputDto.PersonOutputDto;
import com.bosonit.block7crudvalidation.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * PersonRepositoryImpl class. If we end a class' name by "Impl", Spring automatically will implement its methods
 * within the class with the same name (without Impl).
 * We'll use this class to implement the custom method "getData" so we can call it from "PersonRepository" directly.
 */
public class PersonRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PersonMapper personMapper;

    public List<PersonOutputDto> getCustomPersons(HashMap<String, Object> conditions) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field, value) -> {
            switch (field) {
                case "login", "name", "surname":
                    predicates.add(criteriaBuilder.like(root.get(field), "%" + (String)value + "%"));
                    break;
                case "createdDate":
                    boolean newer = (boolean) conditions.get("newer");
                    if (newer) {
                        predicates.add(criteriaBuilder.greaterThan(root.<Date>get(field), (Date)value));
                    } else {
                        predicates.add(criteriaBuilder.lessThan(root.<Date>get(field), (Date)value));
                    }
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        if ((boolean) conditions.get("orderedBy")) {
            query.orderBy(criteriaBuilder.asc(root.get("login")));
        } else {
            query.orderBy(criteriaBuilder.asc(root.get("name")));
        }

        int pageNumber = (int) conditions.getOrDefault("pageNumber", 1);
        int pageSize = (int) conditions.getOrDefault("pageSize", 10);

        int firstResult = (pageNumber - 1) * pageSize;

        List<Person> resultList = entityManager.createQuery(query)
                .setFirstResult(firstResult)
                .setMaxResults(pageSize)
                .getResultList();

        return personMapper.domainToOutput(resultList);
    }
}
