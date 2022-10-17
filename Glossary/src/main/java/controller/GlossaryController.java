package controller;

import dao.ModuleTagDao;
import dao.TermDao;
import dao.UnitDao;

public class GlossaryController {

    private TermDao termDao;
    private UnitDao unitDao;
    private ModuleTagDao moduleTagDao;

    public GlossaryController(TermDao termDao, UnitDao unitDao, ModuleTagDao moduleTagDao){
        this.termDao = termDao;
        this.unitDao = unitDao;
        this.moduleTagDao = moduleTagDao;
    }

    //Call CRUD operations from DAO classes to post to View here
}
