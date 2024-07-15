package exceptions;

import java.sql.SQLException;

public class DatabaseException extends SQLException {
    public DatabaseException(Throwable cause) {
        super(cause);
    }

    public DatabaseException(String message) {
        super(message);
    }
}
