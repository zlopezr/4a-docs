package com.minsuite.minsuite.repositories;

import com.minsuite.minsuite.models.Account;
import com.minsuite.minsuite.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository <Account, String> { }
