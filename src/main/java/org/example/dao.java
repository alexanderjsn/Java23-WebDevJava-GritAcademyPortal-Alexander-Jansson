package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class dao {

    private static final String sql = "SELECT ingrediens FROM ingredienser WHERE ingrediens LIKE ?";

    public List<Suggestion> getSuggestions(String queryTerm) throws SQLException {
        List<Suggestion> suggestions = new ArrayList<>();
        try (Connection connection = DBconnector.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)){
        pstmt.setString(1, "%" + queryTerm + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            String query = rs.getString("ingrediens");
            suggestions.add(new Suggestion(query));
        }

            }return suggestions;}}

        /*
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, "%" + queryTerm + "%");)}}
          */
