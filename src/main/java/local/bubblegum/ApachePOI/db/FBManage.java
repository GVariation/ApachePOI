package local.bubblegum.ApachePOI.db;

import java.nio.file.Path;
import java.sql.*;
import java.util.List;

public class FBManage {
    private final static String __PREFIX = "jdbc:firebirdsql:localhost/3050:";
    private Connection connection = null;

    public FBManage() {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connect(Path path) {
        try {
            Path pathA = path.toAbsolutePath();
            String connectStr = __PREFIX + pathA.toString() + "?encoding=win1251";

            connection = DriverManager.getConnection(
                    connectStr,
                    "SYSDBA", "masterkey");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query, List<Object> params) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int idx = 1;
            setParamsToStatement(params, preparedStatement, idx);

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw e;
        }
    }

    public int executeUpdate(String query, List<Object> params) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int idx = 1;
            setParamsToStatement(params, preparedStatement, idx);

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Boolean execute(String query, List<Object> params) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int idx = 1;
            setParamsToStatement(params, preparedStatement, idx);
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    private int setParamsToStatement(List<Object> params, PreparedStatement preparedStatement, int idx) throws SQLException {
        if (params != null) {
            for (Object param : params) {
                if (param instanceof Integer) {
                    preparedStatement.setInt(idx, (int) param);
                    idx++;
                } else if (param instanceof Long) {
                    preparedStatement.setLong(idx, (Long) param);
                    idx++;
                } else if (param instanceof Boolean) {
                    preparedStatement.setBoolean(idx, (Boolean) param);
                    idx++;
                } else if (param instanceof Timestamp) {
                    preparedStatement.setTimestamp(idx, (Timestamp) param);
                    idx++;
                } else if (param instanceof String) {
                    preparedStatement.setString(idx, (String) param);
                    idx++;
                }
            }
        }
    return idx;
    }
}
