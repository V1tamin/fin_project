package dao;

import model.Account;

import java.util.List;
import java.util.Optional;

/**
 * @author Anton Lopatin on 28.05.2021
 */
public interface IAccountDAO {
    Optional<Account> findByName(String name);
    Optional<Account> findById(String  id);
    boolean deleteByName(String name);
    boolean deleteById(String  id);
}
