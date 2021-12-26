/**
 * Author: Stanley Chan
 * Revised: April 11th, 2021
 * 
 * Description: Test all JUnit tests.
 */

package src;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestGame.class,
   TestBoard.class,
   TestPosition.class,
   TestTile.class
})

public class AllTests
{
}
