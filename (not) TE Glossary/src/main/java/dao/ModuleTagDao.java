package dao;


import model.ModuleTag;
import model.UnitTag;

import java.util.List;

/**
 * DAO class for interacting with the Module Tag information in the datastore.
 */
public interface ModuleTagDao {
    /**
     * Get all tags from the datastore ordered by ModuleId.
     *
     * @return List of all ModuleTag objects, or an empty list if no tags are found.
     */
    List<ModuleTag> getAll();

    /**
     * Get a tag from the datastore with the specified id.
     * If the id is not found, return null.
     *
     * @param moduleId The id of the Module Tag to return.
     * @return The matching Tag object, or null if the moduleId is not found.
     */
    ModuleTag getById(int moduleId);

}
