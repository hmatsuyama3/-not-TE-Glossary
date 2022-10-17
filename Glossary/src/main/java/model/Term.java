package model;

public class Term {

    /**Model class representing a term in the TE curriculum that can be looked up as part of a glossary.
     * -Terms have a definition
     * -They may also have associated "Tags" relating to the unit the term is introduced.
     * -Future: Users can log in and save words for review? Flash cards? Flash card game where you can review based on
     * Unit? Module??
     */

    private int termId;
    private String term;
    private String definition;

    public Term() {
    }

    public Term(int termId, String term, String definition) {
        this.termId = termId;
        this.term = term;
        this.definition = definition;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
