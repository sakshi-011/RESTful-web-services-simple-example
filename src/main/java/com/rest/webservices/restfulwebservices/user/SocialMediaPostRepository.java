package com.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaPostRepository extends JpaRepository<SocialMediaPost, Integer> {


}
