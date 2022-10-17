package dao;

import model.Term;
import model.Unit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcUnitDao implements UnitDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUnitDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = new JdbcTemplate();}

    @Override
    public List<Unit> getAll(){
        List<Unit> units = new ArrayList<>();
        String sql = "SELECT unit_id, unit " +
                "FROM unit " +
                "ORDER BY unit_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Unit unit = mapRowToUnit(results);
            units.add(unit);
        }
        return units;
    }

    @Override
    public Unit getUnitById(int unitId){
        Unit unit = new Unit();
        String sql = "SELECT unit_id, unit " +
                "FROM unit " +
                "WHERE unit_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, unitId);
        if(results.next()){
            unit = mapRowToUnit(results);
        }
        return unit;
    }

    @Override
    public List<Unit> getUnitsByTermId(int termId){
        List<Unit> units = new ArrayList<>();

        return null;
    }

    @Override
    public List<Unit> getUnitsByModuleId(int moduleId){
        return null;
    }

//    @Override
//    public List<Term> searchForUnit(String unitSearch){
//
//        return null;
//    }

    @Override
    public Unit create(Unit newUnit){
        String sql = "INSERT INTO unit (unit) " +
                "VALUES(?) RETURNING unit_id;";
        int newId = jdbcTemplate.queryForObject(sql, int.class, newUnit.getUnitName());
        return getUnitById(newId);
    }

    @Override
    public boolean update(Unit unit){
        String sql ="UPDATE unit SET unit = ? WHERE unit_id = ?;";
        return jdbcTemplate.update(sql, unit.getUnitName(), unit.getUnitId()) ==1;
    }


    private Unit mapRowToUnit(SqlRowSet results){
        Unit unit = new Unit();
        unit.setUnitId(results.getInt("unit_id"));
        unit.setUnitName(results.getString("unit"));
        return unit;
    }
}
