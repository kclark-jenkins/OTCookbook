package org.krisbox.cookbook.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ConnectionDetailsDao extends CrudRepository<ConnectionDetails, Long> {
    List<ConnectionDetails> findByUsernameAndVolume(String username, String volume);
    Long deleteByUsernameAndVolume(String username, String volume);
}