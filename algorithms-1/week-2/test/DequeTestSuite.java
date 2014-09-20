import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by tomek on 9/20/14.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DequeExceptionsTest.class,
        DequeFirstOperationsTest.class,
        DequeLastOperationsTest.class,
        DequeMixedOperationsTest.class
})
public class DequeTestSuite {
}
