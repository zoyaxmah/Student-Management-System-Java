package GUI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddStudentDetailsTest {

    private AddStudentDetails addStudentDetails;

    @Before
    public void setUp() {
        addStudentDetails = new AddStudentDetails();
    }

    @After
    public void tearDown() {
        addStudentDetails = null;
    }

    @Test
    public void testSaveNewStudentDetails() throws Exception {
        addStudentDetails.getTfFirstName().setText("John");
        addStudentDetails.getTfLastName().setText("Doe");
        addStudentDetails.getTfPrefName().setText("Johnny");
        addStudentDetails.getTfStudID().setText("87654321");
        addStudentDetails.getLstGender().setSelectedIndex(0); 
        addStudentDetails.getTfEmail().setText("john.doe@example.com");
        addStudentDetails.getTfDOB().setText("01-01-2000");
        addStudentDetails.getTfAddress().setText("123 Main St");
        addStudentDetails.getTfSuburb().setText("Central");
        addStudentDetails.getTfCity().setText("Metropolis");
        addStudentDetails.getTfPostCode().setText("1234");
        addStudentDetails.getTfPhone().setText("02123456");

        java.awt.event.ActionEvent evt = new java.awt.event.ActionEvent(addStudentDetails.getBtnSubmit(), java.awt.event.ActionEvent.ACTION_PERFORMED, "Submit");
        invokePrivateMethod(addStudentDetails, "BtnSubmitActionPerformed", evt);

        
    }

    @Test
    public void testClearForm() throws Exception {
        addStudentDetails.getTfFirstName().setText("John");
        addStudentDetails.getTfLastName().setText("Doe");
        addStudentDetails.getTfPrefName().setText("Johnny");
        addStudentDetails.getTfStudID().setText("87654321");
        addStudentDetails.getLstGender().setSelectedIndex(0); //Male
        addStudentDetails.getTfEmail().setText("john.doe@example.com");
        addStudentDetails.getTfDOB().setText("01-01-2000");
        addStudentDetails.getTfAddress().setText("123 Main St");
        addStudentDetails.getTfSuburb().setText("Central");
        addStudentDetails.getTfCity().setText("Metropolis");
        addStudentDetails.getTfPostCode().setText("1234");
        addStudentDetails.getTfPhone().setText("02123456");

        java.awt.event.ActionEvent evt = new java.awt.event.ActionEvent(addStudentDetails.getBtnClear(), java.awt.event.ActionEvent.ACTION_PERFORMED, "Clear");
        invokePrivateMethod(addStudentDetails, "BtnClearActionPerformed", evt);

        // Verify form is cleared
        assertEquals("", addStudentDetails.getTfFirstName().getText());
        assertEquals("", addStudentDetails.getTfLastName().getText());
        assertEquals("", addStudentDetails.getTfPrefName().getText());
        assertEquals("", addStudentDetails.getTfStudID().getText());
        assertEquals(-1, addStudentDetails.getLstGender().getSelectedIndex());
        assertEquals("", addStudentDetails.getTfEmail().getText());
        assertEquals("", addStudentDetails.getTfDOB().getText());
        assertEquals("", addStudentDetails.getTfAddress().getText());
        assertEquals("", addStudentDetails.getTfSuburb().getText());
        assertEquals("", addStudentDetails.getTfCity().getText());
        assertEquals("", addStudentDetails.getTfPostCode().getText());
        assertEquals("", addStudentDetails.getTfPhone().getText());
    }

    private void invokePrivateMethod(Object instance, String methodName, Object... args) throws Exception {
        Class<?>[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        java.lang.reflect.Method method = instance.getClass().getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        method.invoke(instance, args);
    }
}
