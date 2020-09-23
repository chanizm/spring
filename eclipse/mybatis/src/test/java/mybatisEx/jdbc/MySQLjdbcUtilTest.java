package mybatisEx.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
public class MySQLjdbcUtilTest {
static final Logger log = LogManager.getLogger();
@Test
public void testConnection() throws SQLException {
Connection conn = MySQLJdbcUtil.getConnection();
log.trace(String.format("Connected to database %s " + "successfully.", conn.getCatalog()));
Assert.assertNotNull(conn);
}
}
