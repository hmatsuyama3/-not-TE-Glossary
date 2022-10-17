package model;

public class Unit {
    /**
     * Tags refer to the unit(s) in which the term appears.
     * Many-to-many relationship with Terms.
     */

    private int unitId;
    private String unitName;

    public Unit() {
    }

    public Unit(int unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
