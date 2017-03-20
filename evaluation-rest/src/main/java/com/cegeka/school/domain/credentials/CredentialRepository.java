package com.cegeka.school.domain.credentials;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Named
public class CredentialRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Credential> getAllCredentials() throws NoResultException {
        return entityManager.createQuery("select c from Credential c" , Credential.class).getResultList();
    }

    public void addCredential(Credential credential) throws PersistenceException {
        entityManager.persist(credential);
    }

    public Credential getCredentialById(int id) throws NoResultException {
        return entityManager.createQuery("select c from Credential c where credential_id="+id , Credential.class).getSingleResult();
    }
}
