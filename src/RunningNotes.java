
public class RunningNotes 
{
/* What is servlet container?
 * 
 * It manages the lifecycle of a servlet. It does the following things.
 * 
 * 1. Read web.xml, it has capability to read xml files.
 * 2. Reads the values of Init params and context parameters, using those prepares ServletConfig and ServletContext objects 
 * 2. It finds loadOnStartup servlets.
 * 3. Creates object for those.
 * 4. Calls life cycle init() method on those servles.
 * 5. Invokes service() method when a request is received and basically manages the entire lifecycle of servlet.
 * 5. Finally, it will call destroy method.
 * 
 * What is bean container?
 * 
 * Read xml
 * create instances of beans
 * manage life cycle of beans
 * dynamically pass references
 * 
 * 
 */
}
