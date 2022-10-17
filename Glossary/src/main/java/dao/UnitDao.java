package dao;


import model.Term;
import model.Unit;
import java.util.List;

/**
 * DAO class for interacting with the Unit Tag information in the datastore.
 */
public interface UnitDao {

    /**
     * Get all units from the datastore ordered by UnitId.
     *
     * @return List of all Unit objects, or an empty list if no units are found.
     */
    List<Unit> getAll();

    /**
     * Get a unit from the datastore with the specified id.
     * If the id is not found, return null.
     *
     * @param unitId The id of the Unit to return.
     * @return The matching unit object, or null if the unitId is not found.
     */
    Unit getUnitById(int unitId);

    /**
     * Gets a list of units from the datastore associated to a specified term id.
     * If the id is not found, return null.
     *
     * @param termId The term id associated to the Units to return.
     * @return A list of matching Unit objects, or an empty list if no units are found.
     */
    List<Unit> getUnitsByTermId(int termId);

    /**
     * Gets a list of units from the datastore associated to a specified module id.
     * If the id is not found, return null.
     *
     * @param moduleId The module id associated to the Units to return.
     * @return A list of matching Unit objects, or an empty list if no Units are found.
     */
    List<Unit> getUnitsByModuleId(int moduleId);

    //On second thought, thinking this should be in TermDao if I use it at all
//    /**
//     * Get a unit from the datastore that matches the user input.
//     *
//     * @param unitSearch The String search parameter for which terms will be returned.
//     * @return List of all term objects that match the search query, or an empty list if none are found.
//     */
//    List<Term> searchForUnit(String unitSearch);

    /**
     * Adds a new tag to the datastore.
     *
     * @param newUnit the Unit object to add.
     * @return The added Unit object with its new id value filled in.
     */
    Unit create (Unit newUnit);

    /**
     * Updates an existing unit.
     *
     * @param unit the Unit data to update.
     */
    boolean update (Unit unit);
}
