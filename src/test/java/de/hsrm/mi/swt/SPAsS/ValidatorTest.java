package de.hsrm.mi.swt.SPAsS;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.TestClassGenerator;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

public class ValidatorTest {
    Plan p = new TestClassGenerator().plan;

    //TODO
    @Test
    public void testValidators(){
        Module linAlg = p.getModuleByName("Lineare Algebra");
        Module analysis = p.getModuleByName("Analysis");
        Module bwl = p.getModuleByName("Grundlagen der BWL");
        analysis.move(2);
        p.validate();
        //assertFalse(linAlg.isValid());
        bwl.move(4);
        p.validate();
        p.updateModuleMap();
        for(Module m : p.getModuleMap().get(4)){
            if(m.getSemesterDefault()>=4){
                if(m.isValid())System.out.println();
                //assertFalse(m.isValid());
            }
        }


    }
}
