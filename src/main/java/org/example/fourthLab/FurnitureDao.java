package org.example.fourthLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class FurnitureDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FurnitureDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Furniture> findAll() {
        return jdbcTemplate.query("select * from furniture", new BeanPropertyRowMapper<>(Furniture.class));
    }

    public List<Furniture> findByMinPrice(float minPrice) {
        return jdbcTemplate.query("select * from furniture where price >= ?", new BeanPropertyRowMapper<>(Furniture.class), minPrice);
    }

    public void insert(Furniture furniture) {
        jdbcTemplate.update("insert into furniture (name, description, color, price, weight) values (?,?,?,?,?)",
                furniture.getName(),
                furniture.getDescription(),
                furniture.getColor(),
                furniture.getPrice(),
                furniture.getWeight());
    }

    public int delete(int id) {
        return jdbcTemplate.update("delete from furniture where id = ?", id);
    }

    public Furniture findById(int id) {
        try {
            return jdbcTemplate.queryForObject("select * from furniture where id = ?",
                    new BeanPropertyRowMapper<>(Furniture.class), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void updateFurniture(Furniture furniture) {
        jdbcTemplate.update("update furniture set name = ?, description = ?, color = ?, price = ?, weight = ? where id = ?",
                furniture.getName(),
                furniture.getDescription(),
                furniture.getColor(),
                furniture.getPrice(),
                furniture.getWeight(),
                furniture.getId());
    }
}


