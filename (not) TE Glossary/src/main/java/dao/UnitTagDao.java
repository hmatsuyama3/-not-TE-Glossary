package dao;


import model.Concept;
import model.UnitTag;
import java.util.List;

/**
 * DAO class for interacting with the Unit Tag information in the datastore.
 */
public interface UnitTagDao {

    /**
     * Get all tags from the datastore ordered by UnitId.
     *
     * @return List of all UnitTag objects, or an empty list if no tags are found.
     */
    List<UnitTag> getAll();

    /**
     * Get a tag from the datastore with the specified id.
     * If the id is not found, return null.
     *
     * @param unitId The id of the Unit Tag to return.
     * @return The matching Tag object, or null if the unitId is not found.
     */
    UnitTag getById(int unitId);

    /**
     * Gets a list of tags from the datastore associated to a specified concept id.
     * If the id is not found, return null.
     *
     * @param conceptId The concept id associated to the Unit Tags to return.
     * @return A list of matching UnitTag objects, or an empty list if no UnitTags are found.
     */
    List<UnitTag> getTagsByConceptId(int conceptId);

    /**
     * Gets a list of tags from the datastore associated to a specified module id.
     * If the id is not found, return null.
     *
     * @param moduleId The module id associated to the Unit Tags to return.
     * @return A list of matching UnitTag objects, or an empty list if no UnitTags are found.
     */
    List<UnitTag> getTagsByModuleId(int moduleId);

    /**
     * Get a unit from the datastore that matches the user input.
     *
     * @param unitSearch The String search parameter for which concepts will be returned.
     * @return List of all concept objects that match the search query, or an empty list if none are found.
     */
    List<Concept> searchForUnit(String unitSearch);

    /**
     * Adds a new tag to the datastore.
     *
     * @param newUnitTag the UnitTag object to add.
     * @return The added UnitTag object with its new id value filled in.
     */
    UnitTag create (UnitTag newUnitTag);

    /**
     * Updates an existing unit tag.
     *
     * @param unitTag the UnitTag data to update.
     */
    UnitTag update (UnitTag unitTag);
}
