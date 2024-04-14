package selenium.tests;

import org.testng.annotations.Test;
import selenium.base.MainTest;
import selenium.pages.QApage;

import static org.testng.AssertJUnit.assertTrue;

public class QApageTest extends MainTest {
    QApage qaPage;

    @Test
    public void VisibilityOfQAlogo(){
        qaPage = new QApage();
        Boolean qaLogoVisible = qaPage.qaLogoDisplayed();
        assertTrue(qaLogoVisible == Boolean.TRUE);
    }



}
