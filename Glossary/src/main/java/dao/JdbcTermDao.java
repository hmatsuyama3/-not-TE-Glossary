package dao;

import model.Term;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class JdbcTermDao implements TermDao{

    //Data access information is stored in resources/application.properties.
    //Spring Boot will find this and use it to access the database
    private final JdbcTemplate jdbcTemplate;
    public JdbcTermDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = new JdbcTemplate();}

    @Override
    public Term getTermById(int termId){
        Term term = null;
        String sql = "SELECT term_id, term, definition " +
                "FROM terms " +
                "WHERE term_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, termId);
        if(results.next()){
            term = mapRowToTerm(results);
        }

        return term;
    }

    @Override
    public List<Term> getAllTerms(){
        List<Term> terms = new ArrayList<>();
        String sql = "SELECT term_id, term, definition " +
                "FROM terms " +
                "ORDER BY term_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Term term = mapRowToTerm(results);
            terms.add(term);
        }

        return terms;
    }

    @Override
    public List<Term> getTermByUnitId(int unitId){
        List<Term> terms = new ArrayList<>();
        String sql = "SELECT t.term_id, term, definition " +
                "FROM terms t " +
                "JOIN term_unit t_u ON t.term_id=t_u.term_id " +
                "WHERE unit_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, unitId);
        while(results.next()){
            Term term = mapRowToTerm(results);
            terms.add(term);
        }

        return terms;
    }

    @Override
    public List<Term> getByModuleId(int moduleId){
        return null;
    }

    @Override
    public List<Term> searchForTerm(String termSearch){
        //Currently only does an ILIKE search & returns TERM object. Would like to incorporate additional fuzzy searching
        //Also would like to display unit along with glossary term? Need a new wrapper type class?
        List<Term> terms = new ArrayList<>();
        String sql = "SELECT t.term_id, term, definition " +
                "FROM terms t " +
                "JOIN term_unit t_u ON t.term_id=t_u.term_id " +
                "WHERE term ILIKE ?;";
        String searchWithWildCards = "%" + termSearch + "%";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchWithWildCards);
        while(results.next()){
            Term term = mapRowToTerm(results);
            terms.add(term);
        }
        return terms;
    }

    @Override
    public Term create(Term newTerm){
        String sql = "INSERT INTO terms (term, definition) " +
                "VALUES(?,?) RETURNING term_id;";
        int newId = jdbcTemplate.queryForObject(sql, int.class, newTerm.getTerm(), newTerm.getDefinition());
        return getTermById(newId);
    }

    @Override
    public int delete(int termId){
            return termId;
    }

    @Override
    public Term update(Term modifiedTerm){
        return null;
    }

    @Override
    public int addUnitTagToTerm(int termId, int unitId){
        return termId;
    }

    private Term mapRowToTerm(SqlRowSet results){
        Term term = new Term();
        term.setTermId(results.getInt("term_id"));
        term.setTerm(results.getString("term"));
        term.setDefinition(results.getString("definition"));
        return term;
    }




}
