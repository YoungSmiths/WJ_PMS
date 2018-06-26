package com.wj.pms.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBSchemaCollector {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBSchemaCollector.class);

    public static String getVersionContentByJdbcUrl(String jdbcUrl) {
        LOGGER.info("{}: begin to get db schema from jdbc url.", jdbcUrl);
        JDBCUtils.driver(JDBCUtils.mysqlDriver);
        JDBCUtils.driver(JDBCUtils.oracleDriver);
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection(jdbcUrl);
            LOGGER.info("{}: get connection ok.", jdbcUrl);
            List<String> tableNamePatternList = new ArrayList<>();
            if (jdbcUrl.contains("oracle")) {
                tableNamePatternList.add("SP_PD_OTICKET%");
                tableNamePatternList.add("SP_PD_WTICKET%");
                tableNamePatternList.add("SP_SO_OUTAGE%");
            } else {
                tableNamePatternList.add(null);
            }
            return DBSchemaCollector.computeVersionContent(connection, tableNamePatternList);
        } catch (Exception e) {
            LOGGER.error("Create database connection by url={} has error:", jdbcUrl, e);
            return null;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error("Jdbc connection={} for url={} close error:", connection, jdbcUrl, e);
                }
            }
        }
    }

    private static String computeVersionContent(Connection conn, List<String> tableNamePatternList) {
        LOGGER.info("{}: begin to get database schemas.", conn);
        StringBuilder sb = new StringBuilder();
        ResultSet tables = null;
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            for (String tableNamePattern : tableNamePatternList) {
                tables = metaData.getTables(null, null, tableNamePattern, null);
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    String tableSchema = tables.getString("TABLE_SCHEM");
                    String tableType = tables.getString("TABLE_TYPE");
                    sb.append("tableName=" + tableName + "\t");
                    sb.append("tableSchema=" + tableSchema + "\t");
                    sb.append("tableType=" + tableType + "\t");
                    sb.append("\n");
                    LOGGER.debug("{}: begin to get schema for table={}", conn, tableName);
                    ResultSet columns = metaData.getColumns(null, "%", tableName, "%");
                    try {
                        while (columns.next()) {
                            String columnName = columns.getString("COLUMN_NAME");
                            String datatype = columns.getString("TYPE_NAME");
                            int datasize = columns.getInt("COLUMN_SIZE");
                            int nullable = columns.getInt("NULLABLE");
                            sb.append("\t" + columnName);
                            sb.append("\t" + datatype);
                            sb.append("\t" + datasize);
                            sb.append("\t" + nullable + "\n");
                        }
                    } catch (SQLException e) {
                        sb.append("#Obtain schema for table=").append(tableName).append(" failed.");
                    } finally {
                        columns.close();
                    }
                    sb.append("\n");
                }
                tables.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Get Version Content has error: ", e);
        } finally {
            if (tables != null) {
                try {
                    tables.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        LOGGER.debug("the Version Content is: {}", sb);
        return sb.toString();
    }

}
