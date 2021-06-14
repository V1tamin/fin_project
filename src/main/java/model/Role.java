package model;

import java.io.Serializable;

/**
 * @author Anton Lopatin on 28.05.2021
 */
public enum Role implements Serializable {
    ADMIN,
    MANAGER,
    CLIENT,
    GUEST
}
