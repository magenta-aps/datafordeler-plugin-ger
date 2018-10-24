import dk.magenta.datafordeler.core.Application;
import dk.magenta.datafordeler.core.Engine;
import dk.magenta.datafordeler.core.Pull;
import dk.magenta.datafordeler.ger.GerRegisterManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class PullTest {

    @Autowired
    private Engine engine;

    @Autowired
    private GerRegisterManager registerManager;

    @Test
    public void pullTest() {
        Pull pull = new Pull(engine, registerManager);
        pull.run();
    }

}
