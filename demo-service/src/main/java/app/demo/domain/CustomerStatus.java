package app.demo.domain;

import core.framework.db.DBEnumValue;

/**
 * @author Ethan
 */
public enum CustomerStatus {
    @DBEnumValue("ACTIVE")
    ACTIVE,
    @DBEnumValue("INACTIVE")
    INACTIVE
}
