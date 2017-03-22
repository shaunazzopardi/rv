package mt.edu.um.cs.rv.eventmanager.monitors;

import mt.edu.um.cs.rv.events.Event;
import mt.edu.um.cs.rv.monitors.Monitor;
import mt.edu.um.cs.rv.monitors.results.MonitorResult;
import org.springframework.context.ApplicationContext;

/**
 * Created by dwardu on 19/01/2016.
 */
public class MonitorInvocationServiceActivator
{

    private Monitor monitor;

    private ApplicationContext applicationContext;

    public MonitorInvocationServiceActivator(Monitor monitor, ApplicationContext applicationContext)
    {
        this.monitor = monitor;
        this.applicationContext = applicationContext;
    }
    
    public MonitorResult invokeMonitor(Event e)
    {
        return monitor.handleEvent(e);
    }
}
