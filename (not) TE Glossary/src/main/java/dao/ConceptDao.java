package dao;

import model.Concept;

import java.util.List;

/**
 * DAO class for interacting with the concept information in the datastore.
 */

public interface ConceptDao {

    /**
     * Get a concept from the datastore with a specified id.
     * If the id is not found, return null.
     *
     * @param conceptId The id of the concept to return.
     * @return The matching Concept object, or null if the conceptId is not found.
     */
    Concept getById(int conceptId);

    /**
     * Get all concepts from the datastore ordered alphabetically.
     *
     * @return List of all concept object, or an empty list if no Tags are found.
     */
    List<Concept> getAll();

    /**
     * Get all concepts from the datastore for a specified UnitTag.
     *
     * @param unitId The id of the unit from which concepts will be returned.
     * @return List of all concept objects with the given unitId, or an empty list if none are found.
     */
    List<Concept> getByUnitId(int unitId);

    /**
     * Get all concepts from the datastore for a specified ModuleTag.
     *
     * @param moduleId The id of the module from which concepts will be returned.
     * @return List of all concept objects with the given moduleId, or an empty list if none are found.
     */
    List<Concept> getByModuleId(int moduleId);

    /**
     * Get a concept from the datastore that matches the user input.
     *
     * @param conceptSearch The String search parameter for which concepts will be returned.
     * @return List of all concept objects that match the search query, or an empty list if none are found.
     */
    List<Concept> searchForConcept(String conceptSearch);

    /**
     * Add a new concept to the datastore.
     *
     * @param newConcept the Concept object to add.
     * @return The added Concept object with its new id and any default values filled in.
     */
    Concept create(Concept newConcept);

    /**
     * Removes a concept from the glossary and any tag associations from the datastore.
     *
     * @param conceptId The id of the Concept to remove. If the id is not found, no error will occur.
     * @return count of concepts removed
     */
    int delete(int conceptId);

    /**
     * Update a concept in the datastore.
     * Both the concept name & definition can be updated. ConceptId cannot be changed.
     *
     * @param modifiedConcept The concept object to update.
     */
    Concept update(Concept modifiedConcept);

    /**
     * Add a tag association to a concept.
     * @param conceptId The id of the concept to associate to the tag.
     * @param unitId The id of the UnitTag to associate to the concept.
     * @return count of updates made
     */
    int addUnitTagToConcept(int conceptId, int unitId);
}
