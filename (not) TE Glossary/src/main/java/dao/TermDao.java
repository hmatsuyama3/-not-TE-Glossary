package dao;

import model.Term;

import java.util.List;

/**
 * DAO class for interacting with the term information in the datastore.
 */

public interface TermDao{
    /**
     * Get a term from the datastore with a specified id.
     * If the id is not found, return null.
     *
     * @param termId The id of the term to return.
     * @return The matching term object, or null if the termId is not found.
     */
    Term getById(int termId);

    /**
     * Get all terms from the datastore ordered alphabetically.
     *
     * @return List of all term objects, or an empty list if none are found.
     */
    List<Term> getAll();

    /**
     * Get all terms from the datastore for a specified UnitTag.
     *
     * @param unitId The id of the unit from which terms will be returned.
     * @return List of all term objects with the given unitId, or an empty list if none are found.
     */
    List<Term> getByUnitId(int unitId);

    /**
     * Get all terms from the datastore for a specified Module.
     *
     * @param moduleId The id of the module from which terms will be returned.
     * @return List of all term objects with the given moduleId, or an empty list if none are found.
     */
    List<Term> getByModuleId(int moduleId);

    /**
     * Get a term from the datastore that matches the user input.
     *
     * @param termSearch The String search parameter for which terms will be returned.
     * @return List of all term objects that match the search query, or an empty list if none are found.
     */
    List<Term> searchForTerm(String termSearch);

    /**
     * Add a new term to the datastore.
     *
     * @param newTerm the term object to add.
     * @return The added term object with its new id and any default values filled in.
     */
    Term create(Term newTerm);

    /**
     * Removes a term from the glossary and any tag associations from the datastore.
     *
     * @param termId The id of the term to remove. If the id is not found, no error will occur.
     * @return count of terms removed
     */
    int delete(int termId);

    /**
     * Update a term in the datastore.
     * Both the term name & definition can be updated. TermId cannot be changed.
     *
     * @param modifiedTerm The term object to update.
     */
    Term update(Term modifiedTerm);

    /**
     * Add a tag association to a term.
     * @param termId The id of the term to associate to the tag.
     * @param unitId The id of the UnitTag to associate to the term.
     * @return count of updates made
     */
    int addUnitTagToTerm(int termId, int unitId);
}
