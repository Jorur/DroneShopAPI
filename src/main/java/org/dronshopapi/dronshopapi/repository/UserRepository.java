package org.dronshopapi.dronshopapi.repository;

import org.dronshopapi.dronshopapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
