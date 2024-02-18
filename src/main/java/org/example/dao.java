package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class dao {

    private static final String sql = "SELECT * FROM ingredienser WHERE ingrediens LIKE ? LIMIT 10";

    public List<Suggestion> getSuggestions(String queryTerm)  {
        List<Suggestion> suggestions = new ArrayList<>();

        try (Connection connection = DBconnector.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)){
        pstmt.setString(1, "%" + queryTerm + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            String query = rs.getString("ingrediens");
            suggestions.add(new Suggestion(query));
        }

            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suggestions;}}

        /*
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, "%" + queryTerm + "%");)}}
          */
